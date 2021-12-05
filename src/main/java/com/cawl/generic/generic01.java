package com.cawl.generic;

import java.util.ArrayList;
import java.util.List;

//泛型 类型参数化
public class generic01 {
    public static void main(String[] args) {
        //非泛型版
        /*List list = new ArrayList();
        list.add("qqyumidi");
        list.add("cwl");
        list.add(100);//ClassCastException错误
        for (int i = 0; i < list.size(); i++) {
            String name = (String) list.get(i);
            System.out.println("name:" + name);
        }*/

        //泛型版
        List<String> l = new ArrayList<String>();
        l.add("aaaa");

        //编译期间，检查类型不通过，避免classCastException
        //减少数据类型的转化
        //l.add(100);
        for (int i = 0; i < l.size(); i++) {
            String name = l.get(i);
            System.out.println("name:" + name);
        }
    }
}
