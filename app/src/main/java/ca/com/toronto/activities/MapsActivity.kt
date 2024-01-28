package ca.com.toronto.activities

import android.Manifest
import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ca.com.testtutorials.R
import ca.com.toronto.model.PlacesList
import ca.com.toronto.utils.MY_PERMISSIONS_REQUEST_LOCATION
import ca.com.toronto.utils.Permissions.checkLocationPermission
import ca.com.toronto.utils.Permissions.isAccessCoarseEnabled
import ca.com.toronto.utils.Permissions.isLocationEnabled
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

/**
 * Created by Royal_L on 23-Oct-17.
 */
class MapsActivity : AppCompatActivity(), OnMapReadyCallback, LocationListener {

    private lateinit var viewModel: MapsViewModel

    private lateinit var mMap: GoogleMap
    private var latitude = 0.0
    private var longitude = 0.0
    private var mCurrLocationMarker: Marker? = null
    private var mLocationRequest: LocationRequest? = null
    private lateinit var mSprPlaceType: Spinner
    lateinit var mPlaceType: Array<String>

    private lateinit var mFusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        viewModel = ViewModelProvider(
            this, ViewModelProvider.NewInstanceFactory()
        )[MapsViewModel::class.java]
        // Array of place types
        mPlaceType = resources.getStringArray(R.array.place_type)
        // Array of place type names
        val mPlaceTypeName = resources.getStringArray(R.array.place_type_name)
        // Creating an array adapter with an array of Place types
        // to populate the spinner
        val adapter = ArrayAdapter(this, R.layout.spinner_item, mPlaceTypeName)
        // Getting reference to the Spinner
        mSprPlaceType = findViewById(R.id.spr_place_type)
        // Setting adapter on Spinner to set place types
        mSprPlaceType.adapter = adapter

        //show error dialog if Google Play Services not available
        if (!isGooglePlayServicesAvailable) {
            Log.d("onCreate", "Google Play Services not available. Ending Test case.")
            finish()
        } else {
            Log.d("onCreate", "Google Play Services available. Continuing.")
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        if (this.isAccessCoarseEnabled()) {
            handleFusedLocation()
        } else {
            this.checkLocationPermission()
        }
    }

