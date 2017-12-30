package com.muhamadarief.androidbasic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.muhamadarief.androidbasic.Activity.ActivitesActivity;
import com.muhamadarief.androidbasic.Fragment.MateriFragmentActivity;
import com.muhamadarief.androidbasic.Intent.IntentActivity;

public class MainActivity extends AppCompatActivity {

    Button btnActivity, btnIntent, btnFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnActivity = findViewById(R.id.btn_activity);
        btnIntent = findViewById(R.id.btn_intent);
        btnFragment = findViewById(R.id.btn_fragment);

        btnActivity.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ActivitesActivity.class);
            startActivity(intent);
        });

        btnIntent.setOnClickListener( view -> {
            startActivity(new Intent(MainActivity.this, IntentActivity.class));
        });

        btnFragment.setOnClickListener( view -> {
           startActivity(new Intent(MainActivity.this, MateriFragmentActivity.class));
        });
    }
}
