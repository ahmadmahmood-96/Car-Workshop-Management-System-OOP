package com.company;
import java.util.InputMismatchException;
import java.util.Scanner;

class Login {
    Scanner input = new Scanner(System.in);
    private String username = "admin123";
    private String password = "Admin@123";
    Login(){

    }
    void login(){
        while (true) {
            try {
                System.out.print("Enter username: ");
                String tempUsername = input.nextLine();
                System.out.print("Enter password: ");
                String tempPassword = input.nextLine();
                if (tempUsername.equals(username) && tempPassword.equals(password)) {
                    System.out.println("------------------------------------------");
                    System.out.println("\tWelcome to Admin Panel");
                    System.out.println("------------------------------------------");
                    return;                                                             //If username and password are equal then return back
                } else
                    System.out.println("Wrong Credentials entered\nPlease Enter again!");   //If wrong credentials are eneterd
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a string!");
            }
        }
    }
}
