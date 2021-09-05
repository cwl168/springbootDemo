package com.cawl.generic;

import java.lang.reflect.Method;

/**
 * 桥接方法，保持接口与类的实现关系
 */
public class generic10 {
    public static void main(String[] args) {
        //通过类名获取字节码Class
        Class<InfoImpl> infoClass = InfoImpl.class;
        Method[] declaredMethods = infoClass.getDeclaredMethods();
        //info:Integer
        //info:Object 多了一个Object 方法
        for (Method method : declaredMethods) {
            System.out.println(method.getName() +":"+method.getReturnType().getSimpleName());
        }
    }
}
class InfoImpl implements Info<Integer>{
    @Override
    public Integer info(Integer value) {
        return value;
    }
}

interface Info<T> {
 T info(T t);
}