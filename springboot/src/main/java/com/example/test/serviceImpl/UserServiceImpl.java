package com.example.test.serviceImpl;

import com.example.test.bean.RecordBean;
import com.example.test.bean.UserBean;
import com.example.test.mapper.UserMapper;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    //将DAO注入Service层
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean insertIn(String nickname, String imgurl) {
        return userMapper.insert(nickname,imgurl);
    }
    public UserBean searchIn(String imgurl) {
        return userMapper.search(imgurl);
    }
//    public UserBean searchidIn(int id) { return userMapper.searchid(id);}
    public UserBean getIn(int userID) {
    return userMapper.getInfo(userID);
}
    public UserBean addIn(String gender,int height,int age,double BMI,double weight,double fweight,int userID) {return userMapper.add(gender,height, age, BMI, weight, fweight, userID);}
    public UserBean insertBMIIn(int userID, float BMI) { return userMapper.BMIInfo(userID,BMI); }
}