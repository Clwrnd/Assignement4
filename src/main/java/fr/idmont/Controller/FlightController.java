package fr.idmont.Controller;

import java.util.List;

import fr.idmont.model.Flight;
import fr.idmont.model.Seat;
import service.FlightDB;
import service.FlightDB_interface;
import service.SeatDB;
import service.SeatDB_interface;

public class FlightController {
    private List<Flight> flights;
    private List<Seat> seats;
    private FlightDB_interface flightDB;
    private SeatDB_interface seatDB;

    public FlightController(List<Flight> flight_list, List<Seat> seat_list, FlightDB_interface flight_db,
            SeatDB_interface seat_db) {
        this.flights = flight_list;
        this.seats = seat_list;
        this.flightDB = flight_db;
        this.seatDB = seat_db;
    }

    // FLIGHT CONTROLLER
    public void addFlight(Flight flight) {
        this.flightDB.addFlight(flight);
    }

    public void deleteFlight(Flight flight) {
        this.flightDB.deleteFlight(flight);
    }

    public List<Flight> getFlight(String flight_des) {
        return this.flightDB.selectFlight(flight_des);
    }

    // SEAT CONTROLLER
    public void addSeat(Seat seat) {
        this.seatDB.addSeat(seat);
    }

    public void deleteSeat(Seat seat) {
        this.seatDB.deleteSeat(seat);
    }

    public List<Seat> getSeats(int flightid) {
        return this.seatDB.selectSeat(flightid);
    }

    public void bookSeat(Seat seat) {
        this.seatDB.bookSeat(seat.getFLightID(), seat.getSeatNumber());
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public FlightDB_interface getFlightDB() {
        return flightDB;
    }

    public SeatDB_interface getSeatDB() {
        return seatDB;
    }
}
