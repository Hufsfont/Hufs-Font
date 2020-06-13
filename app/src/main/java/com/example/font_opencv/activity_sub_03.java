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

    private UiHelper uiHelper = new UiHelper();

    //private Mat[] input_img = new Mat[10];
    //private Mat[] output_img = new Mat[10];

    private Mat img_input1;
    private Mat img_input2;
    private Mat img_input3;

    private Mat img_output;

    public native void make_words(long inputImage1, long inputImage2, long inputImage3, long outputImage);

    ImageView imageView1, imageView2, imageView3, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11;

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

/*
        // 자음, 모음을 배열에 각각 저장하는 코드
        Mydata.match();

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

        Bitmap bitmap2 = Mydata.sentence_bitmap;
        Bitmap bmp32 = bitmap2.copy(Bitmap.Config.ARGB_8888, true);

        // 자음, 모음 배열에 비트맵 이미지가 잘 들어 갔는지 확인
        if(Mydata.consonant[0] == null){
            uiHelper.toast(this, "ㄱ 이미지가 없습니다.");
        }
        if(Mydata.vowel[0] == null){
            uiHelper.toast(this, "ㅏ 이미지가 없습니다.");
        }
        if(Mydata.consonant[7] == null){
            uiHelper.toast(this, "ㅇ 이미지가 없습니다.");
        }


        Utils.bitmapToMat(Mydata.consonant[0], img_input1);
        Utils.bitmapToMat(Mydata.vowel[0], img_input2);
        Utils.bitmapToMat(Mydata.consonant[7], img_input3);

 */
        img_input1 = new Mat();
        img_input2 = new Mat();
        img_input3 = new Mat();

        if (img_output == null)
            //img_output = new Mat(500, 550, CvType.CV_8U, new Scalar(4));
            img_output = new Mat();

        for (int i = 0; i < 9; i++ ){
            switch (i){
                case 0:
                    Utils.bitmapToMat(Mydata.myletter_element_b[0][0], img_input1); // ㄱ
                    Utils.bitmapToMat(Mydata.myletter_element_b[4][1], img_input2); // ㅏ
                    Utils.bitmapToMat(Mydata.myletter_element_b[7][2], img_input3); // ㅇ
                    break;
                case 1:
                    Utils.bitmapToMat(Mydata.myletter_element_b[9][0], img_input1); // ㄹ
                    Utils.bitmapToMat(Mydata.myletter_element_b[4][1], img_input2); // ㅏ
                    Utils.bitmapToMat(Mydata.myletter_element_b[6][0], img_input3); // ㅁ
                    break;
                case 2:
                    Utils.bitmapToMat(Mydata.myletter_element_b[8][0], img_input1); // ㅅ
                    Utils.bitmapToMat(Mydata.myletter_element_b[4][1], img_input2); // ㅏ
                    Utils.bitmapToMat(Mydata.myletter_element_b[5][2], img_input3); // ㄴ
                    break;
                case 3:
                    Utils.bitmapToMat(Mydata.myletter_element_b[3][0], img_input1); // ㅂ
                    Utils.bitmapToMat(Mydata.myletter_element_b[4][1], img_input2); // ㅏ
                    Utils.bitmapToMat(Mydata.myletter_element_b[0][0], img_input3); // ㄱ
                    break;
                case 4:
                    Utils.bitmapToMat(Mydata.myletter_element_b[7][2], img_input1); // ㅇ
                    Utils.bitmapToMat(Mydata.myletter_element_b[0][1], img_input2); // ㅓ
                    Utils.bitmapToMat(Mydata.myletter_element_b[9][0], img_input3); // ㄹ
                    break;
                case 5:
                    Utils.bitmapToMat(Mydata.myletter_element_b[2][0], img_input1); // ㅈ
                    Utils.bitmapToMat(Mydata.myletter_element_b[2][1], img_input2); // ㅣ
                    Utils.bitmapToMat(Mydata.myletter_element_b[3][0], img_input3); // ㅂ
                    break;
                case 6:
                    Utils.bitmapToMat(Mydata.myletter_element_b[0][2], img_input1); // ㅌ
                    Utils.bitmapToMat(Mydata.myletter_element_b[2][1], img_input2); // ㅣ
                    Utils.bitmapToMat(Mydata.myletter_element_b[3][0], img_input3); // ㅂ
                    break;
                case 7:
                    Utils.bitmapToMat(Mydata.myletter_element_b[5][0], img_input1); // ㅋ
                    Utils.bitmapToMat(Mydata.myletter_element_b[0][1], img_input2); // ㅓ
                    Utils.bitmapToMat(Mydata.myletter_element_b[6][0], img_input3); // ㅁ
                    break;
                case 8:
                    Utils.bitmapToMat(Mydata.myletter_element_b[7][0], img_input1); // ㅎ
                    Utils.bitmapToMat(Mydata.myletter_element_b[6][1], img_input2); // ㅕ
                    Utils.bitmapToMat(Mydata.myletter_element_b[5][2], img_input3); // ㄴ
                    break;
                default:
                    break;
            }

            if(img_input1 != null && img_input2 != null && img_input3 != null){
                make_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_output.getNativeObjAddr());
            }

            if(img_output != null){
                Mydata.maked_letter[i] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(img_output, Mydata.maked_letter[i]);
            }

        }
