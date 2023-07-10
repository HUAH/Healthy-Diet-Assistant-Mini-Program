package com.example.test.bean;

public class BDietBean {
    private int breakfastdataID;
    private double foodheat;
    private String foodName;
    private String time;


    private int foodID;

    public int getFoodID() {
        return foodID;
    }

    public void setFoodID(int foodID) {
        this.foodID = foodID;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getBreakfastdataID() {
        return breakfastdataID;
    }

    public void setBreakfastdataID(int breakfastdataID) {
        this.breakfastdataID = breakfastdataID;
    }

    public double getFoodheat() {
        return foodheat;
    }

    public void setFoodheat(double foodheat) {
        this.foodheat = foodheat;
    }
}
