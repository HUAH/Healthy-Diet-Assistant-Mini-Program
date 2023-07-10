package com.example.test.controller;

import com.example.test.bean.ExerciseBean;
import com.example.test.bean.WeightHistoryBean;
import com.example.test.service.ExerciseService;
import com.example.test.service.WeightHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.util.List;

@Controller
public class WeightHistoryController {
//    getInfo
@Autowired
    WeightHistoryService weightHistoryService;
    @ResponseBody
    @GetMapping("/weighthistory")
//    @DateTimeFormat(pattern="yyyy-MM-dd")
    public List<WeightHistoryBean> list(int userID) {
        System.out.println("查询历史体重成功");
        List<WeightHistoryBean> list = weightHistoryService.showInfo(userID);
        return list;
    }

    //    addData
    @RequestMapping(value = "addweightData",method = RequestMethod.POST)
    @ResponseBody
    @DateTimeFormat(pattern="yyyy-MM-dd")
    public String InsertWeight(int userID, int weight , String time ,boolean eq,int usetimeid) {
        System.out.println("更新的体重值为"+weight);
        System.out.println("更新日期为"+time);
        System.out.println("ID为"+userID);
        System.out.println(eq+"true该更新 false该插入"+usetimeid);
        if(eq == false){
            System.out.println("应该插入新数据行");
            weightHistoryService.insertweightIn(userID,weight,time);
            weightHistoryService.insertweightIntoo(userID,weight);
        }else
        {System.out.println("应该更新已有数据行，数据行id为"+usetimeid);
            weightHistoryService.updateweightIn(userID,weight,time,usetimeid);
            weightHistoryService.insertweightIntoo(userID,weight);}
        return "OK";
    }
}
