package com.example.demo.forkjoinpooltest;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

public class AggPicTask {
    public static void log(String msg) {
        System.err.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()) + "  " + msg);
    }

    public static class GenPicTask extends ForkJoinTask<String> {
        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public GenPicTask(String result) {
            this.result = result;
        }

        private String result;

        @Override
        public String getRawResult() {
            return result;
        }

        @Override
        protected void setRawResult(String value) {

        }

        @Override
        protected boolean exec() {
            log("begin exec " + result);
            result += String.valueOf(new Random().nextInt());
            try {
//                Thread.sleep(2000 + new Random().nextInt(1000));
                Thread.sleep(2000);
            } catch (Exception ex) {

            }
            log("end exec " + result);
            return true;
        }
    }


    public void compute(ForkJoinPool pool) {
        log("begin");
        GenPicTask t1 = new GenPicTask("aaa");
        GenPicTask t2 = new GenPicTask("bbb");
        GenPicTask t3 = new GenPicTask("ccc");
        log("taskgen");
        pool.submit(t1);
        pool.submit(t2);
        pool.submit(t3);

        log("tasksubmit");

        log("t1 begin join");
        System.err.println(t1.join());
        log("t1 join");
        System.err.println(t2.join());
        log("t2 join");
        System.err.println(t3.join());
        log("t3 join");
        log("total end");
        log(t1.getResult());
        log(t2.getResult());
        log(t3.getResult());

    }

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        AggPicTask t = new AggPicTask();
        t.compute(pool);

    }
}
