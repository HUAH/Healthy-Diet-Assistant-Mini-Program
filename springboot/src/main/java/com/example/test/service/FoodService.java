package com.example.test.service;

import com.example.test.bean.FoodBean;

import java.util.List;

public interface FoodService {
    List<FoodBean> showInfo(String foodName);
    List<FoodBean> showidInfo(int foodID);
//    eigenvalue
    FoodBean insertbIn(int userID,String chose,double foodheart,int foodID,String foodName,String time);
    FoodBean insertlIn(int userID,String chose,double foodheart,int foodID,String foodName,String time);
    FoodBean insertdIn(int userID,String chose,double foodheart,int foodID,String foodName,String time);
    List<FoodBean> showeiInfo(String eigenvalue);
//    List<FoodBean> showb(int userID);
//    List<FoodBean> showl(int userID);
//    List<FoodBean> showd(int userID);
List<FoodBean> showallInfo(int pagenum);

   FoodBean addFood(String foodname, int heat, int protein, int fat, int carbohydrate, String eigenvalue);


    FoodBean deleteFoodById(int id);
}
