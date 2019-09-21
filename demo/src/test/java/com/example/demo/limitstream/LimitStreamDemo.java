package com.example.demo.limitstream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class LimitStreamDemo {
    private static Logger logger = LoggerFactory.getLogger(LimitStreamDemo.class.getName());
    private static final int QUEUE_SIZE = 5;
    private static BlockingQueue queue = new ArrayBlockingQueue(QUEUE_SIZE);
    private static Runnable addToken;
    private static Runnable limitRun;

    static {
        addToken = new Runnable() {
            @Override
            public void run() {
                queue.offer(1);
                logger.info("{} add token.queue size is {}", Thread.currentThread().getName(), queue.size());
            }
        };
        limitRun = new Runnable() {
            @Override
            public void run() {
                try {
                    logger.info("{} run.queue size is {}", Thread.currentThread().getName(), queue.size());
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }


    public static void main(String[] args) {
        System.out.println(queue.size());
        ScheduledExecutorService pool1 = Executors.newScheduledThreadPool(3);

        pool1.scheduleAtFixedRate(addToken, 0, 2, TimeUnit.SECONDS);
        ScheduledExecutorService pool2 = Executors.newScheduledThreadPool(3);
        pool2.scheduleAtFixedRate(limitRun, 0, 1, TimeUnit.SECONDS);
    }
}
