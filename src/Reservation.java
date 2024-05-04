import java.time.LocalDateTime;
import java.util.*;

public class Reservation
{
    static Scanner input = new Scanner(System.in);
    static  ArrayList <Flight> flights;
    private LocalDateTime dateTime;


    public Reservation() {

    }

    public static ArrayList<Flight> getFlights() {
        return flights;
    }

    public static void setFlights(ArrayList<Flight> flights) {
        Reservation.flights = flights;
    }
    public static void addFlight(Flight flight)
    {
        flights.add(flight);
    }
    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
    public static Flight Features()
    {
        Flight requiredFlight = null;
        System.out.print("Which Flight You Want to Select: ");
        String flNum = input.next();
        for(Flight flight: flights)
        {
            if (flNum.equals(flight.getFlightNumber()))
            {
                requiredFlight = flight;
            }
        }
        return requiredFlight;
    }

}
