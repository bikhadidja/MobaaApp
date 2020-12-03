package com.example.mobaapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CalendarandTime extends AppCompatActivity {
    CalendarView mcalendar;
    EditText mtime;
    Button mbook;
    Button mlogout;
    FirebaseAuth firebaseAuth;
    FirebaseUser user;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_and_time);

        mcalendar=findViewById(R.id.calendarViewBook);
        mtime=findViewById(R.id.edtTime);
        mbook=findViewById(R.id.btnBookNow);
        mlogout=findViewById(R.id.btnExit);
        dialog=new ProgressDialog(this);
        dialog.setTitle("booking");
        dialog.setMessage("please wait");
        firebaseAuth=FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();


        mbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CalendarandTime.this,"Date and Time Booked Successfully",Toast.LENGTH_SHORT);
                Log.d("our_data", "onClick: "+mtime.getText().toString()+" "+mcalendar.getDate());
                String time,date,email,key;
                time=mtime.getText().toString();
                date=mcalendar.getDate()+"";
                email=user.getEmail().toString();
                key=System.currentTimeMillis()+"";
                Book boo=new Book(date,time,email,key);
//                DatabaseReference ref= FirebaseDatabase.getInstance().getReference().child("BOOKING/"+key);
//                dialog.show();
//                ref.setValue(boo).addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        dialog.dismiss();
//                        if (task.isSuccessful()){
//                            Toast.makeText(CalendarandTime.this, "Booking Successfully ", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(CalendarandTime.this, "Book failed", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
                Toast.makeText(CalendarandTime.this, "BOOKED", Toast.LENGTH_SHORT).show();
            }
        });
        mlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();

            }
        });

    }
}