package com.example.denis.smartyplants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static com.example.denis.smartyplants.utils.utils.PLANT;

public class ListOfPlants extends AppCompatActivity {

    private ListView mListView;
    private Button homePage;
    ArrayAdapter<String> adapter;
    ArrayList<String> listOfPlants = new ArrayList<>();

    String[] plantName=new String[]{
            "Poison Ivy",
            "Hyacinth",
            "Poison Oak",
            "Daphne Berries",
            "Daffodil",

            "Ricinus",
            "Machineel",
            "Cerbera"

            

    };

    int[] plantImage=new int[]{
            R.drawable.poisonivy,
            R.drawable.hyacinth,
            R.drawable.poisonoak,
            R.drawable.daphne,
            R.drawable.daffodil,

            R.drawable.ricinus,
            R.drawable.machin,
            R.drawable.cerbera

           

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_plants);
        mListView = (ListView) findViewById(R.id.Plant_list);

        List<HashMap<String, String>> aList=new ArrayList<HashMap<String, String>>();



        for (int i=0; i<8;i++){


            HashMap<String, String> hm=new HashMap<String, String>();
            hm.put("plant_name",plantName[i]);
            hm.put("plant_pic",Integer.toString(plantImage[i]));
            aList.add(hm);
        }

        String[] from={"plant_name","plant_pic"};
        int[] to={R.id.plant_name,R.id.plant_pic};

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListOfPlants.this, PlantPage.class);
                intent.putExtra(PLANT, String.valueOf(position));
                startActivity(intent);
            }
        });

        SimpleAdapter simpleAdapter=new SimpleAdapter(getBaseContext(),aList,R.layout.mylist,from,to);
        ListView androidListView=(ListView)findViewById(R.id.Plant_list);
        androidListView.setAdapter(simpleAdapter);

    }

}
