package com.example.test.mapper;

import com.example.test.bean.RecordBean;
import com.example.test.bean.UserBean;

public interface UserMapper {

    UserBean search(String imgurl);
    UserBean insert(String nickname,String imgurl);
    UserBean add(String gender,int height,int age,double BMI,double weight,double fweight,int userID);
//    UserBean add(String weight, int user_id);
    UserBean BMIInfo(int userID, float BMI);
    UserBean weightInfo(int userID, float BMI);
    UserBean getInfo(int userID);
}