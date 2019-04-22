package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//用来修饰类，作用：标志当前是一个springboot的入口类

/*@SpringBootApplication注解等价于
    @configuration:             项目启动配置spring和springmvc的初始搭建
    @EnableAutoConfiguration:   自动与项目中集成的第三方技术进行集成
    @ComponentScan:             扫描入口类所在子包一级子包后代包中的注解
*/
@SpringBootApplication
@MapperScan("com.baizhi.dao")
public class Application {
    public static void main(String[] args) {
        //启动springboot应用
        //参数一：入口类的类对象
        //参数2：主函数的参数
        SpringApplication.run(Application.class,args);
    }
}
