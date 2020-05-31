package com.example.font_opencv;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.font_opencv.utils.UiHelper;

import java.io.File;

public class activity_sub_02 extends AppCompatActivity {

    /*
    static {
        System.loadLibrary("opencv_java4");
        System.loadLibrary("native-lib");
    }

    public native void opencv(long inputImage, long outputImage);

     */

    ImageView imageView1, imageView2, imageView3;
    private String currentPhotoPath = "";
    private UiHelper uiHelper = new UiHelper();
    //private Mat img_input;
    //private Mat img_output;

    //private static final String TAG = "opencv";

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

        if(Mydata.myletter_element[0][0] != null) {
            File tempFile = new File(Environment.getExternalStorageDirectory() + "/temp.jpg");
            Uri imageUri = Uri.parse(Mydata.myletter_element[0][0]);
            imageView1 = (ImageView) findViewById(R.id.imageView1);
            imageView1.setImageURI(imageUri);

        }
        /*
        if(Mydata.example != null) {
            imageButton_1.setImageBitmap(Mydata.example);
            //uiHelper.toast(this, "error.");
        }
         */


        if(Mydata.myletter_element[0][1] != null) {
            Uri imageUri = Uri.parse(Mydata.myletter_element[0][1]);
            imageView2 = (ImageView) findViewById(R.id.imageView2);
            imageView2.setImageURI(imageUri);
        }

        if(Mydata.myletter_element[0][2] != null) {
            Uri imageUri = Uri.parse(Mydata.myletter_element[0][2]);
            imageView3 = (ImageView) findViewById(R.id.imageView3);
            imageView3.setImageURI(imageUri);
        }



    }
    /*
    private String getRealPathFromURI(Uri contentUri) {

        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        cursor.moveToFirst();
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

        return cursor.getString(column_index);
    }

    // 출처 - http://snowdeer.github.io/android/2016/02/02/android-image-rotation/
    public int getOrientationOfImage(String filepath) {
        ExifInterface exif = null;

        try {
            exif = new ExifInterface(filepath);
        } catch (IOException e) {
            Log.d("@@@", e.toString());
            return -1;
        }

        int orientation = exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, -1);

        if (orientation != -1) {
            switch (orientation) {
                case ExifInterface.ORIENTATION_ROTATE_90:
                    return 90;

                case ExifInterface.ORIENTATION_ROTATE_180:
                    return 180;

                case ExifInterface.ORIENTATION_ROTATE_270:
                    return 270;
            }
        }

        return 0;
    }

    public Bitmap getRotatedBitmap(Bitmap bitmap, int degrees) throws Exception {
        if(bitmap == null) return null;
        if (degrees == 0) return bitmap;

        Matrix m = new Matrix();
        m.setRotate(degrees, (float) bitmap.getWidth() / 2, (float) bitmap.getHeight() / 2);

        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), m, true);
    }

*/

}

