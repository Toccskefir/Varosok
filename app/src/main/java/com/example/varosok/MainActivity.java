package com.example.varosok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editTextMainCountry;
    private Button buttonSearch;
    private Button buttonNewRecord;
    private DBHelper DBHelper;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public void init() {
        editTextMainCountry = findViewById(R.id.editTextMainCountry);
        buttonSearch = findViewById(R.id.buttonSearch);
        buttonNewRecord = findViewById(R.id.buttonNewRecord);
        DBHelper = new DBHelper(MainActivity.this);

        sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
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

                    Cursor datas = DBHelper.dataGet(country);

                    if (datas.getCount() == 0) {
                        editor.putString("data", "Nem található rekord a következő adattal: " + country);
                        editor.apply();
                    } else {
                        StringBuilder sb = new StringBuilder();
                        while (datas.moveToNext()) {
                            sb.append(datas.getString(0)).append("\n");
                        }
                        editor.putString("data", sb.toString());
                        editor.apply();
                    }
                }
            }
        });

        buttonNewRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}