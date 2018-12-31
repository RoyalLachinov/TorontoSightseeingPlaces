package ca.com.toronto.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import ca.com.toronto.R;


public class DetailsActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TextView txtViewCNTower = (TextView) findViewById(R.id.txtViewLocationContent);
        ImageView imgView = (ImageView) findViewById(R.id.imgView);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int pointID = Integer.parseInt(bundle.getString("detail"));
        if (pointID == 0) {
            txtViewCNTower.setText(getString(R.string.point_0));
            imgView.setBackgroundResource(R.drawable.point_0);
        } else if (pointID == 1) {
            txtViewCNTower.setText(getString(R.string.point_1));
            imgView.setBackgroundResource(R.drawable.point_1);
        } else if (pointID == 2) {
            txtViewCNTower.setText(getString(R.string.point_2));
            imgView.setBackgroundResource(R.drawable.point_2);
        } else if (pointID == 3) {
            txtViewCNTower.setText(getString(R.string.point_3));
            imgView.setBackgroundResource(R.drawable.point_3);
        } else if (pointID == 4) {
            txtViewCNTower.setText(getString(R.string.point_4));
            imgView.setBackgroundResource(R.drawable.point_4);
        } else if (pointID == 5) {
            txtViewCNTower.setText(getString(R.string.point_5));
            imgView.setBackgroundResource(R.drawable.point_5);
        } else if (pointID == 6) {
            txtViewCNTower.setText(getString(R.string.point_6));
            imgView.setBackgroundResource(R.drawable.point_6);
        } else if (pointID == 7) {
            txtViewCNTower.setText(getString(R.string.point_7));
            imgView.setBackgroundResource(R.drawable.point_7);
        } else if (pointID == 8) {
            txtViewCNTower.setText(getString(R.string.point_8));
            imgView.setBackgroundResource(R.drawable.point_8);
        } else if (pointID == 9) {
            txtViewCNTower.setText(getString(R.string.point_9));
            imgView.setBackgroundResource(R.drawable.point_9);
        } else if (pointID == 10) {
            txtViewCNTower.setText(getString(R.string.point_10));
            imgView.setBackgroundResource(R.drawable.point_10);
        }else if (pointID == 11) {
            txtViewCNTower.setText(getString(R.string.point_11));
            imgView.setBackgroundResource(R.drawable.point_11);
        } else if (pointID == 12) {
            txtViewCNTower.setText(getString(R.string.point_12));
            imgView.setBackgroundResource(R.drawable.point_12);
        } else if (pointID == 13) {
            txtViewCNTower.setText(getString(R.string.point_13));
            imgView.setBackgroundResource(R.drawable.point_13);
        } else if (pointID == 14) {
            txtViewCNTower.setText(getString(R.string.point_14));
            imgView.setBackgroundResource(R.drawable.point_14);
        } else if (pointID == 15) {
            txtViewCNTower.setText(getString(R.string.point_15));
            imgView.setBackgroundResource(R.drawable.point_15);
        } else if (pointID == 16) {
            txtViewCNTower.setText(getString(R.string.point_16));
            imgView.setBackgroundResource(R.drawable.point_16);
        } else if (pointID == 17) {
            txtViewCNTower.setText(getString(R.string.point_17));
            imgView.setBackgroundResource(R.drawable.point_17);
        } else if (pointID == 18) {
            txtViewCNTower.setText(getString(R.string.point_18));
            imgView.setBackgroundResource(R.drawable.point_18);
        } else if (pointID == 19) {
            txtViewCNTower.setText(getString(R.string.point_19));
            imgView.setBackgroundResource(R.drawable.point_19);
        } else if (pointID == 20) {
            txtViewCNTower.setText(getString(R.string.point_20));
            imgView.setBackgroundResource(R.drawable.point_20);
        }else if (pointID == 21) {
            txtViewCNTower.setText(getString(R.string.point_21));
            imgView.setBackgroundResource(R.drawable.point_21);
        } else if (pointID == 22) {
            txtViewCNTower.setText(getString(R.string.point_22));
            imgView.setBackgroundResource(R.drawable.point_22);
        } else if (pointID == 23) {
            txtViewCNTower.setText(getString(R.string.point_23));
            imgView.setBackgroundResource(R.drawable.point_23);
        } else if (pointID == 24) {
            txtViewCNTower.setText(getString(R.string.point_24));
            imgView.setBackgroundResource(R.drawable.point_24);
        } else if (pointID == 25) {
            txtViewCNTower.setText(getString(R.string.point_25));
            imgView.setBackgroundResource(R.drawable.point_25);
        } else if (pointID == 26) {
            txtViewCNTower.setText(getString(R.string.point_26));
            imgView.setBackgroundResource(R.drawable.point_26);
        } else if (pointID == 27) {
            txtViewCNTower.setText(getString(R.string.point_27));
            imgView.setBackgroundResource(R.drawable.point_27);
        } else if (pointID == 28) {
            txtViewCNTower.setText(getString(R.string.point_28));
            imgView.setBackgroundResource(R.drawable.point_28);
        } else if (pointID == 29) {
            txtViewCNTower.setText(getString(R.string.point_29));
            imgView.setBackgroundResource(R.drawable.point_29);
        } else if (pointID == 30) {
            txtViewCNTower.setText(getString(R.string.point_30));
            imgView.setBackgroundResource(R.drawable.point_30);
        }else if (pointID == 31) {
            txtViewCNTower.setText(getString(R.string.point_31));
            imgView.setBackgroundResource(R.drawable.point_31);
        } else if (pointID == 32) {
            txtViewCNTower.setText(getString(R.string.point_32));
            imgView.setBackgroundResource(R.drawable.point_32);
        } else if (pointID == 33) {
            txtViewCNTower.setText(getString(R.string.point_33));
            imgView.setBackgroundResource(R.drawable.point_33);
        } else if (pointID == 34) {
            txtViewCNTower.setText(getString(R.string.point_34));
            imgView.setBackgroundResource(R.drawable.point_34);
        } else if (pointID == 35) {
            txtViewCNTower.setText(getString(R.string.point_35));
            imgView.setBackgroundResource(R.drawable.point_35);
        } else if (pointID == 36) {
            txtViewCNTower.setText(getString(R.string.point_36));
            imgView.setBackgroundResource(R.drawable.point_36);
        } else if (pointID == 37) {
            txtViewCNTower.setText(getString(R.string.point_37));
            imgView.setBackgroundResource(R.drawable.point_37);
        } else if (pointID == 38) {
            txtViewCNTower.setText(getString(R.string.point_38));
            imgView.setBackgroundResource(R.drawable.point_38);
        } else if (pointID == 39) {
            txtViewCNTower.setText(getString(R.string.point_39));
            imgView.setBackgroundResource(R.drawable.point_39);
        } else if (pointID == 40) {
            txtViewCNTower.setText(getString(R.string.point_40));
            imgView.setBackgroundResource(R.drawable.point_40);
        }else if (pointID == 41) {
            txtViewCNTower.setText(getString(R.string.point_41));
            imgView.setBackgroundResource(R.drawable.point_41);
        } else if (pointID == 42) {
            txtViewCNTower.setText(getString(R.string.point_42));
            imgView.setBackgroundResource(R.drawable.point_42);
        } else if (pointID == 43) {
            txtViewCNTower.setText(getString(R.string.point_43));
            imgView.setBackgroundResource(R.drawable.point_43);
        } else if (pointID == 44) {
            txtViewCNTower.setText(getString(R.string.point_44));
            imgView.setBackgroundResource(R.drawable.point_44);
        } else if (pointID == 45) {
            txtViewCNTower.setText(getString(R.string.point_45));
            imgView.setBackgroundResource(R.drawable.point_45);
        } else if (pointID == 46) {
            txtViewCNTower.setText(getString(R.string.point_46));
            imgView.setBackgroundResource(R.drawable.point_46);
        } else if (pointID == 47) {
            txtViewCNTower.setText(getString(R.string.point_47));
            imgView.setBackgroundResource(R.drawable.point_47);
        } else if (pointID == 48) {
            txtViewCNTower.setText(getString(R.string.point_48));
            imgView.setBackgroundResource(R.drawable.point_48);
        } else if (pointID == 49) {
            txtViewCNTower.setText(getString(R.string.point_49));
            imgView.setBackgroundResource(R.drawable.point_49);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        MobileAds.initialize(DetailsActivity.this, getString(R.string.app_id));
        //AdRequest adRequest = new AdRequest.Builder().addTestDevice("9729C22A4D59816BE4E3C61CEE8BF53C").build();
        AdRequest adRequest = new AdRequest.Builder().build();

        mInterstitialAd = new InterstitialAd(DetailsActivity.this);
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
}
