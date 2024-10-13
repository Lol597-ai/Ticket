
class Mehrfahrtenkarte extends Ticket {
    private int fahrten;
    private int zone;
    
    public Mehrfahrtenkarte(int preis, int fahrten, int zone, String verfallsdatum) {
        super(preis, verfallsdatum);
        this.fahrten = fahrten;
        this.zone = zone;
        
    }
   

    public void entwerten() {
        if (fahrten > 0) {
            fahrten-=1;
        }
    }

    public boolean istEntwertet() {
        return fahrten == 0;
    }

    public boolean gueltigInZone(int zone) {
        return zone == this.zone;
    }
	public int getRemainingFahrten() {
        return fahrten;
    }
}