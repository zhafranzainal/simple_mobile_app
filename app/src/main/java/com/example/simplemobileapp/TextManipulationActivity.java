package com.example.simplemobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class TextManipulationActivity extends AppCompatActivity {

    private TextView text;

    private RadioGroup radGroupColour;
    private RadioButton radbtnBlack, radbtnRed, radbtnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_manipulation);

        text = findViewById(R.id.textView);
        radGroupColour = findViewById(R.id.radioGroupColour);
        radbtnBlack = findViewById(R.id.radioButtonBlack);
        radbtnRed = findViewById(R.id.radioButtonRed);
        radbtnBlue = findViewById(R.id.radioButtonBlue);

        radGroupColour.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radbtnBlack.getId()) {
                    text.setTextColor(Color.BLACK);
                } else if (checkedId == radbtnRed.getId()) {
                    text.setTextColor(Color.RED);
                } else if (checkedId == radbtnBlue.getId()) {
                    text.setTextColor(Color.BLUE);
                }
            }

        });

    }

}