package com.example.denis.smartyplants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.denis.smartyplants.utils.utils.PLANT;

public class PlantPage extends AppCompatActivity {
    TextView info , name;
    ImageView pic;
    Button PlantList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plant_page);
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
        String message = getIntent().getStringExtra(PLANT);
        plantPicker(message);
    }
    void plantPicker(String plant)
    {
        if(plant.equals("0"))
        {
            name.setText("Poison Ivy");
            pic.setImageResource(R.drawable.poisonivy);
            info.setText(getResources().getText(R.string.PoisonIvy));
        }
        else if(plant.equals("1"))
        {
            name.setText("Hyacinth");
            pic.setImageResource(R.drawable.hyacinth);
            info.setText(getResources().getText(R.string.Hyacinth));
        }
        else if(plant.equals("2"))
        {
            name.setText("Poison Oak");
            pic.setImageResource(R.drawable.poisonoak);
            info.setText(getResources().getText(R.string.PoisonOak));
        }
        else if(plant.equals("3"))
        {
            name.setText("Daphne");
            pic.setImageResource(R.drawable.daphne);
            info.setText(getResources().getText(R.string.Daphne));
        }
        else if(plant.equals("4"))
        {
            name.setText("Daffodil");
            pic.setImageResource(R.drawable.daffodil);
            info.setText(getResources().getText(R.string.Daffodil));
        }

        else if (plant.equals("5"))
        {
            name.setText("NightShade");
            pic.setImageResource(R.drawable.nightshade);
            info.setText(getResources().getText(R.string.Nightshade));
        }

        else if(plant.equals("6"))
        {
            name.setText("Ricinus");
            pic.setImageResource(R.drawable.ricinus);
            info.setText(getResources().getText(R.string.Ricinus));
        }

        else if(plant.equals("7"))
        {
            name.setText("Machineel");
            pic.setImageResource(R.drawable.machin);
            info.setText(getResources().getText(R.string.Machineel));
        }
        else if(plant.equals("8"))
        {
            name.setText("Cerbera");
            pic.setImageResource(R.drawable.cerbera);
            info.setText(getResources().getText(R.string.Cerbera));
        }






    }

}

