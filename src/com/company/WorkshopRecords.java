package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WorkshopRecords extends Records implements Serializable {

    private ArrayList<Worker> workers = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    WorkshopRecords(){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Workshop Records.txt"))){
            Worker obj;
            while((obj = (Worker) objectInputStream.readObject())!= null){
                workers.add(obj);
            }
        }catch(Exception o){

        }
    }

    @Override
    public void addRecords() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Workshop Records.txt"))) {

            System.out.print("Enter Worker's name: ");
            String name = input.nextLine();
            System.out.print("Enter Worker's Phone Number: ");
            String phoneNumber = input.nextLine();
            System.out.print("Enter Worker's Salary: ");
            String salary = input.nextLine();
            System.out.print("Enter Worker's Address: ");
            String address = input.nextLine();

            Worker worker = new Worker(name, phoneNumber, salary, address);
            workers.add(worker);
            for (int i = 0; i < workers.size(); i++) {
                oos.writeObject(workers.get(i));
            }
            System.out.println("Data has been written into file!\n");
        }
    }

    @Override
    public void viewRecords() {
        new WorkshopRecords();                                                          //Read already added data from file
        if (workers.size() > 0) {                                                       //Shows record if any added before
            System.out.printf("\n%-20s%-20s%-20s%-20s", "Name", "Phone Number", "Salary", "Address");
            for (int i = 0; i < workers.size(); i++) {
                System.out.printf("\n%-20s%-20s%-20s%-20s", workers.get(i).getName(), workers.get(i).getPhoneNumber(),
                        workers.get(i).getAmount(), workers.get(i).getAddress());
            }
            System.out.println("");
        } else
            System.out.println("There is no data in the records to view\n");
    }


    @Override
    public void searchRecords() {
        boolean check = true;
        if (workers.size() > 0) {
            System.out.print("Enter Worker Phone Number to search records: " );
            String phoneNumber = input.nextLine();
            for (int i = 0; i < workers.size(); i++) {
                if (workers.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                    System.out.println(workers.get(i));
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
        if (workers.size() > 0) {
            System.out.print("Enter Worker Phone Number to edit records: " );
            String phoneNumber = input.nextLine();
            for (int i = 0; i < workers.size(); i++) {
                if (workers.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                    System.out.println("The previous data of employee is: ");
                    System.out.println(workers.get(i));
                    System.out.print("Enter name: ");
                    workers.get(i).setName(input.nextLine());
                    System.out.print("Enter Phone Number: ");
                    workers.get(i).setPhoneNumber(input.nextLine());
                    System.out.print("Enter Salary: ");
                    workers.get(i).setAmount(input.nextLine());
                    System.out.print("Enter Address: ");
                    workers.get(i).setAddress(input.nextLine());
                    check = false;
                    break;
                }
            } if (check)
                System.out.println("No Record Found\n");

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Workshop Records.txt"))) {
                for (int i = 0; i < workers.size(); i++) {
                    oos.writeObject(workers.get(i));
                }
            }
        } else
            System.out.println("There is no data in the records to edit\n");
    }

    @Override
    public void deleteRecords() throws IOException {
        boolean check = true;
        if (workers.size() > 0) {
            System.out.print("Enter Worker Phone Number to delete records: " );
            String phoneNumber = input.nextLine();
            for (int i = 0; i < workers.size(); i++) {
                if (workers.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                    System.out.println(workers.remove(i));
                    check = false;
                    break;
                }
            }
            if (check)
                System.out.println("No Record Found\n");

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Workshop Records.txt"))) {
                for (int i = 0; i < workers.size(); i++) {
                    oos.writeObject(workers.get(i));
                }
            }
        } else
            System.out.println("There is no data in the records to delete\n");
    }

    @Override
    public void clearRecords() throws IOException {
        if (workers.size() > 0) {
            workers.clear();
            System.out.println("Data has been erased\n");
        }
        else
            System.out.println("There is no data in the records to clear\n");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Workshop Records.txt"))) {
            for (int i = 0; i < workers.size(); i++) {
                oos.writeObject(workers.get(i));
            }
        }
    }
}
