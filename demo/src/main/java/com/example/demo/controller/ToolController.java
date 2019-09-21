package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@RestController
@RequestMapping("/tool")
public class ToolController {
    @RequestMapping("/encoder")
    public String selefUrlEncodeing(String key) {
        String s1 = null;
        try {
            s1 = URLEncoder.encode(key, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println(s1);
        return s1;
    }
}