/*
        Utils.bitmapToMat(Mydata.myletter_element_b[0][0], img_input1); // ㄱ
        Utils.bitmapToMat(Mydata.myletter_element_b[4][1], img_input2); // ㅏ
        Utils.bitmapToMat(Mydata.myletter_element_b[7][2], img_input3); // ㅇ


        if (img_output == null)
            //img_output = new Mat(500, 550, CvType.CV_8U, new Scalar(4));
            img_output = new Mat();

        if(img_input1 != null && img_input2 != null && img_input3 != null){
            make_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_output.getNativeObjAddr());
        }

        if(img_output != null){
            Mydata.maked_letter[0] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(img_output, Mydata.maked_letter[0]);
        }

        Utils.bitmapToMat(Mydata.myletter_element_b[9][0], img_input1); // ㄹ
        Utils.bitmapToMat(Mydata.myletter_element_b[4][1], img_input2); // ㅏ
        Utils.bitmapToMat(Mydata.myletter_element_b[6][0], img_input3); // ㅁ

        if(img_input1 != null && img_input2 != null && img_input3 != null){
            make_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_output.getNativeObjAddr());
        }

        if(img_output != null){
            Mydata.maked_letter[1] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(img_output, Mydata.maked_letter[1]);
        }

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
        if(Mydata.maked_letter[1] != null) {
            imageView2.setImageBitmap(Mydata.maked_letter[1]);
        }
        if(Mydata.maked_letter[2] != null) {
            imageView3.setImageBitmap(Mydata.maked_letter[2]);
        }
        if(Mydata.maked_letter[3] != null) {
            imageView1.setImageBitmap(Mydata.maked_letter[3]);
        }
        if(Mydata.maked_letter[4] != null) {
            imageView7.setImageBitmap(Mydata.maked_letter[4]);
        }
        if(Mydata.maked_letter[5] != null) {
            imageView8.setImageBitmap(Mydata.maked_letter[5]);
        }
        if(Mydata.maked_letter[6] != null) {
            imageView9.setImageBitmap(Mydata.maked_letter[6]);
        }
        if(Mydata.maked_letter[7] != null) {
            imageView10.setImageBitmap(Mydata.maked_letter[7]);
        }
        if(Mydata.maked_letter[8] != null) {
            imageView11.setImageBitmap(Mydata.maked_letter[8]);
        }
        else{
            uiHelper.toast(this, "error.");
        }

    }



}
