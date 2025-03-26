package service;

import java.util.List;

import fr.idmont.model.Seat;

public interface SeatDB_interface {
    public void addSeat(Seat seat);

    public void deleteSeat(Seat seat);

    public List<Seat> selectSeat(int flightId);

    public void bookSeat(int flightID, int seatNumber);
}
