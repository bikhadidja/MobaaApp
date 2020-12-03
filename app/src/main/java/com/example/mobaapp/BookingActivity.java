package com.example.mobaapp;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

public class BookingActivity extends AppCompatActivity {
    private CheckBox mcheckboxDerma,mGynecology;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        mcheckboxDerma=findViewById(R.id.ckboxDermatology);
        mGynecology=findViewById(R.id.ckboxGynechology);

        mcheckboxDerma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DermatologyActivity.class));
            }
        });
        mGynecology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),GynecologyActivity.class));
            }
        });
    }
}