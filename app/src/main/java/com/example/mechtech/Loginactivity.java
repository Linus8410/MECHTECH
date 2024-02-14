package com.example.mechtech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.Firebase;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Loginactivity extends AppCompatActivity {
    EditText emailll, edpassword;
    TextView txtregister;
    Button btnlogin;
    FirebaseAuth mAuth;
    public void onStart() {
        super.onStart();
        FirebaseUser currentuser=mAuth.getCurrentUser();
        if(currentuser!=null){
            Intent intent=new Intent(getApplicationContext(), Loginactivity.class);
            startActivity(intent);
            finish();

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        emailll = findViewById(R.id.username);
        edpassword = findViewById(R.id.password);
        txtregister = findViewById(R.id.register);
        btnlogin = findViewById(R.id.login);
        mAuth = FirebaseAuth.getInstance();



        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = emailll.getText().toString();
                String password = edpassword.getText().toString();
                if (username.length() == 0 || password.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Please fill all details", Toast.LENGTH_SHORT).show();
                }
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(Loginactivity.this, "Enter Email", Toast.LENGTH_SHORT).show();

                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(Loginactivity.this, "Enter password", Toast.LENGTH_SHORT).show();

                    return;
                }
                mAuth.createUserWithEmailAndPassword(username, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(getApplicationContext(), "Login Success", Toast.LENGTH_SHORT).show();
                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(Loginactivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }


        });

        txtregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Loginactivity.this, Register.class));
            }
        });
    }
}