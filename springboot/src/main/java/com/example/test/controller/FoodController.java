package com.example.test.controller;

import com.example.test.bean.FoodBean;
import com.example.test.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FoodController {

    //将Service注入Web层
    @Autowired
    FoodService foodService;


    @ResponseBody
    @GetMapping("/food")
    public List<FoodBean> list(String foodName) {
        System.out.println("查询食物成功");
        List<FoodBean> list = foodService.showInfo(foodName);
        return list;
    }


    @ResponseBody
    @GetMapping("/foodforid")
    public List<FoodBean> list(int foodID) {
        System.out.println("查询成功");
        List<FoodBean> list = foodService.showidInfo(foodID);
        return list;
    }
//    eigenvalue
@ResponseBody
@GetMapping("/classifyfood")
public List<FoodBean> cllist(String eigenvalue) {
    System.out.println("查询成功");
    List<FoodBean> list = foodService.showeiInfo(eigenvalue);
    return list;
}
    @RequestMapping(value = "insertfood",method = RequestMethod.POST)
    @ResponseBody
    public String InsertFood(int userID,String chose,double foodheart,int foodID,String foodName,String time) {
        System.out.println("获取到的数据为"+userID+chose+foodheart+foodID+foodName);
        System.out.println("吃饭的日期为"+time);
        if(chose.equals("早"))
        {System.out.println(chose);
            foodService.insertbIn(userID,chose,foodheart,foodID,foodName,time) ;}
        else if (chose.equals("午"))
        {System.out.println(chose);
            foodService.insertlIn(userID,chose,foodheart,foodID,foodName,time) ;}
            else if (chose.equals("晚"))
        {System.out.println(chose);
                foodService.insertdIn(userID,chose,foodheart,foodID,foodName,time) ;}
        return "OK";
    }

//    @ResponseBody
//    @GetMapping("/dietdata")
//    public List<FoodBean> dietlist(int userID) {
//        System.out.println("查询成功");
//        List<FoodBean> blist = foodService.showb(userID);
//        List<FoodBean> llist = foodService.showl(userID);
//        List<FoodBean> dlist = foodService.showd(userID);
//        for (int i=0;i<3;i++){
//            switch (i){
//                case 1: return blist;
//                case 2: return llist;
//                case 3: return dlist;
//            }
//        }
//        return blist;
//    }
//    后台使用-----------------------------------------------------------------------------
@ResponseBody
@GetMapping("/getallfood")
public List<FoodBean> allfoodlist(int pagenum) {
        pagenum=(pagenum-1)*7;
    System.out.println("11111111111111"+pagenum);
    List<FoodBean> list = foodService.showallInfo(pagenum);
    System.out.println("查询食物成功");
    return list;
}

//删除
@GetMapping("/deletefood")
public String deleteFood(@RequestParam("id") int id) {
    foodService.deleteFoodById(id); // 调用Service层的方法删除数据
    return "ok"; // 重定向到食品列表页面
}




//        改写后
//@RequestMapping("/foodList")
//public String showAllFoods(Model model, @RequestParam(defaultValue = "1") int page) {
//    int recordsPerPage = 7;
//    int start = (page - 1) * recordsPerPage;
//
//    List<FoodBean> list = foodService.showPageInfo(start, recordsPerPage);
//    model.addAttribute("list", list);
//
//    int totalRecords = foodService.count();
//    int totalPages = (int) Math.ceil((double) totalRecords / recordsPerPage);
//    model.addAttribute("totalPages", totalPages);
//    model.addAttribute("currentPage", page);
//
//    return "success";
//}


    @RequestMapping(value = "/addFood", method = RequestMethod.POST)
    @ResponseBody
    public String addFood(String foodname, int heat, int protein, int fat, int carbohydrate, String eigenvalue) {
        System.out.println(foodname);
        foodService.addFood(foodname,heat,protein,fat,carbohydrate,eigenvalue);
        return "ok";
    }

}

