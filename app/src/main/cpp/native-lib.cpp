#include <jni.h>

#include "opencv2/imgproc/imgproc.hpp"
#include "opencv2/imgcodecs.hpp"
#include "opencv2/highgui/highgui.hpp"
#include <iostream>
#include <opencv2/core/core.hpp>
#include <string>

using namespace cv;
using namespace std;

extern "C"
JNIEXPORT void JNICALL
Java_com_example_font_1opencv_activity_1sub_101_opencv_101(JNIEnv *env, jobject thiz,
                                                           jlong input_image, jlong output_image1,
                                                           jlong output_image2, jlong output_image3,
                                                           jlong output_image4, jlong output_image5,
                                                           jlong output_image6, jlong output_image7,
                                                           jlong output_image8, jlong output_image9,
                                                           jlong output_image10) {
    Mat &input_origin_image = *(Mat *) input_image;
    Mat gray_image;
    Mat binary_image;
    Mat result_binary_image;
    Mat kernel(3, 3, CV_8U, cv::Scalar(1));

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

    //이미지 사이즈 조절
    resize(input_origin_image, input_origin_image, Size(10000, 500), INTER_AREA);

    //원본 이미지를 그레이스케일 이미지로 변환
    cvtColor(input_origin_image, gray_image, COLOR_RGBA2GRAY);


    //이진화
    Mat mask = cv::getStructuringElement(cv::MORPH_RECT, cv::Size(7, 7), cv::Point(1, 1)); //delite연산 kernal 크기
    //이미지를 이진화 (입력이미지,출력이미지,...)
    adaptiveThreshold(gray_image, binary_image, 255, ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 27, 7);
    //이미지 잡음 제거 (입력이미지,출력이미지...)
    morphologyEx(binary_image, binary_image, cv::MORPH_CLOSE, kernel); //close
    //색 반전: deliate연산을 위해
    bitwise_not(binary_image, binary_image);
    //팽창 연산, 이미지의 하얀부분을 팽창시킨다 (입력이미지, 출력이미지,...,반복횟수)
    dilate(binary_image, result_binary_image, mask, cv::Point(-1, -1), 5);

    //이진화 이미지에서 외곽선 찾기
    std::vector<vector<Point>> contours;
    std::vector<Vec4i> hierarchy;

    findContours(result_binary_image, contours, hierarchy, RETR_CCOMP, CHAIN_APPROX_SIMPLE, Point(0, 0));

    Rect roiRect[10];//알맞은 사각형 배열

    //외곽선에 맞춰 사각형 찾기
    if (contours.size() > 0) {
        int hier;
        for (int idx = 0; idx < contours.size(); idx++) {
            Rect rect = boundingRect(contours[idx]);
            if (rect.width > (input_origin_image.size().width/2)) {
                hier = idx;
            }
        } //완료
        for (int i = 0, j = 0; i < contours.size(); i++) {
            if (hierarchy[i][3] == hier) {
                roiRect[j] = boundingRect(contours[i]);
                j++;
            }
        }
    }

    //순서대로 정렬
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10 - i - 1; j++) {
            if (roiRect[j].x > roiRect[j+1].x) {
                Rect bff = roiRect[j];
                roiRect[j] = roiRect[j + 1];
                roiRect[j + 1] = bff;
            }
        }
    }

    //저장
    for (int i = 0; i < 10; i++) {
        switch(i) {
            case 0:
                roi1 = binary_image(roiRect[i]); //CROP
                resize(roi1, roi1, Size(1000, 1000), INTER_LINEAR);
                break;
            case 1:
                roi2 = binary_image(roiRect[i]); //CROP
                resize(roi2, roi2, Size(1000, 1000), INTER_LINEAR);
                break;
            case 2:
                roi3 = binary_image(roiRect[i]); //CROP
                resize(roi3, roi3, Size(1000, 1000), INTER_LINEAR);
                break;
            case 3:
                roi4 = binary_image(roiRect[i]); //CROP
                resize(roi4, roi4, Size(1000, 1000), INTER_LINEAR);
                break;
            case 4:
                roi5 = binary_image(roiRect[i]); //CROP
                resize(roi5, roi5, Size(1000, 1000), INTER_LINEAR);
                break;
            case 5:
                roi6 = binary_image(roiRect[i]); //CROP
                resize(roi6, roi6, Size(1000, 1000), INTER_LINEAR);
                break;
            case 6:
                roi7 = binary_image(roiRect[i]); //CROP
                resize(roi7, roi7, Size(1000, 1000), INTER_LINEAR);
                break;
            case 7:
                roi8 = binary_image(roiRect[i]); //CROP
                resize(roi8, roi8, Size(1000, 1000), INTER_LINEAR);
                break;
            case 8:
                roi9 = binary_image(roiRect[i]); //CROP
                resize(roi9, roi9, Size(1000, 1000), INTER_LINEAR);
                break;
            case 9:
                roi10 = binary_image(roiRect[i]); //CROP
                resize(roi10, roi10, Size(1000, 1000), INTER_LINEAR);
                break;
            default:
                //other_roi[cnt] = input_origin_image(rect);
                break;
        }

    }
}

