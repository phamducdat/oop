package nl.saxion.oop.test.ex1;

import nl.saxion.oop.test.ex1.model.TicketMachine;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        TicketMachine tm = new TicketMachine("Deventer");

        int choice;
        do {
            System.out.println("1. Register new destination with machine");
            System.out.println("2. Show price for specific destination");
            System.out.println("3. Buy ticket to specific destination");
            System.out.println("4. Show all issued tickets");
            System.out.println("0. Exit");
            System.out.println();
            choice = readInt("Please select an entry from the menu: ");
            System.out.println();

            if (choice == 1) {
                // Register new destination with machine
                String destination = readString("Please enter a destination: ");
                double price = readDouble("Please enter a price for a ticket to " + destination + ": ");

                // TODO: Register this destination (with price) with the ticket machine. Take care of any exceptions!
            } else if (choice == 2) {
                // Show price for specific destination
                String destination = readString("Please enter a destination: ");

                // TODO: Retrieve the price for specified destination. Take care of any exceptions!
            } else if (choice == 3) {
                // Buy ticket to specific destination
                String destination = readString("Please enter a destination: ");

                // TODO: Buy a ticket to destination. Take care of any exceptions!
            } else if (choice == 4) {
                // Show all issued tickets

                // TODO: Print out all issued tickets using the toString of TicketMachine.
//                System.out.println(tm);
            } else if (choice == 0) {
                System.out.println("Goodbye");
            }

            System.out.println();
        } while (choice != 0);
    }

    /**
     * Helper method that prints out a message before returning the response (String).
     *
     * @return a String value as returned by the user.
     */
    private static String readString(String msg) {
        System.out.print(msg);
        return readString();
    }

    /**
     * Helper method that returns a String, read by Scanner.
     *
     * @return a String value as returned by the user.
     */
    private static String readString() {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    /**
     * Helper method that prints out a message before returning the response (int).
     *
     * @return the parsed value (as integer) read from user.
     */
    private static int readInt(String msg) {
        System.out.print(msg);
        return readInt();
    }

    /**
     * Helper method that returns an integer, based on the readString() method.
     *
     * @return the parsed value (as integer) read from user.
     */
    private static int readInt() {
        while(true) {
            try {
                return Integer.parseInt(readString());
            } catch (NumberFormatException nfe) {
                System.err.print("That is not a valid value! Try again: ");
            }
        }
    }

    /**
     * Helper method that prints out a message before returning the response (double).
     *
     * @return the parsed value (as double) read from user.
     */
    private static double readDouble(String msg) {
        System.out.print(msg);
        return readDouble();
    }

    /**
     * Helper method that returns an double, based on the readString() method.
     *
     * @return the parsed value (as double) read from user.
     */
    private static double readDouble() {
        while(true) {
            try {
                return Double.parseDouble(readString());
            } catch (NumberFormatException nfe) {
                System.err.print("That is not a valid value! Try again: ");
            }
        }
    }

}
