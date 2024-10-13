import java.util.ArrayList;
public class main {
    public static void main(String[] args) {
        ArrayList<Ticket> tickets = new ArrayList<>();

        // Example tickets
        tickets.add(new Einzelticket(10, "20220201", 1));
        tickets.add(new Mehrfahrtenkarte(10, 5, 1, "20220201"));
        tickets.add(new Generalabo(50,1,1, "John Doe", "20220201"));

        // Ticketkontrolle
        int schwarzeFahrer = kontrolliere(tickets, 1);
        System.out.println("Number of fare evaders: " + schwarzeFahrer);

        // Print ticket information
        System.out.println("Ticket information:");
        for (Ticket ticket : tickets) {
            System.out.println("Inhaber: " + getInhaber(ticket));
            System.out.println("Entwertet: " + ticket.istEntwertet());
            System.out.println("Gültig in Zone " + getZone(ticket) + ": " + ticket.gueltigInZone(1));
            if (ticket instanceof Einzelticket) {
                Einzelticket einzel = (Einzelticket) ticket;
                System.out.println("Verfallsdatum: " + einzel.getVerfallsDatum());
            } else if (ticket instanceof Mehrfahrtenkarte) {
                Mehrfahrtenkarte mehrfahrten = (Mehrfahrtenkarte) ticket;
                System.out.println("Remaining Fahrten: " + mehrfahrten.getRemainingFahrten());
            } 
            
        }
    }

    private static String getInhaber(Ticket ticket) {
        if (ticket instanceof Generalabo) {
            return ((Generalabo) ticket).gibInhaber();
        } else {
            return "N/A";
        }
    }

    private static int getZone(Ticket ticket) {
        if (ticket instanceof Generalabo) {
            return ((Generalabo) ticket).getZone();
        } else {
            return -1; // Default value or handle accordingly
        }
    }

    private static int kontrolliere(ArrayList<Ticket> tickets, int zone) {
        int schwarzeFahrer = 0;
        for (Ticket ticket : tickets) {
            ticket.entwerten();
            if (!ticket.gueltigInZone(zone)) {
                schwarzeFahrer++;
            }
        }
        return schwarzeFahrer;
    }
}