package com.example.demo;

import com.example.demo.proto.AddressBookProtos;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ProtoWrite {
    public static Logger logger = LoggerFactory.getLogger("ProtoWrite");

    public static void main(String[] args) {
        AddressBookProtos.Person cat = AddressBookProtos.Person.newBuilder().setId(1234)
                .setName("John Doe")
                .setEmail("jdoe@example.com")
                .addPhones(
                        AddressBookProtos.Person.PhoneNumber.newBuilder()
                                .setNumber("555-4321")
                                .setType(AddressBookProtos.Person.PhoneType.HOME))
                .build();
        System.out.println(cat);
        System.out.println("-=============-");
        try {
            System.out.println(cat.toByteArray());
            System.out.println("-=============-");
            cat.writeTo(System.out);
            System.out.println("-=============-");
            cat.writeTo(new FileOutputStream("C:\\Users\\admin\\Desktop\\22.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
