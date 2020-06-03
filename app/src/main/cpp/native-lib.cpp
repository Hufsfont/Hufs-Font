#include <jni.h>

#include "opencv2/imgproc/imgproc.hpp"
#include "opencv2/imgcodecs.hpp"
#include "opencv2/highgui/highgui.hpp"
#include <iostream>
#include <opencv2/core/core.hpp>
#include<string>

using namespace cv;
using namespace std;

extern "C"
JNIEXPORT void JNICALL
Java_com_example_font_1opencv_activity_1sub_102_opencv_102(JNIEnv *env, jobject thiz,
                                                           jlong input_image, jlong output_image1,
                                                           jlong output_image2, jlong output_image3,
                                                           jlong output_image4, jlong output_image5,
                                                           jlong output_image6, jlong output_image7,
                                                           jlong output_image8, jlong output_image9,
                                                           jlong output_image10) {
    //이미지 파일을 불러와 그레이 이미지로 변환한다.
    Mat &input_origin_image = *(Mat *) input_image;
    //Mat &result_binary_image = *(Mat *) output_image;
    Mat result_binary_image;
    //Mat other_roi[10];

    Mat &roi1 = *(Mat *)output_image1;
    Mat &roi2 = *(Mat *)output_image2;
    Mat &roi3 = *(Mat *)output_image3;
    Mat &roi4 = *(Mat *)output_image4;
    Mat &roi5 = *(Mat *)output_image5;
    Mat &roi6 = *(Mat *)output_image6;
    Mat &roi7 = *(Mat *)output_image7;
    Mat &roi8 = *(Mat *)output_image8;
    Mat &roi9 = *(Mat *)output_image9;
    Mat &roi10 = *(Mat *)output_image10;
/*
    Mat *roi1 = (Mat *)output_image1;
    Mat *roi2 = (Mat *)output_image2;
    Mat *roi3 = (Mat *)output_image3;
    Mat *roi4 = (Mat *)output_image4;
    Mat *roi5 = (Mat *)output_image5;
    Mat *roi6 = (Mat *)output_image6;
    Mat *roi7 = (Mat *)output_image7;
    Mat *roi8 = (Mat *)output_image8;
    Mat *roi9 = (Mat *)output_image9;
    Mat *roi10 = (Mat *)output_image10;

    roi[0] = *(Mat *)output_image1;
    roi[1] = *(Mat *)output_image2;
    roi[2] = *(Mat *)output_image3;
    roi[3] = *(Mat *)output_image4;
    roi[4] = *(Mat *)output_image5;
    roi[5] = *(Mat *)output_image6;
    roi[6] = *(Mat *)output_image7;
    roi[7] = *(Mat *)output_image8;
    roi[8] = *(Mat *)output_image9;
    roi[9] = *(Mat *)output_image10;

    roi[0] = (Mat *)output_image1;
    roi[1] = (Mat *)output_image2;
    roi[2] = (Mat *)output_image3;
    roi[3] = (Mat *)output_image4;
    roi[4] = (Mat *)output_image5;
    roi[5] = (Mat *)output_image6;
    roi[6] = (Mat *)output_image7;
    roi[7] = (Mat *)output_image8;
    roi[8] = (Mat *)output_image9;
    roi[9] = (Mat *)output_image10;
*/

    Mat input_gray_image;
    Mat kernel(3, 3, CV_8U, cv::Scalar(1));

    //이미지 사이즈 조절
    resize(input_origin_image, input_origin_image, Size(500, 200), 0, 0);

    //원본 이미지를 그레이스케일 이미지로 변환
    cvtColor(input_origin_image, input_gray_image, COLOR_RGBA2GRAY);


    //이진화
    Mat mask = cv::getStructuringElement(cv::MORPH_RECT, cv::Size(3, 3), cv::Point(1, 1)); //delite연산 kernal 크기
    //이미지를 부드럽게 만듦 (입력이미지,출력이미지,...)
    GaussianBlur(input_gray_image, input_gray_image, cv::Point(5, 5), 0);
    //이미지를 이진화 (입력이미지,출력이미지,...)
    adaptiveThreshold(input_gray_image, result_binary_image, 255, ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 17, 3);
    //이미지 잡음 제거 (입력이미지,출력이미지...)
    morphologyEx(result_binary_image, result_binary_image, cv::MORPH_CLOSE, kernel); //close
    //색 반전: deliate연산을 위해
    bitwise_not(result_binary_image, result_binary_image);
    //팽창 연산, 이미지의 하얀부분을 팽창시킨다 (입력이미지, 출력이미지,...,반복횟수)
    dilate(result_binary_image, result_binary_image, mask, cv::Point(-1, -1), 3);

    int cnt = 0; //이미지 저장 이름 구별을 위한 변수

    //이진화 이미지에서 외곽선 찾기
    std::vector<vector<Point>> contours;
    std::vector<Vec4i> hierarchy;

    findContours(result_binary_image, contours, hierarchy, RETR_TREE, CHAIN_APPROX_SIMPLE, Point(0, 0));

    //외곽선에 맞춰 사각형 그리기
    if (contours.size() > 0) {
        for (int idx = 0; idx < contours.size(); idx++) {
            Rect rect = boundingRect(contours[idx]);
            //너무 작거나 너무 큰 사각형은 제외
            if (rect.width < 50 && rect.height >100 && rect.height * rect.width > 2000) {
                rectangle(input_origin_image, Point(rect.x, rect.y), Point(rect.x + rect.width, rect.y + rect.height), Scalar(0, 255, 0), 3);
                switch(cnt)
                {
                    case 0:
                        roi1 = input_origin_image(rect); //CROP
                        break;
                    case 1:
                        roi2 = input_origin_image(rect); //CROP
                        break;
                    case 2:
                        roi3 = input_origin_image(rect); //CROP
                        break;
                    case 3:
                        roi4 = input_origin_image(rect); //CROP
                        break;
                    case 4:
                        roi5 = input_origin_image(rect); //CROP
                        break;
                    case 5:
                        roi6 = input_origin_image(rect); //CROP
                        break;
                    case 6:
                        roi7 = input_origin_image(rect); //CROP
                        break;
                    case 7:
                        roi8 = input_origin_image(rect); //CROP
                        break;
                    case 8:
                        roi9 = input_origin_image(rect); //CROP
                        break;
                    case 9:
                        roi10 = input_origin_image(rect); //CROP
                        break;
                    default:
                        //other_roi[cnt] = input_origin_image(rect);
                        break;
                }
                cnt++;
            }
        }
    }

}

