package com.example.demo.controller;

import com.example.demo.hystrixdemo.CommandHelloworld;
import com.example.demo.hystrixdemo.CommandHelloworldWithFallBack;
import com.netflix.hystrix.*;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Servlet;

@RestController
@RequestMapping("/hystrix")
public class HystrixController {
    @Autowired
    private HystrixMetricsStreamServlet hystrixMetricsStreamServlet;

    @RequestMapping("/first")
    public String cc() {
        String s = new CommandHelloworld(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"), "aaabbbccc").execute();
        return s;
    }

    @RequestMapping("/fallbacktest")
    public String fallbackTest() {
        int count = 0;
        while (count < 100) {
            String s = new CommandHelloworldWithFallBack(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                    .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("threadpoolwithfallback"))
                    .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                            .withCoreSize(10)
                            .withMaximumSize(10))
                    .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                            .withExecutionTimeoutInMilliseconds(1000)
                            .withCircuitBreakerSleepWindowInMilliseconds(5000)
                            .withCircuitBreakerErrorThresholdPercentage(50)
                            .withCircuitBreakerRequestVolumeThreshold(1))
                    , "ccc" + count, count % 20).execute();
            System.out.println(s);
            count++;
            try {
                Thread.currentThread().sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
            }
        }
        return "ok finish";
    }

}
