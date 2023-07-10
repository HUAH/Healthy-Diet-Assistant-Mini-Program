package com.example.test.serviceImpl;

import com.example.test.bean.BDietBean;
import com.example.test.bean.DDietBean;
import com.example.test.bean.ExercisedataBean;
import com.example.test.mapper.ExercisedataMapper;
import com.example.test.service.ExerciseDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseDataServiceImpl implements ExerciseDataService {
    @Autowired
    private ExercisedataMapper exercisedataMapper;
    @Override
    public List<ExercisedataBean> showe(int userID, String time){ return exercisedataMapper.geteInfo(userID,time);}
    public ExercisedataBean dele(int userID, int exercisedataID){return exercisedataMapper.deleInfo(userID,exercisedataID);}
}
