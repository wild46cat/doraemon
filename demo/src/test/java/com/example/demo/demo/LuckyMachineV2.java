package com.example.demo.demo;

import java.util.*;

public class LuckyMachineV2 {
    private static Integer[][] valueArray = {{40, 60}, {61, 88}, {89, 94}, {95, 99}};
    private static double[] probablity = {0.15, 0.3, 0.4, 0.15};
    private static double[] realprobablity;

    static {
        realprobablity = new double[probablity.length + 1];
        realprobablity[0] = 0;
        for (int i = 1; i < realprobablity.length; i++) {
            realprobablity[i] = realprobablity[i - 1] + probablity[i - 1];
        }
    }

    public static List<Integer> runLuckyMachine() {
        double k = Math.random();
        Integer[] res = null;
        int type = 0;
        for (int i = 0; i < realprobablity.length - 1; i++) {
            double vp = realprobablity[i];
            double vn = realprobablity[i + 1];
            if (vp <= k && k < vn) {
                type = i;
                res = valueArray[i];
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        if (res != null) {
            list = new ArrayList<>(Arrays.asList(res));
            list.add(type);
        }
        return list;
    }

    public static int runLuckMachine() {
        List<Integer> list = runLuckyMachine();
        int r1 = (int) (Math.random() * (list.get(1) - list.get(0))) + list.get(0);
        return r1;
    }

    public static void main(String[] args) {
        Set<Integer> typeSet = new HashSet<>();
        typeSet.add(0);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        List<Integer> list4 = new ArrayList<>();
        while (typeSet.size() == 1) {
            typeSet.clear();
            list1.clear();
            list2.clear();
            list3.clear();
            list4.clear();
            list1 = runLuckyMachine();
            list2 = runLuckyMachine();
            list3 = runLuckyMachine();
            list4 = runLuckyMachine();
            System.out.println(list1);
            System.out.println(list2);
            System.out.println(list3);
            System.out.println(list4);
            typeSet.add(list1.get(2));
            typeSet.add(list2.get(2));
            typeSet.add(list3.get(2));
            typeSet.add(list4.get(2));
            System.out.println("typeSet is " + typeSet);
        }
        int r1 = (int) (Math.random() * (list1.get(1) - list1.get(0))) + list1.get(0);
        int r2 = (int) (Math.random() * (list2.get(1) - list2.get(0))) + list2.get(0);
        int r3 = (int) (Math.random() * (list3.get(1) - list3.get(0))) + list3.get(0);
        int r4 = (int) (Math.random() * (list4.get(1) - list4.get(0))) + list4.get(0);
        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);
        System.out.println(r4);
        System.out.println("================");
        System.out.println(runLuckMachine())
        ;
    }

}
