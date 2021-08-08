package com.cawl.annotation;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class Annotion03 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.caowl.annotion.Student2");

        //通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotatio : annotations) {
            System.out.println(annotatio);
        }

        //获得注解的value的值
        TableCaowl tabelcaowl = (TableCaowl) c1.getAnnotation(TableCaowl.class);
        String value = tabelcaowl.value();
        System.out.println(value);

        //获得类指定的注解
        Field f = c1.getDeclaredField("name");
        FieldCaowl anotation = f.getAnnotation(FieldCaowl.class);
        System.out.println(anotation.columnName());
        System.out.println(anotation.type());
        System.out.println(anotation.length());



    }
}

@TableCaowl("db_student")
class Student2 {
    @FieldCaowl(columnName = "id", type = "int", length = 10)
    private int id;
    @FieldCaowl(columnName = "age", type = "int", length = 3)
    private int age;
    @FieldCaowl(columnName = "name", type = "varchar", length = 30)
    private String name;


    public Student2() {
    }

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//类名注解
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableCaowl {
    String value();
}

//属性的注解
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldCaowl {
    String columnName();

    String type();

    int length();
}