/*
extern "C"
JNIEXPORT void JNICALL
Java_com_example_font_1opencv_activity_1sub_103_opencv(JNIEnv *env, jobject thiz, jlong mat_addr_input,
        jlong mat_addr_result) {

    //이미지 파일을 불러와 그레이 이미지로 변환한다.
    Mat &input_origin_image = *(Mat *) mat_addr_input;
    Mat result_binary_image;
    Mat &roi = *(Mat *) mat_addr_result;
    Mat input_gray_image;
    Mat kernel(3, 3, CV_8U, cv::Scalar(1));

    //이미지 사이즈 조절
    resize(input_origin_image, input_origin_image, Size(500, 200), 0, 0);

    //원본 이미지를 그레이스케일 이미지로 변환
    cvtColor(input_origin_image, input_gray_image, COLOR_RGBA2GRAY);


    //이진화
    Mat mask = cv::getStructuringElement(cv::MORPH_RECT, cv::Size(3, 3), cv::Point(1, 1)); //delite연산 kernal 크기
    //이미지를 부드럽게 만듦 (입력이미지,출력이미지,...)
    GaussianBlur(input_gray_image, input_gray_image, cv::Point(5, 5), 0);
    //이미지를 이진화 (입력이미지,출력이미지,...)
    adaptiveThreshold(input_gray_image, result_binary_image, 255, ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 17, 3);
    //이미지 잡음 제거 (입력이미지,출력이미지...)
    morphologyEx(result_binary_image, result_binary_image, cv::MORPH_CLOSE, kernel); //close
    //색 반전: deliate연산을 위해
    bitwise_not(result_binary_image, result_binary_image);
    //팽창 연산, 이미지의 하얀부분을 팽창시킨다 (입력이미지, 출력이미지,...,반복횟수)
    dilate(result_binary_image, result_binary_image, mask, cv::Point(-1, -1), 3);


    int cnt = 0; //이미지 저장 이름 구별을 위한 변수

    //이진화 이미지에서 외곽선 찾기
    std::vector<vector<Point>> contours;
    std::vector<Vec4i> hierarchy;

    findContours(result_binary_image, contours, hierarchy, RETR_TREE, CHAIN_APPROX_SIMPLE, Point(0, 0));

    //외곽선에 맞춰 사각형 그리기
    if (contours.size() > 0) {
        for (int idx = 0; idx < contours.size(); idx++) {
            Rect rect = boundingRect(contours[idx]);
            //너무 작거나 너무 큰 사각형은 제외
            if (rect.width < 50 && rect.height >100 && rect.height * rect.width > 2000) {
                rectangle(input_origin_image, Point(rect.x, rect.y), Point(rect.x + rect.width, rect.y + rect.height), Scalar(0, 255, 0), 3);
                roi = input_origin_image(rect); //CROP
                //cnt++;
            }
        }
    }

}*/

