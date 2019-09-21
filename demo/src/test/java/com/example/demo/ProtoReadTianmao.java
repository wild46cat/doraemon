package com.example.demo;

import com.example.demo.proto.AdDongFengRequest;
import com.example.demo.proto.AddressBookProtos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ProtoReadTianmao {
    public static Logger logger = LoggerFactory.getLogger("ProtoRead");

    public static void main(String[] args) {
        try {
            AdDongFengRequest.Request request= AdDongFengRequest.Request.parseFrom(new FileInputStream("C:\\Users\\admin\\Desktop\\22.txt"));
            System.out.println(request);
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
        }
    }
}
