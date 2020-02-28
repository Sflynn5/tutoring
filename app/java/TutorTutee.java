package com.example.tutoringapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TutorTutee extends AppCompatActivity {

    Button goLogin;
    TextView goRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_register);
        goLogin = findViewById(R.id.log);
        goLogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View t){
                openLogin();
            }
        });

        goRegister = findViewById(R.id.reg);
        goRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View s){
                openRegister();
            }
        });
    }
    public void openLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
    public void openRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }
}