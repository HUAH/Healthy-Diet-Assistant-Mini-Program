package com.example.test.mapper;

import com.example.test.bean.BDietBean;

import java.util.List;

public interface BMapper {
    List<BDietBean> getbInfo (int userID,String time);
    BDietBean delbInfo(int userID,int breakfastdataID);
}
