package com.example.lab22;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        radioButton = findViewById(R.id.red);
        getWindow().getDecorView().setBackgroundColor(Color.RED);
        radioButton = findViewById(R.id.blue);
        getWindow().getDecorView().setBackgroundColor(Color.BLUE);
        radioButton = findViewById(R.id.green);
        getWindow().getDecorView().setBackgroundColor(Color.GREEN);
        radioButton = findViewById(R.id.red);
        getWindow().getDecorView().setBackgroundColor(Color.RED);
    }
}