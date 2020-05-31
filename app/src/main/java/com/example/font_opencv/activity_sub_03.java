package com.example.font_opencv;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import org.opencv.android.Utils;
import org.opencv.core.Mat;

public class activity_sub_03 extends AppCompatActivity {

    static {
        System.loadLibrary("opencv_java4");
        System.loadLibrary("native-lib");
    }

    private Mat img_input;
    private Mat img_output;

    ImageView imageView1;

    public native void opencv(long matAddrInput, long matAddrResult);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_03);

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
                Intent intent = new Intent(getApplicationContext(), activity_sub_04.class);
                startActivityForResult(intent, 1);
            }
        });

        //opencv_and_showResult();

        img_input = new Mat();
        Bitmap bitmap = Mydata.sentence_bitmap;
        Bitmap bmp32 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Utils.bitmapToMat(bmp32, img_input);

        if (img_output == null)
            img_output = new Mat();

        opencv(img_input.getNativeObjAddr(), img_output.getNativeObjAddr());

        Mydata.example = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example);

        imageView1 = (ImageView) findViewById(R.id.imageView1);

        if(Mydata.example != null) {
            imageView1.setImageBitmap(Mydata.example);
            //uiHelper.toast(this, "error.");
        }
    }

//    public native void opencv(long inputImage, long outputImage);
/*
    private void opencv_and_showResult() {
        img_input = new Mat();
        //Bitmap bmp32 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        Utils.bitmapToMat(Mydata.sentence_bitmap, img_input);

        if (img_output == null)
            img_output = new Mat();

        opencv(img_input.getNativeObjAddr(), img_output.getNativeObjAddr());

        Mydata.example= Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example);
    }
 */



}
