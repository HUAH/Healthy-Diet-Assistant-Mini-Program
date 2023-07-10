package com.example.test.serviceImpl;


import com.example.test.bean.FoodBean;
import com.example.test.bean.RecordBean;
import com.example.test.mapper.FoodMapper;
import com.example.test.mapper.RecordMapper;
import com.example.test.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    //将DAO注入Service层
    @Autowired
    private RecordMapper recordMapper;
    @Override
//    返回体重数据
    public List<RecordBean> showweightInfo(int userID) { return recordMapper.getweightInfo(userID);}
//    插入早餐数据
    public RecordBean insertbreakfastIn(int userID,int calorieIntake_bf,int foodID) {return recordMapper.breakfastInfo(userID,calorieIntake_bf,foodID);}
//插入运动数据
    public RecordBean insertcalorieIn(int userID,int calorieBurned,int exerciseID) {return recordMapper.calorieInfo(userID,calorieBurned,exerciseID);}
////    更新体重数据
//    public RecordBean insertweightIn(int userID, int weight, Date time) { return recordMapper.weightInfo(userID,weight,time); }
//    //    更新BMI数据
//    public RecordBean insertBMIIn(int userID,float BMI) { return recordMapper.BMIInfo(userID,BMI); }
}
