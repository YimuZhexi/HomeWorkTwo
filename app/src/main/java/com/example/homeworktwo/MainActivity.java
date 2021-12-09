package com.example.homeworktwo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("yum","(:)-->> 00000");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}