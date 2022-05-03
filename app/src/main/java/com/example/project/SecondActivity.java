package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    private EditText inputField;
    private Button button;

    private SharedPreferences myPreferenceRef;
    private SharedPreferences.Editor myPreferenceEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        inputField = findViewById(R.id.inputField);
        button = findViewById(R.id.applyButton);

        myPreferenceRef = getSharedPreferences("MyPrefs",MODE_PRIVATE);
        myPreferenceEditor = myPreferenceRef.edit();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPreferenceEditor.putString("LabelText", inputField.getText().toString());
                myPreferenceEditor.commit();
            }
        });
    }
}