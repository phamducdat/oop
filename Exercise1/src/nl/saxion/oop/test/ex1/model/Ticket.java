package nl.saxion.oop.test.ex1.model;

public class Ticket {

    private int id;
    private String departure;
    private String location;
    private double price;

    public Ticket(int id, String departure, String location, double price) {
        this.id = id;
        this.departure = departure;
        this.location = location;
        this.price = price;
    }

    public Ticket() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
