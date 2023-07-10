package com.example.test.bean;

import java.util.Date;

public class WeightHistoryBean {
    private int weighthistoryID;
    private int userID;
    private String time;
    private float weight;

    public int getWeighthistoryID() {
        return weighthistoryID;
    }

    public void setWeighthistoryID(int weighthistoryID) {
        this.weighthistoryID = weighthistoryID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
