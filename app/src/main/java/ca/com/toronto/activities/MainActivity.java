package ca.com.toronto.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import ca.com.toronto.R;
import ca.com.toronto.model.LocationsDetail;
import ca.com.toronto.utils.AppRater;
import softpro.naseemali.ShapedNavigationView;
import softpro.naseemali.ShapedViewSettings;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        OnMapReadyCallback {

    private ShapedNavigationView shapedNavigationView;
    private List<MenuItem> items;
    private InterstitialAd mInterstitialAd;
    private GoogleMap mMap;
    private int zoomInZoomOut = 0;

    boolean isOpen = false;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        AppRater.app_launched(MainActivity.this);
        final FloatingActionButton fabPlaces = (FloatingActionButton) findViewById(R.id.fabPlaces);
        fabPlaces.setImageResource(R.drawable.icon_eye);
        fabPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });

        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setImageResource(R.drawable.zoom_in);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (zoomInZoomOut < 4) {
                    zoomInZoomOut++;
                    mMap.animateCamera(CameraUpdateFactory.zoomIn());
                    if (zoomInZoomOut == 4) {
                        zoomInZoomOut++;
                        fab.setImageResource(R.drawable.zoom_out);
                        return;
                    }
                    fab.setImageResource(R.drawable.zoom_in);
                } else if (zoomInZoomOut >= 4) {
                    zoomInZoomOut++;
                    mMap.animateCamera(CameraUpdateFactory.zoomOut());
                    if (zoomInZoomOut == 9) {
                        zoomInZoomOut = 0;
                        fab.setImageResource(R.drawable.zoom_in);
                        return;
                    }
                    fab.setImageResource(R.drawable.zoom_out);
                }

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        items = new ArrayList<>();
        Menu menu;

        shapedNavigationView = (ShapedNavigationView) findViewById(R.id.nav_view);
        shapedNavigationView.setNavigationItemSelectedListener(this);
//        shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.ROUNDED_RECT);
//        shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.WAVES);
//        shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.WAVES_INDEFINITE);
//        shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.BOTTOM_ROUND);
//        shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.FULL_ROUND);
//        shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.ARC_CONVEX);
//        shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.ARC_CONCAVE);
        shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.ROUNDED_RECT);
