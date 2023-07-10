package com.example.test.service;

import com.example.test.bean.FoodBean;
import com.example.test.bean.MealBean;

import java.util.List;

public interface MealService {

    List<MealBean> showmealInfo(double needhaet, double needprotein,int check1,int check2);
    List<MealBean> showidInfo(int mealID);
}
