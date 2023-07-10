package com.example.test.controller;

import com.example.test.bean.ExerciseBean;
import com.example.test.bean.FoodBean;
import com.example.test.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ExerciseController {
    @Autowired
    ExerciseService exerciseService;
    @ResponseBody
    @GetMapping("/exercise")
    public List<ExerciseBean> list(String exerciseName) {
        System.out.println("查询运动名称成功");
        List<ExerciseBean> list = exerciseService.showInfo(exerciseName);
        return list;
    }

    @RequestMapping(value = "insertexercise",method = RequestMethod.POST)
    @ResponseBody
    public String InsertExercise(int userID,double exerciseheat,int exerciseID,String exerciseName,String time) {
        exerciseService.insertIn(userID,exerciseheat,exerciseID,exerciseName,time);
        return "OK";
    }

}
