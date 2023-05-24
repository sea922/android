package com.example.lab5;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Service extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_3);

        // Start the service
        Intent serviceIntent = new Intent(this, MyService.class);
        startService(serviceIntent);
    }
}
