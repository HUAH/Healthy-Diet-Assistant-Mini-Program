package com.example.test.service;

import com.example.test.bean.RecordBean;
import com.example.test.bean.WeightHistoryBean;

import java.sql.Date;
import java.util.List;

public interface WeightHistoryService {
    List<WeightHistoryBean> showInfo(int userID);
    WeightHistoryBean insertweightIn(int userID, int weight, String time);
    WeightHistoryBean updateweightIn(int userID, int weight, String time,int usetimeid);
    WeightHistoryBean insertweightIntoo(int userID, int weight);
}
