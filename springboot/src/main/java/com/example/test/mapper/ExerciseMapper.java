package com.example.test.mapper;

import com.example.test.bean.ExerciseBean;

import java.util.List;

public interface ExerciseMapper {
    List<ExerciseBean> getInfo (String exerciseName);
    ExerciseBean inserte(int userID,double exerciseheat,int exerciseID,String exerciseName,String time);
}
