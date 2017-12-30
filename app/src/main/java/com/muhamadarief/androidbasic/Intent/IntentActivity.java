package com.muhamadarief.androidbasic.Intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.muhamadarief.androidbasic.R;

public class IntentActivity extends AppCompatActivity {

    private Button btnMoveWithDataActivity;
    private Button btnMoveWithObjectActivity;
    private Button btnDialPhone;
    private Button btnMoveForResult;
    private TextView tvResult;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        btnMoveWithDataActivity = findViewById(R.id.btn_move_activity_data);
        btnMoveWithDataActivity.setOnClickListener(view -> {
            Intent moveWithDataIntent = new Intent(IntentActivity.this, MoveWithDataActivity.class);
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 21);
            moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Muhamad Arief");
            startActivity(moveWithDataIntent);
        });



        btnMoveWithObjectActivity = findViewById(R.id.btn_move_activity_object);
        btnMoveWithObjectActivity.setOnClickListener(view -> {
            PersonObject mPerson = new PersonObject();
            mPerson.setName("Muhamad Arief");
            mPerson.setAge(21);
            mPerson.setEmail("muhamadarief3101@gmail.com");
            mPerson.setCity("Samarinda");
            Intent moveWithObjectIntent = new Intent(IntentActivity.this, MoveWithObjectActivity.class);
            moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, mPerson);
            startActivity(moveWithObjectIntent);
        });

        btnDialPhone = findViewById(R.id.btn_dial_number);
        btnDialPhone.setOnClickListener(view -> {
            String phoneNumber = "082157269834";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
            startActivity(dialPhoneIntent);
        });

        btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(view -> {
            Intent moveForResultIntent = new Intent(IntentActivity.this, MoveForResultActivity.class);
            startActivityForResult(moveForResultIntent, REQUEST_CODE);
        });

        tvResult = findViewById(R.id.tv_result);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                String hername = data.getStringExtra(MoveForResultActivity.EXTRA_NAMA);
                tvResult.setText("Hasil : "+hername);
            }
        }
    }
}
