package com.example.myapplication;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DictionaryUsingSQLite extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;
    private TextView definitionTextView;

    private SQLiteDatabase database;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        definitionTextView = findViewById(R.id.definitionTextView);

        // Init DB
        database = openOrCreateDatabase("dictionary.db", MODE_PRIVATE, null);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = searchEditText.getText().toString();
                String definition = searchDictionary(word);
                definitionTextView.setText(definition);
            }
        });
    }

    private String searchDictionary(String word) {
        String query = "SELECT definition FROM dictionary WHERE word = ?";
        String[] selectionArgs = {word};
        Cursor cursor = database.rawQuery(query, selectionArgs);

        if (cursor.moveToFirst()) {
            @SuppressLint("Range") String definition = cursor.getString(cursor.getColumnIndex("definition"));
            cursor.close();
            return definition;
        }

        cursor.close();

        // If no match found
        query = "SELECT word FROM dictionary WHERE word LIKE ?";
        String[] substringArgs = {"%" + word + "%"};
        cursor = database.rawQuery(query, substringArgs);

        StringBuilder resultBuilder = new StringBuilder();
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") String matchingWord = cursor.getString(cursor.getColumnIndex("word"));
                resultBuilder.append(matchingWord).append("\n");
            } while (cursor.moveToNext());
        }

        cursor.close();

        if (resultBuilder.length() == 0) {
            return "No matching words found.";
        } else {
            return resultBuilder.toString();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Close the database connection
        database.close();
    }
}
