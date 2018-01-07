package uk.ac.mmu.project.doomsdayprototype;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    public void mondayOnClick(View v) {
        totalScore++;
        if (date.getDayOfWeek() == 1) {
            currentScore++;
        }
        updateScreen();
    }

    public void tuesdayOnClick(View v) {
        totalScore++;
        if (date.getDayOfWeek() == 2) {
            currentScore++;
        }
        updateScreen();
    }

    public void wednesdayOnClick(View v) {
        totalScore++;
        if (date.getDayOfWeek() == 3) {
            currentScore++;
        }
        updateScreen();
    }

    public void thursdayOnClick(View v) {
        totalScore++;
        if (date.getDayOfWeek() == 4) {
            currentScore++;
        }
        updateScreen();
    }

    public void fridayOnClick(View v) {
        totalScore++;
        if (date.getDayOfWeek() == 5) {
            currentScore++;
        }
        updateScreen();
    }

    public void saturdayOnClick(View v) {
        totalScore++;
        if (date.getDayOfWeek() == 6) {
            currentScore++;
        }
        updateScreen();
    }

    public void sundayOnClick(View v) {
        totalScore++;
        if (date.getDayOfWeek() == 0) {
            currentScore++;
        }
        updateScreen();
    }
}