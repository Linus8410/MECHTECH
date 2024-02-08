package com.example.mechtech;

import static android.opengl.ETC1.isValid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText username,password,email,Password;
    TextView txtregister;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        Password=findViewById(R.id.password2);
        email=findViewById(R.id.emaill);
        txtregister=findViewById(R.id.existingaccount);
        btn=findViewById(R.id.btnregister);

       txtregister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(Register.this, Loginactivity.class));
           }
       });
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String username1=username.getText().toString();
               String password1=password.getText().toString();
               String password2=Password.getText().toString();
               String emaill=email.getText().toString();
               if(username1.length()==0 || emaill.length()==0 || password1.length()==0||password2.length()==0){
                   Toast.makeText( getApplicationContext(),"Please fill all details",Toast.LENGTH_SHORT).show();
               }
               else{
                   if(password1.compareTo(password2)==0){
                       if(isValid(password1)) {
                           Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                           startActivity(new Intent(Register.this, Loginactivity.class));

                       } else{
                               Toast.makeText(getApplicationContext(), "Password must contain atleast 8 characters,having a letter,digit and special symbol", Toast.LENGTH_SHORT).show();

                           }
                   }
                   else{
                       Toast.makeText(getApplicationContext(),"Passwords don't match!", Toast.LENGTH_SHORT).show();
                   }
               }
           }
       });

    }

    private boolean isValid(String password1) {
        int f1=0,f2=0,f3=0;
        if(password.length()<8){
            return false;
        }else {
            for(int p=0;p<password1.length();p++){
                if(Character.isLetter(password1.charAt(p))){
                    f1=1;
                }
            }
            for(int r=0;r<password1.length();r++){
                if(Character.isDigit(password1.charAt(r))){
                    f2=1;
                }
            }
            for(int s=0;s<password1.length();s++){
                char c=password1.charAt(s);
                if(c>=33&&c<=46||c==64){
                    f3=1;
                }
            }
            if(f1==1&&f2==1&&f3==1)
                return true;
            return false;
        }
    }

}