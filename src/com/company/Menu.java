package com.company;

import java.util.Scanner;

class Menu {
    Scanner input = new Scanner(System.in);
    Menu(){

    }
    String menu(){
        System.out.println("------------------------------------------------------");
        System.out.println("\tWelcome to our Car Workshop Management System");
        System.out.println("------------------------------------------------------\n");
        while (true) {
            System.out.print("Enter Customer or Admin to login to system: ");
            String s = input.nextLine();
            if (s.equalsIgnoreCase("admin")) {
                System.out.println("Admin Login");
                return s;
            } else if (s.equalsIgnoreCase("customer")) {
                return s;
            } else {
                System.out.println("Please enter again!");
            }
        }
    }
}
