package com.example.font_opencv;

import android.app.Application;
import android.graphics.Bitmap;


public class Mydata extends Application {

    static int data_count = 0;
    static int[] data_element_count = {0,0,0,0,0,0,0,0,0,0};
    static String sentence_img = new String(); // 사용자가 자른 네모박스 문장 전체 이미지 주소가 저장된 변수
    static String[] myletter = new String[10];
    static int[] myletter_element_count = {3,2,2,2,2,3,3,3,2,2};
    static String[][] myletter_element = new String[10][3]; // 각 자모음 크롭 이미지 주소가 저장된 변수
    static Bitmap sentence_bitmap; // 문장 비트맵 저장.
    static Bitmap[] example = new Bitmap[10];

}
