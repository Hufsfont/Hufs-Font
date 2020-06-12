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
    static Bitmap[] consonant = new Bitmap[14];
    static Bitmap[] vowel = new Bitmap[9];
    static Bitmap[][] myletter_element_b = new Bitmap[10][3];
    static Bitmap[] maked_letter = new Bitmap[9];

    static void match(){

        consonant[0] = myletter_element_b[0][0].copy(myletter_element_b[0][0].getConfig(), true); //ㄱ :
        consonant[1] = myletter_element_b[5][2].copy(myletter_element_b[5][2].getConfig(), true); //ㄴ :
        consonant[2] = myletter_element_b[4][0].copy(myletter_element_b[4][0].getConfig(), true); //ㄷ :
        consonant[3] = myletter_element_b[9][0].copy(myletter_element_b[9][0].getConfig(), true); //ㄹ :
        consonant[4] = myletter_element_b[6][0].copy(myletter_element_b[6][0].getConfig(), true); //ㅁ :
        consonant[5] = myletter_element_b[3][0].copy(myletter_element_b[3][0].getConfig(), true); //ㅂ :
        consonant[6] = myletter_element_b[8][0].copy(myletter_element_b[8][0].getConfig(), true); //ㅅ :
        consonant[7] = myletter_element_b[7][2].copy(myletter_element_b[7][2].getConfig(), true); //ㅇ :
        consonant[8] = myletter_element_b[2][0].copy(myletter_element_b[2][0].getConfig(), true); //ㅈ :
        consonant[9] = myletter_element_b[6][2].copy(myletter_element_b[6][2].getConfig(), true); //ㅊ :
        consonant[10] = myletter_element_b[5][0].copy(myletter_element_b[5][0].getConfig(), true); //ㅋ :
        consonant[11] = myletter_element_b[0][2].copy(myletter_element_b[0][2].getConfig(), true); //ㅌ :
        consonant[12] = myletter_element_b[1][0].copy(myletter_element_b[1][0].getConfig(), true); //ㅍ :
        consonant[13] = myletter_element_b[7][0].copy(myletter_element_b[7][0].getConfig(), true); //ㅎ :

        vowel[0] = myletter_element_b[4][1].copy(myletter_element_b[4][1].getConfig(), true); //ㅏ :
        vowel[1] = myletter_element_b[7][1].copy(myletter_element_b[7][1].getConfig(), true); //ㅑ :
        vowel[2] = myletter_element_b[0][1].copy(myletter_element_b[0][1].getConfig(), true); //ㅓ :
        vowel[3] = myletter_element_b[6][1].copy(myletter_element_b[6][1].getConfig(), true); //ㅕ :
        vowel[4] = myletter_element_b[3][1].copy(myletter_element_b[3][1].getConfig(), true); //ㅗ :
        vowel[5] = myletter_element_b[1][1].copy(myletter_element_b[1][1].getConfig(), true); //ㅛ :
        vowel[6] = myletter_element_b[8][1].copy(myletter_element_b[8][1].getConfig(), true); //ㅜ :
        vowel[7] = myletter_element_b[9][1].copy(myletter_element_b[9][1].getConfig(), true); //ㅠ :
        vowel[9] = myletter_element_b[2][1].copy(myletter_element_b[2][1].getConfig(), true); //ㅣ :
        vowel[8] = myletter_element_b[5][1].copy(myletter_element_b[5][1].getConfig(), true); //ㅡ :

    }

}
