package com.cawl.annotation;

import java.util.ArrayList;

@SuppressWarnings("waring")
public class Annotion01 extends Object {

    //重写注解
    @Override
    public String toString() {
        return super.toString();
    }

    //丢弃，已过时注解
    @Deprecated
    public  void test02() {
        ArrayList list = new ArrayList();
    }

    //抑制编译器产生警告信息
    @SuppressWarnings("all")
    public  void test01() {
        ArrayList list = new ArrayList();
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        System.out.printf("the length is "+String.valueOf(list.size()));
    }
}
