package com.example.denis.smartyplants;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.denis.smartyplants.model.Score;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import static com.example.denis.smartyplants.utils.utils.RESULT;

public class QuizResults extends AppCompatActivity {
    TextView scored;
    DatabaseReference myRef;
    FirebaseStorage mFirebaseStorage;
    StorageReference mStorageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);

        myRef = FirebaseDatabase.getInstance().getReference();

        String incomingmsg = getIntent().getStringExtra(RESULT);
        scored = (TextView)findViewById(R.id.score);



        myRef.push().setValue(new Score(incomingmsg));
        mFirebaseStorage = FirebaseStorage.getInstance();
        mStorageReference = mFirebaseStorage.getReference();

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
