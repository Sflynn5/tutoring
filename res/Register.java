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

public class Register extends AppCompatActivity {
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        register = findViewById(R.id.registerBut);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View o) {
                goBackLogin();
            }
        });



    }
    public void goBackLogin(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }







}
