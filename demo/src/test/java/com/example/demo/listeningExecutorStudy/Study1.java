package com.example.demo.listeningExecutorStudy;

import com.google.common.util.concurrent.*;

import java.util.Random;
import java.util.concurrent.*;

public class Study1 {
    public static final ListeningExecutorService executorService =
            MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(4,
                    new ThreadFactoryBuilder().setNameFormat("test-%d").build()));

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " start");
        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(Thread.currentThread().getName());
                int k = new Random().nextInt(5000);
                Thread.sleep(k);
                return k;
            }
        };
        ListenableFuture<Integer> listenableFuture = executorService.submit(callable);
        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(Integer integer) {
                System.out.println("onSuccess");
                System.out.println(Thread.currentThread().getName());
                System.out.println(integer);
            }

            @Override
            public void onFailure(Throwable throwable) {

            }
        },executorService);
        System.out.println(Thread.currentThread().getName() + " end");
    }
}

class MyThreadFactory implements ThreadFactory {
    private String threadName;

    public MyThreadFactory(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, threadName);
    }
}
