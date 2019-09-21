package com.example.demo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonTestDemo {
    public static void main(String[] args) {
        String s = "/api/clockInService?signature=0a3a0ff15ee359941bf84631e547ec245a7ea211&echostr=6425896660359968475&timestamp=1544512715&nonce=1067860554";
        String param = "nonce";
        System.out.println(getParamsFromUrl(param, s));
    }

    public static String getParamsFromUrl(String param, String url) {
        String myRegex = "(\\?|&)" + param + "=(.+?)(&|$)";
        Pattern p = Pattern.compile(myRegex);
        Matcher m = p.matcher(url);
        String res1 = "";
        String res2 = "";
        if (m.find()) {
            res1 = m.group(0);
            res2 = m.group(2);
        }
        return res2;
    }
}
