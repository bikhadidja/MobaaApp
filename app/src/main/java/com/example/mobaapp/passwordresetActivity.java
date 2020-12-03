package com.example.mobaapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class passwordresetActivity extends AppCompatActivity {
    TextView mEmail;
    Button mreset;
    FirebaseAuth firebaseAuth;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passwordreset);

        mEmail=findViewById(R.id.TvEmailpwsreset);
        mreset=findViewById(R.id.btnreset);

        firebaseAuth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Resetting");
        dialog.setMessage("Please wait...");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        mreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email;
                email = mEmail.getText().toString().trim();
                if(email.isEmpty()){
                    mEmail.setError("Please enter email");

                }else{
                    dialog.show();
                    firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            dialog.dismiss();
                            if (task.isSuccessful())
                            {
                                Toast.makeText(passwordresetActivity.this,"Password reset link send to"+email, Toast.LENGTH_SHORT);
                            }else{
                                Toast.makeText(passwordresetActivity.this,"Password reset failed", Toast.LENGTH_SHORT);
                                startActivities(new Intent[]{new Intent(getApplicationContext(), MainActivity.class)});
                            }
                        }

                    });

                }
            }
        });
    }
}
