import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class Flight
{
    Scanner input = new Scanner(System.in);

    private String flightNumber;
    Passenger[] passengers;
    private Cities source;
    private Cities destination;
    private Date departureDate;
    private LocalDate arrivalDate;
    private Time departureTime;
    private Time arrivalTime;
    private boolean[] seatsAvailable;
    private double economyFare;
    private double businessFare;

    public Flight(String flightNumber, Cities source,
                  Cities destination, Date departureDate,
                  Time departureTime,Date arrivalDate, Time arrivalTime,
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

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public Time getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Time arrivalTime) {
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
    public boolean bookSeat(ArrayList <Flight> flightsForPassenger)
    {
        boolean result = false;
        System.out.print("Which Flight You Want to Select: ");
        String flNum = input.next();
        for (int i = 0; i < flightsForPassenger.size(); i++) {
            if (flNum.equals(flightsForPassenger.get(i).getFlightNumber()))
            {
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
                    for (int j = 0; j < seatsAvailable.length; j++) {
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
                        } else if (seats>numberOfSeats) {
                            break;

                        }

                    }
                }
            }

        }
        return result;
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
