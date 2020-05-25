package com.example.font_opencv;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class activity_sub_02 extends AppCompatActivity {
    ImageView imageView1, imageView2, imageView3;
    private String currentPhotoPath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_02);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), activity_sub_03.class);
                startActivityForResult(intent, 1);
            }
        });

        ImageButton imageButton_1 = findViewById(R.id.imageButton_1); // 도움말 표시하기
        imageButton_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                setContentView(new SomeView(activity_sub_02.this));
            }
        });

        try {
            Intent mIntent = getIntent();
            currentPhotoPath = mIntent.getStringExtra("image");
            Toast.makeText(getApplicationContext(),currentPhotoPath, Toast.LENGTH_LONG).show();
            Uri imageUri = Uri.parse(currentPhotoPath);
            imageView1 = (ImageView) findViewById(R.id.imageView1);
            imageView1.setImageURI(imageUri);

        }catch (Exception e) {
            Toast.makeText(getApplicationContext(),"실패", Toast.LENGTH_LONG).show();
        }

    }



}
