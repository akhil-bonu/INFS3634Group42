package com.example.charmainebatulan.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class QuizMain extends YouTubeBaseActivity {

    private static final String TAG = "QuizMain";
    YouTubePlayerView youTubePlayerView;
    YouTubePlayer.OnInitializedListener onInitializedListener;

    ImageView imageView;
    Button nextBtn;
    EditText editText;
    TextView qText;

    //Making in-code checks
    int currentIndex = 0; //Which question the user is up to
    boolean vidStarted; //Boolean to tell if video has started or not


    //Making radio buttons
    RadioGroup radioGroup;
    RadioButton ans1;
    RadioButton ans2;
    RadioButton ans3;
    RadioButton ans4;

    Question[] qBank = new Question[]{
            //NOTE: All the free response answers should be in ALL lowercase
            //PSS: the constructors need to assign the image to the question
            new Question(R.string.Question_1, "True", "False", null, null, null, 'T', 'N', R.string.q1_hint),
            new Question(R.string.Question_2, "False", "True", null, null, null, 'T', 'N',R.string.q2_hint),
            new Question(R.string.Question_3, "Unlimited", "1", "20", "Depends on constructor", null, 'M', 'N', R.string.q3_hint),
            new Question(R.string.Question_4, "Both", "Saving redundancy", "Creating hierarchies in OOP", "Neither", null, 'M', 'N', R.string.q4_hint),
            new Question(R.string.Question_5, "extends", "superclass()", "subclass()", ".inherit", null, 'F', 'N', R.string.q5_hint),//free
            new Question(R.string.Question_6, "super", null, null, null, null, 'F', 'N', R.string.q6_hint), //Free
            new Question(R.string.Question_7, "False", "True", null, null, R.drawable.question_seven_img, 'T', 'I', R.string.q7_hint),
            new Question(R.string.Question_8, "Nine", "Seven", "Fourteen", "One", R.drawable.question_eight_img, 'M', 'I', R.string.q8_hint),
            new Question(R.string.Question_9, "teaching", null, null, null, R.drawable.question_nine_img, 'F', 'I', R.string.q9_hint), //free
            new Question(R.string.Question_10, "All of them", "ScienceTeacher", "ChemistryTeacher", "All EXCEPT ChemistryTeacher", R.drawable.question_ten_img, 'M', 'I', R.string.q10_hint),
            new Question(R.string.Question_11, "True", "False", null, null, null, 'T', 'Y', R.string.q11_hint),
            new Question(R.string.Question_12, "Flying Object", "Materials", "SuperPlane", "Paper Plane", null, 'M', 'Y', R.string.q12_hint),
            new Question(R.string.Question_13, "is-a", null, null, null, null, 'F', 'Y', R.string.q13_hint), //free
    };


    //Arraylists to hold which questions the user got right and wrong. This list gets sent to the results activity via intents
    ArrayList<Question> gotWrong = new ArrayList<>();
    ArrayList<Question> gotRight = new ArrayList<>();

    //OnCreate Method
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Starting");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_main);

//        android.app.ActionBar ab = getActionBar();
//        ab.show();
//        ab.setTitle("Inheritance Quiz");


        //Setting widgets to views
        youTubePlayerView = findViewById(R.id.youTubePlayer);
        qText = findViewById(R.id.qText);
        nextBtn = findViewById(R.id.nextBtn);
        radioGroup = findViewById(R.id.radioGroup);
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        editText = findViewById(R.id.editText);
        imageView = findViewById(R.id.imageView);
        imageView.setVisibility(View.VISIBLE);
        youTubePlayerView.setVisibility(View.INVISIBLE);
        editText.setVisibility(View.INVISIBLE);

        refreshQ();
        Log.d(TAG, "onCreate: First Question displaying");


        /*
        Every time the user clicks next, the program needs to check if the answer is correct, then
        update the necessary values, then go to the next question
         */
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Starting");
                checkAns(qBank[currentIndex]);

                if (currentIndex == (qBank.length - 1)) {
                    Log.d(TAG, "onClick: Finished Quiz, loading and starting intent");
                    //Code load and start intent for results page
                    Intent intent = new Intent(QuizMain.this, Results.class);

                    intent.putExtra("wrong", gotWrong);
                    intent.putExtra("right",gotRight);

                    startActivity(intent);

                } else{
                    //Increment question and reload 'page'
                    currentIndex++;
                    refreshQ();
                    nextBtn.setVisibility(View.INVISIBLE);
                }
                Log.d(TAG, "onClick: Completed");
            }

        });

        Log.d(TAG, "onCreate: Successfully completed onCreate");

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton)group.findViewById(checkedId);

                nextBtn.setVisibility(View.VISIBLE);

            }
        });

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextBtn.setVisibility(View.VISIBLE);

            }
        });
    }

    // Method used to refresh the question screen based on the value of the current Index
    public void refreshQ() {
        Log.d(TAG, "refreshQ: Starting for question " + (currentIndex+1));

        //Hide the next button until a button is selected
        nextBtn.setVisibility(View.INVISIBLE);

        //Clear any existing responses
        radioGroup.clearCheck();
        editText.setText(null);
        Log.d(TAG, "refreshQ: Old responses cleared");

        qText.setText(qBank[currentIndex].getqID()); //Updating the Question field
        updateExtraTypeVisibilities(qBank[currentIndex]); //Update the 'extras' section of the screen
        updateQTypeVisibilities(qBank[currentIndex]); //update which response fields are visible
        Log.d(TAG, "refreshQ: Updated all visibilities");

        //if question is not a free choice, then call method to assign the answers to the radio buttons
        if (qBank[currentIndex].getqType() != 'F') {
            assignAnswers(qBank[currentIndex]);
        }
        Log.d(TAG, "refreshQ: Completed successfully for question " + (currentIndex+1));
    }

