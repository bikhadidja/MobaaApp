package com.example.mobaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class DermatologyActivity extends AppCompatActivity {
    CheckBox mgnrlMed,mspecilistMed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dermatology);

        mgnrlMed=findViewById(R.id.cboxgnrlMed);
        mspecilistMed=findViewById(R.id.cboxSpecMed);

        mgnrlMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CalendarandTime.class));
            }
        });
        mspecilistMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CalendarandTime.class));
            }
        });
    }
}