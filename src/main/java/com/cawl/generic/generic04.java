package com.cawl.generic;

public class generic04 {
    public static void main(String[] args) {
        ChildFirst<String> cf = new ChildFirst<>();
        cf.setValue("bbbb");
        System.out.println(cf.getValue());

        ChildFirst<Integer> cf1 = new ChildFirst<>();
        cf1.setValue(100);
        System.out.println(cf1.getValue());

        System.out.println("-----------------------");
        ChildSecond cf3 = new ChildSecond();
        cf3.setValue(200);
        System.out.println(cf3.getValue());
    }
}

//父类
class Parent<E> {
    private E value;

    public E getValue() {
        return value;
    }

    public void setValue(E value) {
        this.value = value;
    }
}

/**
 * 泛型类派生子类，子类也是泛型类，那么子类的泛型标识要和父类一致。 ChildFirst<T> 与 Parent<T> 一致
 *
 * @param <T>
 */
class ChildFirst<T> extends Parent<T> {
    //@Override
    public T getValue() {
        return super.getValue();
    }


    //继承类为Parent非Parent<T>  类型不一致
    /*@Override
    public Object getValue() {
        return super.getValue();
    }*/
}

/**
 * 泛型类派生子类，如果子类不是泛型类，那么父类要明确数据类型
 */
class ChildSecond extends Parent<Integer> {
    @Override
    public Integer getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Integer value) {
        super.setValue(value);
    }
}

