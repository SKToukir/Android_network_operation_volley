package com.best.hp_.udacitysunshine;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HighScoreActivity extends AppCompatActivity {

    String positionOne,positionTwo,positionThree,positionFour,positionFive;
    int pointOne,pointTwo,pointThree,pointFour,pointFive;
    ScoreClass scoreClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);



    }
}
