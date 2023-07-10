package com.example.test.service;

import com.example.test.bean.DDietBean;

import java.util.List;

public interface DService {
    List<DDietBean> showd(int userID,String time);
    DDietBean deld(int userID, int dinnerdataID);
}
