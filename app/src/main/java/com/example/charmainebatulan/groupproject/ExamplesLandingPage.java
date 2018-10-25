package com.example.charmainebatulan.groupproject;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class ExamplesLandingPage extends AppCompatActivity {

    ImageView usefulVideosIV;
    ImageView codeExamplesIV;
    ImageView resourcesIV;
    private static final String TAG = "ExamplesLandingPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_landing_page);
        Log.d(TAG, "onCreate: Starting");

        // find view from layout resource file
        usefulVideosIV = (ImageView) findViewById(R.id.usefulVideosIV);
        codeExamplesIV = (ImageView) findViewById(R.id.codeExamplesIV);
        resourcesIV = (ImageView) findViewById(R.id.resourcesIV);

        // set ActionBar title
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Examples");

        //codeExamplesIV onClick
        codeExamplesIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: codeExamples imageView clicked");
                Intent intent = new Intent(ExamplesLandingPage.this, ExamplesCodeList.class);
                startActivity(intent);
                Log.d(TAG, "onClick: codeExamplesIV intent launched");
            }
        });
        
        usefulVideosIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: usefulVideos imageView clicked");
                Intent intent = new Intent(ExamplesLandingPage.this, YoutubeLandingPage.class);
                startActivity(intent);
                Log.d(TAG, "onClick: usefulVideosIV intent launch");
            }
        });

        resourcesIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: resources imageView clicked");
                Intent intent = new Intent(ExamplesLandingPage.this, FlickrMainActivity.class);
                startActivity(intent);
                Log.d(TAG, "onClick: resourcesIV intent launch");
            }
        });
    }
}
