
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

public class ExamplesCodeList extends AppCompatActivity {

    ListView examplesListView;
    private static final String TAG = "Code Examples";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examples_code_list);
        Log.d(TAG, "onCreate: Starting");

        // find view from layout resource file
        examplesListView = (ListView)findViewById(R.id.youtubeListView);

        // set ActionBar title
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Topics");

        // adding each item in LearnContentData to ArrayList
        ArrayList<Content> examplesMap = new ArrayList<>();
        for (Map.Entry<Integer, Content> e : LearnContentData.examplesMap.entrySet()){
            examplesMap.add(e.getValue());
            Log.d(TAG, "onCreate: items added to examplesMap");

            // adding arrayList to ArrayAdapter
            final ArrayAdapter<Content> examplesAdaptor = new ArrayAdapter<>(this, R.layout.learn_text_view, examplesMap);
            examplesListView.setAdapter(examplesAdaptor);
            Log.d(TAG, "onCreate: added to examplesMap arrayAdapter ");

            examplesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Log.d(TAG, "onCreate: listView clicked");
                    Content ec = (Content)examplesListView.getItemAtPosition(position);
                    int myPosition = ec.getId();
                    Intent intent = new Intent(ExamplesCodeList.this, ExamplesTutorial.class);
                    intent.putExtra("examplesMap", myPosition);
                    startActivity(intent);
                    Log.d(TAG, "onCreate: intent launched");

//

                }
            });


        }
    }
}
