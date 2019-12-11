package com.xueyou.dubbo.providerxml;

import com.xueyou.dubbo.demo.IGreetingsService;

public class GreetingsServiceImpl implements IGreetingsService {
    public String sayHello(String name) {
        String res = String.format("i am %s", name);
        System.out.println(res);
        return res;
    }
}
