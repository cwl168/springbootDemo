package com.cawl.reflect;

//测试class类的创建方式有哪些
public class Reflect02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Student();
        System.out.println("这个人是："+person.name);

        //方式一 通过对象获得
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());

        //方式二 forname 获得
        Class c2 = Class.forName("com.caowl.reflect.Student");
        System.out.println(c2.hashCode());

        //方式三 通过类名.class获得
        Class c3 = Student.class;
        System.out.println(c3.hashCode());
    }
}
class Person {
    public String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Student extends Person {
    public Student() {
        this.name = "学生";
    }
}

class Teacher extends Person{
    public Teacher(String name) {
        this.name = "老师";
    }
}