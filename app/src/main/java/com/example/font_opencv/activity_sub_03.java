package com.example.font_opencv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.font_opencv.utils.UiHelper;

public class activity_sub_03 extends AppCompatActivity {

    static {
        System.loadLibrary("opencv_java4");
        System.loadLibrary("native-lib");
    }

    //private Mat img_input;
    //private Mat img_output;
    private UiHelper uiHelper = new UiHelper();

    //private Mat[] input_img = new Mat[10];
    //private Mat[] output_img = new Mat[10];

    //public native void cv_array_test(long inputImage, long outputImage);

    ImageView imageView1, imageView2, imageView3, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11;

    //public native void opencv(long matAddrInput, long matAddrResult);

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


        //img_input = new Mat();
        //Bitmap bitmap = Mydata.sentence_bitmap;
        //Bitmap bmp32 = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        //Utils.bitmapToMat(Mydata.sentence_bitmap, img_input);
/*
        if (img_output == null)
            img_output = new Mat();

        opencv(img_input.getNativeObjAddr(), img_output.getNativeObjAddr());

        Mydata.example[1] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[1]);

 */

        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);
        imageView8 = (ImageView) findViewById(R.id.imageView8);
        imageView9 = (ImageView) findViewById(R.id.imageView9);
        imageView10 = (ImageView) findViewById(R.id.imageView10);
        imageView11 = (ImageView) findViewById(R.id.imageView11);




        if(Mydata.maked_letter[0] != null) {
            imageView6.setImageBitmap(Mydata.maked_letter[0]);
        }
        else{
            uiHelper.toast(this, "error.");
        }
        /*

        cv_array_test(img_input.getNativeObjAddr(), output_img[0].getNativeObjAddr());

        for(int i = 0; i < 10; i++){
            Mydata.example[i] = Bitmap.createBitmap(output_img[i].cols(), output_img[i].rows(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(output_img[i], Mydata.example[i]);
        }

 */


    }



}
