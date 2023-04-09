package com.example.lab24;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editName, editEmail, editProject;
    String name, email, project;
    //TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName  = (EditText) findViewById(R.id.editName);
        editEmail = (EditText) findViewById(R.id.editEmail);
        editProject = (EditText) findViewById(R.id.editProject);
        ///result = (TextView) findViewById(R.id.tvResult);

        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
        Intent intent = new Intent(this, NewActivity.class);
        String name = editName.getText().toString();
        String email = editEmail.getText().toString();
        String project = editProject.getText().toString();
        intent.putExtra("name", name);
        intent.putExtra("email", email);
        intent.putExtra("project", project);
        startActivity(intent);
    }
}