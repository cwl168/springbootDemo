package com.cawl.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class lambda3 {
    public static void main(String[] args) {
        List<String> cities = Arrays.asList(
                "Milan",
                "london",
                "San Francisco",
                "Tokyo",
                "New Delhi"
        );

        //字母自然顺序排序
        cities.sort(Comparator.naturalOrder());
        System.out.println(cities);

        //cities.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);



        Employee e1 = new Employee(1,23,"M","Rick","Beethovan");
        Employee e2 = new Employee(2,13,"F","Martina","Hengis");
        Employee e3 = new Employee(3,43,"M","Ricky","Martin");
        Employee e4 = new Employee(4,26,"M","Jon","Lowman");
        Employee e5 = new Employee(5,19,"F","Cristine","Maria");
        Employee e6 = new Employee(6,15,"M","David","Feezor");
        Employee e7 = new Employee(7,68,"F","Melissa","Roy");
        Employee e8 = new Employee(8,79,"M","Alex","Gussin");
        Employee e9 = new Employee(9,15,"F","Neetu","Singh");
        Employee e10 = new Employee(10,45,"M","Naveen","Jain");


        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);
        //age升序
        //employees.stream().sorted(Comparator.comparing(Employee::getAge)).forEach(System.out::println);
        //age倒序
        //employees.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).forEach(System.out::println);


        //都是正序 ，不加reversed
        //都是倒序，最后面加一个reserved
        //先是倒序（加reserved），然后正序
        //先是正序（加reserved），然后倒序（加reserved）

        /*employees.stream().sorted(Comparator.comparing(Employee::getGender).reversed()
                .thenComparing(Employee::getAge)
                .reversed()).forEach(System.out::println);*/


        employees.stream().sorted(new Comparator<Employee>() {
            @Override
            public int compare(Employee em1, Employee em2) {
                if(em1.getAge() == em2.getAge()){
                    return 0;
                }
                return em1.getAge() - em2.getAge() > 0 ? -1:1;
            }
        }).forEach(System.out::println);






    }
}


@Data
@AllArgsConstructor
class Employee {

    private Integer id;
    private Integer age;   //年龄
    private String gender;  //性别
    private String firstName;
    private String lastName;
}