package cinema;

import java.util.Scanner;

public class Cinema {

public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        System.out.println();
        printCinema(rows, seats);
        System.out.println();
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();
        int price = getPrice(rows, seats, row);
        System.out.println();
        System.out.println("Ticket price: $" + price);
        System.out.println();
        printCinema(rows, seats, row, seat);
    }

    public static void printCinema(int rows, int seats) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(i); //+ " ");
            for (int j = 1; j <= seats; j++) {
                System.out.print(" S");
            }
            System.out.println();
        }
    }

    public static void printCinema(int rows, int seats, int row, int seat) {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 1; i <= rows; i++) {
            System.out.print(i); //+ " ");
            for (int j = 1; j <= seats; j++) {
                if (i == row && j == seat) {
                    System.out.print(" B");
                } else {
                    System.out.print(" S");
                }
            }
            System.out.println();
        }
    }

    public static int getPrice(int rows, int seats, int row) {
        int totalSeats = rows * seats;
        int price = 0;
        if (totalSeats <= 60) {
            price = 10;
        } else {
            int frontRows = rows / 2;
            if (row <= frontRows) {
                price = 10;
            } else {
                price = 8;
            }
        }
        return price;
    }
} 