package com.baizhi.service;

import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {
    public List<Emp> queryAll(Integer page);
    public void delete(String id);
    public void insert(Emp emp);
    public void update(Emp emp);
    public Emp findOne(String id);
    public Integer totals();
}
