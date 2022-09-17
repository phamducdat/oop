package nl.saxion.oop.test.ex1.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TicketMachine {

    private String location;


    private List<Destination> destinationList;

    private List<Ticket> ticketList;

    public TicketMachine(String location) {
        this.location = location;

        destinationList = new ArrayList<>();
        ticketList = new ArrayList<>();

    }

    /**
     * Registers a new destination with the machine. Every destination has a name (String) and a price (double).
     * <p>
     * Make sure you check that destination does not already exists within the machine and that the value of price > 0!
     *
     * @param destination The name of the destination, must not already exist in the machine.
     * @param price       The price to get to that destination as an integer. Note that the price cannot be 0 (or less).
     */
    public void registerDestination(String destination, double price)
            throws Exception {

        validateDestinationNameNotExist(destination);
        validatePrice(price);

        Destination newDestination = new Destination(destination, price);
        destinationList.add(newDestination);
    }

    /**
     * Returns the price associated with a specific destination.
     * <p>
     * Make sure to throw an exception in case the destination does not exist within the machine!
     *
     * @param destinationName The destination that the price is requested for.
     * @return An integer value representing the cost to get to that destination.
     */
    public double getPrice(String destinationName) throws MachineException {

        Destination destination = findDestinationByName(destinationName);
        return destination.getPrice();
    }

    /**
     * Buy a ticket to get to specified destination. Please note that we only return the (unique) identifier from the
     * ticket. Ticket instances are kept within the actual machine because you want to be able to display them later!
     * <p>
     * Make sure to throw an exception in case the destination does not exist within the machine!
     *
     * @param destinationName The destination the ticket is bought for.
     * @return The unique identifier for the ticket that is issued (int).
     */
    public int buyTicket(String destinationName) throws Exception {
        Destination destination = findDestinationByName(destinationName);

        int id = ticketList.size() + 1;
        Ticket ticket = new Ticket(id, this.location, destination.getDestination(), destination.getPrice());
        ticketList.add(ticket);

        return id;
    }

    @Override
    public String toString() {

        String str = "Tickets issued by this machine:\n";
        double sales = 0.0;

        for (Ticket ticket : ticketList) {
            str += "\t\tTicket " +
                    ticket.getId() + " " +
                    this.location + " --> " +
                    ticket.getDeparture() + " [€" + ticket.getPrice() + "]\n";
            sales += ticket.getPrice();
        }

        str += "Total sales: € " + sales;

        return str;
    }

    private Destination findDestinationByName(String destination) throws MachineException {
        for (Destination destinationObject : this.destinationList) {
            if (destinationObject.getDestination().equals(destination)) {
                return destinationObject;
            }
        }

        throw new MachineException("Not found destination : " + destination);
    }

    private void validateDestinationNameNotExist(String destinationName)
            throws MachineException {
        for (Destination destination : destinationList) {
            if (Objects.equals(destination.getDestination(), destinationName))
                throw new MachineException("Destination name exist!");
        }
    }

    private void validatePrice(double price) throws Exception {
        if (price < 0.00)
            throw new MachineException("The price must never be € 0.00 or less");
    }


}
