package com.example.test.controller;

import com.example.test.bean.UserBean;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    //将Service注入Web层
    @Autowired
    UserService userService;

    @RequestMapping("/searchuser")
    @GetMapping
    @ResponseBody
    public UserBean SearchUser(String imgurl) {
        UserBean user = userService.searchIn(imgurl);
        return user;
    }


    @RequestMapping(value = "insertuser",method = RequestMethod.POST)
    @ResponseBody
    public String InsertUser(String nickname,String imgurl) {
        System.out.println(nickname);
        userService.insertIn(nickname,imgurl);
        return "ok";
    }
    @RequestMapping(value = "save",method = RequestMethod.POST)
    @ResponseBody
    public String saveData(String gender,int height,int age,double BMI,double weight,double fweight,int userID) {
        userService.addIn(gender,height, age, BMI, weight, fweight, userID);
        return "ok";
    }

    @RequestMapping(value = "addBMIData",method = RequestMethod.POST)
    @ResponseBody
    public String InsertBMI(int userID,float BMI) {
        System.out.println("userid"+userID);
        System.out.println("更新的BMI值为"+BMI);
        System.out.println("111111111111111111");
        userService.insertBMIIn(userID,BMI);
        return "OK";
    }

//    getData
@RequestMapping("/getData")
@GetMapping
@ResponseBody
public UserBean getData(int userID) {
    UserBean user = userService.getIn(userID);
    return user;
}
}