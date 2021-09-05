package com.cawl.generic;

import java.util.ArrayList;

//泛型数组
public class generic11 {
    public static void main(String[] args) {
        //ArrayList<String>[] listArr = new ArrayList<5>();

        ArrayList[] list = new ArrayList[5];
        ArrayList<String>[] listArr = list;
        System.out.println(listArr);

        ArrayList<String>[] listArr2 = new ArrayList[5];
        System.out.println(listArr2);

    }
}
