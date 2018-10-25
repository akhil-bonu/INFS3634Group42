package com.example.charmainebatulan.groupproject;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView learnIV;
    ImageView examplesIV;
    ImageView quizIV;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Starting");

        // find view from layout resource file
        learnIV = (ImageView) findViewById(R.id.learnIV);
        examplesIV = (ImageView) findViewById(R.id.examplesIV);
        quizIV = (ImageView) findViewById(R.id.quizIV);


        // rename action bar
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Inherit Java");

        //onClick for learnIV
        learnIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: learn imageView clicked");
                Intent intent = new Intent(MainActivity.this, LearnLandingPage.class);
                startActivity(intent);
                Log.d(TAG, "onClick: learnIV intent launched");
            }
        });

        //onClick for examplesIV
        examplesIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: examples imageView clicked");
                Intent intent = new Intent(MainActivity.this, ExamplesLandingPage.class);
                startActivity(intent);
                Log.d(TAG, "onClick: examplesIV intent launched");
            }
        });

        //onClick for quizIV
        quizIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: quiz ImageView clicked");
                Intent intent = new Intent(MainActivity.this, QuizMain.class);
                startActivity(intent);
                Log.d(TAG, "onClick: quizIV intent launched");


            }
        });

    }

}