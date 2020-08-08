package com.company;

import java.util.List;

public class Student {
    String name;
    int age;
    List<Integer> grades;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void present(){
        System.out.println("Je suis " + this.name);
    }

}
