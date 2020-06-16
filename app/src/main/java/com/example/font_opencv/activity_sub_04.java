package com.example.font_opencv;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.font_opencv.utils.UiHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class activity_sub_04 extends AppCompatActivity {

    ImageView imageView1;
    private UiHelper uiHelper = new UiHelper();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_04);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), activity_sub_05.class);
                startActivityForResult(intent, 1);
            }
        });

        imageView1 = (ImageView) findViewById(R.id.imageView1);

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    saveBitmapToJpeg(Mydata.myletter_element_b[0][0], "giyeok");
                    saveBitmapToJpeg(Mydata.myletter_element_b[4][1], "ah");
                    saveBitmapToJpeg(Mydata.myletter_element_b[3][0], "bieub");
                    //uiHelper.toast(activity_sub_04.this, "call the function.");
                } catch (Exception e) {
                    uiHelper.toast(activity_sub_04.this, "fail save image");
                }
            }
        });

        if (Mydata.maked_letter[0] != null) {
            imageView1.setImageBitmap(Mydata.maked_letter[0]);
        }

    }

    private void saveBitmapToJpeg(Bitmap bitmap, String name) throws IOException{

        String path = Environment.getExternalStorageDirectory().getPath()+ File.separator + "font_image";

        //저장할 파일 이름
        String fileName = name + ".jpg";

        //storage 에 파일 인스턴스를 생성합니다.

        File outputDir= new File(path);


        outputDir.mkdirs();
        File newFile = new File(path+"/"+fileName);
        FileOutputStream out = new FileOutputStream(newFile);
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
        out.close();
    }

/*
    // 외부 저장소
    private void saveBitmapToJpeg(Bitmap bitmap, String name) {

        uiHelper.toast(activity_sub_04.this, "called function.");

        File storageDir = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DCIM
                ), "font_image"
        );

        //저장할 파일 이름
        String fileName = name + ".jpg";

        //storage 에 파일 인스턴스를 생성합니다.
        File tempFile = new File(storageDir, fileName);

        try {

            // 자동으로 빈 파일을 생성합니다.
            tempFile.createNewFile();

            // 파일을 쓸 수 있는 스트림을 준비합니다.
            FileOutputStream out = new FileOutputStream(tempFile);

            // compress 함수를 사용해 스트림에 비트맵을 저장합니다.
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

            // 스트림 사용후 닫아줍니다.
            out.close();

        } catch (FileNotFoundException e) {
            Log.e("MyTag","FileNotFoundException : " + e.getMessage());
        } catch (IOException e) {
            Log.e("MyTag","IOException : " + e.getMessage());
        }
    }

 */

    /*
    // 내부 저장소
    private void saveBitmapToJpeg(Bitmap bitmap, String name) {

        //내부저장소 캐시 경로를 받아옵니다.
        File storage = getCacheDir();

        //저장할 파일 이름
        String fileName = name + ".jpg";

        //storage 에 파일 인스턴스를 생성합니다.
        File tempFile = new File(storage, fileName);

        try {

            // 자동으로 빈 파일을 생성합니다.
            tempFile.createNewFile();

            // 파일을 쓸 수 있는 스트림을 준비합니다.
            FileOutputStream out = new FileOutputStream(tempFile);

            // compress 함수를 사용해 스트림에 비트맵을 저장합니다.
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);

            // 스트림 사용후 닫아줍니다.
            out.close();

        } catch (FileNotFoundException e) {
            Log.e("MyTag","FileNotFoundException : " + e.getMessage());
        } catch (IOException e) {
            Log.e("MyTag","IOException : " + e.getMessage());
        }
    }

     */

}
