package com.example.demo.task;


import com.example.demo.controller.TaskHelperController;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {
//    @Scheduled(cron = "0/5 * * * * ?")
    public void test() {
        Thread thread = new Thread(new Exetask());
        thread.start();
        System.out.println(thread.getName() + "===============begin" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
    }

    class Exetask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                try {
                    if (TaskHelperController.stopFlag) {
                        throw new InterruptedException();
                    }
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName() + "   " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()));
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "  stop!!!");
                    break;
                }
            }
        }
    }

}
