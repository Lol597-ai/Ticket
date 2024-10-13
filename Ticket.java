import java.util.ArrayList;
public abstract class Ticket {
    private boolean entwertet;
    private int preis;
    private String verfallsDatum;

    public Ticket(int preis, String verfallsDatum) {
        this.preis = preis;
        this.verfallsDatum = verfallsDatum;
        this.entwertet = false;
    }
    public boolean istEntwertet() {
        return entwertet;
    }
    public void entwerten() {
        this.entwertet = true;
    }

    public abstract boolean gueltigInZone(int zone);

    public static int kontrolliere(ArrayList<Ticket> tickets , int zone, String datum) {
        int schwarzFahrer = 0;

        for (Ticket ticket : tickets) {
            ticket.entwerten();

            if (ticket.istEntwertet() || !ticket.gueltigInZone(zone) || !pruefeGültigkeit(ticket, datum)) {
                schwarzFahrer++;
            }
        }

        return schwarzFahrer;
    }

    private static boolean pruefeGültigkeit(Ticket ticket, String aktuellesDatum) {
        if (ticket instanceof Einzelticket) {
            Einzelticket einzelticket = (Einzelticket) ticket;
            return einzelticket.getVerfallsDatum().compareTo(aktuellesDatum) >= 0;
        } else if (ticket instanceof Mehrfahrtenkarte) {
            Mehrfahrtenkarte mehrfahrtenkarte = (Mehrfahrtenkarte) ticket;
            return mehrfahrtenkarte.istEntwertet();
        } else if (ticket instanceof Generalabo) {
            Generalabo generalabo = (Generalabo) ticket;
            return generalabo.getVerfallsDatum().compareTo(aktuellesDatum) >= 0;
        }

        return false;
    }
}