    @SuppressLint("MissingPermission")
    private fun handleFusedLocation() {
        if (this.isLocationEnabled()) {
            mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
            mFusedLocationClient.lastLocation.addOnCompleteListener { task ->
                val location = task.result
                if (location == null) {
                    requestNewLocationData()
                } else {
                    latitude = location.latitude
                    longitude = location.longitude
                }
            }

            mSprPlaceType.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(
                    adapterView: AdapterView<*>?, view: View, i: Int, l: Long
                ) {
                    mPlaceType = resources.getStringArray(R.array.place_type)
                    Handler(Looper.getMainLooper()).postDelayed({
                        buildRetrofitAndGetResponse(mPlaceType[i])
                    }, 2000)
                }

                override fun onNothingSelected(adapterView: AdapterView<*>?) {}
            }

        } else {
            Toast.makeText(this, "Please turn on your location...", Toast.LENGTH_LONG).show()
            val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
            startActivity(intent)
        }
    }

    @SuppressLint("MissingPermission")
    private fun requestNewLocationData() {
        // Initializing LocationRequest
        // object with appropriate methods
        val mLocationRequest = LocationRequest()
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
        mLocationRequest.setInterval(5)
        mLocationRequest.setFastestInterval(0)
        mLocationRequest.setNumUpdates(1)

        // setting LocationRequest
        // on FusedLocationClient
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        mFusedLocationClient.requestLocationUpdates(
            mLocationRequest, mLocationCallback, Looper.myLooper()
        )
    }

    private val mLocationCallback: LocationCallback = object : LocationCallback() {
        override fun onLocationResult(locationResult: LocationResult) {}
    }

    private val isGooglePlayServicesAvailable: Boolean
        get() {
            val googleAPI = GoogleApiAvailability.getInstance()
            val result = googleAPI.isGooglePlayServicesAvailable(this)
            if (result != ConnectionResult.SUCCESS) {
                if (googleAPI.isUserResolvableError(result)) {
                    googleAPI.getErrorDialog(this, result, 0)?.show()
                }
                return false
            }
            return true
        }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Torotno, Canada.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.uiSettings.isRotateGesturesEnabled = true
        //Initialize Google Play Services
        handleGoogleApiClient()
    }

    private fun handleGoogleApiClient() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ContextCompat.checkSelfPermission(
                    this, Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                buildGoogleApiClient()
                mMap.isMyLocationEnabled = true
            }
        } else {
            buildGoogleApiClient()
            mMap.isMyLocationEnabled = true
        }
    }

    private fun buildRetrofitAndGetResponse(type: String) {
        viewModel.initializeRetrofitClient(type, "$latitude,$longitude")
        viewModel.locationsLiveData.observe(this, locationsObserver)
    }

    private val locationsObserver = Observer<PlacesList> { placesResponse ->
        try {
            mMap.clear()
            // This loop will go through all the results and add marker on each location.

            for (placeModel in placesResponse.placesList) {
                val lat = placeModel.geometry?.location?.lat
                val lng = placeModel.geometry?.location?.lng
                val placeName = placeModel.name
                val vicinity = placeModel.vicinity
                val markerOptions = MarkerOptions()
                val latLng = if (lat != null && lng != null) {
                    LatLng(lat, lng)
                } else {
                    LatLng(0.0, 0.0)
                }
                // Position of Marker on Map
                markerOptions.position(latLng)
                // Adding Title to the Marker
                markerOptions.title("$placeName : $vicinity")
                // Adding Marker to the Camera.
                val m = mMap.addMarker(markerOptions)
                // Adding colour to the marker
                markerOptions.icon(
                    BitmapDescriptorFactory.defaultMarker(
                        BitmapDescriptorFactory.HUE_RED
                    )
                )
                // move map camera
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
                mMap.animateCamera(CameraUpdateFactory.zoomTo(11f))
            }
        } catch (e: Exception) {
            Log.d("onResponse", "There is an error")
            e.printStackTrace()
        }
    }

    @Synchronized
    private fun buildGoogleApiClient() {
        val mGoogleApiClient = GoogleApiClient.Builder(this)
            .addConnectionCallbacks(object : GoogleApiClient.ConnectionCallbacks {
                override fun onConnected(p0: Bundle?) {
                    mLocationRequest = LocationRequest()
                    mLocationRequest?.setInterval(1000)
                    mLocationRequest?.setFastestInterval(1000)
                    mLocationRequest?.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY)
                }

                override fun onConnectionSuspended(p0: Int) {}
            }).addOnConnectionFailedListener { }.addApi(LocationServices.API).build()
        mGoogleApiClient.connect()
    }

    override fun onLocationChanged(location: Location) {
        Log.d("onLocationChanged", "entered")
        //mLastLocation = location
        if (mCurrLocationMarker != null) {
            mCurrLocationMarker?.remove()
        }
        //Place current location marker
        latitude = location.latitude
        longitude = location.longitude
        val latLng = LatLng(location.latitude, location.longitude)
        val markerOptions = MarkerOptions()
        markerOptions.position(latLng)
        markerOptions.title(getString(R.string.your_current_location))

        // Adding colour to the marker
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA))

        // Adding Marker to the Map
        mCurrLocationMarker = mMap.addMarker(markerOptions)

        //move map camera
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        mMap.animateCamera(CameraUpdateFactory.zoomTo(11f))
    }

    override fun onRequestPermissionsResult(
        requestCode: Int, permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_LOCATION -> {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted. Do the
                    // contacts-related task you need to do.
                    handleGoogleApiClient()
                } else {
                    // Permission denied, Disable the functionality that depends on this permission.
                    Toast.makeText(this, getString(R.string.permission_denied), Toast.LENGTH_LONG).show()
                }
                return
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
