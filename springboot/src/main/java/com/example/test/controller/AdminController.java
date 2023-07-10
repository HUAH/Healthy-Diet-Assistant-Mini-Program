package com.example.test.controller;

import com.example.test.bean.AdminBean;
import com.example.test.bean.FoodBean;
import com.example.test.bean.UserBean;
import com.example.test.service.AdminService;
import com.example.test.service.FoodService;
import com.example.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AdminController {
    //将Service注入Web层
    @Autowired
    AdminService adminService;
    @Autowired
    FoodService foodService;
    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(String email, String password){
        AdminBean adminBean = adminService.loginIn(email,password);
        if(adminBean!=null){
            return "success";
        }else {
            return "er";
        }
    }
    //重写后的登录功能
//    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
//    public String login(String email, String password) {
//        AdminBean adminBean = adminService.loginIn(email, password);
//        if (adminBean != null) {
//            return "redirect:/foodList"; // 重定向到 showFoodList 方法
//        } else {
//            return "er";
//        }
//    }

    //分页显示功能
//    @RequestMapping(value = "/foodList")
//    public String showFoodList(@RequestParam(defaultValue = "1") int page, Model model) {
//        int pageSize = 7; // 每页显示7条数据
//        List<FoodBean> list = foodService.showallInfo((page - 1) * pageSize, pageSize);
//        model.addAttribute("list", list);
//        return "success";
//    }

}
