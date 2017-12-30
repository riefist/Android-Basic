package com.muhamadarief.androidbasic.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.muhamadarief.androidbasic.R;

public class MoveWithObjectActivity extends AppCompatActivity {

    public static final String EXTRA_PERSON = "extra_person";
    private TextView tvObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        tvObject = findViewById(R.id.tv_object_received);
        PersonObject mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Nama : "+mPerson.getName()+ ", Email : "+mPerson.getEmail()+
                ", Age : "+mPerson.getAge()+", Location : "+mPerson.getCity();
        tvObject.setText(text);

    }
}
