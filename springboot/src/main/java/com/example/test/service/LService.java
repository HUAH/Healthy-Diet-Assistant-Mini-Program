package com.example.test.service;

import com.example.test.bean.DDietBean;
import com.example.test.bean.LDietBean;

import java.util.List;

public interface LService {
    List<LDietBean> showl(int userID,String time);
    LDietBean dell(int userID, int lunchdataID);
}
