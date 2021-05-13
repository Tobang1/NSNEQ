package com.borat.nsneq;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button buttonStartQuestion = findViewById(R.id.button_start_exam);
        buttonStartQuestion.setOnClickListener(v -> startQuiz());
    }
    private void startQuiz(){
        Intent intent = new Intent(MainActivity.this, ExamActivity.class);
        startActivity(intent);
    }
}