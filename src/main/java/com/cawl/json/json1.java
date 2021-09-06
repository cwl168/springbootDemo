package com.cawl.json;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class json1 {

    public static void main(String[] args) throws IOException, ParseException {
        //对象转Json
        Person person = new Person();
        person.setName("xiaoming");
        person.setSex("male");
        person.setAge(18);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(person);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        //json转对象
        String json = "{\"name\":\"小民\",\"age\":20,\"birthday\":844099200000,\"email\":\"xiaomin@sina.com\"}";
        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(json, User.class);
        System.out.println(user);

        //json注解u
        User u = new User();
        u.setName("小民");
        u.setEmail("xiaomin@sina.com");
        u.setAge(20);

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(dateformat.parse("1996-10-01"));

        ObjectMapper mr = new ObjectMapper();
        String jsonStr = mr.writeValueAsString(user);
        System.out.println(jsonStr);
    }
}

@Data
class Person{
    private String name;
    private String sex;
    private Integer age;
}
@Data
class User {
    private String name;
    private Integer age;
    @JsonFormat(pattern = "yyyy年MM月dd日",timezone="GMT+8")
    private Date birthday;
    private String email;
}

