package com.xueyou.dubbo.demo.consumerxml;

import com.xueyou.dubbo.demo.IGreetingsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Application {
    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws IOException {
        log.info("consume start");
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/dubbo-consumer.xml");
        context.start();
        IGreetingsService greetingService = (IGreetingsService) context.getBean("greetingService");
        String res = greetingService.sayHello("dubbo consumer");
        log.info(res);
        System.in.read();
    }

}
