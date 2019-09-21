package com.example.demo;

import org.apache.commons.lang.StringUtils;

public class StringUtilsTest {
    public static final String H5_BBS_URL_PREFIX = "https://bbs.j.cn/html/adredirect/adRedirect.html?adrealurl=";

    public static void main(String[] args) {
//        String s = "https://bbs.j.cn/html/adredirect/adRedirect.html?adrealurl=https://bbs.j.cn/html/adredirect/adRedirect.html?adrealurl=http://www.baidu.com";
        String s = "saaadfadsff";
        System.out.println(s);
        System.out.println(promoUrlMpH5Decode(s));
    }

    public static String promoUrlMpH5Decode(String url) {
        String res = StringUtils.substringAfter(url, H5_BBS_URL_PREFIX);
        return StringUtils.isBlank(res) ? url : res;
    }
}
