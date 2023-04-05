package com.example.zakat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class personal_zakat extends AppCompatActivity {
    LinearLayout calcView, resultView;
    MaterialButton calc, back;
    TextInputEditText gold, silver, bank, loan, invest, cradit, employee, tax;
    TextView total, jakat;
    int nisab = 43000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_zakat);

        // get all linear layout
        calcView = findViewById(R.id.calcView);
        resultView = findViewById(R.id.resultView);

        // get all textinput
        gold = findViewById(R.id.gold);
        silver = findViewById(R.id.silver);
        bank = findViewById(R.id.bank);
        loan = findViewById(R.id.loan);
        invest = findViewById(R.id.invest);
        cradit = findViewById(R.id.cradit);
        employee = findViewById(R.id.employee);
        tax = findViewById(R.id.tax);

        // get all textview
        total = findViewById(R.id.total);
        jakat = findViewById(R.id.zakat);

        // get all buttons
        calc = findViewById(R.id.calc);
        back = findViewById(R.id.back);


        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int gold_amount = Integer.parseInt(gold.getText().toString());
                int silver_amount = Integer.parseInt(silver.getText().toString());
                int bank_amount = Integer.parseInt(bank.getText().toString());
                int loan_amount = Integer.parseInt(loan.getText().toString());
                int invest_amount = Integer.parseInt(invest.getText().toString());

                int cradit_amount = Integer.parseInt(cradit.getText().toString());
                int employee_amount = Integer.parseInt(employee.getText().toString());
                int tax_amount = Integer.parseInt(tax.getText().toString());

                int asset = gold_amount + silver_amount + bank_amount + loan_amount + invest_amount;
                int liabilities = cradit_amount + employee_amount + tax_amount;

                int total_asset = asset - liabilities;

                if(total_asset >= nisab){
                    float payable_zakat = (float) ((total_asset * 2.5) / 100);
                    calcView.setVisibility(View.GONE);
                    resultView.setVisibility(View.VISIBLE);

                    total.setText("মোট সম্পদ " + total_asset + " টাকা");
                    jakat.setText("যাকাত প্রদেয় " + payable_zakat + " টাকা");
                }else {
                    calcView.setVisibility(View.GONE);
                    resultView.setVisibility(View.VISIBLE);

                    total.setText("মোট সম্পদ " + total_asset + " টাকা");
                    jakat.setText("আপনার জাকাত দেওয়ার মত পর্যাপ্ত নিসাব নাই!!");
                }

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcView.setVisibility(View.VISIBLE);
                resultView.setVisibility(View.GONE);

            }
        });
    }
}