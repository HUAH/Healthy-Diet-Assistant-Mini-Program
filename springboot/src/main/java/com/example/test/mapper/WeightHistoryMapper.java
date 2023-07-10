package com.example.test.mapper;

import com.example.test.bean.RecordBean;
import com.example.test.bean.WeightHistoryBean;

import java.sql.Date;
import java.util.List;

public interface WeightHistoryMapper {
     List<WeightHistoryBean> getInfo(int userID);
     WeightHistoryBean weightInfo(int userID, int weight, String time);
     WeightHistoryBean weightupdateInfo(int userID, int weight, String time,int usetimeid);
     WeightHistoryBean weightInfotoo(int userID, int weight);
}
