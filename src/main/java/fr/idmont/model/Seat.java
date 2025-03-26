package fr.idmont.model;

public class Seat {
    private int seatID;
    private int flightID;
    private int seatNumber;
    private String seatClass;
    private boolean availability;

    public Seat(int id, int flightID, int seatNumber, String seatClass, boolean availability) {
        this.seatID = id;
        this.flightID = flightID;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.availability = availability;
    }

    public int getSeatID() {
        return seatID;
    }

    public int getFLightID() {
        return flightID;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public boolean getAvailability() {
        return availability;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

}
