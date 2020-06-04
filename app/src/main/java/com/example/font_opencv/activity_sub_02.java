package com.example.font_opencv;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.font_opencv.utils.UiHelper;

import org.opencv.android.Utils;
import org.opencv.core.Mat;

public class activity_sub_02 extends AppCompatActivity {

    static {
        System.loadLibrary("opencv_java4");
        System.loadLibrary("native-lib");
    }

    ImageView imageView1, imageView2, imageView3;
    private String currentPhotoPath = "";
    private UiHelper uiHelper = new UiHelper();

    private Mat img_input;
    //private Mat img_output;
    //List<Mat> img_outputs = new ArrayList<Mat>();

    private Mat img_output1;
    private Mat img_output2;
    private Mat img_output3;
    private Mat img_output4;
    private Mat img_output5;
    private Mat img_output6;
    private Mat img_output7;
    private Mat img_output8;
    private Mat img_output9;
    private Mat img_output10;


    //private Mat[] img_outputs = new Mat[50];


    public native void opencv_02(long inputImage, long outputImage1, long outputImage2, long outputImage3, long outputImage4, long outputImage5,
                              long outputImage6,  long outputImage7, long outputImage8, long outputImage9, long outputImage10);


    //public native void opencv_02_array(long inputImage, Mat[] outputImage);

    //public native void opencv_02_for2(long inputImage, long outputImage1, long outputImage2);



    //public native void opencv_02_test(long inputImage, long outputImage);

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
                Mydata.data_count++;
                Intent intent = new Intent(getApplicationContext(), activity_sub_02_01.class);
                startActivityForResult(intent, 1);
            }
        });

        ImageButton imageButton_1 = findViewById(R.id.imageButton_1); // 도움말 표시하기
        imageButton_1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                setContentView(new SomeView(activity_sub_02.this));
            }
        });

        img_input = new Mat();
        //Bitmap bitmap2 = Mydata.sentence_bitmap;
        //Bitmap bmp32 = bitmap2.copy(Bitmap.Config.ARGB_8888, true);
        Utils.bitmapToMat(Mydata.sentence_bitmap, img_input);


/*
        if (img_output == null)
            img_output = new Mat();

 */


        if (img_output1 == null)
            img_output1 = new Mat();

        if (img_output2 == null)
            img_output2 = new Mat();

        if (img_output3 == null)
            img_output3 = new Mat();

        if (img_output4 == null)
            img_output4 = new Mat();

        if (img_output5 == null)
            img_output5 = new Mat();

        if (img_output6 == null)
            img_output6 = new Mat();

        if (img_output7 == null)
            img_output7 = new Mat();

        if (img_output8 == null)
            img_output8 = new Mat();

        if (img_output9 == null)
            img_output9 = new Mat();

        if (img_output10 == null)
            img_output10 = new Mat();


        //uiHelper.toast(this, "error.");


        opencv_02(img_input.getNativeObjAddr(), img_output1.getNativeObjAddr(), img_output2.getNativeObjAddr(), img_output3.getNativeObjAddr(),
                img_output4.getNativeObjAddr(), img_output5.getNativeObjAddr(),img_output6.getNativeObjAddr(), img_output7.getNativeObjAddr(),
                img_output8.getNativeObjAddr(), img_output9.getNativeObjAddr(), img_output10.getNativeObjAddr());


        //opencv_02_array(img_input.getNativeObjAddr(), img_outputs);

        //opencv_02_test(img_input.getNativeObjAddr(), img_output.getNativeObjAddr());

        //img_outputs = opencv_02_arraylist(img_input.getNativeObjAddr());

        //opencv_02_for2(img_input.getNativeObjAddr(), img_output1.getNativeObjAddr(), img_output2.getNativeObjAddr());

        /*
        for(int i = 0; i < 50; i++){
            Mydata.example[i] = Bitmap.createBitmap(img_outputs[i].cols(), img_outputs[i].rows(), Bitmap.Config.ARGB_8888);
            Utils.matToBitmap(img_outputs[i], Mydata.example[i]);
            i++;
        }

         */

        //uiHelper.toast(this, "output met->bitmap");

/*
        Mydata.example[0] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[0]);

 */


        Mydata.example[0] = Bitmap.createBitmap(img_output1.cols(), img_output1.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output1, Mydata.example[0]);

        Mydata.example[1] = Bitmap.createBitmap(img_output2.cols(), img_output2.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output2, Mydata.example[1]);

        Mydata.example[2] = Bitmap.createBitmap(img_output3.cols(), img_output3.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output3, Mydata.example[2]);

        Mydata.example[3] = Bitmap.createBitmap(img_output4.cols(), img_output4.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output4, Mydata.example[3]);

        Mydata.example[4] = Bitmap.createBitmap(img_output5.cols(), img_output5.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output5, Mydata.example[4]);

        Mydata.example[5] = Bitmap.createBitmap(img_output6.cols(), img_output6.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output6, Mydata.example[5]);

        Mydata.example[6] = Bitmap.createBitmap(img_output7.cols(), img_output7.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output7, Mydata.example[6]);

        Mydata.example[7] = Bitmap.createBitmap(img_output8.cols(), img_output8.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output8, Mydata.example[7]);

        Mydata.example[8] = Bitmap.createBitmap(img_output9.cols(), img_output9.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output9, Mydata.example[8]);

        Mydata.example[9] = Bitmap.createBitmap(img_output10.cols(), img_output10.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output10, Mydata.example[9]);

/*

        Mydata.example[0] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[0]);

        Mydata.example[1] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[1]);

        Mydata.example[2] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[2]);

        Mydata.example[3] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[3]);

        Mydata.example[4] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[4]);

        Mydata.example[5] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[5]);

        Mydata.example[6] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[6]);

        Mydata.example[7] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[7]);

        Mydata.example[8] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[8]);

        Mydata.example[9] = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.example[9]);
*/

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

