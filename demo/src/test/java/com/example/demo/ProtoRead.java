package com.example.demo;

import com.example.demo.proto.AddressBookProtos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProtoRead {
    public static Logger logger = LoggerFactory.getLogger("ProtoRead");

    public static void main(String[] args) {
        try {
            AddressBookProtos.Person person= AddressBookProtos.Person.parseFrom(new FileInputStream("C:\\Users\\admin\\Desktop\\22.txt"));
            System.out.println(person);
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
        }
    }
}
