package com.example.test.service;

import com.example.test.bean.BDietBean;

import java.util.List;

public interface BService {
    List<BDietBean> showb(int userID,String time);
    BDietBean delb(int userID,int breakfastdataID);
}
