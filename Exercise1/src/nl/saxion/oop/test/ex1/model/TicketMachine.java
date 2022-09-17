package nl.saxion.oop.test.ex1.model;

import java.util.ArrayList;
import java.util.List;

public class TicketMachine {

    private String location;


    private List<Destination> destinationList;

    public TicketMachine(String location) {
        this.location = location;

        destinationList = new ArrayList<>();

    }

    /**
     * Registers a new destination with the machine. Every destination has a name (String) and a price (double).
     * <p>
     * Make sure you check that destination does not already exists within the machine and that the value of price > 0!
     *
     * @param destination The name of the destination, must not already exist in the machine.
     * @param price       The price to get to that destination as an integer. Note that the price cannot be 0 (or less).
     */
    public void registerDestination(String destination, double price) {
        Destination newDestination = new Destination(destination, price);

        destinationList.add(newDestination);

    }

    /**
     * Returns the price associated with a specific destination.
     * <p>
     * Make sure to throw an exception in case the destination does not exist within the machine!
     *
     * @param destination The destination that the price is requested for.
     * @return An integer value representing the cost to get to that destination.
     */
    public double getPrice(String destination) {
        return 0.0;
    }

    /**
     * Buy a ticket to get to specified destination. Please note that we only return the (unique) identifier from the
     * ticket. Ticket instances are kept within the actual machine because you want to be able to display them later!
     * <p>
     * Make sure to throw an exception in case the destination does not exist within the machine!
     *
     * @param destination The destination the ticket is bought for.
     * @return The unique identifier for the ticket that is issued (int).
     */
    public int buyTicket(String destination) {
        return -1;
    }


}
