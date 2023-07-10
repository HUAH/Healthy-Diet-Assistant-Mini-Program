package com.example.test.mapper;

import com.example.test.bean.BDietBean;
import com.example.test.bean.ExercisedataBean;

import java.util.List;

public interface ExercisedataMapper {
    List<ExercisedataBean> geteInfo (int userID, String time);
    ExercisedataBean deleInfo(int userID,int exercisedataID);
}
