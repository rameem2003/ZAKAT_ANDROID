package com.rol.zakat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private ProgressBar pr;
    int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, home_page.class);
                startActivity(i);
                finish();
            }
        }, 3000);
        
        loading();
    }

    private void loading() {
        pr = findViewById(R.id.prb);
        final Timer t = new Timer();
        TimerTask tt = new TimerTask() {
            @Override
            public void run() {
                counter++;
                pr.setProgress(counter);

                if (counter == 100){
                    t.cancel();
                }
            }
        };

        t.schedule(tt, 0, 100);
    }
}