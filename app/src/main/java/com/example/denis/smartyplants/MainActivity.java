package com.example.denis.smartyplants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Creates the ad banner for the adMob
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7757616415214622");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
    //Button that allows the user to go to the list of plants page
    public void goToPlants(View view) {
        Intent intent = new Intent(MainActivity.this, ListOfPlants.class);
        startActivity(intent);
    }
    //Button that allows the user to go to take the quiz
    public void takeQuiz(View view) {
        Intent intent = new Intent(MainActivity.this, Quiz.class);
        startActivity(intent);
    }
}
