package com.example.test.service;

import com.example.test.bean.ExerciseBean;

import java.util.List;

public interface ExerciseService {
    List<ExerciseBean> showInfo(String exerciseName);
    ExerciseBean insertIn(int userID,double exerciseheat,int exerciseID,String exerciseName,String time);
}
