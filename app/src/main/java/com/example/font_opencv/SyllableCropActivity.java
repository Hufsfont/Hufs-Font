package com.example.font_opencv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SyllableCropActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(new SomeView(SyllableCropActivity.this));
    }
}
