package com.company;

import java.io.Serializable;
import java.util.ArrayList;


class Person implements Serializable {                                      //Person class, Parent class
    private String name;
    private String phoneNumber;
    private String amount;

    public Person() {}

    public Person(String name, String phoneNumber, String amount) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Name: " + name + '\n' +
                "Phone Number: " + phoneNumber;
    }
}
