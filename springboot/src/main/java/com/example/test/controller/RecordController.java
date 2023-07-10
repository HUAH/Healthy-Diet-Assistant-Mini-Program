package com.example.test.controller;

import com.example.test.bean.RecordBean;
import com.example.test.service.RecordService;
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
public class RecordController {
    //将Service注入Web层
    @Autowired
    RecordService recordService;

    @ResponseBody
    @GetMapping("/getweightData")
    public List<RecordBean> list(int userID) {
        System.out.println("查询体重数据成功");
        List<RecordBean> list = recordService.showweightInfo(userID);
        return list;
    }

//    insertbreakfast
    @RequestMapping(value = "insertbreakfast",method = RequestMethod.POST)
    @ResponseBody
    public String InsertBreakfast(int userID,int calorieIntake_bf,int foodID) {
        System.out.println(calorieIntake_bf);
        System.out.println("插入卡路里摄入与食物id"+calorieIntake_bf+foodID);
        recordService.insertbreakfastIn(userID,calorieIntake_bf,foodID);
        return "ok";
    }


////    addData
//@RequestMapping(value = "addweightData",method = RequestMethod.POST)
//@ResponseBody
//@DateTimeFormat(pattern="yyyy-MM-dd")
//public String InsertWeight(int userID, int weight , Date time) {
//    System.out.println("更新的体重值为"+weight);
//    System.out.println("更新日期为"+time);
//    recordService.insertweightIn(userID,weight,time);
//    return "OK";
//}


//    getbreakfastData
//@ResponseBody
//@GetMapping("/getbreakfastData")
//public List<RecordBean> list(int userID) {
//    System.out.println("查询成功");
//    List<RecordBean> list = recordService.showbreakfastInfo(userID);
//    return list;
//}
}
