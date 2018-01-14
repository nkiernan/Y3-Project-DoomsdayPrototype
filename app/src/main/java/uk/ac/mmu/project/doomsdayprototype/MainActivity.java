package uk.ac.mmu.project.doomsdayprototype;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import utils.DateGenerator;

public class MainActivity extends AppCompatActivity {

    private DateGenerator date;
    private int currentScore = 0;
    private int totalScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        updateScreen();
    }

    @SuppressLint("DefaultLocale")
    public void updateScreen() {
        date = new DateGenerator();
        TextView givenDate = findViewById(R.id.dateLabel);
        TextView score = findViewById(R.id.runningScoreLabel);

        givenDate.setText(date.toString());
        score.setText(String.format("%d/%d", currentScore, totalScore));
    }

    public void processAnswer(int i) {
        totalScore++;
        if (date.getDayOfWeek() == i) {
            currentScore++;
        }
        updateScreen();
    }

    public void mondayOnClick(View v) {
        processAnswer(1);
    }

    public void tuesdayOnClick(View v) {
        processAnswer(2);
    }

    public void wednesdayOnClick(View v) {
        processAnswer(3);
    }

    public void thursdayOnClick(View v) {
        processAnswer(4);
    }

    public void fridayOnClick(View v) {
        processAnswer(5);
    }

    public void saturdayOnClick(View v) {
        processAnswer(6);
    }

    public void sundayOnClick(View v) {
        processAnswer(0);
    }
}