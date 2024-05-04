import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

public class Flight
{
    Scanner input = new Scanner(System.in);

    private String flightNumber;
    Passenger[] passengers;
    private Cities source;
    private Cities destination;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;
    private boolean[] seatsAvailable;
    private double economyFare;
    private double businessFare;

    public Flight(String flightNumber, Cities source,
                  Cities destination, LocalDate departureDate,
                  LocalTime departureTime,LocalDate arrivalDate, LocalTime arrivalTime,
                  int seats, double economyFare,
                  double businessFare)
    {
        setFlightNumber(flightNumber);
        setSource(source);
        setDestination(destination);
        setDepartureDate(departureDate);
        setDepartureTime(departureTime);
        setArrivalTime(arrivalTime);
        seatsAvailable = new boolean[seats];
        passengers = new Passenger[seats];
        setEconomyFare(economyFare);
        setBusinessFare(businessFare);

    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Cities getSource() {
        return source;
    }



    public void setSource(Cities source) {
        this.source = source;
    }

    public Cities getDestination() {
        return destination;
    }

    public void setDestination(Cities destination) {
        this.destination = destination;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public boolean[] getSeatsAvailable() {
        return seatsAvailable;
    }

    public void setSeatsAvailable(boolean[] seatsAvailable)
    {
        this.seatsAvailable = seatsAvailable;
    }

    public double getEconomyFare() {
        return economyFare;
    }

    public void setEconomyFare(double economyFare) {
        this.economyFare = economyFare;
    }

    public double getBusinessFare() {
        return businessFare;
    }

    public void setBusinessFare(double businessFare) {
        this.businessFare = businessFare;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public boolean checkSeatAvailable(int numberOfSeats)
    {

        boolean result=false;
        int seats=0;
        for (int i = 0; i < seatsAvailable.length; i++) {
            if(!seatsAvailable[i])
            {
                seats++;
            }

        }
        if (seats>=numberOfSeats)
        {
            result = true;
        }
        return result;
    }
    public boolean bookSeat()
    {
        boolean result = false;
        System.out.println("Enter Passenger Details");
        String temp = input.nextLine();
        System.out.print("Enter Name: ");
        String name = input.nextLine();
        System.out.print("Enter Phone Number: ");
        String ph = input.nextLine();
        System.out.print("Enter Email: ");
        String email = input.nextLine();
        System.out.print("Enter Number of Seats: ");
        int numberOfSeats = input.nextInt();
        while (!checkSeatAvailable(numberOfSeats))
        {
            System.out.println("Seats not Available");
            System.out.print("Enter Less Number of Seats Again: ");
            numberOfSeats = input.nextInt();
        }
        if (checkSeatAvailable(numberOfSeats))
        {
            int seats=0;
            for (int j = 0; j < seatsAvailable.length; j++)
            {
                if(!seatsAvailable[j])
                {
                    if (seats<numberOfSeats)
                    {
                        seatsAvailable[j]=true;
                        seats++;
                        passengers[j] = new Passenger(name, ph, email);
                        result = true;
                        System.out.println("Seats Booked.");
                    }
                } else if (seats>numberOfSeats)
                {
                    break;
                }

            }
        }

        return result;
    }
    public ArrayList<Passenger> displaySeats(Passenger pass)
    {
        ArrayList<Passenger>seats = new ArrayList<>();
        System.out.print("Seats : ");
        for (int i = 0; i < passengers.length; i++) {
            if (pass.getEmail().equals(passengers[i].getEmail()))
            {
                System.out.printf("%-3s", i+1);
                seats.add(passengers[i]);

            }
        }
        return seats;
    }
    public void cancelSeat()
    {
        String name, phNumber = null, email;
        System.out.print("Enter Name: ");
        name = input.nextLine();
        System.out.print("Email: ");
        email = input.next();
        Passenger pass = new Passenger(name, phNumber, email);
        String ch;
        int temp;
        ArrayList <Passenger> seats = displaySeats(pass);
        if (seats.size()>1)
        {
            System.out.print("\nDo You Want to cancel All Seats: ");
            ch = input.next();
            ch = ch.toUpperCase();
            if (ch.equals("ALL")) {
                for(int i=0; i< passengers.length; i++)
                {
                    if (pass.equals(passengers[i]))
                    {
                        passengers[i] = null;
                        seatsAvailable[i] = true;
                    }
                }
                System.out.println("All Seats Cancelled");
            }
            else if (ch.equals("NO")){
                temp = input.nextInt();
                passengers[temp-1]= null;
                System.out.println("Seats cancelled");
            }
        }
    }
    public ArrayList<Passenger> displaySeats(Passenger pass)
    {
        ArrayList<Passenger>seats = new ArrayList<>();
        System.out.print("Seats : ");
        for (int i = 0; i < passengers.length; i++) {
            if (pass.equals(passengers[i]))
            {
                System.out.printf("%-3s", i+1);
                seats.add(pass);

            }
        }
        return seats;
    }
    public void cancelSeat(Passenger pass)
    {
        String ch;
        int temp;
        ArrayList <Passenger> seats = displaySeats(pass);
        if (seats.size()>1)
        {
            System.out.print("\nDo You Want to cancel All Seats: ");
            ch = input.next();
            ch = ch.toUpperCase();
            if (ch.equals("ALL")) {
                for(int i=0; i< passengers.length; i++)
                {
                    if (pass.equals(passengers[i]))
                    {
                        passengers[i] = null;
                        seatsAvailable[i] = true;
                    }
                }
                System.out.println("All Seats Cancelled");
            }
            else {
                temp = input.nextInt();
                passengers[temp-1]= null;
                System.out.println("Seats cancelled");
            }
        }


    }


//    @Override
//    public String toString()
//    {
//        return "Flight{" +
//                "FlightNumber='" + flightNumber + '\'' +
//                ", passengers=" + passengers +
//                ", source='" + source + '\'' +
//                ", destination='" + destination + '\'' +
//                ", departureDate='" + departureDate + '\'' +
//                ", departureTime='" + departureTime + '\'' +
//                ", arrivalTime='" + arrivalTime + '\'' +
//                ", seatsAvailable=" + Arrays.toString(seatsAvailable) +
//                ", economyFare=" + economyFare +
//                ", businessFare=" + businessFare +
//                '}';
//    }
}
