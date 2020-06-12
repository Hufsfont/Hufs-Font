package com.example.font_opencv;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class CropActivity extends AppCompatActivity {


    ImageView compositeImageView;
    boolean crop;
    private String currentPhotoPath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cropview);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            crop = extras.getBoolean("crop");
        }

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);


        int widthOfscreen = 0;
        int heightOfScreen = 0;

        DisplayMetrics dm = new DisplayMetrics();
        try {
            getWindowManager().getDefaultDisplay().getMetrics(dm);
        } catch (Exception ex) {
        }
        widthOfscreen = dm.widthPixels;
        heightOfScreen = dm.heightPixels;

        compositeImageView = (ImageView) findViewById(R.id.imageview);


        Bitmap resultingImage = Bitmap.createBitmap(widthOfscreen, heightOfScreen, bitmap.getConfig());

        Canvas canvas = new Canvas(resultingImage);
        Paint paint = new Paint();
        paint.setAntiAlias(true);

        Path path = new Path();
        for (int i = 0; i < SomeView.points.size(); i++) {
            path.lineTo(SomeView.points.get(i).x, SomeView.points.get(i).y);
        }
        canvas.drawPath(path, paint);
        if (crop) {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));

        } else {
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
        }
        canvas.drawBitmap(bitmap, 0, 0, paint);
        compositeImageView.setImageBitmap(resultingImage);

        SaveImage(resultingImage);

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (Mydata.data_count == 0) {
                    Mydata.myletter_element[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = currentPhotoPath;
                    Mydata.myletter_element_b[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = resultingImage;
                    Intent intent = new Intent(CropActivity.this, activity_sub_02.class);
                    Mydata.data_element_count[Mydata.data_count]++;
                    startActivity(intent);
                }

                if (Mydata.data_count == 1) {
                    Mydata.myletter_element[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = currentPhotoPath;
                    Mydata.myletter_element_b[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = resultingImage;
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_01.class);
                    Mydata.data_element_count[Mydata.data_count]++;
                    startActivity(intent);
                }

                if (Mydata.data_count == 2) {
                    Mydata.myletter_element[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = currentPhotoPath;
                    Mydata.myletter_element_b[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = resultingImage;
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_02.class);
                    Mydata.data_element_count[Mydata.data_count]++;
                    startActivity(intent);
                }

                if (Mydata.data_count == 3) {
                    Mydata.myletter_element[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = currentPhotoPath;
                    Mydata.myletter_element_b[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = resultingImage;
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_03.class);
                    Mydata.data_element_count[Mydata.data_count]++;
                    startActivity(intent);
                }

                if (Mydata.data_count == 4) {
                    Mydata.myletter_element[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = currentPhotoPath;
                    Mydata.myletter_element_b[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = resultingImage;
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_04.class);
                    Mydata.data_element_count[Mydata.data_count]++;
                    startActivity(intent);
                }

                if (Mydata.data_count == 5) {
                    Mydata.myletter_element[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = currentPhotoPath;
                    Mydata.myletter_element_b[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = resultingImage;
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_05.class);
                    Mydata.data_element_count[Mydata.data_count]++;
                    startActivity(intent);
                }

                if (Mydata.data_count == 6) {
                    Mydata.myletter_element[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = currentPhotoPath;
                    Mydata.myletter_element_b[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = resultingImage;
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_06.class);
                    Mydata.data_element_count[Mydata.data_count]++;
                    startActivity(intent);
                }

                if (Mydata.data_count == 7) {
                    Mydata.myletter_element[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = currentPhotoPath;
                    Mydata.myletter_element_b[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = resultingImage;
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_07.class);
                    Mydata.data_element_count[Mydata.data_count]++;
                    startActivity(intent);
                }

                if (Mydata.data_count == 8) {
                    Mydata.myletter_element[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = currentPhotoPath;
                    Mydata.myletter_element_b[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = resultingImage;
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_08.class);
                    Mydata.data_element_count[Mydata.data_count]++;
                    startActivity(intent);
                }

                if (Mydata.data_count == 9) {
                    Mydata.myletter_element[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = currentPhotoPath;
                    Mydata.myletter_element_b[Mydata.data_count][Mydata.data_element_count[Mydata.data_count]] = resultingImage;
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_09.class);
                    Mydata.data_element_count[Mydata.data_count]++;
                    startActivity(intent);
                }
            }
        });

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                if (Mydata.data_count == 0) {
                    Intent intent = new Intent(CropActivity.this, activity_sub_02.class);
                    startActivity(intent);
                }

                if (Mydata.data_count == 1) {
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_01.class);
                    startActivity(intent);
                }

                if (Mydata.data_count == 2) {
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_02.class);
                    startActivity(intent);
                }

                if (Mydata.data_count == 3) {
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_03.class);
                    startActivity(intent);
                }

                if (Mydata.data_count == 4) {
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_04.class);
                    startActivity(intent);
                }

                if (Mydata.data_count == 5) {
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_05.class);
                    startActivity(intent);
                }

                if (Mydata.data_count == 6) {
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_06.class);
                    startActivity(intent);
                }

                if (Mydata.data_count == 7) {
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_07.class);
                    startActivity(intent);
                }

                if (Mydata.data_count == 8) {
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_08.class);
                    startActivity(intent);
                }

                if (Mydata.data_count == 9) {
                    Intent intent = new Intent(CropActivity.this, activity_sub_02_09.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void SaveImage(Bitmap finalBitmap) {
        String imageFileName = "JPEG_" + System.currentTimeMillis() + "_";
        File storageDir = new File(
                Environment.getExternalStoragePublicDirectory(
                        Environment.DIRECTORY_DCIM
                ), "Camera"
        );
        File file = new File (storageDir, imageFileName);
        if (file.exists ()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        currentPhotoPath = "file:" + file.getAbsolutePath();

    }



}