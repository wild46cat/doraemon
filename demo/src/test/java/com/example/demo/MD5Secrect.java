package com.example.demo;


import org.apache.commons.codec.digest.DigestUtils;

public class MD5Secrect {
    public static void main(String[] args) {
        System.out.println(123);
        String secrectStr = DigestUtils.md5Hex("abcdeftg");
        System.out.println(secrectStr);
        System.out.println(secrectStr.substring(0, 20).toUpperCase());
    }
}
