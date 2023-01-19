package com.eyffes.adscommons;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class LauncActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // showToastMessage = false; // want to avoid here
        super.onCreate(savedInstanceState);// I always want this in first line of onCreate
        Intent intent = new Intent(LauncActivity.this, MainActivity.class);
        //intent.putExtra("AdMobUnitID", "ca-app-pub-4465131953139681/6515863348");
        intent.putExtra("AdMobUnitID", getAdMobUnitID());
        startActivity(intent);
        finish();
    }

    private String getAdMobUnitID (){
        String mAdMobUnitID = "";
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mAdMobUnitID = extras.getString("AdMobUnitID");
            Toast.makeText(this, "recupere : " + mAdMobUnitID + "class : " + getClass().getSimpleName(), Toast.LENGTH_SHORT).show();
        }
        else
            mAdMobUnitID = "ca-app-pub-3940256099942544/3419835294";
            Toast.makeText(this, "RIEN RECUPERE 1 : " + extras + " class :" + this.getClass().getSimpleName() , Toast.LENGTH_SHORT).show();

        return mAdMobUnitID;
    }


}
