package com.example.demo.demo;

public class LuckyMachine {
    private static int[] money = {8, 5, 3, 2};
    private static double[] probablity = {0.02, 0.03, 0.05, 0.9};
    public static double[] realprobablity;

    static {
        realprobablity = new double[probablity.length + 1];
        realprobablity[0] = 0;
        for (int i = 1; i < realprobablity.length; i++) {
            realprobablity[i] = realprobablity[i - 1] + probablity[i - 1];
        }
    }

    public static int runLuckyMachine() {
        double k = Math.random();
        System.out.println(k);
        int res = 0;
        for (int i = 0; i < realprobablity.length - 1; i++) {
            double vp = realprobablity[i];
            double vn = realprobablity[i + 1];
            if (vp <= k && k < vn) {
                res = money[i];
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < realprobablity.length; i++) {
            double v = realprobablity[i];
            System.out.println(v);
        }
        System.out.println("=====================");
        int a1 = 0;
        int a2 = 0;
        int a3 = 0;
        int a4 = 0;
        for (int i = 0; i < 1000000; i++) {
            int tmp = runLuckyMachine();
            System.out.println(tmp);
            if (tmp == 2) {
                a1++;
            }
            if (tmp == 3) {
                a2++;
            }
            if (tmp == 5) {
                a3++;
            }
            if (tmp == 8) {
                a4++;
            }
        }
        System.out.println("a1:" + a1);
        System.out.println("a2:" + a2);
        System.out.println("a3:" + a3);
        System.out.println("a4:" + a4);
    }

}
