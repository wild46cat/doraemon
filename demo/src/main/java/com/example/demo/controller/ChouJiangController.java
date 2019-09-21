package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/choujiang")
public class ChouJiangController {
    @RequestMapping("/begin")
    public int begin(){
        int res =  (int) (Math.random()*10);
        return res;
    }
}
