package com.example.charmainebatulan.groupproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

//Leveraged publicly available code via github to develop the pie charts

public class Results extends AppCompatActivity{

    private static final String TAG = "Results";

    PieChart pieChart;
    TextView noRightAndWrong;
    TextView resultTextView;

    Button seeIncorrectBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate: Starting OnCreate for results");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // rename action bar
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setTitle("Results");

        final ArrayList<Question> gotWrong = (ArrayList<Question>)getIntent().getSerializableExtra("wrong");
        ArrayList<Question> gotRight = (ArrayList<Question>)getIntent().getSerializableExtra("right");

        float results[] = {gotRight.size(), gotWrong.size()};
        String xEntries[] = {"Correct", "Incorrect"};

        int temp = gotRight.size();
        double temp1 = Double.valueOf(temp);

        double doubleMark = (double) (temp1 / 13.0);

        Log.d(TAG, "onCreate: Calculated mark is " + doubleMark);


        //Assigning widgets to views
        pieChart = findViewById(R.id.resultChart);
        noRightAndWrong = findViewById(R.id.correctText);
        resultTextView = findViewById(R.id.resultTextView);
        seeIncorrectBtn = findViewById(R.id.seeIncorrectBtn);

        //methods to set the pie chart and set the Textviews
        setPieChart(results, doubleMark, xEntries);
        displayResultTexts(gotRight, gotWrong, doubleMark);

        if(gotWrong.size()==0) { //If user got all the questions correct, hide the seeIncorrectBtn
            seeIncorrectBtn.setVisibility(View.INVISIBLE);
            Log.d(TAG, "onCreate: Nothing wrong");
        } else seeIncorrectBtn.setVisibility(View.VISIBLE);

        seeIncorrectBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Starting");
                //Start intent to go to the ShowIncorrect Activity
                Intent intent = new Intent(Results.this, ShowIncorrect.class);
                intent.putExtra("GotWrong", gotWrong);
                startActivity(intent);
                Log.d(TAG, "onClick: Completed");

            }
        });



        Log.d(TAG, "onCreate: Completed");
    }

    //Method first sets all the visual properties of the graph
    //Then sets the data to the chart
    public void setPieChart(float[] results, double result, String[] xEntries) {
        Log.d(TAG, "setPieChart: Starting");

        pieChart.setRotationEnabled(true);
        pieChart.setUsePercentValues(true);
        pieChart.setCenterTextColor(Color.BLACK);
        pieChart.setHoleRadius(25f);
        pieChart.setHoleColor(Color.WHITE);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText(calculateMark(result)); //Sets the center text of the chart to display the mark
        pieChart.setCenterTextSize(25);
        pieChart.setDrawEntryLabels(true);
        pieChart.setEntryLabelTextSize(20);
        pieChart.setDescription(null);
        Legend legend =pieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);

        List<PieEntry> pieEntryList = new ArrayList<>();

        for (int i = 0; i < results.length; i++) {
            pieEntryList.add(new PieEntry(results[i], xEntries[i]));
        }

        PieDataSet dataSet = new PieDataSet(pieEntryList, "");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData data = new PieData(dataSet);
        data.setDrawValues(false);
        pieChart.setData(data);

        Log.d(TAG, "setPieChart: Completed");
    }

    public void displayResultTexts(ArrayList<Question> gotRight, ArrayList<Question> gotWrong, double result) {
        Log.d(TAG, "displayResultTexts: Starting ");

        String noRightAndWrong = "You got " + gotRight.size() + " correct and " + gotWrong.size() + " incorrect";
        this.noRightAndWrong.setText(noRightAndWrong);

        String mark = calculateMark(result);
        String resultText = "Your mark is " + mark;
        resultTextView.setText(resultText);

        Log.d(TAG, "displayResultTexts: Completed");
    }

    public String calculateMark(double result) {
        Log.d(TAG, "calculateMark: Starting");

        double result2 =  (result*100.0);
        String mark;


        if (result2 < 50) {
            mark = "FL";
        } else if (result2 < 65.0) {
            mark = "PS";
        } else if (result2 < 75.0) {
            mark = "CR";
        } else if (result2 < 85.0) {
            mark = "DS";
        } else {
            mark = "HD";
        }

        Log.d(TAG, "calculateMark: Completed");

        return mark;

    }
}