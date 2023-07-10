package com.example.test.serviceImpl;

import com.example.test.bean.ExerciseBean;
import com.example.test.mapper.ExerciseMapper;
import com.example.test.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService {
    //将DAO注入Service层
    @Autowired
    private ExerciseMapper exerciseMapper;
    @Override
    public List<ExerciseBean> showInfo(String exerciseName){
        return exerciseMapper.getInfo(exerciseName);
    }
    public ExerciseBean insertIn(int userID,double exerciseheat,int exerciseID,String exerciseName,String time){return exerciseMapper.inserte(userID,exerciseheat,exerciseID,exerciseName,time);}
}
