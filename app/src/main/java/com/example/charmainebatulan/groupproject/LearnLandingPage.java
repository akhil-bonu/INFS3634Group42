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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

public class LearnLandingPage extends AppCompatActivity {

    ListView learnListView;
    TextView listTextView;
    private static final String TAG = "LearnLandingPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_landing_page);
        Log.d(TAG, "onCreate: Starting");

        // find view from layout resource file
        learnListView = (ListView)findViewById(R.id.learnListView);
        listTextView = (TextView)findViewById(R.id.listTextView);

        // set ActionBar title
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Topics");


        // adding each item in LearnContentData to ArrayList
        ArrayList<Content> content = new ArrayList<>();
        for (Map.Entry<Integer, Content> c : LearnContentData.content.entrySet()){
            content.add(c.getValue());
            Log.d(TAG, "onCreate: items added to contentArray");
        }

        // adding arrayList to ArrayAdapter
        final ArrayAdapter<Content> contentAdapter = new ArrayAdapter<>(this, R.layout.learn_text_view, content);
        learnListView.setAdapter(contentAdapter);
        Log.d(TAG, "onCreate: added to content arrayAdapter ");

        //code for when user clicks on an item
        learnListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d(TAG, "onCreate: listView clicked");
                Content lc = (Content)learnListView.getItemAtPosition(position);
                int myPosition = lc.getId();
                Intent intent = new Intent(LearnLandingPage.this, LearnTutorial.class);
                intent.putExtra("map", myPosition);
                startActivity(intent);
                Log.d(TAG, "onCreate: intent launched");

//                int myPosition = (int)learnListView.getItemAtPosition(position);

            }
        });
    }
}
