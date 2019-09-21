package com.example.demo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListApp {
    public static void main(String[] args) {
        Student student = new Student.Builder()
                .setName("aa")
                .setAddress("csdfsdf")
                .setAge(12)
                .addHobbies("dsfsdf")
                .build();
        Student student2 = new Student.Builder()
                .setName("addfa")
                .setAddress("csdfsdf")
                .setAge(12)
                .addHobbies("dsfsdf")
                .build();
        List<Student> list = new ArrayList<>();
        list.add(student);
        list.add(student2);
        Iterator<Student> iterator = list.iterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.getName().equals("aa")) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}