/*extern "C"
JNIEXPORT void JNICALL
Java_com_example_font_1opencv_activity_1sub_102_opencv_102_1test(JNIEnv *env, jobject thiz,
                                                                 jlong input_image,
                                                                 jlong output_image) {
    Mat &input_origin_image = *(Mat *) input_image;
    Mat result_binary_image;
    Mat &roi = *(Mat *)output_image;

    Mat input_gray_image;
    Mat kernel(3, 3, CV_8U, cv::Scalar(1));

    //이미지 사이즈 조절
    resize(input_origin_image, input_origin_image, Size(500, 200), 0, 0);

    //원본 이미지를 그레이스케일 이미지로 변환
    cvtColor(input_origin_image, input_gray_image, COLOR_RGBA2GRAY);


    //이진화
    Mat mask = cv::getStructuringElement(cv::MORPH_RECT, cv::Size(3, 3), cv::Point(1, 1)); //delite연산 kernal 크기
    //이미지를 부드럽게 만듦 (입력이미지,출력이미지,...)
    GaussianBlur(input_gray_image, input_gray_image, cv::Point(5, 5), 0);
    //이미지를 이진화 (입력이미지,출력이미지,...)
    adaptiveThreshold(input_gray_image, result_binary_image, 255, ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 17, 3);
    //이미지 잡음 제거 (입력이미지,출력이미지...)
    morphologyEx(result_binary_image, result_binary_image, cv::MORPH_CLOSE, kernel); //close
    //색 반전: deliate연산을 위해
    bitwise_not(result_binary_image, result_binary_image);
    //팽창 연산, 이미지의 하얀부분을 팽창시킨다 (입력이미지, 출력이미지,...,반복횟수)
    dilate(result_binary_image, result_binary_image, mask, cv::Point(-1, -1), 3);

    int cnt = 0; //이미지 저장 이름 구별을 위한 변수

    //이진화 이미지에서 외곽선 찾기
    std::vector<vector<Point>> contours;
    std::vector<Vec4i> hierarchy;

    findContours(result_binary_image, contours, hierarchy, RETR_TREE, CHAIN_APPROX_SIMPLE, Point(0, 0));

    //외곽선에 맞춰 사각형 그리기
    if (contours.size() > 0) {
        for (int idx = 0; idx < contours.size(); idx++) {
            Rect rect = boundingRect(contours[idx]);
            //너무 작거나 너무 큰 사각형은 제외
            if (rect.width < 50 && rect.height >100 && rect.height * rect.width > 2000) {
                rectangle(input_origin_image, Point(rect.x, rect.y), Point(rect.x + rect.width, rect.y + rect.height), Scalar(0, 255, 0), 3);
                roi = input_origin_image(rect); //CROP
            }
        }
    }

}*/

