package com.example.letngo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class letngo_support extends AppCompatActivity {

    ImageButton back;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letngo_support);

        back = findViewById(R.id.back_btn);

        back.setOnClickListener(v -> onBackPressed());

        button = findViewById(R.id.nextStep);

        button.setOnClickListener(v -> {
            Intent intent = new Intent(letngo_support.this, letngo_support2.class);
            startActivity(intent);
        });
    }
}