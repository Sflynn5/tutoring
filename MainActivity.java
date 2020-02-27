package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner1);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.Subjects));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(myAdapter);

        Spinner upvotesSpinner = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> upvoteAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.UpVotes));
        upvoteAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        upvotesSpinner.setAdapter(upvoteAdapter);

        Spinner courseLevelSpinner = (Spinner) findViewById(R.id.spinner3);

        ArrayAdapter<String> courseLevelAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.CourseLevel));
        courseLevelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        courseLevelSpinner.setAdapter(courseLevelAdapter);
    }
}
