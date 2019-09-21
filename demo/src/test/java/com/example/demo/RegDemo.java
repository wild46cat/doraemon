package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegDemo {
    public static void main(String[] args) {
        String tmpfilePath = "http://www.baidu.com?aa=123&bb=123&ip=324fdsf&ddd=324&kkjk=2";
        Pattern pattern = Pattern.compile("&ip=(.*?)&");
        Matcher matcher = pattern.matcher(tmpfilePath);
        if(matcher.find()){
            System.out.println(matcher.group(1));
        }

    }
}
