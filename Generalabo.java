public class Generalabo extends Ticket {

	private String inhaber; // Nur für diese Person gültig!
        private int zone; 
        private int fahrten;
	
    
    public Generalabo(int preis,int fahrten,int Zone, String inhaber, String verfallsDatum) {
        super(preis,verfallsDatum);
        this.fahrten = fahrten;
        this.zone = zone;
        this.inhaber = inhaber;
        

    }
    public String gibInhaber() {
            return inhaber;
    }
    public boolean gueltigInZone(int zone) {
            return zone == this.zone;
    }
    public int getZone() {
            return zone;
    }
}
