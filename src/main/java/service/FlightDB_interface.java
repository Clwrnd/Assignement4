package service;

import java.util.List;

import fr.idmont.model.Flight;

public interface FlightDB_interface {
    public void addFlight(Flight seat);

    public void deleteFlight(Flight seat);

    public List<Flight> selectFlight(String destination);

}
