package service;

import java.util.List;

import fr.idmont.model.Flight;

public class FlightDB implements FlightDB_interface {

    @Override
    public void addFlight(Flight seat) {
    }

    @Override
    public void deleteFlight(Flight seat) {
    }

    @Override
    public List<Flight> selectFlightByDest(String destination) {
        return null;
    }

    @Override
    public List<Flight> selectFlightByAirline(String airline) {
        return null;
    }

    @Override
    public List<Flight> selectFlightByDestAndDep(String destination, String departure) {
        return null;
    }

}
