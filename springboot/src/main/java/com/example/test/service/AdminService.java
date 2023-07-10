package com.example.test.service;

import com.example.test.bean.AdminBean;

public interface AdminService {
    AdminBean loginIn(String email,String password);
}
