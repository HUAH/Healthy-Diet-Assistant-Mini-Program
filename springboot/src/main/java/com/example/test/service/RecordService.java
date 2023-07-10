package com.example.test.service;

import com.example.test.bean.RecordBean;

import java.sql.Date;
import java.util.List;

public interface RecordService {
    List<RecordBean> showweightInfo(int userID);
    RecordBean insertbreakfastIn(int userID,int calorieIntake_bf,int foodID);
    RecordBean insertcalorieIn(int userID,int calorieBurned,int exerciseID);
//    RecordBean insertweightIn(int userID, int weight, Date time);

//    List<RecordBean> showbreakfastInfo(int userID);
}
