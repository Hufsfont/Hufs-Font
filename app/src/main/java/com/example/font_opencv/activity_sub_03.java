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
    private Mat img_input4;

    private Mat img_output;

    public native void make_type1_words(long inputImage1, long inputImage2, long outputImage);
    public native void make_type2_words(long inputImage1, long inputImage2, long outputImage);
    public native void make_type3_words(long inputImage1, long inputImage2, long inputImage3, long outputImage);
    public native void make_type4_words(long inputImage1, long inputImage2, long inputImage3, long outputImage);
    public native void make_type5_words(long inputImage1, long inputImage2, long inputImage3, long outputImage);
    public native void make_type6_words(long inputImage1, long inputImage2, long inputImage3, long inputImage4, long outputImage);

    //private Mat cons_img; // 배열 테스트용
    //private Mat vow_img; // 배열 테스트용

    //Mat[] output_img = new Mat[10];
    //List<Mat> consonents = new ArrayList<Mat>(); // 배열 테스트용
    //List<Mat> Mydata.vowels = new ArrayList<Mat>(); // 배열 테스트용
    //List<Mat> output_img_list = new ArrayList<Mat>(); // 배열 테스트용

    //public native void arr_test(long[] consImage, long[] vowImage, long[] outputImage); // 배열 테스트용

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


        // 자음, 모음을 배열에 각각 저장하는 코드
        //Mydata.match(); // 배열 테스트용
