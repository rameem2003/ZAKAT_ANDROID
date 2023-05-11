package com.example.zakat;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorStateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.zip.Inflater;

public class personal_zakat extends AppCompatActivity {
    LinearLayout calcView, resultView;
    MaterialButton calc, back;

    TextInputLayout gold_layout, silver_layout, bank_layout, hajj_layout, loan_layout, invest_layout, cradit_layout, employee_layout, tax_layout;
    TextInputEditText gold, silver, bank, hajj, loan, invest, cradit, employee, tax;
    TextView total, jakat;

    AlertDialog dialog;

    int nisab = 43000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_zakat);

        String errorMsg = "ফিল্ডটি পুরন হয় নাই, দয়া করে পূরণ করুন বা শূন্য বসিয়ে এগিয়ে যান";
        String toastMsg = "আপনি একটি ফিল্ড খালি রেখেছেন";

        // get all linear layout
        calcView = findViewById(R.id.calcView);
        resultView = findViewById(R.id.resultView);

        // get all layout
        gold_layout = findViewById(R.id.gold_layout);
        silver_layout = findViewById(R.id.silver_layout);
        bank_layout = findViewById(R.id.bank_layout);
        hajj_layout = findViewById(R.id.hajj_layout);
        loan_layout = findViewById(R.id.loan_layout);
        invest_layout = findViewById(R.id.invest_layout);
        cradit_layout = findViewById(R.id.cradit_layout);
        employee_layout = findViewById(R.id.employee_layout);
        tax_layout = findViewById(R.id.tax_layout);

        // get all textinput
        gold = findViewById(R.id.gold);
        silver = findViewById(R.id.silver);
        bank = findViewById(R.id.bank);
        hajj = findViewById(R.id.hajj);
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
                String gold_value = gold.getText().toString();
                String silver_value = silver.getText().toString();
                String bank_value = bank.getText().toString();
                String hajj_value = hajj.getText().toString();
                String loan_value = loan.getText().toString();
                String invest_value = invest.getText().toString();
                String cradit_value = cradit.getText().toString();
                String employee_value = employee.getText().toString();
                String tax_value = tax.getText().toString();

                closeKeyboard();

                if(gold_value.isEmpty()){
                    gold_layout.setHelperText(errorMsg);
                    gold_layout.setError(errorMsg);
                    Toast.makeText(personal_zakat.this, toastMsg, Toast.LENGTH_SHORT).show();
                }
                else if(silver_value.isEmpty()){
                    silver_layout.setHelperText(errorMsg);
                    silver_layout.setError(errorMsg);
                    Toast.makeText(personal_zakat.this, toastMsg, Toast.LENGTH_SHORT).show();
                }

                else if(bank_value.isEmpty()){
                    bank_layout.setHelperText(errorMsg);
                    bank_layout.setError(errorMsg);
                    Toast.makeText(personal_zakat.this, toastMsg, Toast.LENGTH_SHORT).show();
                }

                else if(hajj_value.isEmpty()){
                    hajj_layout.setHelperText(errorMsg);
                    hajj_layout.setError(errorMsg);
                    Toast.makeText(personal_zakat.this, toastMsg, Toast.LENGTH_SHORT).show();
                }

                else if(loan_value.isEmpty()){
                    loan_layout.setHelperText(errorMsg);
                    loan_layout.setError(errorMsg);
                    Toast.makeText(personal_zakat.this, toastMsg, Toast.LENGTH_SHORT).show();
                }

                else if(invest_value.isEmpty()){
                    invest_layout.setHelperText(errorMsg);
                    invest_layout.setError(errorMsg);
                    Toast.makeText(personal_zakat.this, toastMsg, Toast.LENGTH_SHORT).show();
                }

                else if(cradit_value.isEmpty()){
                    cradit_layout.setHelperText(errorMsg);
                    cradit_layout.setError(errorMsg);
                    Toast.makeText(personal_zakat.this, toastMsg, Toast.LENGTH_LONG).show();
                }

                else if(employee_value.isEmpty()){
                    employee_layout.setHelperText(errorMsg);
                    employee_layout.setError(errorMsg);
                    Toast.makeText(personal_zakat.this, toastMsg, Toast.LENGTH_LONG).show();
                }

                else if(tax_value.isEmpty()){
                    tax_layout.setHelperText(errorMsg);
                    tax_layout.setError(errorMsg);
                    Toast.makeText(personal_zakat.this, toastMsg, Toast.LENGTH_LONG).show();
                }

                else {
                    if(!gold_value.isEmpty()){
                        gold_layout.setError("");
                        gold_layout.setHelperText("ফিল্ডটি পূরণ হয়েছে");
                        gold_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#FF009432")));
                    } if (!silver_value.isEmpty()) {
                        silver_layout.setError("");
                        silver_layout.setHelperText("ফিল্ডটি পূরণ হয়েছে");
                        silver_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#FF009432")));
                    } if (!bank_value.isEmpty()) {
                        bank_layout.setError("");
                        bank_layout.setHelperText("ফিল্ডটি পূরণ হয়েছে");
                        bank_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#FF009432")));
                    } if (!hajj_value.isEmpty()) {
                        hajj_layout.setError("");
                        hajj_layout.setHelperText("ফিল্ডটি পূরণ হয়েছে");
                        hajj_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#FF009432")));
                    } if (!loan_value.isEmpty()) {
                        loan_layout.setError("");
                        loan_layout.setHelperText("ফিল্ডটি পূরণ হয়েছে");
                        loan_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#FF009432")));
                    } if (!invest_value.isEmpty()) {
                        invest_layout.setError("");
                        invest_layout.setHelperText("ফিল্ডটি পূরণ হয়েছে");
                        invest_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#FF009432")));
                    } if (!cradit_value.isEmpty()) {
                        cradit_layout.setError("");
                        cradit_layout.setHelperText("ফিল্ডটি পূরণ হয়েছে");
                        cradit_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#FF009432")));
                    } if (!employee_value.isEmpty()) {
                        employee_layout.setError("");
                        employee_layout.setHelperText("ফিল্ডটি পূরণ হয়েছে");
                        employee_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#FF009432")));
                    } if (!tax_value.isEmpty()) {
                        tax_layout.setError("");
                        tax_layout.setHelperText("ফিল্ডটি পূরণ হয়েছে");
                        tax_layout.setHelperTextColor(ColorStateList.valueOf(Color.parseColor("#FF009432")));
                    }


                    int gold_amount = Integer.parseInt(gold.getText().toString());
                    int silver_amount = Integer.parseInt(silver.getText().toString());
                    int bank_amount = Integer.parseInt(bank.getText().toString());
                    int hajj_amount = Integer.parseInt(hajj.getText().toString());
                    int loan_amount = Integer.parseInt(loan.getText().toString());
                    int invest_amount = Integer.parseInt(invest.getText().toString());

                    int cradit_amount = Integer.parseInt(cradit.getText().toString());
                    int employee_amount = Integer.parseInt(employee.getText().toString());
                    int tax_amount = Integer.parseInt(tax.getText().toString());

                    int asset = gold_amount + silver_amount + bank_amount + hajj_amount+ loan_amount + invest_amount;
                    int liabilities = cradit_amount + employee_amount + tax_amount;

                    int total_asset = asset - liabilities;

                    if(total_asset >= nisab){
                        float payable_zakat = (float) ((total_asset * 2.5) / 100);
                        //calcView.setVisibility(View.GONE);
                        //resultView.setVisibility(View.VISIBLE);

                        //total.setText("মোট সম্পদ " + total_asset + " টাকা");
                        //jakat.setText("যাকাত প্রদেয় " + payable_zakat + " টাকা");

                        showCustomAlertBox(total_asset, payable_zakat, "");



                    }else {
                        //calcView.setVisibility(View.GONE);
                        //resultView.setVisibility(View.VISIBLE);

                        //total.setText("মোট সম্পদ " + total_asset + " টাকা");
                        //jakat.setText("আপনার জাকাত দেওয়ার মত পর্যাপ্ত নিসাব নাই!!");

                        showCustomAlertBox(total_asset, 0, "আপনার জাকাত দেওয়ার মত পর্যাপ্ত নিসাব নাই!!");
                    }
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

    private void showCustomAlertBox(int asset, float zakat, String msg) {
        // custom alert messagebox create
        LayoutInflater inflater = getLayoutInflater();
        View layoutView = inflater.inflate(R.layout.alertdialogue, null);
        TextView totalAssetMsg = layoutView.findViewById(R.id.tatalAsset);
        TextView zakatPayMsg = layoutView.findViewById(R.id.zakatPay);
        Button customMsgBack = layoutView.findViewById(R.id.back);

        dialog = new AlertDialog.Builder(personal_zakat.this).setView(layoutView).create();
        dialog.show();

        totalAssetMsg.setText("মোট সম্পদ " + asset + " টাকা");
        zakatPayMsg.setText("যাকাত প্রদেয় " + zakat + " টাকা। " + msg);

        customMsgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();;
            }
        });
    }

    public void closeKeyboard () {
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            im.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}