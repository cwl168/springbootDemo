package com.cawl.generic;

import lombok.Data;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 类型擦除
 */
public class generic09 {
    public static void main(String[] args) {
        //泛型擦除造成两者的相等，都会转化为ArrayList
        List<String> l1 = new ArrayList<String>();
        List<Integer> l2 = new ArrayList<Integer>();
        System.out.println(l1.getClass() == l2.getClass());

        System.out.println("================");

        Erasure2<Integer> erasure2 = new Erasure2<>();
        erasure2.setKey(100);
        System.out.println(erasure2.getKey()+ ":"+ getType(erasure2.getKey()));
        //通配符上限，通过反射获取字节码文件的Class
        Class <? extends  Erasure2> cls2 = erasure2.getClass();
        Field[] Fields= cls2.getDeclaredFields();

        //类型都是object 而非泛型T标识 出现了无限制类型擦除
        for (Field field : Fields) {
            System.out.println(field.getName() + ":"+field.getType().getSimpleName());
        }
        System.out.println("================");
        //擦除方法中类型定义的参数
        Erasure<Integer> erasure = new Erasure<>();
        //通配符上限，通过反射获取字节码文件的Class
        Class <? extends  Erasure> cls = erasure.getClass();
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() +":"+method.getReturnType().getSimpleName());
        }

    }
    public static String getType(Object o){ //获取变量类型方法
        return o.getClass().toString(); //使用int类型的getClass()方法
    }
}
class Erasure2<T> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }
}

class Erasure<T extends  Number> {
    private T key;

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    /**
     * 泛型方法
     * @param t
     * @param <T>
     * @return
     */
    public <T extends List> T show(T t) {
        return t;
    }
}

