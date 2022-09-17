package nl.saxion.oop.test.ex1.model;

public class Destination {

    private String destination;

    private double price;

    public Destination(String destination, double price) {
        this.destination = destination;
        this.price = price;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
