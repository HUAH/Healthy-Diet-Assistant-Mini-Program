package com.example.test.serviceImpl;

import com.example.test.bean.FoodBean;
import com.example.test.bean.MealBean;
import com.example.test.mapper.MealMapper;
import com.example.test.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealServiceImpl implements MealService {
    //将DAO注入Service层
    @Autowired
    private MealMapper mealMapper;
    @Override
    public List<MealBean> showmealInfo(double needhaet,double needprotein ,int check1,int check2){ return mealMapper.getmealInfo(needhaet,needprotein,check1,check2); }
    public List<MealBean> showidInfo(int mealID) { return mealMapper.getidInfo(mealID); }
}
