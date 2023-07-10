package com.example.test.mapper;

import com.example.test.bean.RecordBean;

import java.sql.Date;
import java.util.List;

public interface RecordMapper {
    List<RecordBean> getweightInfo(int userID);
    RecordBean breakfastInfo(int userID,int calorieIntake_bf,int foodID);
    RecordBean calorieInfo(int userID,int calorieBurned,int exerciseID);
//    RecordBean weightInfo(int userID, int weight, Date time);

//    List<RecordBean> getbreakfastInfo(int userID);
}
