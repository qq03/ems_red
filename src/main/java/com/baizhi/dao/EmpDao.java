package com.baizhi.dao;

import com.baizhi.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpDao {
    public List<Emp> queryAll(@Param("begin") Integer begin, @Param("end") Integer end);
    public void delete(String id);
    public void update(Emp emp);
    public void insert(Emp emp);
    public Emp findOne(String id);
    public Integer totals();
}
