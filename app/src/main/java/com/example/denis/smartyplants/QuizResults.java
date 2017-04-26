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
        //Creates the banner for the ad for AdMob
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
        //If the score is above or equal to 70 then the message of good job along with a smiley face is shown
        if(Integer.parseInt(incomingmsg) >= 70)
        {
            scored.setText("Good job you have passed with a " + incomingmsg);
            scorePic.setImageResource(R.drawable.goodgrade);
        }
        //If the score is below 70 then the message of better luck next time along with a sad face is shown
        else
        {
            scored.setText("Sorry you have only received a " + incomingmsg + " better luck next time");
            scorePic.setImageResource(R.drawable.badgrade);
        }



    }
    //Button that takes the user back to the home page after the quiz results
    public void back(View view) {
        Intent intent = new Intent(QuizResults.this, MainActivity.class);
        startActivity(intent);
    }
}
