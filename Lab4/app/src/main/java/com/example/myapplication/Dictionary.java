package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Dictionary extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;
    private TextView definitionTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        searchEditText = findViewById(R.id.searchEditText);
        searchButton = findViewById(R.id.searchButton);
        definitionTextView = findViewById(R.id.definitionTextView);

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

        String definition;
        switch (word.toLowerCase()) {
            case "smoothly":
                definition = "(Adv) in an even way, without suddenly stopping and starting again";
                break;
            case "banana":
                definition = "(Noun) a round fruit with shiny red or green skin that is fairly hard and white inside";
                break;
            case "dictionary":
                definition = "(Noun) a book or electronic resource that gives a list of the words of a language in alphabetical order and explains what they mean, or gives a word for them in a foreign language";
                break;
            default:
                definition = "Word not found in the dictionary.";
                break;
        }

        return definition;
    }
}
