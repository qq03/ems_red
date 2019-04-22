package com.baizhi.service.impl;

import com.baizhi.dao.AdminDao;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Admin login(Admin admin) {
        Admin login = adminDao.login(admin.getUsername());
        if(login== null){
            throw new RuntimeException("用户不存在");
        }else{
            if(login.getPassword().equals(admin.getPassword())){
                return login;
            }else{
                throw new RuntimeException("密码错误");
            }
        }
    }

    @Override
    public void insert(Admin admin) {
        admin.setId(UUID.randomUUID().toString());
        adminDao.insert(admin);
    }
}
