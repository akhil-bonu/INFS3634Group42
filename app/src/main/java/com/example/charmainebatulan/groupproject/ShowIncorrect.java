package com.example.charmainebatulan.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

public class ShowIncorrect extends AppCompatActivity {
    private static final String TAG = "QuizMain";
    Button nextBtn;
    Button backBtn;
    TextView qText;
    TextView answerText;
    TextView hintText;
    ImageView imageView;
    ImageView homeBtnView;
    int currentIndex = 0;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Starting for ShowIncorrect Activity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_incorrect);
        nextBtn = findViewById(R.id.nextBtn);
        backBtn = findViewById(R.id.backBtn);
        qText = findViewById(R.id.qText);
        answerText = findViewById(R.id.answerText);
        hintText = findViewById(R.id.hintText);
        imageView = findViewById(R.id.imageView);
        homeBtnView = findViewById(R.id.goToHome);


        //Establishing the visibilities of all the buttons at OnCreate, to ensure proper manipulation during the button listeners
        homeBtnView.setVisibility(View.INVISIBLE);
        nextBtn.setVisibility(View.VISIBLE);
        backBtn.setVisibility(View.VISIBLE);

        // rename action bar
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Incorrect Answers");


        //Recieve the Question ArrayList from intent
        final ArrayList<Question> gotWrong = (ArrayList<Question>) getIntent().getSerializableExtra("GotWrong");

        //Loading the first incorrectly answered question
        refreshQ(gotWrong.get(currentIndex));

        //Listener for next button
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Starting");

                //This increment will only occur until the end of the gotWrong array is reached
                if (currentIndex != (gotWrong.size() - 1)) {
                    currentIndex++;
                    refreshQ(gotWrong.get(currentIndex));
                    Log.d(TAG, "onClick: Refreshed to question number: " + (currentIndex + 1));


                    /*Once the end of the array has been reached, alter visibilities to force the user to
                    either go back or go to the home screen
                     */
                    if (currentIndex == gotWrong.size() - 1) {
                        homeBtnView.setVisibility(View.VISIBLE);
                        nextBtn.setVisibility(View.INVISIBLE);
                    }

                }
                Log.d(TAG, "onClick: Completed");
            }
        });

        //Listener for back button
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Starting");
                if (currentIndex == 0) {//If the user tries clicking back when on the first question
                    Log.d(TAG, "onClick: On first wrong question");
                } else {
                    currentIndex--;
                    refreshQ(gotWrong.get(currentIndex));

                    //Ensuring the next button remains visible as long as the user isn't at the end of the array
                    nextBtn.setVisibility(View.VISIBLE);
                    Log.d(TAG, "onClick: Refreshed to question number: " + (currentIndex + 1));
                }
                Log.d(TAG, "onClick: Completed");
            }
        });

        //Listener for the home icon (in top right corner) which will take user to home screen
        //Note: user must view all of their incorrect answers before being able to exit this screen and go to the home page
        homeBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ShowIncorrect.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }

    //Method to refresh the page to align with the current Index. Similar to how the quiz questions were handled
    public void refreshQ(Question question) {
        Log.d(TAG, "refreshQ: Starting");
        if (question.getExtras() == 'I') {
            imageView.setImageResource(question.getImageRef());
        } else imageView.setImageResource(R.drawable.quiz_placeholder);

        String qTextString = (getResources().getString(question.getqID()));
        qText.setText(qTextString);

        String answerTextString = question.getAnswer();
        answerText.setText(answerTextString);

        String hintString = (getResources().getString(question.getHint()));
        hintText.setText(hintString);

        Log.d(TAG, "refreshQ: Completed");
    }


}