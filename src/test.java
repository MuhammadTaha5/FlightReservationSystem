import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        int choice, depDate, arrDate, depTime, arrTime;
        double economyFare, businessFare;
        String flightNumber, depMonth, arrMonth;

        String source, destination;

        int totalSeats;
        Scanner input = new Scanner(System.in);
        ArrayList<Flight> flights = new ArrayList<>();
        ReservationManagement res = new ReservationManagement();
        //Sample Flights for testing
        Flight f1 = new Flight("EK-1322", Cities.DUBAI, Cities.KARACHI, LocalDate.of(2024, Month.APRIL, 6), LocalTime.of(20, 0, 0), LocalDate.of(2024, Month.APRIL, 6), LocalTime.of(22, 30, 0), 26, 45000, 90000 );
        Flight f2 = new Flight("EK-132", Cities.ABUDHABI, Cities.KARACHI, LocalDate.of(2024, Month.APRIL, 6), LocalTime.of(20, 0, 0), LocalDate.of(2024, Month.APRIL, 6), LocalTime.of(22, 30, 0), 26, 45000, 90000 );
        Flight f3 = new Flight("EK-1333", Cities.ABUDHABI, Cities.KARACHI, LocalDate.of(2024, Month.APRIL, 6), LocalTime.of(20, 0, 0), LocalDate.of(2024, Month.APRIL, 6), LocalTime.of(22, 30, 0), 26, 45000, 90000 );

        flights.add(f1);
        flights.add(f2);
        flights.add(f3);
        res.addFlights(flights);
        System.out.print("Enter 1 for Administration: ");
        choice = input.nextInt();
        if (choice==1) {
            displayAdminMenu();
            System.out.println("Enter Choice: ");
            int ch = input.nextInt();
            while (ch!=4) {
                switch (ch) {
                    case 0:
                    {
                        ReservationManagement.getFlights();
                        break;
                    }
                    case 1: {
                        System.out.print("Enter Flight Number: ");
                        flightNumber = input.next();
                        System.out.print("Enter Departure City: ");
                        source = input.next();
                        System.out.print("Enter Arrival City: ");
                        destination = input.next();
                        System.out.print("Enter Departure Date: ");
                        depDate = input.nextInt();
                        System.out.print("Enter Departure Month: ");
                        depMonth = input.next();
                        System.out.print("Enter Departure Time(HH:Min): ");
                        depTime = input.nextInt();
                        System.out.print("Enter Arrival Date");
                        arrDate = input.nextInt();
                        System.out.print("Enter Arrival Month: ");
                        arrMonth = input.next();
                        System.out.print("Enter Arrival Time: ");
                        arrTime = input.nextInt();

                        System.out.print("Enter Number of Seats: ");
                        totalSeats = input.nextInt();
                        System.out.print("Enter Economy Fare: ");
                        economyFare = input.nextDouble();
                        System.out.print("Enter business Fare: ");
                        businessFare = input.nextDouble();

                        res.addFlights(new Flight(flightNumber, selectCity(source), selectCity(destination), LocalDate.of(2024, selectMonth(depMonth), depDate), LocalTime.of(depTime / 100, depTime % 100, 0), LocalDate.of(2024, selectMonth(arrMonth), arrDate), LocalTime.of(arrTime / 100, arrTime % 100, 0), totalSeats, economyFare, businessFare));
                        //Reservation.addFlight(new Flight(flightNumber, selectCity(source), selectCity(destination), LocalDate.of(2024, selectMonth(depMonth), depDate), LocalTime.of(depTime / 100, depTime % 100, 0), LocalDate.of(2024, selectMonth(arrMonth), arrDate), LocalTime.of(arrTime / 100, arrTime % 100, 0), totalSeats, economyFare, businessFare));

                        break;
                    }
                    case 2: {
                        System.out.println("Which Flight You want To Cancel: ");
                        System.out.print("Enter Flight Number: ");
                        flightNumber = input.next();
                        res.cancelFlight(flightNumber);
                        break;
                    }
                    case 3: {
                        System.out.print("Enter Departure City: ");
                        source = input.next();
                        System.out.print("Enter Arrival City: ");
                        destination = input.next();
                        res.searchBySourceToDestination(selectCity(source), selectCity(destination));
                        break;
                    }

                }
                displayAdminMenu();
                System.out.println("Enter Choice: ");
                ch = input.nextInt();

            }
        }
        System.out.println("Do you want to login as user");
        System.out.print("Press 2: ");
        choice = input.nextInt();
        if (choice == 2)
        {
            Reservation.setFlights(ReservationManagement.getFlights());
            displayPassengerMenu();
            System.out.print("Enter Choice: ");
            int ch = input.nextInt();
            while (ch != 5) {
                switch (ch) {
                    case 1: {
                        System.out.print("Enter Departure City: ");
                        source = input.next();
                        System.out.print("Enter Destination City: ");
                        destination = input.next();
                        res.searchBySourceToDestination(selectCity(source), selectCity(destination));
                        break;
                    }
                    case 2: {
                        System.out.print("Enter Departure City: ");
                        source = input.next();
                        System.out.print("Enter Destination City: ");
                        destination = input.next();
                        res.searchBySourceToDestination(selectCity(source), selectCity(destination));
                        Reservation.Features().bookSeat();
                        break;
                    }
                    case 3: {
                        System.out.print("Enter Departure City: ");
                        source = input.next();
                        System.out.print("Enter Destination City: ");
                        destination = input.next();
                        res.searchBySourceToDestination(selectCity(source), selectCity(destination));
                        Reservation.Features().cancelSeat();
                        break;
                    }
                    case 4: {
                        System.out.print("Enter Departure City: ");
                        source = input.next();
                        System.out.print("Enter Destination City: ");
                        destination = input.next();
                        System.out.print("Enter Number of Seats: ");
                        int numSeats = input.nextInt();
                        res.searchBySourceToDestination(selectCity(source), selectCity(destination));
                        if (Reservation.Features().checkSeatAvailable(numSeats)) {
                            System.out.println("Seats are Available");
                        } else {
                            System.out.println("Seats not Available");
                        }
                        break;
                    }

                }
                displayPassengerMenu();
                System.out.print("Enter Choice: ");
                ch = input.nextInt();
            }
        }


    }
    public static void displayAdminMenu()
    {
        System.out.println("Enter 0 to Display All Flights");
        System.out.println("Enter 1 for Adding Flight");
        System.out.println("Enter 2 for Cancelling Flight");
        System.out.println("Enter 3 for Searching Flight");
        System.out.println("Enter 4 to Exit");
    }
    public static void displayPassengerMenu()
    {
        System.out.println("Enter 1 to Search Flight");
        System.out.println("Enter 2 to Book seat");
        System.out.println("Enter 3 to Cancel seat");
        System.out.println("Enter 4 to Check seat Availability");
        System.out.println("Enter 5 to Exit");
    }
    public static Cities selectCity(String city)
    {
        Cities c= null;
        city = city.toUpperCase();
        for (Cities ct: Cities.values()) {
            if (city.equals(ct.name()))
            {
                c = ct;
            }
        }
        return c;
    }
    public static Month selectMonth(String mon)
    {
        Month m= null;
        mon = mon.toUpperCase();
        for (Month mn: Month.values()) {
            if (mon.equals(mn.name()))
            {
                m = mn;
            }
        }
        return m;
    }
}
