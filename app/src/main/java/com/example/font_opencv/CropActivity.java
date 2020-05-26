package com.example.font_opencv;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;

public class CropActivity extends AppCompatActivity {

    ImageView compositeImageView;
    boolean crop;
    int count = 0;
    private String currentPhotoPath = "";
    File sendimage;

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

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CropActivity.this, activity_sub_02.class);
                Uri uri = Uri.parse(currentPhotoPath);
                intent.putExtra("image", currentPhotoPath);
                Toast.makeText(getApplicationContext(),currentPhotoPath, Toast.LENGTH_LONG).show();
                startActivity(intent);
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
