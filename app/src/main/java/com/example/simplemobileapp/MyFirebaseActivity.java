package com.example.simplemobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyFirebaseActivity extends AppCompatActivity {

    private EditText itemName;
    private EditText itemPrice;
    private EditText itemQty;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_firebase);

        itemName = findViewById(R.id.editTextItem);
        itemPrice = findViewById(R.id.editTextPrice);
        itemQty = findViewById(R.id.editTextQuantity);
        btn = findViewById(R.id.buttonSubmit);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");

    }
}