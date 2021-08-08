package com.cawl.generic;

import java.util.ArrayList;
import java.util.Random;

public class generic03 {
    public static void main(String[] args) {
        //成员方法，返回值泛型
        ProductGetter<String> pg = new ProductGetter<>();
        String[] strList = {"苹果手机", "华为手机", "小米手机"};
        for (String s : strList) {
            pg.addProduct(s);
        }
        String s = pg.getProduct();
        System.out.println(s + "\t" + s.getClass().getSimpleName());
        System.out.println("-----------------------");

        //泛型方法
        ProductGetter<String> pg2 = new ProductGetter<>();
        ArrayList<String> strList2 = new ArrayList<>();
        strList2.add("苹果手机");
        strList2.add("华为手机");
        strList2.add("小米手机");
        //泛型方法调用
        String s1 = pg2.getProduct(strList2);
        System.out.println(s1 + "\t" + s1.getClass().getSimpleName());

        ArrayList<Integer> intList2 = new ArrayList<>();
        intList2.add(100);
        intList2.add(200);
        intList2.add(300);
        //泛型方法调用
        String s2 = pg2.getProduct(strList2);
        System.out.println(s2 + "\t" + s2.getClass().getSimpleName());

        System.out.println("-----------------------");
        //调用多个泛型类型的静态泛型方法
        ProductGetter.printType(130, "java", true);
        ProductGetter.printType(true, false, true);


    }
}


class ProductGetter<T> {
    //奖品
    private T product;

    Random random = new Random();
    //奖品池
    ArrayList<T> list = new ArrayList<>();

    public void addProduct(T t) {
        list.add(t);
    }

    /**
     * 成员方法，返回值采用泛型
     *
     * @return
     */
    public T getProduct() {
        return list.get(random.nextInt(list.size()));
    }

    /**
     * 定义泛型方法
     *
     * @param list 参数
     * @param <E>  泛型表示 ，具体类型，由调用方法的时候来指定
     * @return
     */
    public <E> E getProduct(ArrayList<E> list) {
        return list.get(random.nextInt(list.size()));
    }

    /**
     * 静态的泛型方法，采用多个泛型类型
     *
     * @param t
     * @param e
     * @param k
     * @param <T>
     * @param <E>
     * @param <K>
     */
    public static <T, E, K> void printType(T t, E e, K k) {
        System.out.println(t + "\t" + t.getClass().getSimpleName());
        System.out.println(e + "\t" + e.getClass().getSimpleName());
        System.out.println(k + "\t" + k.getClass().getSimpleName());
    }

}