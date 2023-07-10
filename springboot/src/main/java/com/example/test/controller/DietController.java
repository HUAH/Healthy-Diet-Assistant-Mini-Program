package com.example.test.controller;

import com.example.test.bean.*;
import com.example.test.service.BService;
import com.example.test.service.DService;
import com.example.test.service.ExerciseDataService;
import com.example.test.service.LService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class DietController {
//            早餐————————————————————————————————————————————————————————————————————————————
    @Autowired
    BService bService;
    @ResponseBody
    @GetMapping("/bdietdata")
    public List<BDietBean> dietBlist(int userID,String time) {
        System.out.println("查询成功");
        List<BDietBean> blist = bService.showb(userID,time);
        return blist;
    }
    @ResponseBody
    @GetMapping("/delb")
    public String delb(int userID,int breakfastdataID) {
        System.out.println("删除成功"+userID+breakfastdataID);
        bService.delb(userID,breakfastdataID);
        return "ok";
    }
//午餐-----------------------------------------------------------------------------
    @Autowired
    LService lService;
    @ResponseBody
    @GetMapping("/ldietdata")
    public List<LDietBean> dietLlist(int userID,String time) {
        System.out.println("查询成功");
        List<LDietBean> llist = lService.showl(userID,time);
        return llist;
    }
    @ResponseBody
    @GetMapping("/dell")
    public String dell(int userID,int lunchdataID) {
        System.out.println("删除成功"+userID+lunchdataID);
        lService.dell(userID,lunchdataID);
        return "ok";
    }
//    晚餐------------------------------------------------------------------------------
    @Autowired
    DService dService;
    @ResponseBody
    @GetMapping("/ddietdata")
    public List<DDietBean> dietDlist(int userID,String time) {
        System.out.println("查询成功");
        List<DDietBean> dlist = dService.showd(userID,time);
        return dlist;
    }
    @ResponseBody
    @GetMapping("/deld")
    public String deld(int userID,int dinnerdataID) {
        System.out.println("删除成功"+userID+dinnerdataID);
        dService.deld(userID,dinnerdataID);
        return "ok";
    }
//    运动----------------------------------------------------------------------------------
    @Autowired
    ExerciseDataService exerciseDataService;
    @ResponseBody
    @GetMapping("/exercisedata")
    public List<ExercisedataBean> exerciseDatalist(int userID,String time) {
        System.out.println("查询成功");
        List<ExercisedataBean> elist = exerciseDataService.showe(userID,time);
        return elist;
    }
    @ResponseBody
    @GetMapping("/dele")
    public String dele(int userID,int exercisedataID) {
        System.out.println("删除成功"+userID+exercisedataID);
        exerciseDataService.dele(userID,exercisedataID);
        return "ok";
    }

}
