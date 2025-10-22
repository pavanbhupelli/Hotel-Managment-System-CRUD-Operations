package com.codegnan.controller;

import java.util.List;
import java.util.Scanner;

import com.codegnan.exceptions.HotelNotFoundException;
import com.codegnan.model.Hotel;
import com.codegnan.service.HotelService;
import com.codegnan.service.HotelServiceImpl;

public class HotelController {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        HotelService service = new HotelServiceImpl();

        // add employees (hotel rooms)
        service.addHotel(new Hotel(101, "1stfloor", "single", 5000));
        service.addHotel(new Hotel(102, "2ndfloor", "double", 2500));
        service.addHotel(new Hotel(103, "3rdfloor", "double", 6000));
        service.addHotel(new Hotel(104, "1stfloor", "single", 4500));
        service.addHotel(new Hotel(105, "2ndfloor", "single", 3500));

        int n;

        do {
            System.out.println("\n1. Add Hotel Room");
            System.out.println("2. View All Hotel Rooms");
            System.out.println("3. Find Hotel by RoomNo");
            System.out.println("4. Update Hotel Room");
            System.out.println("5. Delete Hotel Room");
            System.out.println("6. Multiple Record Update");
            System.out.println("7. Multiple Record Deletion");
            System.out.println("8. Exit");
            System.out.println("Enter Your Choice :");
            n = sc.nextInt();

            switch (n) {
                case 1:
                    System.out.println("Enter RoomNo :");
                    int roomNo = sc.nextInt();
                    System.out.println("Enter Room Floor :");
                    String floor = sc.next();
                    System.out.println("Enter Room Type :");
                    String type = sc.next();
                    System.out.println("Enter Room cost :");
                    double cost = sc.nextDouble();
                    service.addHotel(new Hotel(roomNo, floor, type, cost));
                    System.out.println("Hotel Room added successfully.");
                    break;

                case 2:
                    System.out.println("ROOMNO\tFLOOR\tTYPEOFROOM\tCOST");
                    System.out.println("=================================");
                    List<Hotel> allHotel = service.getAllHotel();
                    for (Hotel all : allHotel) {
                        System.out.println(all);
                    }
                    break;

                case 3:
                    System.out.println("Fetch employee with roomNo (Enter RoomNo):");
                    int fetchId = sc.nextInt();
                    try {
                        Hotel fetchHotel = service.getHotelDyId(fetchId);
                        System.out.println("Found :" + fetchHotel);
                    } catch (HotelNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 4:
                    System.out.println("update Hotel Room with RoomNo");
                    System.out.println("Enter RoomNo:");
                    int uRoomNo = sc.nextInt();
                    System.out.println("Enter Room Floor:");
                    String uFloor = sc.next();
                    System.out.println("Enter Room Type:");
                    String uType = sc.next();
                    System.out.println("Enter Room cost:");
                    double uCost = sc.nextDouble();

                    try {
                        service.updateHotel(new Hotel(uRoomNo, uFloor, uType, uCost));
                        System.out.println("Hotel Room updated successfully. Check your DB records:");
                    } catch (HotelNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    System.out.println("Enter RoomNo to delete:");
                    int dRoomNo = sc.nextInt();
                    try {
                        service.deleteHotelId(dRoomNo);
                        System.out.println("Employee updated Succesfully. Check your DB records");
                    } catch (HotelNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    System.out.println("enter how many records to update");
                    int countUpdate = sc.nextInt();
                    sc.nextLine();  // <--- consume leftover newline here
                    for (int i = 0; i < countUpdate; i++) {
                        System.out.println("enter the room No");
                        int drooNo = sc.nextInt();
                        sc.nextLine(); // consume newline after int input

                        System.out.println("enter the Room Floor");
                        String dfloor = sc.nextLine();

                        System.out.println("enter the Room Type");
                        String dtype = sc.nextLine();

                        System.out.println("enter the Room cost");
                        double dcost = sc.nextDouble();
                        sc.nextLine(); // consume newline after double input

                        try {
                            service.updateHotel(new Hotel(drooNo, dfloor, dtype, dcost));
                            System.out.println("Hotel Rooms updated succesfully. Check your DB records:");
                        } catch (HotelNotFoundException e) {
                            System.out.println("Hotel with ID " + drooNo + " not found. Update failed.");
                            e.printStackTrace();
                        }
                    }
                    break;


                case 7:
                    System.out.println("enter how many records to delete");
                    int countDelete = sc.nextInt();
                    for (int i = 0; i < countDelete; i++) {
                        System.out.println("Enter the rooNo to delete");
                        int rooNo = sc.nextInt();
                        try {
                            service.deleteHotelId(rooNo);
                            System.out.println("Room deleted Succesfully. Check your DB records");
                        } catch (HotelNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                    break;

                case 8:
                    System.out.println("Exited");
                    break;

                default:
                    System.out.println("Enter Correct choice.");
            }

        } while (n != 8);

        sc.close();

    }
}
