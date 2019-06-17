package com.takhero.supermag;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button btn;
    AdView mAdView;
    Typeface btnFont, txtFont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this,"ca-app-pub-2916081203297616~9482160314");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        btn = findViewById(R.id.btnFirst);
        textView = findViewById(R.id.textFirst);
        txtFont = Typeface.createFromAsset(getAssets(),"fonts/Comfortaa-Light.ttf");
        btnFont = Typeface.createFromAsset(getAssets(),"fonts/CaviarDreams_Bold.ttf");
        btn.setTypeface(btnFont);
        textView.setTypeface(txtFont);

        textView.setText(R.string.firstCnv);
        btn.setText(R.string.firstBtn);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        exitApp();
    }

    public void second(View view){
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void exitApp(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
