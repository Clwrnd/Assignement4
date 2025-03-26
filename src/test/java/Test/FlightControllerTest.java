package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.ArrayList;
import java.util.List;

import fr.idmont.Controller.FlightController;
import fr.idmont.model.Flight;
import fr.idmont.model.Seat;
import service.FlightDB_interface;
import service.MockFlightDB;
import service.MockSeatDB;
import service.SeatDB_interface;

public class FlightControllerTest {
    FlightController fl_contr;

    @BeforeEach
    public void init() {

        List<Flight> l_fl = new ArrayList<>();
        l_fl.add(new Flight(0, 3747, "F6", "Paris", "London", "", "", 0.0, 1, 9.0));
        l_fl.add(new Flight(1, 34774, "F6", "Paris", "Milan", "", "", 0.0, 1, 9.0));
        l_fl.add(new Flight(2, 364644, "F6", "Paris", "Saint Denis", "", "", 0.0, 1, 9.0));
        l_fl.add(new Flight(3, 273737, "F6", "Paris", "Madrid", "", "", 0.0, 1, 9.0));

        List<Seat> l_s = new ArrayList<>();
        int j = 0;
        for (Flight f : l_fl) {
            for (int i = 0; i < 10; i++) {
                l_s.add(new Seat(j, f.getId(), i, "Eco", true));
                j++;
            }
        }

        SeatDB_interface stdb = new MockSeatDB(l_s);
        FlightDB_interface fdb = new MockFlightDB(l_fl);
        fl_contr = new FlightController(l_fl, l_s, fdb, stdb);
    }

    @Test
    public void constructorTest() {
        assertEquals(40, fl_contr.getSeats().size());
    }

    @Test
    public void addFlightTest() {
        fl_contr.addFlight(new Flight(4, 3848832, "F6", "Paris", "Budapest", "", "", 0.0, 0, 76.9));
        assertEquals(4, fl_contr.getFlights().getLast().getId());
        assertEquals(3848832, fl_contr.getFlights().getLast().getFlightNumber());
        assertEquals("F6", fl_contr.getFlights().getLast().getAirline());
        assertEquals("Paris", fl_contr.getFlights().getLast().getFrom());
        assertEquals("Budapest", fl_contr.getFlights().getLast().getTo());
        assertEquals("", fl_contr.getFlights().getLast().getDeparture());
        assertEquals("", fl_contr.getFlights().getLast().getReturnTime());
        assertEquals(0.0, fl_contr.getFlights().getLast().getPrice());
        assertEquals(0, fl_contr.getFlights().getLast().getDuration());
        assertEquals(76.9, fl_contr.getFlights().getLast().getCarbonFootprint());
    }

    @Test
    public void deleteFlightTest() {
        Flight to_del = fl_contr.getFlights().get(2);
        fl_contr.deleteFlight(to_del);
        assertEquals(fl_contr.getFlights().contains(to_del), false);
    }

    @Test
    public void getFlightTest() {
        assertEquals(1, fl_contr.getFlight("Madrid").size());
    }

    @Test
    public void addSeatTest() {
        fl_contr.addSeat(new Seat(40, 2, 10, "premium", false));
        assertEquals(2, fl_contr.getSeats().getLast().getFLightID());
        assertEquals(10, fl_contr.getSeats().getLast().getSeatNumber());
        assertEquals("premium", fl_contr.getSeats().getLast().getSeatClass());
        assertEquals(false, fl_contr.getSeats().getLast().getAvailability());

    }

    @Test
    public void deleteSeatTest() {
        Seat to_del = fl_contr.getSeats().get(2);
        fl_contr.deleteSeat(to_del);
        assertEquals(false, fl_contr.getSeats().contains(to_del));
    }

    @Test
    public void getSeatTest() {

        assertEquals(10, fl_contr.getSeats(3).size());
    }

    @Test
    public void boolSeatTest() {
        fl_contr.bookSeat(fl_contr.getSeats().get(25));
        assertEquals(false, fl_contr.getSeats().get(25).getAvailability());
    }

}