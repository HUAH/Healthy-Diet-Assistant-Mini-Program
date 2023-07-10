package com.example.test.bean;

import javax.xml.crypto.Data;
import java.sql.Date;

public class RecordBean {
    private int RecordID;
    private int UserID;
    private Date RecordDate;
    private int Weight;
    private float BMI;
    private int CalorieIntake_bf;
    private int CalorieBurned;
    private int FoodID;
    private int ExerciseID;

    public int getRecordID() {
        return RecordID;
    }

    public void setRecordID(int recordID) {
        RecordID = recordID;
    }

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }


    public Date getRecordDate() {
        return RecordDate;
    }

    public void setRecordDate(Date recordDate) {
        RecordDate = recordDate;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public float getBMI() {
        return BMI;
    }

    public void setBMI(int BMI) {
        this.BMI = BMI;
    }

    public int getCalorieIntake_bf() {
        return CalorieIntake_bf;
    }

    public void setCalorieIntake_bf(int calorieIntake_bf) {
        CalorieIntake_bf = calorieIntake_bf;
    }

    public int getCalorieBurned() {
        return CalorieBurned;
    }

    public void setCalorieBurned(int calorieBurned) {
        CalorieBurned = calorieBurned;
    }

    public int getFoodID() {
        return FoodID;
    }

    public void setFoodID(int foodID) {
        FoodID = foodID;
    }

    public int getExerciseID() {
        return ExerciseID;
    }

    public void setExerciseID(int exerciseID) {
        ExerciseID = exerciseID;
    }
}
