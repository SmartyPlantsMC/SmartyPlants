package com.example.denis.smartyplants;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


import static com.example.denis.smartyplants.R.array.Questions;
import static com.example.denis.smartyplants.utils.utils.RESULT;

public class Quiz extends AppCompatActivity {
RadioGroup Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10;

    TextView quest1,quest2,quest3,quest4,quest5,quest6,quest7,quest8,quest9,quest10;

    String Answers[];
    ArrayList<Integer> list = new ArrayList<>();
    ArrayList<String> lstOfAnswers = new ArrayList<>();
    int[] check= new int[10];
    int score =0;

Button submit;
    RadioButton radiobtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //The answer array contains the String array of questions which is all the questions and answers
        Answers = getResources().getStringArray(R.array.Questions);

        //adds the values of 0-10 to the list
        setContentView(R.layout.activity_quiz);
        for(int w = 0; w<10; w++)
        {
            list.add(new Integer(w));
        }


        //Takes the list and shuffles the current numbers it has into a random order
        Collections.shuffle(list);
        //Radio groups for the 10 quiz questions
        Q1 = (RadioGroup)findViewById(R.id.Q1group);

        Q2 = (RadioGroup)findViewById(R.id.Q2group);
        Q3 = (RadioGroup)findViewById(R.id.Q3group);
        Q4 = (RadioGroup)findViewById(R.id.Q4group);
        Q5 = (RadioGroup)findViewById(R.id.Q5group);
        Q6 = (RadioGroup)findViewById(R.id.Q6group);
        Q7 = (RadioGroup)findViewById(R.id.Q7group);
        Q8 = (RadioGroup)findViewById(R.id.Q8group);
        Q9 = (RadioGroup)findViewById(R.id.Q9group);
        Q10 = (RadioGroup)findViewById(R.id.Q10group);

        //The questions for the 10 quiz questions which are always randomly selected
        quest1 = (TextView)findViewById(R.id.Quiz_question);
        quest2 = (TextView)findViewById(R.id.Quiz_question2);
        quest3=(TextView)findViewById(R.id.Quiz_question3);
        quest4=(TextView)findViewById(R.id.Quiz_question4);
        quest5 = (TextView)findViewById(R.id.Quiz_question5);
        quest6 = (TextView)findViewById(R.id.Quiz_question6);
        quest7=(TextView)findViewById(R.id.Quiz_question7);
        quest8=(TextView)findViewById(R.id.Quiz_question8);
        quest9 = (TextView)findViewById(R.id.Quiz_question9);
        quest10 = (TextView)findViewById(R.id.Quiz_question10);


        //Calls the questionPicker function and selects a random number from the list array
        //That random number is multiplied by 6 so that the string array comes back with 6 elements
        //The question, the 4 choices, and the answer
            QuestionPicker(Q1, list.get(0) *6, quest1);
            QuestionPicker(Q2, list.get(1)* 6, quest2);
            QuestionPicker(Q3, list.get(2)* 6, quest3);
            QuestionPicker(Q4, list.get(3)* 6, quest4);
            QuestionPicker(Q5, list.get(4)* 6, quest5);
            QuestionPicker(Q6, list.get(5)* 6, quest6);
            QuestionPicker(Q7, list.get(6)* 6, quest7);
            QuestionPicker(Q8, list.get(7)* 6, quest8);
            QuestionPicker(Q9, list.get(8)* 6, quest9);
             QuestionPicker(Q10,list.get(9)* 6, quest10);

        //The submit button takes the user to that gradeQuiz function
        submit = (Button)findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gradeQuiz();


            }
        });

    }
    //The questionPicker function takes the 6 elements it receives from the string array and splits them
    //The question gets put in a the question textView
    //The four choices get assigned to 4 radio button texts
    //The answer is stored and then compared to the users choice radiobutton's value
    void QuestionPicker(RadioGroup quizgroup,int y, TextView quizQuestions)
    {

        quizQuestions.setText(Answers[y]);

        //radioButton.setText(Questions[0]);

        int start = y+1;
        int end = start +4;

        int t=0;



        for(int i =start; i <end; i++)
        {


            ((RadioButton) quizgroup.getChildAt(t)).setText(Answers[i]);
            t++;
        }

        lstOfAnswers.add(Answers[end]);





        //quest1.setText(Questions[0]);

    }
    //The check array contains all the values for the users choices for each radiogroup
    void gradeQuiz()
    {

        score = 0;
        check[0] = (Q1.getCheckedRadioButtonId());
        check[1] = (Q2.getCheckedRadioButtonId());
        check[2] = (Q3.getCheckedRadioButtonId());
        check[3] = (Q4.getCheckedRadioButtonId());
        check[4] = (Q5.getCheckedRadioButtonId());
        check[5] = (Q6.getCheckedRadioButtonId());
        check[6] = (Q7.getCheckedRadioButtonId());
        check[7] = (Q8.getCheckedRadioButtonId());
        check[8] = (Q9.getCheckedRadioButtonId());
        check[9] =(Q10.getCheckedRadioButtonId());


        //This loop goes through the 10 answers the user has selected and the 10 current answers
        //It awards the user 10 points for each current answer
        for(int i = 0; i<10; i++)
        {
            radiobtn = (RadioButton)findViewById(check[i]);
            if(radiobtn.getText().equals(lstOfAnswers.get(i)))
            {
                score +=10;
            }
        }

        //It then takes the result and takes the user to the QuizResult page with that score
        Intent intent = new Intent(Quiz.this, QuizResults.class);
        intent.putExtra(RESULT,Integer.toString(score));
        startActivity(intent);


    }
    //Button that takes the user to the home page
    public void goToHomePage2(View view) {
        Intent intent = new Intent(Quiz.this, MainActivity.class);
        startActivity(intent);
    }
}
