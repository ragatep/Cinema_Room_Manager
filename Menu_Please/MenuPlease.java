package cinema;

import java.util.Scanner;

public class Cinema {

    static char[][] seatMap;
    static int numRows;
    static int numCols;
    static int totalSeats;

    static int ticketsSold = 0;
    static int totalSales = 0;
    static int maxIncome = 0;


    public static void showSeats() {
        System.out.println();
        System.out.println("Cinema:");
        for (int i = -1; i < numRows; i++) {
            if (i == -1) {
                System.out.print(" ");
            } else {
                System.out.print(i + 1);
            }
            for (int j = 0; j < numCols; j++) {
                if (i == -1) {
                    System.out.print(" " + (j + 1));
                } else {
                    System.out.print(" " + seatMap[i][j]);
                }
            }
            System.out.println();
        }
    }

    public static void buyTicket() {
        Scanner scanner = new Scanner(System.in);
        int seatRow = 0;
        int seatCol;
        int seatPrice;
        boolean validSeat = false;

        while(!validSeat) {
            System.out.println();
            System.out.println("Enter a row number:");
            seatRow = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatCol = scanner.nextInt();

            try {
                if (seatMap[seatRow - 1][seatCol - 1] == 'B') {
                    System.out.println();
                    System.out.println("That ticket has already been purchased!");
                } else {
                    seatMap[seatRow - 1][seatCol - 1] = 'B';
                    validSeat = true;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println();
                System.out.println("Wrong input!");
            }
        }

        if (totalSeats <= 60) {
            seatPrice = 10;
        } else if (seatRow <= numRows / 2) {
            seatPrice = 10;
        } else {
            seatPrice = 8;
        }

        totalSales += seatPrice;
        ticketsSold ++;

        System.out.println();
        System.out.println("Ticket price: $" + seatPrice);
    }

    public static void showStatistics() {
        System.out.println();
        System.out.println("Number of purchased tickets: " + ticketsSold);
        System.out.printf("Percentage: %.2f", 100 * (double)ticketsSold/totalSeats);
        System.out.print("%\n");
        System.out.println("Current income: $" + totalSales);
        System.out.println("Total income: $" + getMaxIncome());
    }

    public static int getMaxIncome() {
        if (totalSeats <= 60) {
            maxIncome = totalSeats * 10;
        }
        else {
            int frontRows = numRows / 2;
            int backRows = numRows - frontRows;
            int frontRowIncome = 10 * numCols * frontRows;
            int backRowIncome = 8 * numCols * backRows;
            maxIncome = frontRowIncome + backRowIncome;
        }
        return maxIncome;
    }

    public static int getMenuOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int menuOption = scanner.nextInt();
        return menuOption;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuOption = -1;

        System.out.println("Enter the number of rows:");
        numRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        numCols = scanner.nextInt();
        totalSeats = numRows * numCols;
        seatMap = new char[numRows][numCols];

        //Set all seats to S
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                seatMap[i][j] = 'S';
            }
        }

        while (menuOption != 0) {
            menuOption = getMenuOption();
            switch (menuOption) {
                case 1:
                    showSeats();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 3:
                    showStatistics();
                    break;
                default:
                    break;
            }
        }


    }
}