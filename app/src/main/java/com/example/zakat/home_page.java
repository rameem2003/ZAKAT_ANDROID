package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class home_page extends AppCompatActivity {
    private CardView personal, organization, rules, about;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        personal = findViewById(R.id.personal);
        organization = findViewById(R.id.organizartion);
        rules = findViewById(R.id.rules);
        about = findViewById(R.id.about);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                Intent i = new Intent(home_page.this, personal_zakat.class);
                startActivity(i);
            }
        });

        organization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                Intent i = new Intent(home_page.this, organizational_zakat.class);
                startActivity(i);
            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                Intent i = new Intent(home_page.this, rules.class);
                startActivity(i);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                Intent i = new Intent(home_page.this, about.class);
                startActivity(i);
            }
        });
    }
}