public class Geldzaehler {
    private int anz10Cent;
    private int anz20Cent;
    private int anz50Cent;
    private int anz1Euro;
    private int anz2Euro;
    
    public Geldzaehler() {
        anz10Cent = 0;
        anz20Cent = 0;
        anz50Cent = 0;
        anz1Euro = 0;
        anz2Euro = 0;
    }
    
    // 10 => 10 Cent
    // 100 => 1 Euro
    public void wirfMuenzeEin(int wert) {
        if (wert == 10) {
            anz10Cent = anz10Cent + 1;
        } else if (wert == 20) {
            anz20Cent = anz20Cent + 1;
        } else if (wert == 50) {
            anz50Cent = anz50Cent + 1;
        }
        // TODO restliche Werte
    }
    
    public int gibGesamtWert() {
        return -1;
    }
    
    public void druckeUebersicht() {
        System.out.println(anz10Cent + " 10-Cent Stücke");
        System.out.println(anz20Cent + " 20-Cent Stücke");
        System.out.println(anz50Cent + " 50-Cent Stücke");
        System.out.println("Gesamtwert: " + gibGesamtWert());
    }
}
