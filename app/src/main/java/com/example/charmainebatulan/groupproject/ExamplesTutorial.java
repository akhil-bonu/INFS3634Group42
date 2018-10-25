package com.example.charmainebatulan.groupproject;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ExamplesTutorial extends AppCompatActivity {

    ImageView codeIV;
    ImageView outputIV;
    Button showOutputButton;
    private static final String TAG = "ExamplesTutorial";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_tutorial);
        Log.d(TAG, "onCreate: Starting");

        // find view from layout resource file
        codeIV = (ImageView)findViewById(R.id.codeIV);
        outputIV = (ImageView)findViewById(R.id.outputIV);
        showOutputButton = (Button)findViewById(R.id.showOutputButton);

        //retrieve intent
        Intent intent = getIntent();
        int exampleID = intent.getExtras().getInt("examplesMap");
        Log.d(TAG, "onCreate: intent data retrieved");
        Content content = LearnContentData.getExampleById(exampleID);
        codeIV.setImageResource(content.getCodingExample());
        outputIV.setImageResource(content.getOutput());



        //code for when use clicks SHOW button
        showOutputButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: show Button clicked ");
                outputIV.setVisibility(View.VISIBLE);
            }
        });


        // set ActionBar title
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle(content.getTopic());


    }
}
