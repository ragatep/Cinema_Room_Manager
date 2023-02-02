package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
        int totalSeats = rows * seats;
        int income = 0;
        if (totalSeats <= 60) {
            income = totalSeats * 10;
        } else {
            int frontRows = rows / 2;
            int backRows = rows - frontRows;
            income = frontRows * seats * 10 + backRows * seats * 8;
        }
        System.out.println("Total income:");
        System.out.println("$" + income);
    }
}