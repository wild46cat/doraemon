package com.example.demo;


import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Xydemo {
    public static void main(String[] args) {
        System.out.println(123);
        String cc = "oDsTG5cXP_S66Ung-RutSGTd0BPY";
//        String cc = "oDsTG5cXP-S66UngRutSGTd0BPY";

        Pattern JCNUSERID_PATTERN = Pattern.compile("^[\\w|\\-|=]+$");
        boolean matches = JCNUSERID_PATTERN.matcher(cc).matches();
        System.out.println(matches);

        List<String> tmpList = Arrays.asList("aa","bb","cc");
        System.out.println(tmpList);
        List<Object> transform = Lists.transform(tmpList, new Function<String, Object>() {
            @Override
            public Object apply(String s) {
                return s + "aaa";
            }
        });
        System.out.println(transform);

    }
}
