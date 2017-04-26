package com.example.denis.smartyplants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MoreInfo extends AppCompatActivity {
    TextView Moreinfo , MoreInfoname;
    ImageView MoreInfopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info);
        Moreinfo = (TextView)findViewById(R.id.MoreInfo_Desc);
        MoreInfopic = (ImageView)findViewById(R.id.MoreInfo_Pic);
        MoreInfoname = (TextView)findViewById(R.id.NameOfPlant);
    }

    void plantPicker(String plant)
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

}
