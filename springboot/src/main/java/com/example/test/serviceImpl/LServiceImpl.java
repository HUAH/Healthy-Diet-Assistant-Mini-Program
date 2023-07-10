package com.example.test.serviceImpl;

import com.example.test.bean.BDietBean;
import com.example.test.bean.LDietBean;
import com.example.test.mapper.LMapper;
import com.example.test.service.LService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LServiceImpl implements LService {
    @Autowired
    private LMapper lMapper;
    @Override
    public List<LDietBean> showl(int userID,String time){ return lMapper.getlInfo(userID,time);}
    public  LDietBean dell(int userID,int lunchdataID){return lMapper.dellInfo(userID,lunchdataID);}
}
