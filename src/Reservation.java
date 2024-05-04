import java.time.LocalDateTime;
import java.util.*;

public class Reservation
{
    static  ArrayList <Flight> flights;
    private Flight flight;
    private LocalDateTime dateTime;

    public Reservation(Flight flight) {
        this.flight = flight;
        this.dateTime = LocalDateTime.now();
    }

    public static ArrayList<Flight> getFlights() {
        return flights;
    }

    public static void setFlights(ArrayList<Flight> flights) {
        Reservation.flights = flights;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
