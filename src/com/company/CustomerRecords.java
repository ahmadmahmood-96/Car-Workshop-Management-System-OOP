package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class CustomerRecords extends Records implements Serializable {

    private ArrayList<Customer> customers = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    CustomerRecords(){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(new File("Customer Records.txt")))){
            Customer customer = null;
            while((customer = (Customer) objectInputStream.readObject())!= null){
                customers.add(customer);
            }
        }catch(Exception ignored){}
    }

    @Override
    public void addRecords() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer Records.txt"))) {

            String date = new Date().toString();
            System.out.println("\nCar Service Date: " + date);
            System.out.print("Enter Customer's name: ");
            String name = input.nextLine();
            System.out.print("Enter Customer's Phone Number: ");
            String phoneNumber = input.nextLine();
            System.out.print("Enter Customer's total work cost: ");
            String amount = input.nextLine();
            System.out.print("Enter Customer's Car Number: ");
            String carNumber = input.nextLine();
            System.out.print("Enter Customer's Car service: ");
            String carService = input.nextLine();

            Customer customer = new Customer(name, phoneNumber, amount, carNumber, carService, date);
            customers.add(customer);
            for (int i = 0; i < customers.size(); i++) {
                oos.writeObject(customers.get(i));
            }
            System.out.println("Data has been written into file!\n");
        }
    }

    @Override
    public void viewRecords() {
        new CustomerRecords();
        if (customers.size() > 0) {                                                       //Shows record if any added before
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s\n", "Name", "Phone Number", "Amount", "Car Number", "Car Service", "Service Date");
            for (int i = 0; i < customers.size(); i++) {
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s", customers.get(i).getName(),
                        customers.get(i).getPhoneNumber(), customers.get(i).getAmount() ,customers.get(i).getCarNumber(), customers.get(i).getCarService(),
                        customers.get(i).getServiceDate());
            }
            System.out.println();
        } else
            System.out.println("There is no data in the records to view\n");
    }

    @Override
    public void searchRecords() {
        boolean check = true;
        if (customers.size() > 0) {
            System.out.print("Enter Customer Car Number to search records: " );
            String carNumber = input.nextLine();
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getCarNumber().equalsIgnoreCase(carNumber)) {
                    System.out.println(customers.get(i));
                    check = false;
                    break;
                }
            }
            if (check)
                System.out.println("No Record Found\n");
        } else
            System.out.println("There is no data in the records to search\n");
    }


    @Override
    public void editRecords() throws IOException {
        boolean check = true;
        if (customers.size() > 0) {
            System.out.print("Enter Customer Car Number to edit records: ");
            String carNumber = input.nextLine();
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getCarNumber().equalsIgnoreCase(carNumber)) {
                    System.out.println("The previous data of Customer is: ");
                    System.out.println(customers.get(i));
                    System.out.print("Enter name: ");
                    customers.get(i).setName(input.nextLine());
                    System.out.print("Enter Phone Number: ");
                    customers.get(i).setPhoneNumber(input.nextLine());
                    System.out.print("Enter Total work cost: ");
                    customers.get(i).setAmount(input.nextLine());
                    System.out.print("Enter Car Number: ");
                    customers.get(i).setCarNumber(input.nextLine());
                    System.out.print("Enter Car Service: ");
                    customers.get(i).setCarService(input.nextLine());
                    check = false;
                    break;
                }
            }

            if (check)
                System.out.println("No Record Found\n");
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer Records.txt"))) {
                for (int i = 0; i < customers.size(); i++) {
                    oos.writeObject(customers.get(i));
                }
            }
        } else
            System.out.println("There is no data in the records to edit\n");
    }

    @Override
    public void deleteRecords() throws IOException {
        boolean check = true;
        if (customers.size() > 0) {
            System.out.print("Enter Customer Car Number to delete records: " );
            String carNumber = input.nextLine();
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getCarNumber().equalsIgnoreCase(carNumber)) {
                    System.out.println(customers.remove(i));
                    check = false;
                    break;
                }
            }
            if (check)
                System.out.println("No Record Found\n");

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer Records.txt"))) {
                for (int i = 0; i < customers.size(); i++) {
                    oos.writeObject(customers.get(i));
                }
            }

        } else
            System.out.println("There is no data in the records to delete\n");
    }


    @Override
    public void clearRecords() throws IOException {
        if (customers.size() > 0) {
            customers.clear();
            System.out.println("Data has been erased\n");
        }
        else
            System.out.println("There is no data in the records to clear\n");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer Records.txt"))) {
            for (int i = 0; i < customers.size(); i++) {
                oos.writeObject(customers.get(i));
            }
        }
    }
}


