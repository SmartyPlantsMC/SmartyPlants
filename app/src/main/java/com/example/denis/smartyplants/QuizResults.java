package com.example.denis.smartyplants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.denis.smartyplants.utils.utils.RESULT;

public class QuizResults extends AppCompatActivity {
    TextView scored;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        String incomingmsg = getIntent().getStringExtra(RESULT);
        scored = (TextView)findViewById(R.id.score);

        if(Integer.parseInt(incomingmsg) >= 60)
        {
            scored.setText("Good job you have passed with a " + incomingmsg);
        }
        else
        {
            scored.setText("Sorry you have only received a " + incomingmsg + " better luck next time");
        }



    }
}
