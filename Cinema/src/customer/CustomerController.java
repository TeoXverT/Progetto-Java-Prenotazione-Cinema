
package customer;

import inputoutput.AdapterSQLCustomer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import obj.Config;
import obj.Film;
import obj.Booking;
import obj.Projection;
import obj.Hall;
import obj.Seat;

public class CustomerController {

    private static CustomerController instance;

    private AdapterSQLCustomer adapter;
    private Config config;

    public CustomerController() {
        adapter = new AdapterSQLCustomer();
    }

    public static synchronized CustomerController getInstance() {
        if (instance == null) {
            instance = new CustomerController();
        }
        return instance;
    }

    //mod
    public ArrayList<Film> futureFilmBySlider(int deltaData, int sliderValue) throws SQLException {
        return adapter.getIncomingFilmBySlider(deltaData, sliderValue);
    }

    public Config getConfig() throws SQLException {
        if (config == null) {
            config = adapter.getConfig();
        }
        return config;
    }

    public Hall roomByID(int idHall) throws SQLException {
        return adapter.getHallByIdHall(idHall); 
    }

    public ArrayList<Projection> projectionFilteredByFilmAndTime(int idFilm, Calendar focusedDateTime) throws SQLException {
        return adapter.getProjectionFilteredByFilmAndTime(idFilm, focusedDateTime); 
    }

    public ArrayList<Seat> getSeats(int idHall) {
        ArrayList<Seat> seat;
        seat = adapter.getSeatByIdHall(idHall); 
        return seat;
    }

    public int writeBooking(Booking booking) throws SQLException {
        int idBooking = 0;
        if (adapter.checkBookedSeat(booking.getProjection().getIdProjection(), booking.getBookedSeat())) { //Controllo disponibilità posti
            adapter.writeBooking(booking);
            idBooking = adapter.getIdLastBooking();
            adapter.writeBookedSeat(idBooking, booking.getBookedSeat());
        }
        return idBooking;
    }

    public ArrayList<Seat> getTakenSeats(int idProjection) throws SQLException {
        return adapter.getTakenSeats(idProjection);
    }

    public void getInsertPaymentForced(Booking booking) throws SQLException {
        adapter.insertFakePayment(booking.getIdBooking()); 
    }

    public int checkBookingPayment(int idBooking) throws SQLException {
        return adapter.checkBookingPayment(idBooking);
    }
}
