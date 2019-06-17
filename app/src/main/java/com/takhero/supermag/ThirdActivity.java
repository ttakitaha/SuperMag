package com.takhero.supermag;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ThirdActivity extends AppCompatActivity {

    TextView textView;
    ProgressBar pBar;
    AdView mAdView;
    Typeface btnFont, txtFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        MobileAds.initialize(this,"ca-app-pub-2916081203297616~9482160314");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        textView = findViewById(R.id.textFirst);
        pBar = findViewById(R.id.pBar);
        txtFont = Typeface.createFromAsset(getAssets(),"fonts/Comfortaa-Light.ttf");
        btnFont = Typeface.createFromAsset(getAssets(),"fonts/CaviarDreams_Bold.ttf");
        textView.setTypeface(txtFont);

        textView.setText(R.string.thirdCnv);
        pBar.setVisibility(View.VISIBLE);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(ThirdActivity.this, FourthActivity.class));
                finish();
            }
        }, 3250);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(ThirdActivity.this, MainActivity.class));
        finish();
    }
}
