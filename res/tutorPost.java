package com.example.tutoringapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class tutorPost extends AppCompatActivity {
    Button addInfo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_post);
        addInfo = findViewById(R.id.btnAdd);
        addInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addTutorInfo();
            }
        });
    }

    public void addTutorInfo(){
        Intent intent = new Intent(this, tutorView.class);
        startActivity(intent);
    }

}
