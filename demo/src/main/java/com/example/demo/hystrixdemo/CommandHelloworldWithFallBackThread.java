package com.example.demo.hystrixdemo;

import com.netflix.hystrix.HystrixCommand;


public class CommandHelloworldWithFallBackThread extends HystrixCommand<String> {
    private String name;
    private int timeIndex;

    public CommandHelloworldWithFallBackThread(Setter setter, String name) {
        super(setter);
        this.name = name;
    }

    @Override
    protected String getFallback() {
        return "fall back " + name;
    }

    @Override
    protected String run() {
        try {
            Thread.currentThread().sleep(400);
        } catch (InterruptedException e) {
        }
        return "ok " + name;
    }

}
