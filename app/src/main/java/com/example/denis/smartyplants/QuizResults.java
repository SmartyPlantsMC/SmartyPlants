package com.example.denis.smartyplants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.denis.smartyplants.model.Score;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import static com.example.denis.smartyplants.utils.utils.RESULT;

public class QuizResults extends AppCompatActivity {
    TextView scored;
    DatabaseReference myRef;
    ImageView scorePic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-7757616415214622");

        AdView mAdView = (AdView) findViewById(R.id.adViewQR);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Creates a reference in firebase that puts the result of the quizzes under 'scores'
        myRef = FirebaseDatabase.getInstance().getReference("scores");

        String incomingmsg = getIntent().getStringExtra(RESULT);
        scored = (TextView)findViewById(R.id.score);
        scorePic = (ImageView)findViewById(R.id.ScorePic);

        //Pushes the users score to the firebase and creates
        // a new score each time instead of replacing the old one
        myRef.push().setValue(new Score(incomingmsg));

        if(Integer.parseInt(incomingmsg) >= 60)
        {
            scored.setText("Good job you have passed with a " + incomingmsg);
            scorePic.setImageResource(R.drawable.goodgrade);
        }
        else
        {
            scored.setText("Sorry you have only received a " + incomingmsg + " better luck next time");
            scorePic.setImageResource(R.drawable.badgrade);
        }



    }

    public void back(View view) {
        Intent intent = new Intent(QuizResults.this, MainActivity.class);
        startActivity(intent);
    }
}
