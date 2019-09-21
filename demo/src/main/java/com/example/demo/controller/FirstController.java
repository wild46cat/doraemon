package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;


@RestController
@RequestMapping("/api")
public class FirstController {
    Logger logger = LoggerFactory.getLogger(FirstController.class.getName());

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    @RequestMapping("/myReplyPost")
    public String myReplyPost() {
        return "aabbccdd";
    }

    @RequestMapping("/getMenu")
    public String getMenu() {
        return "getmenu";
    }

    @RequestMapping(value = "/aaapost", method = RequestMethod.POST)
    public String aaaPost(Student stu, String cc) {
        return stu.getAge() + cc;
    }

}

class Student implements Serializable {
    private int name;
    private String age;


    public Student() {
    }

    public Student(int name, String age) {
        this.name = name;
        this.age = age;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}