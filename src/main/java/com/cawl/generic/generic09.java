package com.cawl.generic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

/**
 * 类型擦除
 */
public class generic09 {
    public static void main(String[] args) {

        Erasure<Integer> erasure = new Erasure<>();
        //通配符上限，通过反射获取字节码文件的Class
        Class <? extends  Erasure> cls = erasure.getClass();
        Field[] Fields= cls.getDeclaredFields();

        //类型都是object 而非泛型T标识 出现了无限制类型擦除
        for (Field field : Fields) {
            //System.out.println(field.getName() + ":"+field.getType().getSimpleName());
        }

        //擦除方法中类型定义的参数
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() +":"+method.getReturnType().getSimpleName());
        }

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

