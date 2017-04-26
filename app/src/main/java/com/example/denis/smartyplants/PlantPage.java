package com.example.denis.smartyplants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import static android.R.id.message;
import static com.example.denis.smartyplants.utils.utils.PLANT;

public class PlantPage extends AppCompatActivity {
    TextView info , name;
    ImageView pic;
    Button PlantList;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_page);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7757616415214622");

        AdView mAdView = (AdView) findViewById(R.id.adViewPP);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        info = (TextView)findViewById(R.id.PlantPage_Desc);
        pic = (ImageView)findViewById(R.id.PlantPage_Image);
        name = (TextView)findViewById(R.id.NameOfPlant);
        PlantList = (Button)findViewById(R.id.PlantPage_PlantList);
        PlantList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(PlantPage.this, ListOfPlants.class);
                startActivity(intent);

            }
        });
        message = getIntent().getStringExtra(PLANT);
        plantPicker(message);
    }
    //PlantPicker for the Plant page
    //This function takes the string value from incoming message from the List of plant page
    //Depending on the value it receives, it will pick the text, image, and the info about the plant
    void plantPicker(String plant)
    {
        if(plant.equals("0"))
        {
            name.setText(R.string.PoisonIvyName);
            pic.setImageResource(R.drawable.poisonivy);
            info.setText(getResources().getText(R.string.PoisonIvy));
        }
        else if(plant.equals("1"))
        {
            name.setText(R.string.HyacinthName);
            pic.setImageResource(R.drawable.hyacinth);
            info.setText(getResources().getText(R.string.Hyacinth));
        }
        else if(plant.equals("2"))
        {
            name.setText(R.string.PoisonOakName);
            pic.setImageResource(R.drawable.poisonoak);
            info.setText(getResources().getText(R.string.PoisonOak));
        }
        else if(plant.equals("3"))
        {
            name.setText(R.string.DaphneName);
            pic.setImageResource(R.drawable.daphne);
            info.setText(getResources().getText(R.string.Daphne));
        }
        else if(plant.equals("4"))
        {
            name.setText(R.string.DaffodilName);
            pic.setImageResource(R.drawable.daffodil);
            info.setText(getResources().getText(R.string.Daffodil));
        }

        else if (plant.equals("5"))
        {
            name.setText(R.string.NightshadeName);
            pic.setImageResource(R.drawable.nightshade);
            info.setText(getResources().getText(R.string.Nightshade));
        }

        else if(plant.equals("6"))
        {
            name.setText(R.string.RicinusName);
            pic.setImageResource(R.drawable.ricinus);
            info.setText(getResources().getText(R.string.Ricinus));
        }

        else if(plant.equals("7"))
        {
            name.setText(R.string.MachineeName);
            pic.setImageResource(R.drawable.machin);
            info.setText(getResources().getText(R.string.Machineel));
        }
        else if(plant.equals("8"))
        {
            name.setText(R.string.CerberaName);
            pic.setImageResource(R.drawable.cerbera);
            info.setText(getResources().getText(R.string.Cerbera));
        }
        else if(plant.equals("9"))
        {
            name.setText(R.string.AngelsTrumpetName);
            pic.setImageResource(R.drawable.angeltrumpet);
            info.setText(getResources().getText(R.string.AngelsTrumpet));
        }






    }
    //Takes the value of the current plant the user is on
    //Takes them to the more info page that shows the user more info on the plant they're currently looking at
    public void goToMoreInfo(View view) {
        Intent intent = new Intent(PlantPage.this, MoreInfo.class);
        intent.putExtra(PLANT,message);
        startActivity(intent);
    }
}

