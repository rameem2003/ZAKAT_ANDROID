package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;

public class home_page extends AppCompatActivity {
    private CardView personal, organization, rules, hadis, about, update;
    Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        personal = findViewById(R.id.personal);
        organization = findViewById(R.id.organizartion);
        rules = findViewById(R.id.rules);
        hadis = findViewById(R.id.hadis);
        about = findViewById(R.id.about);
        update = findViewById(R.id.update);

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

        hadis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent h = new Intent(home_page.this, hadispage.class);
                startActivity(h);
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

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vibrator.vibrate(100);
                Uri uri = Uri.parse("https://republic-of-legends.netlify.app/projects/android/amar_zakat.html");
                Intent i = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(i);
            }
        });
    }
}