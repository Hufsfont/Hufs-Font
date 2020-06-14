package com.example.font_opencv;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.font_opencv.utils.UiHelper;

import org.opencv.android.Utils;
import org.opencv.core.Mat;


public class activity_sub_05 extends AppCompatActivity {

    static {
        System.loadLibrary("opencv_java4");
        System.loadLibrary("native-lib");
    }

    private UiHelper uiHelper = new UiHelper();

    private Mat img_input1;
    private Mat img_input2;
    private Mat img_input3;
    private Mat img_input4;
    private Mat img_input5;
    private Mat img_input6;
    private Mat img_input7;
    private Mat img_input8;
    private Mat img_input9;

    private Mat img_output;

    public native void show_words(long inputImage1, long inputImage2, long inputImage3, long inputImage4, long inputImage5, long inputImage6, long inputImage7, long inputImage8, long inputImage9, long outputImage);

    ImageView imageView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_05);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        ImageButton image_button = findViewById(R.id.imageButton2);
        image_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(activity_sub_05.this, "폰트가 저장되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });

        img_input1 = new Mat();
        img_input2 = new Mat();
        img_input3 = new Mat();
        img_input4 = new Mat();
        img_input5 = new Mat();
        img_input6 = new Mat();
        img_input7 = new Mat();
        img_input8 = new Mat();
        img_input9 = new Mat();

        if (img_output == null)
            //img_output = new Mat(500, 550, CvType.CV_8U, new Scalar(4));
            img_output = new Mat();

        for (int i = 0; i < 9; i++ ) {
            switch (i) {
                case 0:
                    Utils.bitmapToMat(Mydata.maked_letter[i], img_input1);
                case 1:
                    Utils.bitmapToMat(Mydata.maked_letter[i], img_input2);
                case 2:
                    Utils.bitmapToMat(Mydata.maked_letter[i], img_input3);
                case 3:
                    Utils.bitmapToMat(Mydata.maked_letter[i], img_input4);
                case 4:
                    Utils.bitmapToMat(Mydata.maked_letter[i], img_input5);
                case 5:
                    Utils.bitmapToMat(Mydata.maked_letter[i], img_input6);
                case 6:
                    Utils.bitmapToMat(Mydata.maked_letter[i], img_input7);
                case 7:
                    Utils.bitmapToMat(Mydata.maked_letter[i], img_input8);
                case 8:
                    Utils.bitmapToMat(Mydata.maked_letter[i], img_input9);
            }
        }

        if(img_input1 != null && img_input2 != null && img_input3 != null && img_input4 != null && img_input5 != null &&
                img_input6 != null && img_input7 != null && img_input8 != null && img_input9 != null){
            show_words(img_input1.getNativeObjAddr(), img_input2.getNativeObjAddr(), img_input3.getNativeObjAddr(), img_input4.getNativeObjAddr(),
                    img_input5.getNativeObjAddr(), img_input6.getNativeObjAddr(), img_input7.getNativeObjAddr(), img_input8.getNativeObjAddr(),
                    img_input9.getNativeObjAddr(), img_output.getNativeObjAddr());
        }

        Mydata.show_image = Bitmap.createBitmap(img_output.cols(), img_output.rows(), Bitmap.Config.ARGB_8888);
        Utils.matToBitmap(img_output, Mydata.show_image);

        imageView4 = (ImageView) findViewById(R.id.imageView4);

        if(Mydata.show_image != null) {
            imageView4.setImageBitmap(Mydata.show_image);
        }
        else{
            uiHelper.toast(this, "There's no image.");
        }
    }
}

