package com.example.simplemobileapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyIntentActivity extends AppCompatActivity {

    private EditText urlInput;
    private Button searchBtn;
    private Button homeBtn;
    private Button callBtn;
    private Button smsBtn;
    private Button dialBtn;

    private final String mCallPhonePermission = android.Manifest.permission.CALL_PHONE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intent);

        urlInput = findViewById(R.id.urlText);
        searchBtn = findViewById(R.id.searchButton);
        homeBtn = findViewById(R.id.homeButton);
        callBtn = findViewById(R.id.callButton);
        smsBtn = findViewById(R.id.smsButton);
        dialBtn = findViewById(R.id.dialButton);

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = urlInput.getText().toString();

                if (!url.startsWith("http://") && !url.startsWith("https://")) {
                    url = "http://" + url;
                }

                if (Patterns.WEB_URL.matcher(url).matches()) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                } else {
                    Toast.makeText(MyIntentActivity.this, "Invalid URL. Please enter a valid URL.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                startActivity(intent);
            }
        });

        callBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MyIntentActivity.this, mCallPhonePermission) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MyIntentActivity.this, new String[]{mCallPhonePermission}, 1);
                } else {
                    initiatePhoneCall();
                }
            }
        });

        smsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("smsto:60172923450"));
                startActivity(intent);
            }
        });

        dialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:60172923450"));
                startActivity(intent);
            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                initiatePhoneCall();
            } else {
                Toast.makeText(this, "Permission to make a phone call is required.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void initiatePhoneCall() {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:60172923450"));
        startActivity(intent);
    }
}