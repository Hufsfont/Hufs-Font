package com.example.font_opencv;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class SyllableCropActivity extends AppCompatActivity { // 추가된 액티비티

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
