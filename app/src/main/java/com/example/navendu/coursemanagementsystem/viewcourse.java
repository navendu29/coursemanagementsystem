package com.example.navendu.coursemanagementsystem;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class viewcourse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewcourse);
        SharedPreferences sharedPreferences = getSharedPreferences("CourseManagementSystem",MODE_PRIVATE);

        String retrievedValue = sharedPreferences.getString("courses","0");


            EditText t=(EditText) findViewById(R.id.ff);

            t.setText(retrievedValue);



    }

}
