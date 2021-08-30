package com.cawl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        //启动SpringBoot应用 返回Spring的ioc容器
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);

        //获取bean,redisTemplate
       Object redisTemplate = context.getBean("redisTemplate");
        System.out.println(redisTemplate);

       Object user =  context.getBean("user");
       System.out.println(user);

       String str = "1";
       List<String> list = Optional.of(Arrays.asList(str.split(" ")))
               .orElse(new ArrayList<>())
               .stream()
               .map(String::valueOf)
               .collect(Collectors.toList());;
        System.out.println(list);

    }

}
