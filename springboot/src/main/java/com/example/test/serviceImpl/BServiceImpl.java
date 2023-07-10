package com.example.test.serviceImpl;


import com.example.test.bean.BDietBean;
import com.example.test.mapper.BMapper;

import com.example.test.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BServiceImpl implements BService {
    @Autowired
    private BMapper bMapper;
    @Override
    public List<BDietBean> showb(int userID,String time){ return bMapper.getbInfo(userID,time);}
    public  BDietBean delb(int userID,int breakfastdataID){return bMapper.delbInfo(userID,breakfastdataID);}
}
