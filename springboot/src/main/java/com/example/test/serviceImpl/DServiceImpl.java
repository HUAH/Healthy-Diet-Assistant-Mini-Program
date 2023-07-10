package com.example.test.serviceImpl;

import com.example.test.bean.BDietBean;
import com.example.test.bean.DDietBean;
import com.example.test.bean.LDietBean;
import com.example.test.mapper.DMapper;
import com.example.test.mapper.LMapper;
import com.example.test.service.DService;
import com.example.test.service.LService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DServiceImpl implements DService {
    @Autowired
    private DMapper dMapper;
    @Override
    public List<DDietBean> showd(int userID,String time){ return dMapper.getdInfo(userID,time);}
    public DDietBean deld(int userID, int dinnerdataID){return dMapper.deldInfo(userID,dinnerdataID);}
}
