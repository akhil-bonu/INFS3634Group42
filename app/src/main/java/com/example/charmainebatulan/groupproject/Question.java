package com.example.charmainebatulan.groupproject;

import android.util.Log;

import java.io.Serializable;
//Question is the class that contains blueprint details for building a question for the app

class Question implements Serializable {


    private static final String TAG = "Question";
    private int qID; //the question is contained here in int format. When creating an object, strings.xml will be called
    private String answer; //correct answer
    private String incorrect1; //incorrect option
    private String incorrect2; //incorrect option (3 and 4 will be null if the question is true or false type)
    private String incorrect3;
    private Integer imageRef; //reference to which image the question uses (will be null if quiz_placeholder is to be used)
    private char qType; //Either: T = True/False, M = Multiple Choice, or F = Free choice
    private char extras; //Either N = none, I = Image, or Y = Youtube based question
    private int hint;

    //1 package protected constructor since the variables can be null if not used
    Question(int qID, String answer, String incorrect1, String incorrect2, String incorrect3, Integer imageRef, char qType, char extras, int hint) {
        Log.d(TAG, "Question: Main constructor called");
        this.qID = qID;
        this.answer = answer;
        this.incorrect1 = incorrect1;
        this.incorrect2 = incorrect2;
        this.incorrect3 = incorrect3;
        this.imageRef = imageRef;
        this.qType = qType;
        this.extras = extras;
        this.hint = hint;
    }

    //Getters. Setters are superfluous for this app
    int getqID() {
        return qID;
    }

    String getAnswer() {
        return answer;
    }

    String getIncorrect1() {
        return incorrect1;
    }

    String getIncorrect2() {
        return incorrect2;
    }

    String getIncorrect3() {
        return incorrect3;
    }

    Integer getImageRef() {
        return imageRef;
    }

    char getqType() {
        return qType;
    }

    char getExtras() {
        return extras;
    }
    int getHint(){return hint;}

}
