package service;

import java.util.List;

import fr.idmont.model.Flight;

public interface FlightDB_interface {
    public void addFlight(Flight seat);

    public void deleteFlight(Flight seat);

    public List<Flight> selectFlightByDest(String destination);

    public List<Flight> selectFlightByDestAndDep(String destination, String departure);

    public List<Flight> selectFlightByAirline(String airline);

}
