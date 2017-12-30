package com.muhamadarief.androidbasic.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.muhamadarief.androidbasic.R;

public class ActivitesActivity extends AppCompatActivity {

    EditText edtLenght, edtWidth;
    Button btnCalculate;
    TextView tvResult;

    public static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activites);


        edtLenght = findViewById(R.id.edt_lenght);
        edtWidth = findViewById(R.id.edt_width);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        if (savedInstanceState != null){
            tvResult.setText(savedInstanceState.getString(STATE_HASIL));
        }

        btnCalculate.setOnClickListener(view -> {
            String lenght = edtLenght.getText().toString().trim();
            String width = edtWidth.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(lenght)){
                isEmptyFields = true;
                edtLenght.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(width)){
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields){
                double l = Double.parseDouble(lenght);
                double w = Double.parseDouble(width);
                double volume = l * w;
                tvResult.setText(String.valueOf(volume));
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, tvResult.getText().toString());
        super.onSaveInstanceState(outState);
    }

}
