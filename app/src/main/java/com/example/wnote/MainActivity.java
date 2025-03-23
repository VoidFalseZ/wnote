package com.example.wnote;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText noteEditText;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteEditText = findViewById(R.id.noteEditText);
        Button saveButton = findViewById(R.id.saveButton);

        // Initialize SharedPreferences
        sharedPreferences = getSharedPreferences("WNotePrefs", MODE_PRIVATE);
        noteEditText.setText(sharedPreferences.getString("note", "")); // Load saved note

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNote();
            }
        });
    }

    private void saveNote() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("note", noteEditText.getText().toString());
        editor.apply();
    }
}