/*
extern "C"
JNIEXPORT jobject JNICALL
Java_com_example_font_1opencv_activity_1sub_102_opencv_102_1arraylist(JNIEnv *env, jclass clazz,
                                                                      jlong input_image){
    jclass clsArrayList = env->FindClass("java/util/ArrayList");
    jmethodID mCtor = env->GetMethodID(clsArrayList, "<init>", "()V");
    jmethodID mAdd = env->GetMethodID(clsArrayList, "add", "(ILjava/lang/Object;)V");
    jobject resultArray = env->NewObject(clsArrayList, mCtor);

    Mat &input_origin_image = *(Mat *) input_image;
    Mat result_binary_image;
    Mat input_gray_image;
    Mat kernel(3, 3, CV_8U, cv::Scalar(1));

    //이미지 사이즈 조절
    resize(input_origin_image, input_origin_image, Size(500, 200), 0, 0);

    //원본 이미지를 그레이스케일 이미지로 변환
    cvtColor(input_origin_image, input_gray_image, COLOR_RGBA2GRAY);


    //이진화
    Mat mask = cv::getStructuringElement(cv::MORPH_RECT, cv::Size(3, 3), cv::Point(1, 1)); //delite연산 kernal 크기
    //이미지를 부드럽게 만듦 (입력이미지,출력이미지,...)
    GaussianBlur(input_gray_image, input_gray_image, cv::Point(5, 5), 0);
    //이미지를 이진화 (입력이미지,출력이미지,...)
    adaptiveThreshold(input_gray_image, result_binary_image, 255, ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 17, 3);
    //이미지 잡음 제거 (입력이미지,출력이미지...)
    morphologyEx(result_binary_image, result_binary_image, cv::MORPH_CLOSE, kernel); //close
    //색 반전: deliate연산을 위해
    bitwise_not(result_binary_image, result_binary_image);
    //팽창 연산, 이미지의 하얀부분을 팽창시킨다 (입력이미지, 출력이미지,...,반복횟수)
    dilate(result_binary_image, result_binary_image, mask, cv::Point(-1, -1), 3);

    int cnt = 0; //이미지 저장 이름 구별을 위한 변수

    //이진화 이미지에서 외곽선 찾기
    std::vector<vector<Point>> contours;
    std::vector<Vec4i> hierarchy;

    findContours(result_binary_image, contours, hierarchy, RETR_TREE, CHAIN_APPROX_SIMPLE, Point(0, 0));

    //외곽선에 맞춰 사각형 그리기
    if (contours.size() > 0) {
        for (int idx = 0; idx < contours.size(); idx++) {
            Rect rect = boundingRect(contours[idx]);
            //너무 작거나 너무 큰 사각형은 제외
            if (rect.width < 50 && rect.height >100 && rect.height * rect.width > 2000) {
                rectangle(input_origin_image, Point(rect.x, rect.y), Point(rect.x + rect.width, rect.y + rect.height), Scalar(0, 255, 0), 3);
                Mat roi = input_origin_image(rect); //CROP
                env->CallVoidMethodV(resultArray, mAdd, roi);
            }
        }
    }
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_font_1opencv_activity_1sub_102_opencv_102_1array(JNIEnv *env, jobject thiz,
                                                                  jlong input_image,
                                                                  jobjectArray output_image) {
    Mat &input_origin_image = *(Mat *) input_image;
    Mat result_binary_image;
    Mat roi[50];
    roi = output_image;
    Mat input_gray_image;
    Mat kernel(3, 3, CV_8U, cv::Scalar(1));

    //이미지 사이즈 조절
    resize(input_origin_image, input_origin_image, Size(500, 200), 0, 0);

    //원본 이미지를 그레이스케일 이미지로 변환
    cvtColor(input_origin_image, input_gray_image, COLOR_RGBA2GRAY);


    //이진화
    Mat mask = cv::getStructuringElement(cv::MORPH_RECT, cv::Size(3, 3), cv::Point(1, 1)); //delite연산 kernal 크기
    //이미지를 부드럽게 만듦 (입력이미지,출력이미지,...)
    GaussianBlur(input_gray_image, input_gray_image, cv::Point(5, 5), 0);
    //이미지를 이진화 (입력이미지,출력이미지,...)
    adaptiveThreshold(input_gray_image, result_binary_image, 255, ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 17, 3);
    //이미지 잡음 제거 (입력이미지,출력이미지...)
    morphologyEx(result_binary_image, result_binary_image, cv::MORPH_CLOSE, kernel); //close
    //색 반전: deliate연산을 위해
    bitwise_not(result_binary_image, result_binary_image);
    //팽창 연산, 이미지의 하얀부분을 팽창시킨다 (입력이미지, 출력이미지,...,반복횟수)
    dilate(result_binary_image, result_binary_image, mask, cv::Point(-1, -1), 3);


    int cnt = 0; //이미지 저장 이름 구별을 위한 변수

    //이진화 이미지에서 외곽선 찾기
    std::vector<vector<Point>> contours;
    std::vector<Vec4i> hierarchy;

    findContours(result_binary_image, contours, hierarchy, RETR_TREE, CHAIN_APPROX_SIMPLE, Point(0, 0));

    //외곽선에 맞춰 사각형 그리기
    if (contours.size() > 0) {
        for (int idx = 0; idx < contours.size(); idx++) {
            Rect rect = boundingRect(contours[idx]);
            //너무 작거나 너무 큰 사각형은 제외
            if (rect.width < 50 && rect.height >100 && rect.height * rect.width > 2000) {
                rectangle(input_origin_image, Point(rect.x, rect.y), Point(rect.x + rect.width, rect.y + rect.height), Scalar(0, 255, 0), 3);
                roi = input_origin_image(rect); //CROP
                //cnt++;
            }
        }
    }
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_font_1opencv_activity_1sub_102_opencv_102_1for2(JNIEnv *env, jobject thiz,
                                                                 jlong input_image,
                                                                 jlong output_image1,
                                                                 jlong output_image2) {
    Mat &input_origin_image = *(Mat *) input_image;
    Mat result_binary_image;

    Mat roi1 = *(Mat *) output_image1;
    Mat roi2 = *(Mat *) output_image2;

    Mat input_gray_image;
    Mat kernel(3, 3, CV_8U, cv::Scalar(1));

    //이미지 사이즈 조절
    resize(input_origin_image, input_origin_image, Size(500, 200), 0, 0);

    //원본 이미지를 그레이스케일 이미지로 변환
    cvtColor(input_origin_image, input_gray_image, COLOR_RGBA2GRAY);


    //이진화
    Mat mask = cv::getStructuringElement(cv::MORPH_RECT, cv::Size(3, 3),
                                         cv::Point(1, 1)); //delite연산 kernal 크기
    //이미지를 부드럽게 만듦 (입력이미지,출력이미지,...)
    GaussianBlur(input_gray_image, input_gray_image, cv::Point(5, 5), 0);
    //이미지를 이진화 (입력이미지,출력이미지,...)
    adaptiveThreshold(input_gray_image, result_binary_image, 255, ADAPTIVE_THRESH_MEAN_C,
                      THRESH_BINARY, 17, 3);
    //이미지 잡음 제거 (입력이미지,출력이미지...)
    morphologyEx(result_binary_image, result_binary_image, cv::MORPH_CLOSE, kernel); //close
    //색 반전: deliate연산을 위해
    bitwise_not(result_binary_image, result_binary_image);
    //팽창 연산, 이미지의 하얀부분을 팽창시킨다 (입력이미지, 출력이미지,...,반복횟수)
    dilate(result_binary_image, result_binary_image, mask, cv::Point(-1, -1), 3);

    int cnt = 0; //이미지 저장 이름 구별을 위한 변수

    //이진화 이미지에서 외곽선 찾기
    std::vector<vector<Point>> contours;
    std::vector<Vec4i> hierarchy;

    findContours(result_binary_image, contours, hierarchy, RETR_TREE, CHAIN_APPROX_SIMPLE,
                 Point(0, 0));

    //외곽선에 맞춰 사각형 그리기
    if (contours.size() > 0) {
        for (int idx = 0; idx < contours.size(); idx++) {
            Rect rect = boundingRect(contours[idx]);
            //너무 작거나 너무 큰 사각형은 제외
            if (rect.width < 50 && rect.height > 100 && rect.height * rect.width > 2000) {
                rectangle(input_origin_image, Point(rect.x, rect.y),
                          Point(rect.x + rect.width, rect.y + rect.height), Scalar(0, 255, 0), 3);
                if (cnt == 0) {
                    roi1 = input_origin_image(rect); //CROP
                    cnt++;
                } else if (cnt == 1) {
                    roi2 = input_origin_image(rect); //CROP
                }
            }
        }
    }
}*/