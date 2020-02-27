package com.ark.my_app_firebase;

public class User {
    public String name,email,phone,type;


    public User(){
    //blank constructor

    }


    public User(String name, String email, String phone, String type){
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.type = type;
    }
}
