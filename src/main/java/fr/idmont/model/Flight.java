package fr.idmont.model;

public class Flight {

    private final String airline, from, to, departure, returnTime;
    private final Double price, carbonFootprint;
    private final int id, flightNumber, duration;

    public Flight(
            int id_var,
            int flightNumber,
            String airline,
            String from,
            String to,
            String departure,
            String returnTime,
            Double price,
            int duration,
            Double carbonFootprint) {
        this.id = id_var;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.departure = departure;
        this.returnTime = returnTime;
        this.price = price;
        this.duration = duration;
        this.carbonFootprint = carbonFootprint;
    }

    public int getId() {
        return id;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public String getAirline() {
        return airline;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getDeparture() {
        return departure;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public Double getPrice() {
        return price;
    }

    public int getDuration() {
        return duration;
    }

    public Double getCarbonFootprint() {
        return carbonFootprint;
    }

}
