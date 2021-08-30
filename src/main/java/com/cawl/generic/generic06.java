package com.cawl.generic;

/**
 * 泛型通配符
 */
public class generic06 {

    public static void main(String[] args) {

        Box<Number> box1 = new Box<>();
        box1.setFirst(100);
        showBox(box1);

        Box<Integer> box2 = new Box<>();
        box2.setFirst(200);
        showBox(box2);

    }

    //通配符上限 传Number和Integer类型(Integer继承Number)
    public static void showBox(Box<? extends Number> box) {
        Number first = box.getFirst();
        System.out.println(first);
    }

    //泛型通配符  Box<?> box
    /*public static void showBox(Box<?> box) {
        Object first = box.getFirst();
        System.out.println(first);
    }*/

    /* Integer虽然继承Number类型，但是泛型不能通过多态和继承理解  Box<Object> box
    public static void showBox(Box<Number> box) {
        Number first = box.getFirst();
        System.out.println(first);
    }
    //并非方法重载 Box<Number> 与 Box<Integer>都为Box类型
    public static void showBox(Box<Integer> box) {
        Number first = box.getFirst();
        System.out.println(first);
    }
    */
}

class Box<E> {
    private E first;

    public E getFirst() {
        return first;
    }

    public void setFirst(E first) {
        this.first = first;
    }
}