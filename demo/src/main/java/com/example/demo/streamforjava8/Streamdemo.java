package com.example.demo.streamforjava8;

import org.apache.commons.lang.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streamdemo {
    public static List<Map<String, Object>> mapList = new ArrayList<>();
    public static List<Map<String, Object>> mapList2 = new ArrayList<>();

    public static void init() {
        Map<String, Object> m = new HashMap<>();
        m.put("id", 123);
        m.put("name", 222);
        mapList.add(m);
        Map<String, Object> n = new HashMap<>();
        n.put("id", 1);
        n.put("name", "sdfdf");
        mapList.add(n);

        Map<String, Object> k = new HashMap<>();
        k.put("id", 1);
        k.put("content", "内容详细");
        mapList2.add(k);
        Map<String, Object> l = new HashMap<>();
        l.put("id", 3);
        l.put("content", "内容详细2");
        mapList2.add(l);
    }

    public static boolean streamContains(List<Map<String, Object>> mapList, Object id) {
        return mapList.stream().filter(x -> {
            Object id1 = x.get("id");
            if (id1 == null || id == null) {
                return false;
            } else {
                return StringUtils.equals(String.valueOf(id1), String.valueOf(id));
            }
        }).count() > 0;
    }

    public static Optional<Object> streamConvert(List<Map<String, Object>> mapList, Object id) {
        Optional<Object> content = mapList.stream().filter(x -> {
            Object id1 = x.get("id");
            if (id1 == null || id == null) {
                return false;
            } else {
                return StringUtils.equals(String.valueOf(id1), String.valueOf(id));
            }
        }).map(x -> {
            return x.get("content");
        }).findFirst();
        return content;
    }

    public static void main(String[] args) {
        init();
        System.out.println(mapList);
        System.out.println(mapList2);
        List<Map<String, Object>> mapsRes = mapList.stream().filter(m -> {
            return streamContains(mapList2, m.get("id"));
        }).map(x -> {
            x.put("content", streamConvert(mapList2, x.get("id")).get());
            return x;
        }).collect(Collectors.toList());

        System.out.println(mapsRes);

        List<Integer> c = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7);
        System.out.println(c.subList(0,2));
        System.out.println(c.subList(2,4));
        System.out.println(c.subList(4,6));
    }
}
