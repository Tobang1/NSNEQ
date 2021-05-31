package com.borat.NSON;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_EXAM = 1;

    public static final String EXTRA_CATEGORY_ID = "extraCategoryID";
    public static final String EXTRA_CATEGORY_NAME = "extraCategoryName";

    public static final String SHARED_PREF ="sharedPrefs";
    public static final String KEY_HIGHSCORE = "keyHighscore";

    private TextView textViewHighscore;
    private Spinner spinnerCategory;
    private int highscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewHighscore = findViewById(R.id.text_view_highscore);
        spinnerCategory = findViewById(R.id.spinner_category);

        loadCategories();
        loadHighscore();



        Button buttonStartQuestion = findViewById(R.id.button_start_exam);
        buttonStartQuestion.setOnClickListener((View v) -> {
            startExam();
        });

        Button buttonRules = findViewById(R.id.buttonRules);
        buttonRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRules();
            }
        });

        Button buttonBiblography = findViewById(R.id.button_bibliography);
        buttonBiblography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startBiblography();
            }
        });

        Button buttonContactUs = findViewById(R.id.button_contact_us);
        buttonContactUs.setOnClickListener((View v) -> {
            startContactUs();
        });

        Button buttonAccount = findViewById(R.id.button_account);
        buttonAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAccount();
            }
        });

    }
    private void startExam(){
        Category selectedCategory = (Category) spinnerCategory.getSelectedItem();
        int categoryID = selectedCategory.getId();
        String categoryName = selectedCategory.getName();

        Intent intent = new Intent(MainActivity.this, ExamActivity.class);
        intent.putExtra(EXTRA_CATEGORY_ID, categoryID);
        intent.putExtra(EXTRA_CATEGORY_NAME, categoryName);
        startActivityForResult(intent,REQUEST_CODE_EXAM );
    }

    private void startBiblography(){
        Intent intent = new Intent(MainActivity.this, ScrollingActivity.class);
        startActivity(intent);
    }
    private void startContactUs(){
        Intent intent = new Intent(MainActivity.this, ContactUs.class);
        startActivity(intent);
    }
    private void startAccount(){
        Intent intent = new Intent(MainActivity.this, account.class);
             startActivity(intent);
    }
    private  void startRules(){
        Intent intent = new Intent(MainActivity.this, Rules.class);
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

    private void loadCategories(){
        ExamDbHelper dbHelper = ExamDbHelper.getInstance(this);
        List<Category> categories = dbHelper.getAllCategories();
        ArrayAdapter<Category> adapterCategories = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, categories);
        adapterCategories.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategory.setAdapter(adapterCategories);
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

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Login.class));
        finish();
    }
}