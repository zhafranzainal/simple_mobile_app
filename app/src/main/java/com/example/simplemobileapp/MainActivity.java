package com.example.simplemobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText numberEditText1;
    private EditText numberEditText2;
    private EditText numberResultEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberEditText1 = findViewById(R.id.number1);
        numberEditText2 = findViewById(R.id.number2);
        numberResultEditText = findViewById(R.id.numberResult);

        Button addButton = findViewById(R.id.button_plus);
        Button subtractButton = findViewById(R.id.button_minus);
        Button multiplyButton = findViewById(R.id.button_multiply);
        Button divideButton = findViewById(R.id.button_divide);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation("+");
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation("-");
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation("*");
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation("/");
            }
        });

    }

    private void performCalculation(String operator) {

        String numberStr1 = numberEditText1.getText().toString();
        String numberStr2 = numberEditText2.getText().toString();

        if (!numberStr1.isEmpty() && !numberStr2.isEmpty()) {

            double number1 = Double.parseDouble(numberStr1);
            double number2 = Double.parseDouble(numberStr2);
            double result = 0.0;

            switch (operator) {

                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    if (number2 != 0) {
                        result = number1 / number2;
                    } else {
                        numberResultEditText.setText("Error: Division by zero");
                        return;
                    }
                    break;

            }

            numberResultEditText.setText(String.valueOf(result));

        } else {
            numberResultEditText.setText("Please enter numbers in both fields.");
        }

    }
}