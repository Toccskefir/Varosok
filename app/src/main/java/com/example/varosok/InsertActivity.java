package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private EditText editTextName;
    private EditText editTextCountry;
    private EditText editTextPopulation;
    private Button buttonInsert;
    private Button buttonInsertBack;
    private DBHelper DBHelper;

    public void init() {
        editTextName = findViewById(R.id.editTextName);
        editTextCountry = findViewById(R.id.editTextCountry);
        editTextPopulation = findViewById(R.id.editTextPopulation);
        buttonInsert = findViewById(R.id.buttonInsert);
        buttonInsertBack = findViewById(R.id.buttonInsertBack);
        DBHelper = new DBHelper(InsertActivity.this);
    }

    public void editTextReset() {
        editTextName.setText(null);
        editTextCountry.setText(null);
        editTextPopulation.setText(null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String country = editTextCountry.getText().toString();
                String population = editTextPopulation.getText().toString();
                
                if (name.trim().isEmpty() || country.trim().isEmpty() || population.trim().isEmpty()) {
                    Toast.makeText(InsertActivity.this, "Kitöltetlen adatmezők", Toast.LENGTH_SHORT).show();
                } else {
                    int populationInt = Integer.parseInt(population);
                    if (DBHelper.dataRecord(name, country, populationInt)) {
                        Toast.makeText(InsertActivity.this, "Sikeres adatfelvétel", Toast.LENGTH_SHORT).show();
                        editTextReset();
                    } else {
                        Toast.makeText(InsertActivity.this, "Sikertelen adatfelvétel", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        buttonInsertBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InsertActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}