extern "C"
JNIEXPORT void JNICALL
Java_com_example_font_1opencv_activity_1sub_103_make_1words(JNIEnv *env, jobject thiz,
                                                            jlong input_image1, jlong input_image2,
                                                            jlong input_image3,
                                                            jlong output_image) {
/*
    Mat &first = *(Mat *) input_image1;
    Mat &medi = *(Mat *) input_image2;
    Mat &final = *(Mat *) input_image3;
    Mat &dst = *(Mat *) output_image;

    //*(Mat *) output_image = dst; //세로로 이미지 붙인 결과
    dst = cv::Mat::zeros(Size(500, 550), CV_8U);

    cvtColor(dst, dst, COLOR_GRAY2RGB);
    //색반전
    dst = ~dst;

    resize(first, first, Size(300, 300), INTER_AREA);
    resize(medi, medi, Size(300, 300), INTER_AREA);
    resize(final, final, Size(300, 200), INTER_AREA);

    threshold(first, first, 170, 255, THRESH_BINARY_INV);
    threshold(medi, medi, 170, 255, THRESH_BINARY_INV);
    threshold(final, final, 170, 255, THRESH_BINARY_INV);

    std::vector<vector<Point>> contours;
    std::vector<Vec4i> hierarchy;
    //초성
    findContours(first, contours, hierarchy, RETR_EXTERNAL, CHAIN_APPROX_SIMPLE, Point(0, 0));
    for (int i = 0; i< contours.size(); i++)
    {
        Scalar color = Scalar(0, 0, 0);
        drawContours(dst, contours, i, color, 2, 8, hierarchy, 0, Point(0, 0));
    }
    cv::fillPoly(dst, contours, cv::Scalar(0, 0, 0));

    //중성
    findContours(medi, contours, hierarchy, RETR_EXTERNAL, CHAIN_APPROX_SIMPLE, Point(0, 0));
    for (int i = 0; i< contours.size(); i++)
    {
        Scalar color = Scalar(0, 0, 0);
        drawContours(dst, contours, i, color, 2, 8, hierarchy, 0, Point(200, 0));
    }
    cv::fillPoly(dst, contours, cv::Scalar(0, 0, 0), cv::LINE_8, 0, Point(200, 0));

    //종성
    findContours(final, contours, hierarchy, RETR_EXTERNAL, CHAIN_APPROX_SIMPLE, Point(0, 0));
    for (int i = 0; i< contours.size(); i++)
    {
        Scalar color = Scalar(0, 0, 0);
        drawContours(dst, contours, i, color, 2, 8, hierarchy, 0, Point(100,300));
    }
    cv::fillPoly(dst, contours, cv::Scalar(0, 0, 0), cv::LINE_8, 0, Point(100, 300));
*/

    Mat &first = *(Mat *) input_image1;
    Mat &medi = *(Mat *) input_image2;
    Mat &final = *(Mat *) input_image3;
    Mat dst; //가로로 이미지 붙인 결과
    Mat &dst_1 = *(Mat *) output_image; //세로로 이미지 붙인 결과

    resize(first, first, Size(300, 300), INTER_AREA);
    resize(medi, medi, Size(200, 300), INTER_AREA);
    resize(final, final, Size(500, 300), INTER_AREA);

    hconcat(first, medi, dst); //가로로 이미지 붙이기
    vconcat(dst, final, dst_1); //세로로 이미지 붙이기

    //이진화해서 글자만 추출하기
    //열거상수 THRESH_BINARY_INV

    threshold(dst_1, dst_1, 170, 255, THRESH_BINARY_INV);

    //색반전
    dst_1 = ~dst_1;

    resize(dst_1, dst_1, Size(500, 500), INTER_AREA);


}

