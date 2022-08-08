package com.example.letngo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class payment_homepage21 extends AppCompatActivity {
    ImageButton back;
    Button select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_homepage21);

        back = findViewById(R.id.btn_backButtonPaymentDetails);
        select = findViewById(R.id.btn_nextStep);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment_homepage21.this, payment_homepage22.class);
                startActivity(intent);
            }
        });


        back.setOnClickListener(v -> onBackPressed());

    }
}