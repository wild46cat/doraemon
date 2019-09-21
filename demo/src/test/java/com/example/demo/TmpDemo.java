package com.example.demo;

import java.util.List;

public class TmpDemo {
    public static void main(String[] args) {
        for (int i = 1; i <= 2; i++) {
            System.out.println(i);
        }
    }
}


class ExpectCaculate {
    private static int[] money = {1, 2};
    private double p = 0;
    public static double[] realprobablity;

    public ExpectCaculate(double p) {
        this.p = p;
        realprobablity = new double[3];
        realprobablity[0] = 0;
        realprobablity[1] = 2 - p;
        realprobablity[2] = p - 1;
    }

    public int runLuckyMachine() {
        double k = Math.random();
        int res = 1;
        double vp = realprobablity[0];
        double vn = realprobablity[1];
        if (vp <= k && k < vn) {
            res = money[0];
        } else {
            res = money[1];
        }
        return res;
    }
}