package com.cawl.reflect;

class Reflect1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c1 = Class.forName("com.caowl.reflect.User");
        System.out.println("args = " + c1);


        //获取类名  Class.forName
        Class c2 = Class.forName("com.caowl.reflect.User");
        Class c3 = Class.forName("com.caowl.reflect.User");

        //都是同一个类
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c3.hashCode());

    }
}


class User {
    private int Id;
    private String Name;
    private int age;
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


}