package service;

import java.util.ArrayList;
import java.util.List;

import fr.idmont.model.Flight;
import fr.idmont.model.Seat;

public class MockFlightDB implements FlightDB_interface {

    List<Flight> flights = new ArrayList<>();

    public MockFlightDB(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public void addFlight(Flight fligth) {
        this.flights.add(fligth);
    }

    @Override
    public void deleteFlight(Flight flight) {
        for (Flight f : this.flights) {
            if (f.getId() == flight.getId()) {
                this.flights.remove(f);
                break;
            }
        }
    }

    @Override
    public List<Flight> selectFlight(String destination) {
        List<Flight> dest_fl = new ArrayList<>();
        for (Flight f : this.flights) {
            if (f.getTo() == destination) {
                dest_fl.add(f);
            }
        }
        return dest_fl;
    }

}
