package com.example.test.service;

import com.example.test.bean.BDietBean;
import com.example.test.bean.ExercisedataBean;

import java.util.List;

public interface ExerciseDataService {
    List<ExercisedataBean> showe(int userID,String time);
    ExercisedataBean dele(int userID, int exercisedataID);
}
