import java.sql.SQLException;
import java.util.Scanner;
public class TicketTransactions {
    DBTransactions t = new DBTransactions();
    Scanner sc = new Scanner(System.in);
    public void TicketOptions() throws SQLException {
        System.out.println("-------------OPTIONS--------------------");
        System.out.println("1.Ticket Booking");
        System.out.println("2.Ticket Checking");
        int option = sc.nextInt();
        switch (option) {
            case 1 :
                System.out.println("1.Istanbul");
                System.out.println("2.Ankara");
                System.out.println("3.İzmir");
                System.out.println("4.Konya");
                int busChoice = sc.nextInt();
                switch (busChoice){
                    case 1:
                        t.TicketBooking(1);
                        break;
                    case 2:
                        t.TicketBooking(2);
                        break;
                    case 3:
                        t.TicketBooking(3);
                        break;
                    case 4:
                        t.TicketBooking(4);
                        break;
                }

                t.Payment(); break;
            case 2 : t.TicketChecking();
        }

    }

}
