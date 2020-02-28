package com.example.tutoringapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    Button login;
    TextView email;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login = findViewById(R.id.btnLogin);
        email = findViewById(R.id.etEmail);
        password = findViewById(R.id.etPassword);
        /*
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (student) {
                    openStudentView();
                }else {
                    openTutorView();
                }
            }
        });*/


    }

    public void openStudentView(){
        //Intent intent = new Intent(this, studentView.class);
        //startActivity(intent);
    }

    public void openTutorView(){
        Intent intent = new Intent(this, tutorView.class);
        startActivity(intent);
    }



}