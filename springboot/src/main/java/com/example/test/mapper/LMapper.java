package com.example.test.mapper;

import com.example.test.bean.BDietBean;
import com.example.test.bean.FoodBean;
import com.example.test.bean.LDietBean;

import java.util.List;

public interface LMapper {
    List<LDietBean> getlInfo (int userID,String time);
    LDietBean dellInfo(int userID, int lunchdataID);
}
