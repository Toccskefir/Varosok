package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextCountry;
    private EditText editTextPopulation;
    private Button buttonInsert;
    private Button buttonInsertBack;

    public void init() {
        editTextName = findViewById(R.id.editTextName);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextPopulation = findViewById(R.id.editTextPopulation);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonInsertBack = findViewById(R.id.buttonInsertBack);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        buttonInsertBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}