package com.example.demo.controller;

import com.xueyou.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/namespacetest")
public class NamespaceController {

    @Resource(name = "user2")
    private User user;

    @RequestMapping("/user")
    public User namespacetest() {
        return user;
    }
}
