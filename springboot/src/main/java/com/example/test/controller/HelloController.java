package com.example.test.controller;

import com.example.test.bean.FoodBean;
import com.example.test.bean.MealBean;
import com.example.test.bean.RecordBean;
import com.example.test.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class HelloController {
    @Autowired
    MealService mealService;

    public int check1;
    public int check2;
    public double needhaet;      //需要的热量
    public double needprotein;  //需要的蛋白质量

    @RequestMapping(value = "start",method = RequestMethod.POST)
    @ResponseBody
    public void getinformation(double weight, Float BMR,boolean checked1,boolean checked2,int radio) {
        System.out.println("体重"+weight);
        System.out.println(BMR);
        System.out.println(checked1);
        System.out.println(checked2);
        if (checked1==true){
            check1=0;
        }else
            check1=1;
        if (checked2==true){
            check2=0;
        }else
            check2=1;
        if(radio==1){
            System.out.println("目标为增肌");
            needhaet = BMR+500;
            needprotein = weight*1.3;
            System.out.println("所需热量为"+needhaet+"所需蛋白质为"+needprotein);
        }else if (radio==2){
            System.out.println("目标为减肥");
            needhaet = BMR-500;
            needprotein = weight*0.8;
            System.out.println("所需热量为"+needhaet+"所需蛋白质为"+needprotein);
        }else if (radio==3){
            System.out.println("目标为塑形");
            needhaet = BMR+500;
            needprotein = weight*1.0;
            System.out.println("所需热量为"+needhaet+"所需蛋白质为"+needprotein);
        }

    }
    @ResponseBody
    @GetMapping("/meal")
    public List<MealBean> list() {
        System.out.println(needhaet+"----"+needprotein+"ch1"+check1+"ch2"+check2);
        List<MealBean> list = mealService.showmealInfo(needhaet,needprotein,check1,check2);
        return list;
    }
    @ResponseBody
    @GetMapping("/mealforid")
    public List<MealBean> list(int mealID) {
        System.out.println("查询成功");
        List<MealBean> list = mealService.showidInfo(mealID);
        return list;
    }

}