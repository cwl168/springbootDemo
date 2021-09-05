package com.cawl.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class lambda1 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("hello", "word");
        System.out.println(words);
        words.stream()
                .map(w -> Arrays.stream(w.split("")))    //[[h,e,l,l,o],[w,o,r,l,d]]
                .forEach(System.out::println);

        words.stream()
                .flatMap(w -> Arrays.stream(w.split(""))) // [h,e,l,l,o,w,o,r,l,d]
                .forEach(System.out::println);


        //flatMap可以理解为将若干个子管道中的数据全都，平面展开到父管道中进行处理。
        String[] arr1 = {"a", "b", "c", "d", "e", "f"};
        List<String> listA = new ArrayList<>(Arrays.asList(arr1));

        String[] arr2 = {"d", "e", "f", "g", "h"};
        List<String> listB = new ArrayList<>(Arrays.asList(arr2));

        List<String> collect = Stream.of(listA, listB)
                .flatMap(Collection::stream)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(collect);


        //并行处理
        Stream.of("Monkey", "Lion", "Giraffe", "Lemur", "Lion")
                .parallel()
                .forEach(System.out::println);

    }
}

