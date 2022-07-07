package com.company;
import java.io.Serializable;
import java.util.Scanner;

public class CarWorkshop implements Serializable {
    public static void main(String[] args) {                                //Menu m = new Menu(); m.menu();
        Scanner input = new Scanner(System.in);
        String menu = new Menu().menu();                                    //Calls menu method in Menu class
        if (menu.equalsIgnoreCase("admin")) {                    //menu method returns a string and it is checked here
            new Login().login();
            while (true) {
                try {
                    System.out.print("""

                            ----------------------
                            Press for:
                            1 --> Workshop Records
                            2 --> Customer Records
                            3 --> Reservations
                            4 --> Exit
                            ----------------------
                            ~>\s""");                                       //Main menu of admin
                    int data = input.nextInt();
                    if (data == 1) {
                        while (true) {
                            WorkshopRecords w = new WorkshopRecords();
                            System.out.println("------------------------------------------------");
                            System.out.println("\tWelcome to Workshop Records");
                            System.out.println("------------------------------------------------");
                            System.out.print("""

                                    ----------------------
                                    Press for:
                                    1 --> Add Workshop Records
                                    2 --> View Workshop Records
                                    3 --> Search Workshop Records
                                    4 --> Edit Workshop Records
                                    5 --> Delete Workshop Records
                                    6 --> Clear Workshop Records
                                    0 --> Back
                                    ----------------------
                                    ~>\s""");                               //Workshop Menu
                            int data1 = input.nextInt();
                            if (data1 == 0)
                                break;
                            else if (data1 == 1)
                                w.addRecords();
                            else if (data1 == 2)
                                w.viewRecords();
                            else if (data1 == 3)
                                w.searchRecords();
                            else if (data1 == 4)
                                w.editRecords();
                            else if (data1 == 5)
                                w.deleteRecords();
                            else if (data1 == 6)
                                w.clearRecords();
                            else
                                System.out.println("Please enter from the given choices!\n");
                        }
                    } else if (data == 2) {
                        while (true) {
                            CustomerRecords c = new CustomerRecords();
                            System.out.println("------------------------------------------------");
                            System.out.println("\tWelcome to Customer Records");
                            System.out.println("------------------------------------------------");
                            System.out.print("""

                                    ----------------------
                                    Press for:
                                    1 --> Add Customer Records
                                    2 --> View Customer Records
                                    3 --> Search Customer Records
                                    4 --> Edit Customer Records
                                    5 --> Delete Customer Records
                                    6 --> Clear Customer Records
                                    0 --> Back
                                    ----------------------
                                    ~>\s""");                                   //Customer Menu
                            int data1 = input.nextInt();
                            if (data1 == 0)
                                break;
                            else if (data1 == 1)
                                c.addRecords();
                            else if (data1 == 2)
                                c.viewRecords();
                            else if (data1 == 3)
                                c.searchRecords();
                            else if (data1 == 4)
                                c.editRecords();
                            else if (data1 == 5)
                                c.deleteRecords();
                            else if (data1 == 6)
                                c.clearRecords();
                            else
                                System.out.println("Please enter from the given choices!\n");
                        }
                    } else if (data == 3) {
                        while (true) {
                            ReservationRecords r = new ReservationRecords();
                            System.out.println("------------------------------------------------");
                            System.out.println("\tWelcome to Reservation Records");
                            System.out.println("------------------------------------------------");
                            System.out.print("""

                                    ----------------------
                                    Press for:
                                    1 --> Add Reservation Records
                                    2 --> View Reservation Records
                                    3 --> Cancel Reservation Records
                                    4 --> Clear Reservation Records
                                    0 --> Back
                                    ----------------------
                                    ~>\s""");                                       //Reservation Menu
                            int data1 = input.nextInt();
                            if (data1 == 0)
                                break;
                            else if (data1 == 1)
                                r.addReservation();
                            else if (data1 == 2)
                                r.viewReservation();
                            else if (data1 == 3)
                                r.cancelReservation();
                            else if (data1 == 4)
                                r.clearRecords();
                            else
                                System.out.println("Please enter from the given choices!\n");
                        }
                    } else if (data == 4)
                        break;
                    else
                        System.out.println("Invalid  Input");
                } catch (Exception ex) {
                    System.out.println("Please enter an integer");
                    input.nextLine();
                }
            }
        } else {
            System.out.println("------------------------------------------");
            System.out.println("\tWelcome to Customer Panel");
            System.out.println("------------------------------------------");
            while (true) {
                try {
                    CustomerRecords c = new CustomerRecords();
                    ReservationRecords r = new ReservationRecords();
                    System.out.print("""

                            ----------------------
                            Press for:
                            1 --> Search Customer Records
                            2 --> Add Reservations
                            3 --> Cancel Reservations
                            0 --> Exit
                            ----------------------
                            ~>\s""");                                           //Customer Menu
                    int data = input.nextInt();
                    if (data == 0)
                        break;
                    else if (data == 1)
                        c.searchRecords();
                    else if (data == 2)
                        r.addReservation();
                    else if (data == 3)
                        r.cancelReservation();
                    else
                        System.out.println("Invalid  Input");
                } catch (Exception ex) {
                    System.out.println("Please enter from the given choices");
                }
            }
        }
    }
}