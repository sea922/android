package com.example.lab24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NewActivity extends AppCompatActivity {
    TextView result;
    private TextView nameTextView, emailTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        result = (TextView) findViewById(R.id.tvResult);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        String email = intent.getStringExtra("email");
        String project = intent.getStringExtra("project");
        result.setText("Name:\t" + name + "\nEmail:\t" + email + "\nProject:\t" + project );

        //nameTextView.setText(name);
        //emailTextView.setText(email);
    }
}