package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextMainCountry;
    private Button buttonSearch;
    private Button buttonNewRecord;

    public void init() {
        editTextMainCountry = findViewById(R.id.editTextMainCountry);
        buttonSearch = findViewById(R.id.buttonSearch);
        buttonNewRecord = findViewById(R.id.buttonNewRecord);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country = editTextMainCountry.getText().toString();
                if (country.trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Adjon meg országot", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, SearchResultActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        buttonNewRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String country = editTextMainCountry.getText().toString();
                if (country.trim().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Adjon meg országot", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}