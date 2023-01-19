package com.eyffes.adscommons;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends AppCompatActivity {

    private InterstitialAd mInterstitialAd;
    private String AdMobUnitID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //fad
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String result = extras.getString("AdMobUnitID");
            //Toast.makeText(this, "recupere : " + result, Toast.LENGTH_SHORT).show();
            InterstitialAd_load(AdMobUnitID);
        }
        //else
        //    Toast.makeText(this, "RIEN RECUPERE 1 : " + extras + " class :" + this.getClass().getSimpleName() , Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //InterstitialAd_load(AdMobUnitID);
        //showAd();
    }

    public void InterstitialAd_load(String adMobUnitID) {

        //InterstitialAd_load(adMobUnitID = "ca-app-pub-3940256099942544/3419835294");
        AdRequest adRequest = new AdRequest.Builder().build();
        //ca-app-pub-4465131953139681/1616732799 vrai
        // 2 ca-app-pub-4465131953139681/7270472003
        //test ca-app-pub-3940256099942544/1033173712
        // new test ca-app-pub-3940256099942544/3419835294
        //InterstitialAd.load(this,"ca-app-pub-3940256099942544/3419835294", adRequest,

        if (adMobUnitID == null ) adMobUnitID = "ca-app-pub-3940256099942544/3419835294";
        else
            Toast.makeText(getApplicationContext(), "recupéré 2  " + adMobUnitID, Toast.LENGTH_SHORT).show();

            InterstitialAd.load(this,adMobUnitID, adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        mInterstitialAd = interstitialAd;
                        mInterstitialAd.show(getParent());
                        //Toast.makeText(getApplicationContext(), "LOADED", Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        //Toast.makeText(getApplicationContext(), "NOT LOADED " +  loadAdError.getMessage(), Toast.LENGTH_SHORT).show();
                        mInterstitialAd = null;
                    }
                });
    }

    /*void showAd(){
        //boolean result = false;
        if (mInterstitialAd != null) {
            mInterstitialAd.show(this);
            //Toast.makeText(getApplicationContext(), "je lance le ad", Toast.LENGTH_LONG).show();
            //InterstitialAd_load(AdMobUnitID);
            //result = true;
        } else {
            InterstitialAd_load(AdMobUnitID);
            //Toast.makeText(getApplicationContext(), "PAS de AD a lancer", Toast.LENGTH_LONG).show();
        }
        //return result;
    }*/
}