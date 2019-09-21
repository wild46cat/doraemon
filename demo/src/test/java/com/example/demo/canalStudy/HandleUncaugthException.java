package com.example.demo.canalStudy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HandleUncaugthException {
    private static final Logger logger = LoggerFactory.getLogger(HandleUncaugthException.class.getSimpleName());

    public static void main(String[] args) {
        System.out.println("print begin program ...");
        setGlobalUncaughtExceptionHandler();
        int a = 10 / 0;
        System.out.println(a);
    }

    private static void setGlobalUncaughtExceptionHandler() {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                logger.error("UnCaughtException", e);
            }
        });
    }
}
