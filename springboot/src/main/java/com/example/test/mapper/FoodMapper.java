package com.example.test.mapper;

import com.example.test.bean.FoodBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodMapper {
     List<FoodBean> getInfo (String foodName);
     List<FoodBean> getidInfo (int foodID);
//     eigenvalue
List<FoodBean> geteiInfo (String eigenvalue);
     FoodBean insertb (int userID,String chose,double foodheart,int foodID,String foodName,String time);
     FoodBean insertl (int userID,String chose,double foodheart,int foodID,String foodName,String time);
     FoodBean insertd (int userID,String chose,double foodheart,int foodID,String foodName,String time);


     List<FoodBean> getdInfo (int userID);
     List<FoodBean> getallInfo (int pagenum);
     FoodBean addInfo(String foodname, int heat, int protein, int fat, int carbohydrate, String eigenvalue);

     FoodBean del(int id);
}
