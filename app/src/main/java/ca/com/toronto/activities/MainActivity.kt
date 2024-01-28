package ca.com.toronto.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import ca.com.testtutorials.R
import ca.com.toronto.utils.AppRater.handleAppLaunch
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import softpro.naseemali.ShapedNavigationView
import softpro.naseemali.ShapedViewSettings

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    private lateinit var shapedNavigationView: ShapedNavigationView
    private lateinit var items: MutableList<MenuItem>
    private var mMap: GoogleMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        handleAppLaunch(this@MainActivity)
        val fabPlaces = findViewById<FloatingActionButton>(R.id.fabPlaces)
        fabPlaces.setImageResource(R.drawable.icon_eye)
        fabPlaces.setOnClickListener { _: View? ->
            startActivity(
                Intent(
                    this@MainActivity,
                    MapsActivity::class.java
                )
            )
        }
        var zoomInZoomOut = 0
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setImageResource(R.drawable.zoom_in)
        fab.setOnClickListener { _: View? ->
            if (zoomInZoomOut < 4) {
                zoomInZoomOut++
                mMap?.animateCamera(CameraUpdateFactory.zoomIn())
                if (zoomInZoomOut == 4) {
                    zoomInZoomOut++
                    fab.setImageResource(R.drawable.zoom_out)
                    return@setOnClickListener
                }
                fab.setImageResource(R.drawable.zoom_in)
            } else if (zoomInZoomOut >= 4) {
                zoomInZoomOut++
                mMap?.animateCamera(CameraUpdateFactory.zoomOut())
                if (zoomInZoomOut == 9) {
                    zoomInZoomOut = 0
                    fab.setImageResource(R.drawable.zoom_in)
                    return@setOnClickListener
                }
                fab.setImageResource(R.drawable.zoom_out)
            }
        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(
            this,
            drawer,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        items = ArrayList()
        shapedNavigationView = findViewById(R.id.nav_view)
        shapedNavigationView.setNavigationItemSelectedListener(this)
        //shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.ROUNDED_RECT);
        //shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.WAVES);
        //shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.WAVES_INDEFINITE);
        //shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.BOTTOM_ROUND);
        //shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.FULL_ROUND);
        //shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.ARC_CONVEX);
        //shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.ARC_CONCAVE);
        shapedNavigationView.settings.shapeType = ShapedViewSettings.ROUNDED_RECT
        //shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.NORMAL);
        val menu: Menu = shapedNavigationView.menu
        for (i in 0 until menu.size()) {
            items.add(menu.getItem(i))
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }

    override fun onBackPressed() {
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        val menu = shapedNavigationView.menu
        val size = menu.size()
        item.setChecked(true)
        val position = items.indexOf(item)
        for (i in 0 until size) {
            if (position == i) {
                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                intent.putExtra("detail", position.toString())
                startActivity(intent)
            }
        }
        val drawer = findViewById<DrawerLayout>(R.id.drawer_layout)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]

        mMap = googleMap
        mMap?.mapType = GoogleMap.MAP_TYPE_HYBRID
        val zoomLevel = 13f //This goes up to 21

        viewModel.locationsLiveData.observe(this) { locationDetails ->
            for (locationsDetail in locationDetails) {
                try {
                    val latLng = LatLng(locationsDetail.lat, locationsDetail.lng)
                    mMap?.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel))
                    mMap?.addMarker(
                        MarkerOptions().position(latLng).title(locationsDetail.title)
                            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                    )
                    mMap?.moveCamera(CameraUpdateFactory.newLatLng(latLng))
                    mMap?.setOnMarkerClickListener { _: Marker? -> false }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }
}
