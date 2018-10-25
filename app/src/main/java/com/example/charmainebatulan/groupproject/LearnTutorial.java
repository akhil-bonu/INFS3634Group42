package com.example.charmainebatulan.groupproject;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class LearnTutorial extends AppCompatActivity {

    ImageView learnImage;
    TextView descriptionTV;
    private static final String TAG = "LearnTutorial";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_tutorial);
        Log.d(TAG, "onCreate: Starting");

        // find view from layout resource file
        learnImage = (ImageView)findViewById(R.id.learnImage);
        descriptionTV = (TextView)findViewById(R.id.descriptionTV);



        //retrieve intent
        Intent intent = getIntent();
        int passedID = intent.getExtras().getInt("map");
        Log.d(TAG, "onCreate: intent data retrieved");
        Content lc = LearnContentData.getContentById(passedID);
        learnImage.setImageResource(lc.getImage());
        descriptionTV.setText(lc.getDescription());
        descriptionTV.setMovementMethod(new ScrollingMovementMethod());


        // set ActionBar title
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle(lc.getTopic());

    }
}
