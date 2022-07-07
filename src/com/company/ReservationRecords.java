package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

interface ReservationInterface{
    void addReservation() throws IOException;
    void viewReservation() throws IOException, ClassNotFoundException;
    void cancelReservation() throws IOException, ClassNotFoundException;
    void clearRecords() throws IOException;
}

public class ReservationRecords implements ReservationInterface, Serializable{

    private ArrayList<Reservation> reservations = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    ReservationRecords(){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("Reservation Records.txt"))){
            Reservation reservation = null;
            while((reservation = (Reservation) objectInputStream.readObject())!= null){
                reservations.add(reservation);
            }
        }catch(Exception o){

        }
    }

    @Override
    public void addReservation() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Reservation Records.txt"))) {
            System.out.print("Enter Customer's name: ");
            String name = input.nextLine();
            System.out.print("Enter Customer's Phone Number: ");
            String phoneNumber = input.nextLine();
            System.out.print("Enter day: ");
            String day = input.nextLine();
            System.out.print("Enter date: ");
            String date = input.nextLine();
            String time;

            while (true) {
                boolean check = true;
                System.out.print("Enter time between 9am and 5pm (e.g. 3pm): ");
                time = input.nextLine();
                if (reservations.isEmpty()){
                    break;
                }
                else {
                    for (int i = 0; i < reservations.size(); i++){
                        if (reservations.get(i).getDay().equalsIgnoreCase(day) && reservations.get(i).getTime().equalsIgnoreCase(time)){
                            check = false;
                            break;
                        }
                    }
                }
                if (check){
                    break;
                }
                else
                    System.out.println("Sorry! This time slot is not available select another");
            }

            Reservation reservation = new Reservation(name, phoneNumber, day, date, time);
            reservations.add(reservation);
            for (int i = 0; i < reservations.size(); i++) {
                oos.writeObject(reservations.get(i));
            }
            System.out.println("Data has been written into file!\n");
        }
    }

    @Override
    public void viewReservation() {
        new ReservationRecords();
        if (reservations.size() > 0) {                                                       //Shows record if any added before
            System.out.printf("\n%-20s%-20s%-20s%-20s%-20s", "Name", "Phone Number", "Day", "Date", "Time");
            for (int i = 0; i < reservations.size(); i++) {
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s", reservations.get(i).getName(), reservations.get(i).getPhoneNumber(),
                        reservations.get(i).getDay(), reservations.get(i).getDate(), reservations.get(i).getTime());
            }
            System.out.println();
        } else
            System.out.println("There is no data in the records");
    }


    @Override
    public void cancelReservation() throws IOException {
        boolean check = true;
        if (reservations.size() > 0) {
            System.out.print("Enter Phone Number to cancel reservation: " );
            String phoneNumber = input.nextLine();
            for (int i = 0; i < reservations.size(); i++) {
                if (reservations.get(i).getPhoneNumber().equalsIgnoreCase(phoneNumber)) {
                    System.out.println(reservations.remove(i));
                    check = false;
                    break;
                }
            }
            if (check)
                System.out.println("No Record Found");

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Reservation Records.txt"))) {
                oos.writeObject(reservations);
            }
        } else
            System.out.println("There is no data in the records");
    }

    @Override
    public void clearRecords() throws IOException {
        if (reservations.size() > 0) {
            reservations.clear();
            System.out.println("Data has been erased");
        }
        else
            System.out.println("There is no data in the records to clear\n");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Customer Records.txt"))) {
            for (int i = 0; i < reservations.size(); i++) {
                oos.writeObject(reservations.get(i));
            }
        }
    }
}

