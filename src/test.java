import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Flight f1 = new Flight("EK-1322", Cities.DUBAI, Cities.KARACHI, new Date(2024, 06, 06), new Time(20, 00, 00), new Date(2024, 06, 06), new Time(24, 00, 00), 26, 45000, 90000 );
        Flight f2 = new Flight("EK-132", Cities.ABU_DHABI, Cities.KARACHI, new Date(2024, 06, 06), new Time(20, 00, 00), new Date(2024, 06, 06), new Time(24, 00, 00), 26, 45000, 90000 );
        Flight f3 = new Flight("EK-1333", Cities.ABU_DHABI, Cities.KARACHI, new Date(2024, 06, 06), new Time(20, 00, 00), new Date(2024, 06, 06), new Time(14, 00, 00), 26, 45000, 90000 );
        ReservationManagement res = new ReservationManagement();
        res.addFlight(f1);
        res.addFlight(f2);
        res.addFlight(f3);

        ArrayList<Reservation>reservations = new ArrayList<>();
        Reservation r1 = new Reservation(f1);
        Reservation r2 = new Reservation(f2);
        Reservation r3 = new Reservation(f3);
        ArrayList <Flight> flightsForSelection = res.searchBySourceToDestination(Cities.ABU_DHABI, Cities.KARACHI);
        r1.getFlight().bookSeat(flightsForSelection);
        System.out.println(r1.getFlight().passengers[0]+" "+ r1.getFlight().passengers[1]);
        r1.getFlight().cancelSeat(new Passenger("Taha", "0309", "taha.saeed"));
    }
}