/*
extern "C"
JNIEXPORT void JNICALL
Java_com_example_font_1opencv_activity_1sub_101_cv_1test(JNIEnv *env, jobject thiz,
                                                         jlong input_image,
                                                         jlong output_image){
    Mat &input_origin_image = *(Mat *) input_image;
    Mat result_binary_image;
    Mat input_gray_image;
    Mat kernel(3, 3, CV_8U, cv::Scalar(1));

    // output_image 배열의 사이즈 가져오기
    //jsize len = env->GetArrayLength(output_image);
    //Mat roi[len]; // output_image 배열과 동일한 크기의 Mat 배열 생성
    //Mat *roi = reinterpret_cast<Mat *>(env->GetLongArrayElements(output_image, NULL));
    // output_image 배열 값(주소)을  add_roi 배열에 저장
    //jlong *add_java = env->GetLongArrayElements(output_image, NULL);
    // roi 배열의 주소를 add_roi 배열의 값들로 바꿔야 함
    // roi 배열 첫 번째 요소의 메모리 주소를 포인터에 저장
    //Mat *add_roi = roi;
    //add_roi = reinterpret_cast<Mat *>(add_java);

    Mat roi[10];
    roi = *(Mat *)output_image;





    //이미지 사이즈 조절
    resize(input_origin_image, input_origin_image, Size(10000, 500), INTER_AREA);

    //원본 이미지를 그레이스케일 이미지로 변환
    cvtColor(input_origin_image, input_gray_image, COLOR_RGBA2GRAY);


    //이진화
    Mat mask = cv::getStructuringElement(cv::MORPH_RECT, cv::Size(7, 7), cv::Point(1, 1)); //delite연산 kernal 크기
    //이미지를 이진화 (입력이미지,출력이미지,...)
    adaptiveThreshold(input_gray_image, result_binary_image, 255, ADAPTIVE_THRESH_MEAN_C, THRESH_BINARY, 27, 7);
    //이미지 잡음 제거 (입력이미지,출력이미지...)
    morphologyEx(result_binary_image, result_binary_image, cv::MORPH_CLOSE, kernel); //close
    //색 반전: deliate연산을 위해
    bitwise_not(result_binary_image, result_binary_image);
    //팽창 연산, 이미지의 하얀부분을 팽창시킨다 (입력이미지, 출력이미지,...,반복횟수)
    dilate(result_binary_image, result_binary_image, mask, cv::Point(-1, -1), 5);

    //이진화 이미지에서 외곽선 찾기
    std::vector<vector<Point>> contours;
    std::vector<Vec4i> hierarchy;

    findContours(result_binary_image, contours, hierarchy, RETR_CCOMP, CHAIN_APPROX_SIMPLE, Point(0, 0));

    Rect roiRect[10];//알맞은 사각형 배열

    //외곽선에 맞춰 사각형 찾기
    if (contours.size() > 0) {
        int hier;
        for (int idx = 0; idx < contours.size(); idx++) {
            Rect rect = boundingRect(contours[idx]);
            if (rect.width > 2000) {
                hier = idx;
            }
        } //완료
        for (int i = 0, j = 0; i < contours.size(); i++) {
            if (hierarchy[i][3] == hier) {
                roiRect[j] = boundingRect(contours[i]);
                j++;
            }
        }
    }

    //순서대로 정렬
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10 - i - 1; j++) {
            if (roiRect[j].x > roiRect[j+1].x) {
                Rect bff = roiRect[j];
                roiRect[j] = roiRect[j + 1];
                roiRect[j + 1] = bff;
            }
        }
    }

    //저장
    for (int i = 0; i < 10; i++) {
        *(&roi[i]) = input_origin_image(roiRect[i]); //CROP
    }

}
*/extern "C"
JNIEXPORT void JNICALL
Java_com_example_font_1opencv_activity_1sub_105_show_1words(JNIEnv *env, jobject thiz,
                                                            jlong input_image1, jlong input_image2,
                                                            jlong input_image3, jlong input_image4,
                                                            jlong input_image5, jlong input_image6,
                                                            jlong input_image7, jlong input_image8,
                                                            jlong input_image9,
                                                            jlong output_image) {
    Mat &one = *(Mat *) input_image1;
    Mat &two = *(Mat *) input_image2;
    Mat &three = *(Mat *) input_image3;
    Mat &four = *(Mat *) input_image4;
    Mat &five = *(Mat *) input_image5;
    Mat &six = *(Mat *) input_image6;
    Mat &seven = *(Mat *) input_image7;
    Mat &eight = *(Mat *) input_image8;
    Mat &nine = *(Mat *) input_image9;

    Mat row1; //가로로 이미지 붙인 결과
    Mat row2;
    Mat row3;
    Mat col1;
    Mat &final_col = *(Mat *) output_image; //세로로 이미지 붙인 결과

    resize(one, one, Size(300, 300), INTER_AREA);
    resize(two, two, Size(300, 300), INTER_AREA);
    resize(three, three, Size(300, 300), INTER_AREA);
    resize(four, four, Size(300, 300), INTER_AREA);
    resize(five, five, Size(300, 300), INTER_AREA);
    resize(six, six, Size(300, 300), INTER_AREA);
    resize(seven, seven, Size(300, 300), INTER_AREA);
    resize(eight, eight, Size(300, 300), INTER_AREA);
    resize(nine, nine, Size(300, 300), INTER_AREA);


    hconcat(one, two, row1);
    hconcat(row1, three, row1); // 첫째줄
    hconcat(four, five, row2);
    hconcat(row2, six, row2); // 둘째줄
    hconcat(seven, eight, row3);
    hconcat(row3, nine, row3); // 셋째줄
    vconcat(row1, row2, col1); //세로로 이미지 붙이기
    vconcat(col1, row3, final_col);

    //이진화해서 글자만 추출하기
    //열거상수 THRESH_BINARY_INV

    threshold(final_col, final_col, 170, 255, THRESH_BINARY_INV);

    //색반전
    final_col = ~final_col;

    resize(final_col, final_col, Size(500, 500), INTER_AREA);
}