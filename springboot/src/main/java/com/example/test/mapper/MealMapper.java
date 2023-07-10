package com.example.test.mapper;

import com.example.test.bean.FoodBean;
import com.example.test.bean.MealBean;

import java.util.List;

public interface MealMapper {
    List<MealBean> getmealInfo (double needhaet,double needprotein,int check1,int check2);
    List<MealBean> getidInfo (int mealID);
}
