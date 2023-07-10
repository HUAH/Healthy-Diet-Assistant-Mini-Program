package com.example.test.serviceImpl;


import com.example.test.bean.RecordBean;
import com.example.test.bean.UserBean;
import com.example.test.bean.WeightHistoryBean;
import com.example.test.mapper.WeightHistoryMapper;
import com.example.test.service.WeightHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class WeigHistoryImpl implements WeightHistoryService {
    @Autowired
    private WeightHistoryMapper weightHistoryMapper;
    @Override
    public List <WeightHistoryBean> showInfo(int userID) { return weightHistoryMapper.getInfo(userID); }
    //    更新体重数据
    public WeightHistoryBean insertweightIn(int userID, int weight, String time) { return weightHistoryMapper.weightInfo(userID,weight,time); }
    public WeightHistoryBean insertweightIntoo(int userID, int weight) { return weightHistoryMapper.weightInfotoo(userID,weight); }
    public WeightHistoryBean updateweightIn (int userID, int weight, String time,int usetimeid) { return weightHistoryMapper.weightupdateInfo(userID,weight,time,usetimeid); }
}
//
//public class UserServiceImpl implements UserService {
//
//    //将DAO注入Service层
//    @Autowired
//    private UserMapper userMapper;
//
//    @Override
//    public UserBean insertIn(String nickname, String imgurl) {
//        return userMapper.insert(nickname,imgurl);
//    }