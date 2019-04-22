package com.baizhi.controller;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("emp")
public class EmpController {
    @Autowired
    private EmpService empService;
    @RequestMapping("findAll")
    public String findAll(HttpServletRequest request, Integer page){
        page=page==null?1:page;
        List<Emp> emps = empService.queryAll(page);
        Integer totals = empService.totals();
        System.out.println(totals);
        request.setAttribute("emps",emps);
        request.setAttribute("totals",totals);
        return "emplist";
    }
    @RequestMapping("insert")
    public String insert(Emp emp){
        empService.insert(emp);
        return "redirect:/emp/findAll";
    }

    @RequestMapping("update")
    public String update(Emp emp){
        empService.update(emp);
        return "redirect:/emp/findAll";
    }
    @RequestMapping("delete")
    public String delete(String id){
        empService.delete(id);
        return "redirect:/emp/findAll";
    }
    @RequestMapping("findOne")
    public String findOne(String id,Model model){
        Emp emp = empService.findOne(id);
        model.addAttribute("emp",emp);
        return "updateEmp";
    }

}
