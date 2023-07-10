package com.example.test.serviceImpl;

import com.example.test.bean.FoodBean;
import com.example.test.mapper.FoodMapper;
import com.example.test.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    //将DAO注入Service层
    @Autowired
    private FoodMapper foodMapper;
    @Override
    public List<FoodBean> showInfo(String foodName){
        return foodMapper.getInfo(foodName);
    }
    public List<FoodBean> showidInfo(int foodID) { return foodMapper.getidInfo(foodID); }
//    eigenvalue
    public List<FoodBean> showeiInfo(String eigenvalue){
    return foodMapper.geteiInfo(eigenvalue);
}
    public FoodBean insertbIn(int userID,String chose,double foodheart,int foodID , String foodName,String time) {
        return foodMapper.insertb(userID,chose,foodheart,foodID , foodName,time);
    }
    public FoodBean insertlIn(int userID,String chose,double foodheart,int foodID,String foodName,String time) {
        return foodMapper.insertl(userID,chose,foodheart,foodID,foodName,time);
    }
    public FoodBean insertdIn(int userID,String chose,double foodheart,int foodID,String foodName,String time) {
        return foodMapper.insertd(userID,chose,foodheart,foodID,foodName,time);
    }

//    public List<FoodBean> showb(int userID){ return foodMapper.getbInfo(userID);}
//    public List<FoodBean> showl(int userID){ return foodMapper.getlInfo(userID);}
//    public List<FoodBean> showd(int userID){ return foodMapper.getdInfo(userID);}
    public List<FoodBean> showallInfo(int pagenum){  return foodMapper.getallInfo(pagenum); }
    public FoodBean addFood(String foodname, int heat, int protein, int fat, int carbohydrate, String eigenvalue){return foodMapper.addInfo(foodname,heat,protein,fat,carbohydrate,eigenvalue);}

    public FoodBean deleteFoodById(int id){return foodMapper.del(id);}



}
