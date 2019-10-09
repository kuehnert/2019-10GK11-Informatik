public class AutoHaus {
    Auto auto1, auto2, auto3;
    
    public AutoHaus() {
        auto1 = new Auto("VW", 3, 10000);
        auto2 = new Auto("BMW", 7, 100010);
        auto3 = new Auto("Mercedes", 5, 50000);
    }
    
    private void druckeAuto(Auto auto) {
        System.out.println(
            "****************************************\n" +
            "* Auto                                 *\n" + 
            auto.gibMarke() +
            ", " + auto.gibAnzahlTueren() + "-Türer " + 
            " kostet " +
            auto.gibPreis()
        );
    }
    
    public void druckeAlleAutos() {
        druckeAuto(auto1);
        druckeAuto(auto2);
        druckeAuto(auto3);
    }
    
    public void druckePreisAllerAutos() {
        int summe; // Erstelle eine neue Variable summe vom Typ Zahl
        summe = 0; // Setze summe auf 0
        
        summe = auto1.gibPreis() + auto2.gibPreis() + auto3.gibPreis();
        
        System.out.println("Der Gesamtpreis aller Autos ist: " + 
            summe);
    }
}