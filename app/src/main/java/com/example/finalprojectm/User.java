package com.example.finalprojectm;

public class User {
    String id;
    String fullName;
    String email;
    String phone;
        public User(){

        }
    public User(String userid, String fullName) {
        this.id=userid;
        this.fullName=fullName;

    }

    public User(String userid, String fullName, String email, String phone) {
        this.id=userid;
        this.fullName=fullName;
        this.email=email;
        this.phone=phone;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
