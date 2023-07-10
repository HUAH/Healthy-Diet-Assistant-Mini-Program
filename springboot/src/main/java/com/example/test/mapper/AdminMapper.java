package com.example.test.mapper;

import com.example.test.bean.AdminBean;

public interface AdminMapper {
    AdminBean getInfo(String email,String password);
}