//        shapedNavigationView.getSettings().setShapeType(ShapedViewSettings.NORMAL);

        menu = shapedNavigationView.getMenu();

        for (int i = 0; i < menu.size(); i++) {
            items.add(menu.getItem(i));
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        MobileAds.initialize(MainActivity.this, getString(R.string.app_id));
        //AdRequest adRequest = new AdRequest.Builder().addTestDevice("9729C22A4D59816BE4E3C61CEE8BF53C").build();
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd = new InterstitialAd(MainActivity.this);
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ads_unit_id));
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            public void onAdLoaded() {
                //super.onAdLoaded();
                Log.i("AdsInterstitaldd", "Ad loaded");
                showInterstitial();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
                Log.i("AdsInterstitaldd", "onAdFailedToLoad "+errorCode);
            }

            @Override
            public void onAdOpened() {
                // showInterstitial();
                // Code to be executed when the ad is displayed.
                Log.i("AdsInterstitaldd", "onAdOpened");
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
                Log.i("AdsInterstitaldd", "onAdLeftApplication");
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                Log.i("AdsInterstitaldd", "onAdClosed");
            }
        });
    }

    private void showInterstitial() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        }
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        Menu menu = shapedNavigationView.getMenu();
        int size = menu.size();

        item.setChecked(true);
        int position = items.indexOf(item);

        for (int i = 0; i < size; i++) {
            if (position == i) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra("detail", position + "");
                startActivity(intent);

            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        float zoomLevel = 13f; //This goes up to 21

        List<LocationsDetail> list = new ArrayList<>();
        list.add(new LocationsDetail("Royal Ontario Museum", 43.6677291, -79.3956327));
        list.add(new LocationsDetail("Casa Loma", 43.6781009, -79.4102353));
        list.add(new LocationsDetail("Hockey Hall of Fame", 43.6472722, -79.3798789));
        list.add(new LocationsDetail("Art Gallery of Ontario", 43.6536066, -79.3947014));
        list.add(new LocationsDetail("Ripley's Aquarium of Canada", 43.6424537, -79.3883121));
        list.add(new LocationsDetail("Distillery District", 43.6508959, -79.3606324));
        list.add(new LocationsDetail("St. Lawrence Market South", 43.6490516, -79.3739628));
        list.add(new LocationsDetail("Toronto Islands", 43.6208961, -79.3809296));
        list.add(new LocationsDetail("Toronto Eaton Centre", 43.6544382, -79.3828881));
        list.add(new LocationsDetail("Lake Ontario", 43.8334169, -78.2962345));
        list.add(new LocationsDetail("Ontario Science Centre", 43.7164222, -79.3392783));
        list.add(new LocationsDetail("Queen Street West", 43.6493583, -79.3962112));
        list.add(new LocationsDetail("Bata Shoe Museum", 43.6672426, -79.4023547));
        list.add(new LocationsDetail("High Park", 43.6467379, -79.4666694));
        list.add(new LocationsDetail("Chinatown, Toronto", 43.6533055, -79.4018915));
        list.add(new LocationsDetail("Yorkville, Toronto", 43.6724856, -79.3924302));
        list.add(new LocationsDetail("Canada's Wonderland", 43.8430176, -79.5416512));
        list.add(new LocationsDetail("Kensington Market", 43.6551171, -79.4079228));
        list.add(new LocationsDetail("Toronto Zoo", 43.8176993, -79.1880792));
        list.add(new LocationsDetail("Union Station", 43.6451893, -79.3828018));
        list.add(new LocationsDetail("Black Creek Pioneer Village", 43.7734366, -79.5171418));
        list.add(new LocationsDetail("Centreville Amusement Park", 43.6208031, -79.3769045));
        list.add(new LocationsDetail("Allan Gardens", 43.6617585, -79.3768705));
        list.add(new LocationsDetail("Nathan Phillips Square", 43.6525485, -79.3857005));
        list.add(new LocationsDetail("Fort York", 43.6374165, -79.4086562));
        list.add(new LocationsDetail("Toronto City Hall", 43.6534829, -79.3862826));
        list.add(new LocationsDetail("Gardiner Museum", 43.6681404, -79.3952718));
        list.add(new LocationsDetail("Edwards Gardens", 43.7334726, -79.3616114));
        list.add(new LocationsDetail("Yonge-Dundas Square", 43.6560359, -79.3824244));
        list.add(new LocationsDetail("Toronto Harbour", 43.6388346, -79.3840672));
        list.add(new LocationsDetail("The Beaches", 43.6674604, -79.3153824));
        list.add(new LocationsDetail("Textile Museum of Canada", 43.6545332, -79.3890797));
        list.add(new LocationsDetail("Spadina House", 43.6790455, -79.4088208));
        list.add(new LocationsDetail("Toronto waterfront", 43.6416441, -79.3788385));
        list.add(new LocationsDetail("Gooderham Building", 43.6483281, -79.3750438));
        list.add(new LocationsDetail("Hanlan's Point Beach", 43.6214627, -79.3963405));
        list.add(new LocationsDetail("Roy Thomson Hall", 43.6465712, -79.3869448));
        list.add(new LocationsDetail("Sugar Beach", 43.6427294, -79.3676444));
        list.add(new LocationsDetail("Don Valley Brick Works", 43.6871996, -79.3667461));
        list.add(new LocationsDetail("Harbourfront Centre", 43.6388617, -79.3827647));
        list.add(new LocationsDetail("EdgeWalk at the CN Tower", 43.6422949, -79.3879505));
        list.add(new LocationsDetail("Chinguacousy Park", 43.7253315, -79.7243438));
        list.add(new LocationsDetail("Centennial Park", 43.6519906, -79.5913268));
        list.add(new LocationsDetail("Woodbine Beach", 43.6617461, -79.3100127));
        list.add(new LocationsDetail("Aga Khan Museum", 43.7257495, -79.3340014));
        list.add(new LocationsDetail("Toronto Island Park", 43.6208961, -79.3809296));
        list.add(new LocationsDetail("Player One Amusement Group", 43.6937843, -79.6276462));
        list.add(new LocationsDetail("Riverdale Farm", 43.6671213, -79.3633138));
        list.add(new LocationsDetail("Legoland Discovery Centre", 43.8251614, -79.5376193));
        list.add(new LocationsDetail("CN Tower", 43.6425555, -79.3871045));

        for (LocationsDetail locationsDetail : list) {
            try {
                LatLng latLng = new LatLng(locationsDetail.getLat(), locationsDetail.getLng());
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel));
                mMap.addMarker(new MarkerOptions().position(latLng).title(locationsDetail.getTitle())
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        return false;
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
