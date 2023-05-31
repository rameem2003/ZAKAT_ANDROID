package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class hadispage extends AppCompatActivity {

    CardView hadis1, hadis2, hadis3, hadis4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hadispage);

        hadis1 = findViewById(R.id.hadis1);
        hadis2 = findViewById(R.id.hadis2);
        hadis3 = findViewById(R.id.hadis3);
        hadis4 = findViewById(R.id.hadis4);

        hadis1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hadispage.this, hadis_one.class);
                startActivity(i);
            }
        });

        hadis2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hadispage.this, hadis_two.class);
                startActivity(i);
            }
        });

        hadis3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hadispage.this, hadis_three.class);
                startActivity(i);
            }
        });

        hadis4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(hadispage.this, hadis_four.class);
                startActivity(i);
            }
        });
    }
}