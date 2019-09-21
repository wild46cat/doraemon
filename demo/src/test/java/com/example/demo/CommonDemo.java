package com.example.demo;

import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Random;

public class CommonDemo {
    public static void main(String[] args) {
        List<String> posts = null;
        System.out.println(CollectionUtils.isEmpty(posts));
        for (String post : posts) {
            System.out.println(post);
        }
    }
}
