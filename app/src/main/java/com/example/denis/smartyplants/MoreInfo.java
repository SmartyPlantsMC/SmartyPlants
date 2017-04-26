package com.example.denis.smartyplants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static com.example.denis.smartyplants.utils.utils.PLANT;

public class MoreInfo extends AppCompatActivity {
    TextView Moreinfo , MoreInfoname;
    ImageView MoreInfopic;
    String msg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7757616415214622");

        AdView mAdView = (AdView) findViewById(R.id.adViewMI);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Moreinfo = (TextView)findViewById(R.id.MoreInfo_Desc);
        MoreInfopic = (ImageView)findViewById(R.id.MoreInfo_Pic);
        MoreInfoname = (TextView)findViewById(R.id.MoreInfoPlantName);
        msg = getIntent().getStringExtra(PLANT);
        plantPickerMoreInfo(msg);
    }
    //PlantPicker for the more info page
    //This function takes the string value from incoming message from the List of plant page
    //Depending on the value it receives, it will pick the text, image, and the info about the plant
    void plantPickerMoreInfo(String plant)
    {
        if(plant.equals("0"))
        {
            MoreInfoname.setText("Poison Ivy");
            MoreInfopic.setImageResource(R.drawable.poisonivy);
            Moreinfo.setText(getResources().getText(R.string.PoisonIvy));
        }
        else if(plant.equals("1"))
        {
            MoreInfoname.setText("Hyacinth");
            MoreInfopic.setImageResource(R.drawable.hyacinth);
            Moreinfo.setText(getResources().getText(R.string.Hyacinth));
        }
        else if(plant.equals("2"))
        {
            MoreInfoname.setText("Poison Oak");
            MoreInfopic.setImageResource(R.drawable.poisonoak);
            Moreinfo.setText(getResources().getText(R.string.PoisonOak));
        }
        else if(plant.equals("3"))
        {
            MoreInfoname.setText("Daphne");
            MoreInfopic.setImageResource(R.drawable.daphne);
            Moreinfo.setText(getResources().getText(R.string.Daphne));
        }
        else if(plant.equals("4"))
        {
            MoreInfoname.setText("Daffodil");
            MoreInfopic.setImageResource(R.drawable.daffodil);
            Moreinfo.setText(getResources().getText(R.string.Daffodil));
        }
        else if (plant.equals("5"))
        {
            MoreInfoname.setText("NightShade");
            MoreInfopic.setImageResource(R.drawable.nightshade);
            Moreinfo.setText(getResources().getText(R.string.Nightshade));
        }
        else if(plant.equals("6"))
        {
            MoreInfoname.setText("Ricinus");
            MoreInfopic.setImageResource(R.drawable.daffodil);
            Moreinfo.setText(getResources().getText(R.string.Ricinus));
        }

        else if(plant.equals("7"))
        {
            MoreInfoname.setText("Machineel");
            MoreInfopic.setImageResource(R.drawable.machin);
            Moreinfo.setText(getResources().getText(R.string.Machineel));
        }
        else if(plant.equals("8"))
        {
            MoreInfoname.setText("Cerbera");
            MoreInfopic.setImageResource(R.drawable.cerbera);
            Moreinfo.setText(getResources().getText(R.string.Cerbera));
        }
        else if(plant.equals("9"))
        {
            MoreInfoname.setText("Angel's Trumpet");
            MoreInfopic.setImageResource(R.drawable.angeltrumpet);
            Moreinfo.setText(getResources().getText(R.string.AngelsTrumpet));
        }

    }
    //Button that lets the user go to the plant page
    public void goToPlantPage(View view) {
        Intent intent = new Intent(MoreInfo.this, PlantPage.class);
        intent.putExtra(PLANT,msg);
        startActivity(intent);
    }
    //Button that lets the user go to the home page
    public void goToHomePage(View view) {
        Intent intent2 = new Intent(MoreInfo.this, MainActivity.class);
        startActivity(intent2);
    }
}
