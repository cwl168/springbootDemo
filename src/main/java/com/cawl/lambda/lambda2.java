package com.cawl.lambda;

import java.util.Arrays;
import java.util.List;

public class lambda2 {
    public static void main(String[] args) {
        char[] chars;
        List<String> words = Arrays.asList("hello", "word");
        for (String word : words) {
            char[] char1 = word.toCharArray();
            for (char c : char1) {
                System.out.println(c);
            }
        }

        //用map方法是做不到的，这个需求用map方法无法实现。map只能针对一维数组进行操作
        words.stream()
                .map(w -> Arrays.stream(w.split("")))
                .forEach(System.out::println);

        //flatMap可以理解为将若干个子管道中的数据全都，平面展开到父管道中进行处理。
        words.stream()
                .flatMap(w -> Arrays.stream(w.split(""))) // [h,e,l,l,o,w,o,r,l,d]
                .forEach(System.out::println);
    }
}
