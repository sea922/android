package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //@Override
    //private AppBarConfiguration appBarConfiguration;
    //private ActivityMainBinding binding;

    Toolbar navBar;
    Button btn_alert;

    AlertDialog alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //navBar = (Toolbar) findViewById(R.id.navBar);

        alert = new AlertDialog.Builder(this).create();

        btn_alert = (Button) findViewById(R.id.button6);

        btn_alert.setOnClickListener(this::onClick);


    }

    //@Override
    public void onClick(View view) {
        Button btn = (Button) view;

        Date now = new Date();

        String msg ="Thời gian hiện tại là: " + now.toString();

        alert.setMessage(msg);
        alert.show();

    }
}