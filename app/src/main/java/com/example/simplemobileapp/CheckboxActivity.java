package com.example.simplemobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CheckboxActivity extends AppCompatActivity {

    private CheckBox check1;
    private Button button;
    private RadioGroup radioGroup;
    private RadioButton radioBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkbox);

        check1 = findViewById(R.id.checkBox);
        button = findViewById(R.id.button);
        radioGroup = findViewById(R.id.radioGroup);

        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    Toast.makeText(CheckboxActivity.this, "Red is selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // StringBuffer result = new StringBuffer();
                // result.append("Red is ").append(check1.isChecked());
                // Toast.makeText(CheckboxActivity.this, result.toString(), Toast.LENGTH_SHORT).show();

                int selected_id = radioGroup.getCheckedRadioButtonId();
                radioBtn = findViewById(selected_id);
                Toast.makeText(CheckboxActivity.this, radioBtn.getText().toString(), Toast.LENGTH_SHORT).show();

            }
        });

    }


}