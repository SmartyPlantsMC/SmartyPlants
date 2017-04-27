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
            MoreInfoname.setText(R.string.PoisonIvyName);
            MoreInfopic.setImageResource(R.drawable.poisonivymore);
            Moreinfo.setText(R.string.PoisonIvyMore);
        }
        else if(plant.equals("1"))
        {
            MoreInfoname.setText(R.string.HyacinthName);
            MoreInfopic.setImageResource(R.drawable.hyacinthmore);
            Moreinfo.setText(R.string.Hyacinth);
        }
        else if(plant.equals("2"))
        {
            MoreInfoname.setText(R.string.PoisonOakName);
            MoreInfopic.setImageResource(R.drawable.poisonoakmore);
            Moreinfo.setText(getResources().getText(R.string.PoisonOak));
        }
        else if(plant.equals("3"))
        {
            MoreInfoname.setText(R.string.DaphneName);
            MoreInfopic.setImageResource(R.drawable.daphnemore);
            Moreinfo.setText(getResources().getText(R.string.Daphne));
        }
        else if(plant.equals("4"))
        {
            MoreInfoname.setText(R.string.DaffodilName);
            MoreInfopic.setImageResource(R.drawable.daffodilmore);
            Moreinfo.setText(getResources().getText(R.string.Daffodil));
        }
        else if (plant.equals("5"))
        {
            MoreInfoname.setText(R.string.NightshadeName);
            MoreInfopic.setImageResource(R.drawable.nightshademore);
            Moreinfo.setText(getResources().getText(R.string.NightShadeMore));
        }
        else if(plant.equals("6"))
        {
            MoreInfoname.setText(R.string.RicinusName);
            MoreInfopic.setImageResource(R.drawable.ricinusmore);
            Moreinfo.setText(R.string.RicinusMore);
        }

        else if(plant.equals("7"))
        {
            MoreInfoname.setText(R.string.MachineeName);
            MoreInfopic.setImageResource(R.drawable.machineelmore);
            Moreinfo.setText(R.string.MachineelMore);
        }
        else if(plant.equals("8"))
        {
            MoreInfoname.setText(R.string.CerberaName);
            MoreInfopic.setImageResource(R.drawable.cerberamore);
            Moreinfo.setText(R.string.CerberaMore);
        }
        else if(plant.equals("9"))
        {
            MoreInfoname.setText(R.string.AngelsTrumpetName);
            MoreInfopic.setImageResource(R.drawable.angelstrumpetmore);
            Moreinfo.setText(getResources().getText(R.string.AngelTrumpetMore));
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
