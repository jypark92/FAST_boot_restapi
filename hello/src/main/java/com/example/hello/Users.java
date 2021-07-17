package com.example.hello;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Users {

    private String name;
    private int age;
    @JsonProperty("phone_number")
    private String phoneNumber;

    public Users(){};

    public Users(String name, int age, String phoneNumber){
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
//    object mapper로 활용되는 클래스에서 사용자 지정 메소드를 만들때 get이 들어가지 않도록 해야한다.
//    public Users getUefaultUser(){
//        return new Users("default",0);
//    }

    public Users defaultUser(){
        return new Users("default",0,"010-111-1125");
    }

    @Override
    public String toString() {
        return "Users{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
