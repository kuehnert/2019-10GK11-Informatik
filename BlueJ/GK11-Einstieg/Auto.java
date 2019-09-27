public class Auto {
    private String marke;
    private int preis; 
    private int anzahlTueren;
    
    // Konstruktor: Erstellung eines neuen Autos
    public Auto(String neueMarke, int neueAnzahlTueren, int neuerPreis) {
        marke = neueMarke;
        anzahlTueren = neueAnzahlTueren;
        preis = neuerPreis;
    }
    
    public String gibMarke() {
        return marke;
    }
    
    public int gibPreis() {
        return preis;
    }
    
    public int gibAnzahlTueren() {
        return anzahlTueren;
    }
}
