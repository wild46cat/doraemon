package com.example.demo.hystrixdemo;


import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;

public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(123);
        String result = new CommandHelloworld(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"), "aaabbbccc").execute();
        String result2 = new CommandHelloworld(HystrixCommandGroupKey.Factory.asKey("ExampleGroup2"), "123sss").execute();
        System.out.println(result);
        System.out.println(result2);

        String s = new CommandHelloworld(HystrixCommand.Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("threadpool2"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(500))
                , "ccc").execute();
        System.out.println(s);
    }

}
