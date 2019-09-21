package com.example.demo.exception;

public class ExceptionDemo {
    public static void main(String[] args) {
        int a = 10;
        try {
            if (a == 10) {
                throw new Exception("aaaa");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
