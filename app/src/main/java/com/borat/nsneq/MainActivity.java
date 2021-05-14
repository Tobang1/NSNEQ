package com.borat.nsneq;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_EXAM = 1;

    public static final String SHARED_PREF ="sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;

    private int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHighscore = findViewById(R.id.text_view_highscore);
        loadHighscore();


        Button buttonStartQuestion = findViewById(R.id.button_start_exam);
        buttonStartQuestion.setOnClickListener((View v) -> {
            startExam();
        });

        Button buttonCategory= findViewById(R.id.button_Category);
        buttonCategory.setOnClickListener((View v) -> {
            startCategory();
        });

    }
    private void startExam(){
        Intent intent = new Intent(MainActivity.this, ExamActivity.class);
        startActivityForResult(intent,REQUEST_CODE_EXAM );
    }

    private void startCategory(){
        Intent intent = new Intent(MainActivity.this, Category.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE_EXAM){
            if (resultCode == RESULT_OK){
                int score = data.getIntExtra(ExamActivity.EXTRA_SCORE, 0);
                if (score > highscore){
                    updateHighScore(score);
                }
            }
        }
    }

    private void loadHighscore(){
        SharedPreferences prefs = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        highscore = prefs.getInt(KEY_HIGHSCORE, 0);
        textViewHighscore.setText("Highscore:"  + highscore);
    }

    private void updateHighScore(int  highscoreNew){
        highscore = highscoreNew;
        textViewHighscore.setText("Highscore:"  + highscore);

        SharedPreferences prefs = getSharedPreferences(SHARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putInt(KEY_HIGHSCORE, highscore);
        editor.apply();
    }
}