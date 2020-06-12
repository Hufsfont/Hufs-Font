package com.example.font_opencv;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.font_opencv.utils.UiHelper;

import org.opencv.android.Utils;
import org.opencv.core.Mat;

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

    private Mat img_input1;
    private Mat img_input2;
    private Mat img_input3;

    private Mat img_output;

    public native void make_words_03(long inputImage1, long inputImage2, long inputImage3, long outputImage);

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
/*
        Mydata.consonant[0] = Mydata.myletter_element_b[0][0]; //ㄱ :
        Mydata.consonant[1] = Mydata.myletter_element_b[5][2]; //ㄴ :
        Mydata.consonant[2] = Mydata.myletter_element_b[4][0]; //ㄷ :
        Mydata.consonant[3] = Mydata.myletter_element_b[9][0]; //ㄹ :
        Mydata.consonant[4] = Mydata.myletter_element_b[6][0]; //ㅁ :
        Mydata.consonant[5] = Mydata.myletter_element_b[3][0]; //ㅂ :
        Mydata.consonant[6] = Mydata.myletter_element_b[8][0]; //ㅅ :
        Mydata.consonant[7] = Mydata.myletter_element_b[7][2]; //ㅇ :
        Mydata.consonant[8] = Mydata.myletter_element_b[2][0]; //ㅈ :
        Mydata.consonant[9] = Mydata.myletter_element_b[6][2]; //ㅊ :
        Mydata.consonant[10] = Mydata.myletter_element_b[5][0]; //ㅋ :
        Mydata.consonant[11] = Mydata.myletter_element_b[0][2]; //ㅌ :
        Mydata.consonant[12] = Mydata.myletter_element_b[1][0]; //ㅍ :
        Mydata.consonant[13] = Mydata.myletter_element_b[7][0]; //ㅎ :

        Mydata.vowel[0] = Mydata.myletter_element_b[4][1]; //ㅏ :
        Mydata.vowel[1] = Mydata.myletter_element_b[7][1]; //ㅑ :
        Mydata.vowel[2] = Mydata.myletter_element_b[0][1]; //ㅓ :
        Mydata.vowel[3] = Mydata.myletter_element_b[6][1]; //ㅕ :
        Mydata.vowel[4] = Mydata.myletter_element_b[3][1]; //ㅗ :
        Mydata.vowel[5] = Mydata.myletter_element_b[1][1]; //ㅛ :
        Mydata.vowel[6] = Mydata.myletter_element_b[8][1]; //ㅜ :
        Mydata.vowel[7] = Mydata.myletter_element_b[9][1]; //ㅠ :
        Mydata.vowel[8] = Mydata.myletter_element_b[5][1]; //ㅡ :
        Mydata.vowel[9] = Mydata.myletter_element_b[2][1]; //ㅣ :

 */


        img_input1 = new Mat();
        img_input2 = new Mat();
        img_input3 = new Mat();
        //Bitmap bitmap2 = Mydata.sentence_bitmap;
        //Bitmap bmp32 = bitmap2.copy(Bitmap.Config.ARGB_8888, true);
/*
        if(Mydata.consonant[0] == null){
            uiHelper.toast(this, "ㄱ에 실패하여 크롭된 이미지가 없습니다.");
        }
        if(Mydata.vowel[0] == null){
            uiHelper.toast(this, "ㅏ에 실패하여 크롭된 이미지가 없습니다.");
        }
        if(Mydata.consonant[7] == null){
            uiHelper.toast(this, "ㅇ에 실패하여 크롭된 이미지가 없습니다.");
        }

 */


        Utils.bitmapToMat(Mydata.myletter_element_b[0][0], img_input1);
        Utils.bitmapToMat(Mydata.myletter_element_b[4][1], img_input2);
        Utils.bitmapToMat(Mydata.myletter_element_b[7][2], img_input3);

        if (img_output == null)
            img_output = new Mat();

        if(img_input1 != null && img_input2 != null && img_input3 != null){
            make_words_03(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_output.getNativeObjAddr());
        }


        if(img_output != null){
            Mydata.maked_letter[0] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(img_output, Mydata.maked_letter[0]);
        }




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
