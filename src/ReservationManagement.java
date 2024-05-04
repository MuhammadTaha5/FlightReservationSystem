import java.util.*;

public class ReservationManagement
{


    private static ArrayList<Flight>flights = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public static ArrayList<Flight> getFlights() {
        System.out.println("Flights");
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "  Flight Number", "Departure", "Destination", "Departure date", "Departure time", "Arrival Time");
        for (int i = 0; i < flights.size(); i++) {
            System.out.print(i+1+" ");
            System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", flights.get(i).getFlightNumber(), flights.get(i).getSource(), flights.get(i).getDestination(), flights.get(i).getDepartureDate(), flights.get(i).getDepartureTime(), flights.get(i).getArrivalTime());

        }

        return flights;
    }


    public void addFlights(ArrayList<Flight> flights)
    {
        this.flights = flights;
    }
    public void addFlights(Flight flight)
    {
        flights.add(flight);
    }

    public ArrayList <Flight> searchBySourceToDestination(Cities sourceCity, Cities destinationCity)
    {

        int fl = 0;
        System.out.println("Flights");
        ArrayList <Flight> flightByPass = new ArrayList<>();
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "  Flight Number", "Departure", "Destination", "Departure date", "Departure time", "Arrival Time");
        for (int i = 0; i < flights.size(); i++) {

            if(sourceCity == flights.get(i).getSource() && destinationCity.equals(flights.get(i).getDestination()))
            {
                fl++;
                System.out.print(fl+" ");
                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", flights.get(i).getFlightNumber(), flights.get(i).getSource(), flights.get(i).getDestination(), flights.get(i).getDepartureDate(), flights.get(i).getDepartureTime(), flights.get(i).getArrivalTime());
                flightByPass.add(flights.get(i));
            }

        }
        if (fl==0)
        {
            System.out.println("No FLight Found on this Route.");
        }
        return flightByPass;
    }

    public void cancelFlight(String flightNumber) {
        {
            for (int i = 0; i < flights.size(); i++) {
                if (flightNumber.equals(flights.get(i).getFlightNumber()))
                {
                    System.out.println("Are You Sure to Cancel A This Flight: y/n\n");
                    String ch = input.next();
                    if (ch.equals("y") || ch.equals("Y"))
                    {
                        flights.remove(i);
                        System.out.println("Flight Cancelled.");
                    }
                }

            }
        }


    }
//    public void bookSeat(Cities form, Cities to, int numSeats)
//    {
//        searchBySourceToDestination(form, to);
//        System.out.print("Select Flight: ");
//        int ch = input.nextInt();
////        reservation.setFlight();
//    }
}


