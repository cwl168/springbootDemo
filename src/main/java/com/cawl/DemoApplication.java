package com.cawl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //启动SpringBoot应用 返回Spring的ioc容器
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        //获取bean,redisTemplate
       /* Object redisTemplate = context.getBean("redisTemplate");
        System.out.println(redisTemplate);*/

       Object user =  context.getBean("user");
        System.out.println(user);


    }

}
