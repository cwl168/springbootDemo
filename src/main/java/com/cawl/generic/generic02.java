package com.cawl.generic;

//泛型类
public class generic02 {
    public static void main(String[] args) {
        //1 泛型类在创建对象的时候，来指定操作的具体数据类型，
        Generic<String> strGeneric = new Generic<>("cwl");
        String s = strGeneric.getKey();
        System.out.println(s);

        Generic<Integer> intGeneric = new Generic<>(100);
        Integer i = intGeneric.getKey();
        System.out.println(i);

        //没有指定类型将按照Object类型
        Generic str1 = new Generic("lin");
        Object st = str1.getKey();
        System.out.println(st);

        //2 泛型类 不支持基本数据类型
        //Generic<int> in = new Generic<int>(100);

        //3 同一泛型类，根据不同的数据类型创建的对象，本质上是同一类型
        System.out.println(strGeneric.getClass() == intGeneric.getClass());

    }
}


class Generic<T> {

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Generic{" +
                "key=" + key +
                '}';
    }
}
