package com.company;

import java.io.Serializable;

public class Reservation implements Serializable {
    private String name;
    private String phoneNumber;
    private String day;
    private String date;
    private String time;

    public Reservation() {
        this.name = null;
        this.phoneNumber = null;
        this.day = null;
        this.date = null;
        this.time = null;
    }

    public Reservation(String name, String phoneNumber, String day, String date, String time) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.day = day;
        this.date = date;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
