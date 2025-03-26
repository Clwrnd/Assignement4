package service;

import java.util.ArrayList;
import java.util.List;

import fr.idmont.model.Seat;

public class MockSeatDB implements SeatDB_interface {

    List<Seat> seats = new ArrayList<>();

    public MockSeatDB(List<Seat> seats_var) {
        this.seats = seats_var;
    }

    @Override
    public void addSeat(Seat seat) {
        seats.add(seat);
    }

    @Override
    public void deleteSeat(Seat seat) {
        for (Seat s : seats) {
            if (s.getSeatID() == seat.getSeatID()) {
                seats.remove(s);
                break;
            }
        }
    }

    @Override
    public List<Seat> selectSeat(int flightId) {
        List<Seat> avai_seat = new ArrayList<>();
        for (Seat s : seats) {
            if (s.getAvailability() == true && s.getFLightID() == flightId) {
                avai_seat.add(s);
            }
        }
        return avai_seat;
    }

    @Override
    public void bookSeat(int flightID, int seatNumber) {
        for (Seat s : seats) {
            if (s.getSeatNumber() == seatNumber && s.getFLightID() == flightID) {
                s.setAvailability(false);
            }
        }
    }

}
