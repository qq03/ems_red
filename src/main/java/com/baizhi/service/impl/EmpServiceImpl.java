package com.baizhi.service.impl;

import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Transactional
@Service("empService")
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<Emp> queryAll(Integer page) {
        Integer rows=3;
        Integer begin=(page-1)*rows;
        List<Emp> emps = empDao.queryAll(begin,rows);
        return emps;
    }

    @Override
    public void delete(String id) {
        empDao.delete(id);
    }

    @Override
    public void insert(Emp emp) {
        emp.setId(UUID.randomUUID().toString());
        empDao.insert(emp);

    }


    @Override
    public void update(Emp emp) {
        empDao.update(emp
        );
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Emp findOne(String id) {
        Emp emp = empDao.findOne(id);
        return emp;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Integer totals() {
        Integer totals = empDao.totals();
        Integer counts=totals%3==0?totals/3:totals/3+1;
        return counts;
    }
}
