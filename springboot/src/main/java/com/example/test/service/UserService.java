package com.example.test.service;

import com.example.test.bean.UserBean;

public interface UserService {

    UserBean searchIn(String imgurl);

//    UserBean searchidIn(int id);

    UserBean insertIn(String nickname,String imgurl);

    UserBean addIn(String gender,int height,int age,double BMI,double weight,double fweight,int userID);

//    UserBean addIn(String weigth,int user_id)
    UserBean insertBMIIn(int userID,float BMI);
    UserBean getIn(int userID);
}