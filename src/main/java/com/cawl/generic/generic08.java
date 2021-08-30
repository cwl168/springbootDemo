package com.cawl.generic;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 通配符下限  只能是实参类型，或实参类型的父类类型
 */
public class generic08 {
    public static void main(String[] args) {
        //只能传  new Compare2() 和 new Compare1()
        //TreeSet<Cat1> treeSet = new TreeSet<>(new Compare2());
        TreeSet<Cat1> treeSet = new TreeSet<>(new Compare1());
        treeSet.add(new Cat1("aaa",20));
        treeSet.add(new Cat1("bbb",22));
        treeSet.add(new Cat1("ccc",35));
        treeSet.add(new Cat1("ddd",14));
        treeSet.add(new Cat1("eee",18));

        for (Cat1 cat1 : treeSet) {
            System.out.println(cat1);
        }

        System.out.println("------------------");

        // 可传 new Compare2()，new Compare1()，new Compare3()
        TreeSet<MiniCat1> treeSet1 = new TreeSet<>(new Compare3());
        //TreeSet<MiniCat1> treeSet1 = new TreeSet<>(new Compare3());
        //TreeSet<MiniCat1> treeSet1 = new TreeSet<>(new Compare3());
        treeSet1.add(new MiniCat1("aaa",20,1));
        treeSet1.add(new MiniCat1("bbb",17,3));
        treeSet1.add(new MiniCat1("ccc",22,2));
        treeSet1.add(new MiniCat1("ddd",15,6));
        for (MiniCat1 miniCat1 : treeSet1) {
            System.out.println(miniCat1);
        }
    }
}

class Compare1 implements Comparator<Animal1> {

    @Override
    public int compare(Animal1 o1, Animal1 o2) {
        return o1.name.compareTo(o2.name);
    }
}
class Compare2 implements Comparator<Cat1>{

    @Override
    public int compare(Cat1 o1, Cat1 o2) {
        return o1.age-o2.age;
    }
}
class Compare3 implements Comparator<MiniCat1>{

    @Override
    public int compare(MiniCat1 o1, MiniCat1 o2) {
        return o1.level-o2.level;
    }
}
class Animal1{
    public String name;

    public Animal1(String name) {

        this.name = name;
    }

    @Override
    public String toString() {
        return "Animal1{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Cat1 extends Animal1{
    public int age;

    public Cat1(String name, int age) {
        super(name);
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class MiniCat1 extends Cat1{
    public int level;

    public MiniCat1(String name, int age, int level) {
        super(name, age);
        this.level = level;
    }

    @Override
    public String toString() {
        return "MiniCat1{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                '}';
    }
}