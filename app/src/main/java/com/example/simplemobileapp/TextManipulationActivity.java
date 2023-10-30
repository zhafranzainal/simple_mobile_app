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
    private RadioButton radBtnBlack, radBtnRed, radBtnBlue;

    private RadioGroup radGroupSize;
    private RadioButton radBtnSmall, radBtnMed, radBtnLarge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_manipulation);

        text = findViewById(R.id.textView);

        radGroupColour = findViewById(R.id.radioGroupColour);
        radBtnBlack = findViewById(R.id.radioButtonBlack);
        radBtnRed = findViewById(R.id.radioButtonRed);
        radBtnBlue = findViewById(R.id.radioButtonBlue);

        radGroupSize = findViewById(R.id.radioGroupSize);
        radBtnSmall = findViewById(R.id.radioButton18);
        radBtnMed = findViewById(R.id.radioButton24);
        radBtnLarge = findViewById(R.id.radioButton28);

        radGroupColour.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radBtnBlack.getId()) {
                    text.setTextColor(Color.BLACK);
                } else if (checkedId == radBtnRed.getId()) {
                    text.setTextColor(Color.RED);
                } else if (checkedId == radBtnBlue.getId()) {
                    text.setTextColor(Color.BLUE);
                }
            }

        });

        radGroupSize.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radBtnSmall.getId()) {
                    text.setTextSize(18);
                } else if (checkedId == radBtnMed.getId()) {
                    text.setTextSize(24);
                } else if (checkedId == radBtnLarge.getId()) {
                    text.setTextSize(28);
                }
            }

        });

    }

}