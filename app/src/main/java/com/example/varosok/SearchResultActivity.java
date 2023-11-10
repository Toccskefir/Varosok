package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {
    private TextView textViewCities;
    private Button buttonSearchBack;
    public void init() {
        textViewCities = findViewById(R.id.textViewCities);
        buttonSearchBack = findViewById(R.id.buttonSearchBack);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        init();

        buttonSearchBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}