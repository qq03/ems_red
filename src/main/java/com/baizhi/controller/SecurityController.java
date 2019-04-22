package com.baizhi.controller;

import com.baizhi.util.VerifyCodeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
@RequestMapping("securityController")
@Controller
public class SecurityController {
    @RequestMapping("getImage")
    public void getImage(HttpServletRequest request,HttpServletResponse response) throws Exception{
        //1.生成随机字符
        String code = VerifyCodeUtils.generateVerifyCode(4);
        System.out.println();
        //2.将随机字符放入一个图片中
        BufferedImage image = VerifyCodeUtils.getImage(100, 50, code);
        //3.将生成随机字符放入session
       request.getSession().setAttribute("code", code);
        //4.响应图片，获取响应流
        response.setContentType("image/png;charset=UTF-8");
        ServletOutputStream os = response.getOutputStream();
        //5.输出图片
        ImageIO.write(image, "png", os);


    }
}
