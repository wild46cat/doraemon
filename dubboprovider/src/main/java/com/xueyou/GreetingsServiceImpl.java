package com.xueyou;

public class GreetingsServiceImpl implements GreetingsService {
    @Override
    public String sayHello(String name) {
        String res = String.format("i am %s", name);
        System.out.println(res);
        return res;
    }
}
