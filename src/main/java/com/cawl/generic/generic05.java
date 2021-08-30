package com.cawl.generic;

public class generic05 {
    public static void main(String[] args) {
        Pair<String, Integer> p = new Pair<String, Integer>("cwl", 100);
        System.out.println(p.getKey() + "====" + p.getValue());

        Pair<Integer, Integer> p1 = new Pair<Integer, Integer>(200, 100);
        System.out.println(p1.getKey() + "====" + p1.getValue());

        Apple a = new Apple("abc");
        System.out.println(a.getKey());

    }
}

/**
 * 泛型接口
 *
 * @param <T>
 */
interface Generator<T> {
    T getKey();
}

/**
 * 泛型接口的实现类，是一个泛型类，
 * 那么要保证实现接口的泛型类泛型标识包含泛型接口的泛型标识
 *
 * @param <T>
 * @param <E>
 */
class Pair<T, E> implements Generator<T> {

    private T key;
    private E value;

    public Pair(T key, E value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public T getKey() {
        return key;
    }

    public E getValue() {
        return value;
    }
}

/**
 * 实现泛型接口的类，不是泛型类，需要明确实现泛型接口的数据类型。
 */
class Apple<T> implements Generator<String> {
    private T val;
    public Apple(T val) {
        this.val = val;
    }

    @Override
    public String getKey() {
        return "hello generic";
    }
}