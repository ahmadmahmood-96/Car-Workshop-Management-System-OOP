package com.company;

import java.io.Serializable;

public class Customer extends Person implements Serializable {
    private String carNumber;
    private String carService;
    private String serviceDate;

    public Customer(String name, String phoneNumber, String amount, String carNumber, String carService, String serviceDate) {
        super(name, phoneNumber, amount);
        this.carNumber = carNumber;
        this.carService = carService;
        this.serviceDate = serviceDate;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getCarService() {
        return carService;
    }

    public void setCarService(String carService) {
        this.carService = carService;
    }

    public String getServiceDate() { return serviceDate; }


    @Override
    public String toString() {
        System.out.println(super.toString());
        return "Car Number: " + carNumber + '\n' +
                "Car Service: " + carService + '\n' +
                "Service Date: " + serviceDate + '\n';
    }
}
