package com.example.demo;

import com.example.demo.proto.AddressBookProtos;

import java.util.List;

public class BuilderPattern {
    public static void main(String[] args) {
        Student student = new Student.Builder()
                .setName("aa")
                .setAddress("csdfsdf")
                .setAge(12)
                .addHobbies("dsfsdf")
                .build();

        System.out.println(student);

        AddressBookProtos.Person cat = AddressBookProtos.Person.newBuilder().setId(1234)
                .setName("John Doe")
                .setEmail("jdoe@example.com")
                .addPhones(
                        AddressBookProtos.Person.PhoneNumber.newBuilder()
                                .setNumber("555-4321")
                                .setType(AddressBookProtos.Person.PhoneType.HOME))
                .build();
        System.out.println(cat);
    }
}
