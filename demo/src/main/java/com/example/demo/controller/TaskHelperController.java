package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/taskHelper")
public class TaskHelperController {
    public static boolean stopFlag = false;

    @RequestMapping("/change")
    public String test(boolean flag) {
        TaskHelperController.stopFlag = flag;
        return "ok";
    }
}
