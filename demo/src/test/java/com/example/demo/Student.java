package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private String address;
    private List<String> hobbies;

    private Student() {
    }

    private Student(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.address = builder.address;
        this.hobbies = builder.hobbies;
    }

    private Student(String name, int age, String address, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.hobbies = hobbies;
    }

    public static class Builder {
        private String name;
        private int age;
        private String address;
        private List<String> hobbies = new ArrayList<>();

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setHobbies(int index, String hobby) {
            this.hobbies.set(index, hobby);
            return this;
        }

        public Builder addHobbies(String hobby) {
            this.hobbies.add(hobby);
            return this;
        }

        public Builder addAllHobbies(List<String> hobbies) {
            this.hobbies.addAll(hobbies);
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }
}
