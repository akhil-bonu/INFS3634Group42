package com.example.charmainebatulan.groupproject;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class YoutubeLandingPage extends AppCompatActivity {

    private static final String TAG = "YoutubeLandingPage";
    ListView youtubeListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_landing_page);
        Log.d(TAG, "onCreate: Starting");

        //find resources
        youtubeListView = (ListView) findViewById(R.id.youtubeListView);

        // set ActionBar title
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Youtube Videos");

        // adding each item in LearnContentData to ArrayList
        ArrayList<Content> videoMap = new ArrayList<>();
        for (Map.Entry<Integer, Content> e : LearnContentData.youtubeMap.entrySet()) {
            videoMap.add(e.getValue());
            Log.d(TAG, "onCreate: items added to examplesMap");

            // adding arrayList to ArrayAdapter
            final ArrayAdapter<Content> videoAdaptor = new ArrayAdapter<>(this, R.layout.learn_text_view, videoMap);
            youtubeListView.setAdapter(videoAdaptor);
            Log.d(TAG, "onCreate: added to examplesMap arrayAdapter ");

            youtubeListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d(TAG, "onCreate: listView clicked");
                    Content yc = (Content) youtubeListView.getItemAtPosition(position);
                    int myPosition = yc.getId();
                    Intent intent = new Intent(YoutubeLandingPage.this, YoutubeActivity.class);
                    intent.putExtra("youtubeMap", myPosition);
                    startActivity(intent);
                    Log.d(TAG, "onCreate: intent launched");

                }
            });


        }
    }
}