/*
updateExtraTypeVisibilities and updateQTypeVisibilities are method to change what is viewable on screen
What is viewable depends on the attributes of the question object,
 */

    //Updating what gets displayed on the top half of the screen
    public void updateExtraTypeVisibilities(Question question) {
        Log.d(TAG, "updateExtraTypeVisibilities: Starting");

        //If question uses the youtube video
        if (question.getExtras() == 'Y') {

            //Set visibilities
            youTubePlayerView.setVisibility(View.VISIBLE);
            imageView.setVisibility(View.INVISIBLE);

            //Starting video if it hasn't already been started
            if (!vidStarted) {
                startVideo(); //method to start the youtube video
            } else {
                Log.d(TAG, "checkExtra: Video has already started");
            }

            //If question uses a non-quiz_placeholder image type
        } else if (question.getExtras() == 'I') {
            Log.d(TAG, "updateExtraTypeVisibilities: Trying to change image");
            //Code to set the image to the image based on question.getImageRef
            imageView.setImageResource(question.getImageRef());

            //Set visibilities
            youTubePlayerView.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);

            //If question doesn't any extras
        } else if (question.getExtras() == 'N') {
            //Set image as quiz_placeholder
            imageView.setImageResource(R.drawable.quiz_placeholder);

            //Set visibilities
            youTubePlayerView.setVisibility(View.INVISIBLE);
            imageView.setVisibility(View.VISIBLE);
        }
        Log.d(TAG, "updateExtraTypeVisibilities: Successfully completed");
    }

    //updating which response fields are available
    public void updateQTypeVisibilities(Question question) {
        Log.d(TAG, "updateQTypeVisibilities: Starting for question " + (currentIndex+1));

        if (question.getqType() == 'T') {
            Log.d(TAG, "checkType: T question");

            ans1.setVisibility(View.VISIBLE);
            ans2.setVisibility(View.VISIBLE);
            ans3.setVisibility(View.INVISIBLE);
            ans4.setVisibility(View.INVISIBLE);
            editText.setVisibility(View.INVISIBLE);

        } else if (question.getqType() == 'M') {
            Log.d(TAG, "checkType: Multiple choice Q");

            ans1.setVisibility(View.VISIBLE);
            ans2.setVisibility(View.VISIBLE);
            ans3.setVisibility(View.VISIBLE);
            ans4.setVisibility(View.VISIBLE);
            editText.setVisibility(View.INVISIBLE);

        } else if (question.getqType() == 'F') {
            Log.d(TAG, "checkType: Free response question");

            ans1.setVisibility(View.INVISIBLE);
            ans2.setVisibility(View.INVISIBLE);
            ans3.setVisibility(View.INVISIBLE);
            ans4.setVisibility(View.INVISIBLE);
            editText.setVisibility(View.VISIBLE);
        }
        Log.d(TAG, "updateQTypeVisibilities: Successfully completed for question " + (currentIndex+1));
    }


    /*
    Method to RANDOMLY assign the options for each question to the radio buttons
     */
    public void assignAnswers(Question question) {
        Log.d(TAG, "assignAnswers: Assigning answers for question: " + (currentIndex+1));

        //Put the options into an arrayList (which can handle both multies and T/F
        ArrayList<String> options = new ArrayList<>(Arrays.asList(
                question.getAnswer(),
                question.getIncorrect1(),
                question.getIncorrect2(),
                question.getIncorrect3()));

        //If the wrong answer is either true or false, then assign the options normally
        //since there's only 2 options in this case, no need for randomisation
        if (options.get(1).equals("True") || options.get(1).equals("False")) {
            ans1.setText(R.string.True);
            ans2.setText(R.string.False);

        } else {

            //Assign the options randomly to the 4 radio buttons
            int randomIndex = Math.abs(new Random().nextInt(4));

            ans1.setText(options.get(randomIndex));
            options.remove(randomIndex);

            randomIndex = Math.abs(new Random().nextInt(3));
            ans2.setText(options.get(randomIndex));
            options.remove(randomIndex);

            randomIndex = Math.abs(new Random().nextInt(2));
            ans3.setText(options.get(randomIndex));
            options.remove(randomIndex);

            ans4.setText(options.get(0));
        }
        Log.d(TAG, "assignAnswers: Completed successfully for question " + (currentIndex+1));
    }


    //Method to check if the user's answer is correct
    public void checkAns(Question question) {
        Log.d(TAG, "checkAns: Checking answer to Question" + (currentIndex+1));
        String answer; //String to hold the correct answer
        String correctAns = question.getAnswer();

        int messageResId = 0;

        /*
          If the question is free choice, extract the answer from the edit text,
          Otherwise call the findCorrectBtn method
         */
        if (question.getqType() == 'F') { answer = editText.getText().toString().toLowerCase(); }
        else answer = findCheckedButton();
        Log.d(TAG, "checkAns: " + correctAns);
        Log.d(TAG, "checkAns: user checked " + answer);


        //Send boolean back to caller based on if user's answer was correct or not
        if (answer.equals(correctAns)) {
            Log.d(TAG, "checkAns: Answer to question " + (currentIndex+1)  + "was correct!");
            gotRight.add(qBank[currentIndex]);
            messageResId = R.string.correct_toast;
        } else {
            Log.d(TAG, "checkAns: Finished Checking");
            gotWrong.add(qBank[currentIndex]);
            messageResId = R.string.incorrect_toast;
        }

        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();
    }

    //Method to figure out which RadioButton is holding the right answer
    public RadioButton findCorrectBtn(String correct) {
        Log.d(TAG, "findCorrectBtn: Starting for question " + (currentIndex+1));
        if (ans1.getText() == correct) {
            return ans1;
        } else if (ans2.getText() == correct) {
            return ans2;
        } else if (ans3.getText() == correct) {
            return ans3;
        } else {
            return ans4;
        }
    }

    //Method to find out which Radio button the user checked
    public String findCheckedButton() {
        if (ans1.isChecked()) return ans1.getText().toString();
        else if (ans2.isChecked()) return ans2.getText().toString();
        else if (ans3.isChecked()) return ans3.getText().toString();
        else return ans4.getText().toString();
    }

    //Method to start the youtube video
    public void startVideo() {
        Log.d(TAG, "startVideo: Starting Video");
        onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo("0PPKccntohM");
                Log.d(TAG, "onInitializationSuccess: Successfully started quiz video");
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onInitializationFailure: Failed to start  quiz video");

            }
        };
        youTubePlayerView.initialize(YoutubeConfig.getApiKey(), onInitializedListener);
        Log.d(TAG, "startVideo: Finished");
    }
}