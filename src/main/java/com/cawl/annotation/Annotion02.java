package com.cawl.annotation;

import java.lang.annotation.*;

public class Annotion02 {

}
//注解可以用在哪些地方
@Target(value = {ElementType.METHOD,ElementType.TYPE})

//注解在什么地方有效
//runtime>class>sources
@Retention(value = RetentionPolicy.RUNTIME)

//文档生成
@Documented

//子类可以继承父类的注解
@Inherited
@interface MyAnnotion{

}