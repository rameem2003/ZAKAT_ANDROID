package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class personal_zakat extends AppCompatActivity {
    MaterialButton btn;
    TextInputEditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_zakat);

        input = findViewById(R.id.input);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = input.getText().toString();
                Toast.makeText(personal_zakat.this, data, Toast.LENGTH_SHORT).show();
            }
        });
    }
}