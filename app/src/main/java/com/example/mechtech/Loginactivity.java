package com.example.mechtech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Loginactivity extends AppCompatActivity {
    EditText edusername,edpassword;
    TextView txtregister;
    Button btnlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);
        edusername=findViewById(R.id.username);
        edpassword=findViewById(R.id.password);
        txtregister=findViewById(R.id.register);
        btnlogin=findViewById(R.id.login);


       btnlogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String username=edusername.getText().toString();
               String password=edpassword.getText().toString();
               if(username.length()==0 || password.length()==0){
                   Toast.makeText(getApplicationContext(),"Please fill all details",Toast.LENGTH_SHORT).show();
               }else{
                   Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
               }
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