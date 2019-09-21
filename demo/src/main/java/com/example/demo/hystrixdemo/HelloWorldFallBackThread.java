package com.example.demo.hystrixdemo;

import com.netflix.hystrix.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HelloWorldFallBackThread {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String s = new CommandHelloworldWithFallBackThread(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup1"))
                        .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("threadpoolwithfallback"))
                        .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                                .withCoreSize(3)
                                .withMaximumSize(6)
                                .withAllowMaximumSizeToDivergeFromCoreSize(true))
                        .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                                .withExecutionTimeoutInMilliseconds(1000)
                                .withCircuitBreakerSleepWindowInMilliseconds(5000)
                                .withCircuitBreakerErrorThresholdPercentage(50)
                                .withCircuitBreakerRequestVolumeThreshold(100))
                        , Thread.currentThread().getName()).execute();
                System.out.println(s);
                try {
                    Thread.currentThread().sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int i = 100;
        while (i > 0) {
            executorService.submit(runnable);
/*            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            */
            i--;
        }
        executorService.shutdown();
    }

}
