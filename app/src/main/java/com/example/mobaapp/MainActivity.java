package com.example.mobaapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {
    EditText password;
    EditText Email;
    Button login;
    TextView signup;
    TextView mpasswordrest;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Email=findViewById(R.id.edtEmail);
        password=findViewById(R.id.edt_password);
        login=findViewById(R.id.btn_login);
        signup=findViewById(R.id.tv_register);
        mpasswordrest=findViewById((R.id.tvpasswordreset));


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),signupActivity.class));
            }
        });
        mpasswordrest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),passwordresetActivity.class));
            }
        });

        firebaseAuth= FirebaseAuth.getInstance();
        progressDialog= new ProgressDialog(this);
        progressDialog.setTitle("Loading");
        progressDialog.setMessage("please, wait");
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);

        FirebaseUser user= firebaseAuth.getCurrentUser();
        if (user!=null)
        {
            firebaseAuth= FirebaseAuth.getInstance();
            firebaseAuth.signOut();
            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
        else{
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final String useremail,userpassword;
                    useremail=Email.getText().toString().trim();
                    userpassword=password.getText().toString().trim();
                    if (useremail.isEmpty()){
                        Email.setError("Please, Enter an email");
                    }
                    else if (userpassword.isEmpty()){
                        password.setError("Please, Enter a password");
                    }
                    else if (userpassword.length()<6){
                        password.setError("Please,Enter password characters that are up to 6");
                    }
                    else{

                        progressDialog.show();
                        firebaseAuth.signInWithEmailAndPassword(useremail,userpassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(MainActivity.this, "Log In Successful", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),homepage.class));
                                    finish();
                                }

                                else {
                                    Toast.makeText(MainActivity.this, "Log in failed", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                    finish();
                                }
                            }
                        });
                    }
                }
            });

        }


    }
}