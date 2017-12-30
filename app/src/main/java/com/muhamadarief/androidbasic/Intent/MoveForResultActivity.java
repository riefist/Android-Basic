package com.muhamadarief.androidbasic.Intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.muhamadarief.androidbasic.R;

public class MoveForResultActivity extends AppCompatActivity {

    private Button btnChoose;
    private EditText edtNama;
    public static final String EXTRA_NAMA = "extra_NAMA";
    public static int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_for_result);

        edtNama = findViewById(R.id.edt_name);
        btnChoose = findViewById(R.id.btn_choose);

        btnChoose.setOnClickListener(view -> {
            String name = edtNama.getText().toString();
            if (TextUtils.isEmpty(name)) {
                edtNama.setError("Isi dulu gan");
                return;
            }
            Intent resultIntent = new Intent();
            resultIntent.putExtra(EXTRA_NAMA, name);
            setResult(RESULT_CODE, resultIntent);
            finish();
        });


    }

}
