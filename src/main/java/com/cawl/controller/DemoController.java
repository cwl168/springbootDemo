package com.cawl.controller;

import com.cawl.mybatis.domain.User;
import com.cawl.mybatis.mapper.UserMapper;
import com.cawl.domain.Person;
import com.cawl.mybatis.mapper.UserXmlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 *  springboot 读取配置三种方式：
 *  1 @value
 *  2 Environment 对象
 *  3 ConfigurationProperties 对象与属性绑定
 */
@RestController
public class DemoController {
    @Value("${name}")
    private String name;

    @Value("${person.name}")
    private String name2;

    @Value("${person.age}")
    private int age;

    @Value("${address[0]}")
    private String address;

    @Value("${msg1}")
    private String msg1;

    @Value("${msg2}")
    private String msg2;

    @Autowired
    private Environment env;

    @Autowired
    private Person person;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserXmlMapper userXmlMapper;

    @RequestMapping("/demo")
    public String hello(){
        System.out.println(name);
        System.out.println(name2);
        System.out.println(age);
        System.out.println(address);
        System.out.println(msg1);
        System.out.println(msg2);

        System.out.println("---------");
        System.out.println(env.getProperty("person.age"));

        System.out.println("---------");
        System.out.println(person);


        //mybatis基于注解的映射
        List<User> list = userMapper.findAll();
        System.out.println(list);

        //mybatis基于注解的映射
        List<User> list2 = userXmlMapper.findAll();
        System.out.println(list2);


        return "demor!";
    }
}
