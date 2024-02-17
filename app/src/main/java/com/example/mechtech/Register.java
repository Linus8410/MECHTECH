package com.example.mechtech;

import static android.opengl.ETC1.isValid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Register extends AppCompatActivity {

    EditText username,password,email,Password;
    TextView txtregister;
    Button btn,btn1;
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
        setContentView(R.layout.activity_register);
        mAuth=FirebaseAuth.getInstance();
        username=findViewById(R.id.username1);
        password=findViewById(R.id.password1);
        Password=findViewById(R.id.password2);
        email=findViewById(R.id.emaill);
        txtregister=findViewById(R.id.existingaccount);
        btn=findViewById(R.id.btnregister);
        btn1=findViewById(R.id.btnmech);

       txtregister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               startActivity(new Intent(Register.this, Loginactivity.class));
               finish();
           }
       });
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String username1=username.getText().toString();
               String password1=password.getText().toString();
               String password2=Password.getText().toString();
               String emaill=email.getText().toString();

               if(TextUtils.isEmpty(emaill)) {
                   Toast.makeText(Register.this, "Enter Email", Toast.LENGTH_SHORT).show();

                   return;
               }
               if(TextUtils.isEmpty(password1)) {
                   Toast.makeText(Register.this, "Enter password", Toast.LENGTH_SHORT).show();

                   return;
               }
               mAuth.createUserWithEmailAndPassword(emaill, password1)
                       .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                           @Override
                           public void onComplete(@NonNull Task<AuthResult> task) {
                               if (task.isSuccessful()) {
                                   Intent intent=new Intent(getApplicationContext(), Loginactivity.class);
                                   startActivity(intent);
                                   finish();
                                   // Sign in success, update UI with the signed-in user's information
                                   Toast.makeText(Register.this, "Account created",
                                           Toast.LENGTH_SHORT).show();


                               } else {
                                   // If sign in fails, display a message to the user.
                                   Toast.makeText(Register.this, "Authentication failed.",
                                           Toast.LENGTH_SHORT).show();

                               }
                           }
                       });
           }



       });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username1=username.getText().toString();
                String password1=password.getText().toString();
                String password2=Password.getText().toString();
                String emaill=email.getText().toString();

                if(TextUtils.isEmpty(emaill)) {
                    Toast.makeText(Register.this, "Enter Email", Toast.LENGTH_SHORT).show();

                    return;
                }
                if(TextUtils.isEmpty(password1)) {
                    Toast.makeText(Register.this, "Enter password", Toast.LENGTH_SHORT).show();

                    return;
                }
                mAuth.createUserWithEmailAndPassword(emaill, password1)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(Register.this, "Account created",
                                            Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(getApplicationContext(), Loginactivity.class);
                                    startActivity(intent);
                                    finish();
                                    // Sign in success, update UI with the signed-in user's information


                                } else {
                                    // If sign in fails, display a message to the user.
                                    Toast.makeText(Register.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
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