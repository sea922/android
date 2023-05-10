package com.example.myapplication;

import static androidx.core.graphics.ImageDecoderKt.decodeBitmap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex4Activity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private ImageView imageView;
    private EditText nameEditText, emailEditText, phoneEditText;
    private RadioGroup genderRadioGroup;
    private Button changeButton, saveButton, cancelButton;

    private Bitmap userImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4);

        imageView = findViewById(R.id.image_view);
        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        phoneEditText = findViewById(R.id.phone_edit_text);
        genderRadioGroup = findViewById(R.id.gender_radio_group);
        changeButton = findViewById(R.id.change_btn);
        saveButton = findViewById(R.id.save_btn);
        cancelButton = findViewById(R.id.cancel_btn);

        // Load user information from shared preferences
        loadUserInfo();

        // Set click listener for the change button to open camera
        changeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

        // Set click listener for the save button to save user information
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUserInfo();
                Toast.makeText(Ex4Activity.this, "User information saved!", Toast.LENGTH_SHORT).show();
            }
        });

        // Set click listener for the cancel button to exit the app
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    // Save user information to shared preferences
    private void saveUserInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", nameEditText.getText().toString());
        editor.putString("email", emailEditText.getText().toString());
        editor.putString("phone", phoneEditText.getText().toString());
        editor.putInt("gender", genderRadioGroup.getCheckedRadioButtonId());
        if (userImage != null) {
            //editor.putString("image", encodeBitmap(userImage));
        }
        editor.apply();
    }

    // Load user information from shared preferences
    private void loadUserInfo() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_info", MODE_PRIVATE);
        nameEditText.setText(sharedPreferences.getString("name", ""));
        emailEditText.setText(sharedPreferences.getString("email", ""));
        phoneEditText.setText(sharedPreferences.getString("phone", ""));
        int genderId = sharedPreferences.getInt("gender", -1);
        if (genderId != -1) {
            genderRadioGroup.check(genderId);
        }
        String imageString = sharedPreferences.getString("image", "");
        if (!imageString.isEmpty()) {
            //userImage = decodeBitmap(imageString);
            imageView.setImageBitmap(userImage);
        }
    }

    // Open camera to take picture
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    // Handle result of camera activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            userImage = (Bitmap) extras.get("data");
            imageView.setImageBitmap(userImage);
        }
    }

    // Encode bitmap to string using Base64
}