/*
        Mydata.consonant[0] = Mydata.myletter_element_b[0][0].copy(Bitmap.Config.ARGB_8888,true); //ㄱ;
        Mydata.consonant[1] = Mydata.myletter_element_b[5][2].copy(Bitmap.Config.ARGB_8888,true); //ㄴ :
        Mydata.consonant[2] = Mydata.myletter_element_b[4][0].copy(Bitmap.Config.ARGB_8888,true); //ㄷ :
        Mydata.consonant[3] = Mydata.myletter_element_b[9][0].copy(Bitmap.Config.ARGB_8888,true); //ㄹ :
        Mydata.consonant[4] = Mydata.myletter_element_b[6][0].copy(Bitmap.Config.ARGB_8888,true); //ㅁ :
        Mydata.consonant[5] = Mydata.myletter_element_b[3][0].copy(Bitmap.Config.ARGB_8888,true); //ㅂ :
        Mydata.consonant[6] = Mydata.myletter_element_b[8][0].copy(Bitmap.Config.ARGB_8888,true); //ㅅ :
        Mydata.consonant[7] = Mydata.myletter_element_b[7][2].copy(Bitmap.Config.ARGB_8888,true); //ㅇ :
        Mydata.consonant[8] = Mydata.myletter_element_b[2][0].copy(Bitmap.Config.ARGB_8888,true); //ㅈ :
        Mydata.consonant[9] = Mydata.myletter_element_b[6][2].copy(Bitmap.Config.ARGB_8888,true); //ㅊ :
        Mydata.consonant[10] = Mydata.myletter_element_b[5][0].copy(Bitmap.Config.ARGB_8888,true); //ㅋ :
        Mydata.consonant[11] = Mydata.myletter_element_b[0][2].copy(Bitmap.Config.ARGB_8888,true); //ㅌ :
        Mydata.consonant[12] = Mydata.myletter_element_b[1][0].copy(Bitmap.Config.ARGB_8888,true); //ㅍ :
        Mydata.consonant[13] = Mydata.myletter_element_b[7][0].copy(Bitmap.Config.ARGB_8888,true); //ㅎ :

        Mydata.vowel[0] = Mydata.myletter_element_b[4][1].copy(Bitmap.Config.ARGB_8888,true); //ㅏ :
        Mydata.vowel[1] = Mydata.myletter_element_b[7][1].copy(Bitmap.Config.ARGB_8888,true); //ㅑ :
        Mydata.vowel[2] = Mydata.myletter_element_b[0][1].copy(Bitmap.Config.ARGB_8888,true); //ㅓ :
        Mydata.vowel[3] = Mydata.myletter_element_b[6][1].copy(Bitmap.Config.ARGB_8888,true); //ㅕ :
        Mydata.vowel[4] = Mydata.myletter_element_b[3][1].copy(Bitmap.Config.ARGB_8888,true); //ㅗ :
        Mydata.vowel[5] = Mydata.myletter_element_b[1][1].copy(Bitmap.Config.ARGB_8888,true); //ㅛ :
        Mydata.vowel[6] = Mydata.myletter_element_b[8][1].copy(Bitmap.Config.ARGB_8888,true); //ㅜ :
        Mydata.vowel[7] = Mydata.myletter_element_b[9][1].copy(Bitmap.Config.ARGB_8888,true); //ㅠ :
        Mydata.vowel[9] = Mydata.myletter_element_b[2][1].copy(Bitmap.Config.ARGB_8888,true); //ㅣ :
        Mydata.vowel[8] = Mydata.myletter_element_b[5][1].copy(Bitmap.Config.ARGB_8888,true); //ㅡ :


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


        for (int i = 0; i < 14; i++){
            Utils.bitmapToMat(Mydata.consonant[i], cons_img);
            consonents.add(cons_img);
        }

        for (int i = 0; i < 9; i++){
            Utils.bitmapToMat(Mydata.vowel[i], vow_img);
            Mydata.vowels.add(vow_img);
        }

        for (int i = 0; i < 9; i++){
            Mat output_img = new Mat();
            output_img_list.add(output_img);
        }

        int cons_elems = consonents.size();
        int vow_elems = Mydata.vowels.size();
        int elems = output_img_list.size();
        Log.v("Matobjdata", "number of cons_elems = " + cons_elems);
        Log.v("Matobjdata", "number of vow_elems = " + vow_elems);
        Log.v("Matobjdata", "number of Matobject read = " + elems);
        long[] temp_adr_cons = new long[cons_elems];
        long[] temp_adr_vow = new long[vow_elems];
        long[] temp_adr = new long[elems];

        for (int i = 0; i < cons_elems; i++){
            Mat tempaddr4cons = consonents.get(i);
            temp_adr_cons[i] = tempaddr4cons.getNativeObjAddr();
        }
        for (int i = 0; i < cons_elems; i++){
            Mat tempaddr4vow = Mydata.vowels.get(i);
            temp_adr_vow[i] = tempaddr4vow.getNativeObjAddr();
        }
        for (int i = 0; i < elems; i++){
            Mat tempaddr = output_img_list.get(i);
            temp_adr[i] = tempaddr.getNativeObjAddr();
        }

        arr_test(temp_adr_cons, temp_adr_vow, temp_adr);

        for (int i = 0; i < 9; i++){
            if(output_img_list!= null){
                Mydata.maked_letter[i] = Bitmap.createBitmap(output_img_list.get(i).cols(), output_img_list.get(i).rows(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(output_img_list.get(i), Mydata.maked_letter[i]);
            }
        }
*/


        img_input1 = new Mat();
        img_input2 = new Mat();
        img_input3 = new Mat();
        img_input4 = new Mat();

        if (img_output == null)
            //img_output = new Mat(500, 550, CvType.CV_8U, new Scalar(4));
            img_output = new Mat();

        for (int i = 0; i < 1; i++ ){
            switch (i){
                case 0:
                    Utils.bitmapToMat(Mydata.myletter_element_b[6][2], img_input1); // ㅊ
                    Utils.bitmapToMat(Mydata.myletter_element_b[8][1], img_input2); // ㅜ
                    Utils.bitmapToMat(Mydata.myletter_element_b[2][1], img_input3); // ㅣ

                    if(img_input1 != null && img_input2 != null && img_input3 != null){
                        make_type3_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_output.getNativeObjAddr());
                    }

                    break;
                    /*
                case 1:
                    Utils.bitmapToMat(Mydata.myletter_element_b[2][0], img_input1); // ㅈ
                    Utils.bitmapToMat(Mydata.myletter_element_b[3][1], img_input2); // ㅗ

                    if(img_input1 != null && img_input2 != null){
                        make_type2_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_output.getNativeObjAddr());
                    }

                    break;
                case 2:
                    Utils.bitmapToMat(Mydata.myletter_element_b[0][0], img_input1); // ㄱ
                    Utils.bitmapToMat(Mydata.myletter_element_b[8][1], img_input2); // ㅜ
                    Utils.bitmapToMat(Mydata.myletter_element_b[0][1], img_input3); // ㅓ
                    Utils.bitmapToMat(Mydata.myletter_element_b[5][2], img_input4); // ㄴ


                    if(img_input1 != null && img_input2 != null && img_input3 != null && img_input4 != null){
                        make_type6_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_input4.getNativeObjAddr(), img_output.getNativeObjAddr());
                    }

                    break;
                case 3:
                    Utils.bitmapToMat(Mydata.myletter_element_b[3][0], img_input1); // ㅂ
                    Utils.bitmapToMat(Mydata.myletter_element_b[6][1], img_input2); // ㅕ
                    Utils.bitmapToMat(Mydata.myletter_element_b[9][0], img_input3); // ㄹ

                    if(img_input1 != null && img_input2 != null && img_input3 != null){
                        make_type4_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_output.getNativeObjAddr());
                    }

                    break;
                case 4:
                    Utils.bitmapToMat(Mydata.myletter_element_b[7][2], img_input1); // ㅍ
                    Utils.bitmapToMat(Mydata.myletter_element_b[0][1], img_input2); // ㅏ

                    if(img_input1 != null && img_input2 != null){
                        make_type1_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_output.getNativeObjAddr());
                    }

                    break;
                case 5:
                    Utils.bitmapToMat(Mydata.myletter_element_b[4][0], img_input1); // ㄷ
                    Utils.bitmapToMat(Mydata.myletter_element_b[3][1], img_input2); // ㅗ
                    Utils.bitmapToMat(Mydata.myletter_element_b[7][2], img_input3); // ㅇ

                    if(img_input1 != null && img_input2 != null && img_input3 != null){
                        make_type5_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_output.getNativeObjAddr());
                    }

                    break;
                case 6:
                    Utils.bitmapToMat(Mydata.myletter_element_b[0][0], img_input1); // ㄱ
                    Utils.bitmapToMat(Mydata.myletter_element_b[3][1], img_input2); // ㅗ
                    Utils.bitmapToMat(Mydata.myletter_element_b[7][2], img_input3); // ㅇ

                    if(img_input1 != null && img_input2 != null && img_input3 != null){
                        make_type5_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_output.getNativeObjAddr());
                    }

                    break;
                case 7:
                    Utils.bitmapToMat(Mydata.myletter_element_b[7][0], img_input1); // ㅎ
                    Utils.bitmapToMat(Mydata.myletter_element_b[4][1], img_input2); // ㅏ
                    Utils.bitmapToMat(Mydata.myletter_element_b[0][0], img_input3); // ㄱ

                    if(img_input1 != null && img_input2 != null && img_input3 != null){
                        make_type4_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_output.getNativeObjAddr());
                    }

                    break;
                case 8:
                    Utils.bitmapToMat(Mydata.myletter_element_b[0][0], img_input1); // ㄱ
                    Utils.bitmapToMat(Mydata.myletter_element_b[3][1], img_input2); // ㅗ
                    Utils.bitmapToMat(Mydata.myletter_element_b[4][1], img_input3); // ㅏ
                    Utils.bitmapToMat(Mydata.myletter_element_b[5][2], img_input4); // ㄴ

                    if(img_input1 != null && img_input2 != null && img_input3 != null && img_input4 != null){
                        make_type6_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_input4.getNativeObjAddr(), img_output.getNativeObjAddr());
                    }

                    break;
*/
                default:
                    break;
            }


            if(img_output != null){
                Mydata.maked_letter[i] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
                Utils.matToBitmap(img_output, Mydata.maked_letter[i]);
            }

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


        /*
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
*/

        else{
            uiHelper.toast(this, "There's no image.");
        }



/*
        // 배열 테스트용

        if(Mydata.maked_letter[0] != null) {
            imageView6.setImageBitmap(Mydata.consonant[0]);
        }

        if(Mydata.maked_letter[1] != null) {
            imageView2.setImageBitmap(Mydata.consonant[1]);
        }
        if(Mydata.maked_letter[2] != null) {
            imageView3.setImageBitmap(Mydata.consonant[2]);
        }
        if(Mydata.maked_letter[3] != null) {
            imageView1.setImageBitmap(Mydata.consonant[3]);
        }
        if(Mydata.maked_letter[4] != null) {
            imageView7.setImageBitmap(Mydata.consonant[4]);
        }
        if(Mydata.maked_letter[5] != null) {
            imageView8.setImageBitmap(Mydata.consonant[5]);
        }
        if(Mydata.maked_letter[6] != null) {
            imageView9.setImageBitmap(Mydata.consonant[6]);
        }
        if(Mydata.maked_letter[7] != null) {
            imageView10.setImageBitmap(Mydata.consonant[7]);
        }
        if(Mydata.maked_letter[8] != null) {
            imageView11.setImageBitmap(Mydata.consonant[8]);
        }
        else{
            uiHelper.toast(this, "There's no image.");
        }

 */



    }


}
