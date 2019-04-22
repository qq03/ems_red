package com.baizhi.dao;


import com.baizhi.entity.Admin;

public interface AdminDao {

    public void insert(Admin admin);
    public Admin login(String username);
}
