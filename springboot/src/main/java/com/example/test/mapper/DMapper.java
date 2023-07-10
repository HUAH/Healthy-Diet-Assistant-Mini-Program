package com.example.test.mapper;

import com.example.test.bean.DDietBean;

import java.util.List;

public interface DMapper {
    List<DDietBean> getdInfo (int userID,String time);
    DDietBean deldInfo(int userID,int dinnerdataID);
}
