package com.example.font_opencv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class activity_sub_02_08 extends AppCompatActivity {

    ImageView imageView1, imageView2, imageView3;
    private String currentPhotoPath = "";
    private UiHelper uiHelper = new UiHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_02_08);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Mydata.data_count--;
                finish();
            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), activity_sub_02_09.class);
                startActivityForResult(intent, 1);
            }
        });

        ImageButton imageButton_1 = findViewById(R.id.imageButton_1); // 도움말 표시하기
        imageButton_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                setContentView(new SomeView(activity_sub_02_08.this));
            }
        });

        if(Mydata.example[Mydata.data_count] != null) {
            imageButton_1.setImageBitmap(Mydata.example[Mydata.data_count]);
        }
        else{
            uiHelper.toast(this, "error.");
        }


        if(Mydata.myletter_element[Mydata.data_count][0] != null) {
            Uri imageUri = Uri.parse(Mydata.myletter_element[Mydata.data_count][0]);
            imageView1 = (ImageView) findViewById(R.id.imageView1);
            imageView1.setImageURI(imageUri);
        }

        if(Mydata.myletter_element[Mydata.data_count][1] != null) {
            Uri imageUri = Uri.parse(Mydata.myletter_element[Mydata.data_count][1]);
            imageView2 = (ImageView) findViewById(R.id.imageView2);
            imageView2.setImageURI(imageUri);
        }

        if(Mydata.myletter_element[Mydata.data_count][2] != null) {
            Uri imageUri = Uri.parse(Mydata.myletter_element[Mydata.data_count][2]);
            imageView3 = (ImageView) findViewById(R.id.imageView3);
            imageView3.setImageURI(imageUri);
        }



    }
}
