package com.cawl.generic;

import java.util.ArrayList;
import java.util.List;


public class generic07 {
    public static void main(String[] args) {
        ArrayList<Animal> animals =  new ArrayList<>();
        ArrayList<Cat> cats =  new ArrayList<>();
        ArrayList<MiniCat> miniCats =  new ArrayList<>();

        //类型通配符上限
        //showAnimal(animals);
        showAnimal(cats);
        //cats.addAll(animals);
        cats.addAll(cats);
        cats.addAll(miniCats);
        showAnimal(miniCats);


        //类型通配符下限
        showAnimal1(animals);
        showAnimal1(cats);
        //showAnimal1(miniCats);

    }

    /**
     * 泛型上限通配符，只能是Cat或者其子类
     * @param list
     */
    public static void showAnimal(ArrayList<? extends Cat> list){
        //通配符上限 不能填充元素
        //list.add(new Cat());
        for (int i = 0; i < list.size() ; i++) {
            Cat cat= list.get(i);
            System.out.println(cat);

        }
    }

    /**
     * 类型通配符下限 要求集合只能是Cat或Cat的父类类型
     * @param list
     */
    public static void showAnimal1(List<? super Cat> list){
        //通配符下限 能填充元素
        list.add(new Cat());
        list.add(new MiniCat());
        for (Object o :list) {
            System.out.println(o);
        }
    }

}
class Animal{}
class Cat extends Animal{}
class MiniCat extends Cat{}