package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("admin")
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @RequestMapping("login")
    @ResponseBody
    public Map<String,Object> login(Admin admin, HttpServletRequest request){
        System.out.println(admin);
        HashMap<String, Object> map = new HashMap<>();
        try{
            Admin login = adminService.login(admin);
            request.getSession().setAttribute("login",login);
            map.put("success",true);
        }catch (Exception e){
            map.put("success",false);
            map.put("message",e.getMessage());
        }
        return map;
    }
    @RequestMapping("insert")
    public String insert(Admin admin,String number,HttpServletRequest request){
        String code = (String) request.getSession().getAttribute("code");
        if(number.equalsIgnoreCase(code)){
            if(admin.getSex().equals("f")){
                admin.setSex("男");
            }else{
                admin.setSex("女");
            }
            System.out.println(admin);
            adminService.insert(admin);
            return "login";
        }else{
            return "regist";
        }


    }
}
