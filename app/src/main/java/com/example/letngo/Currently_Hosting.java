package com.example.letngo;

import android.os.Bundle;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Currently_Hosting extends AppCompatActivity {

    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_hosting);
        back = findViewById(R.id.currently_hosting_back);

        back.setOnClickListener(v -> onBackPressed());
    }
}