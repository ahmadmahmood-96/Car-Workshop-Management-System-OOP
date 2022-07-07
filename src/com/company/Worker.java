package com.company;

import java.io.Serializable;

class Worker extends Person implements Serializable {
    private String address;


    Worker(String name, String phoneNumber, String amount, String address) {
        super(name, phoneNumber, amount);
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Salary: " + getAmount() + '\n' +
                "Address: " + address + '\n';
    }
}
