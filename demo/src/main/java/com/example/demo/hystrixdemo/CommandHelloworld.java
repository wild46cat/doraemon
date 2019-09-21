package com.example.demo.hystrixdemo;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

public class CommandHelloworld extends HystrixCommand<String> {
    private String name;

    public CommandHelloworld(HystrixCommandGroupKey group, String name) {
        super(group);
        this.name = name;
    }

    public CommandHelloworld(Setter setter, String name) {
        super(setter);
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "hello " + name;
    }
}
