public class Roboter { 
    // Jeder Roboter soll eine Zeichenkette namens „name“ besitzen
    private String name;
    private String farbe;

    // Beim „Bau“ oder Erstellen name zuweisen
    // Wir brauchen einen Konstruktor
    // um Befehle beim Programmstart ausfuehren zu lassen
    // muss so heißen wie die Klasse (hier "Roboter")
    public Roboter(String neuerName, String neueFarbe) {
        System.out.println("Roboter wird gebaut...");
        
        name = neuerName;
        farbe = neueFarbe;
        
        System.out.println("Roboter ist fertig gebaut...");
    }

    public void gibName() {
        System.out.println( name );
    }
    
    public void begruesse() {
        System.out.println("Hallo, ich bin " + name);
    }
}

/*
 * Aufgaben:
 * 
 * 1. Definiere eine neue Variable „farbe“ in Roboter
 * 2. Übergeben Sie die neueFarbe im Konstruktor (hinter neuerName)
 * 3. Speichern Sie die neueFarbe als farbe im Konstruktor
 * 4. Erstellen Sie eine neue Funktion „gibFarbe()“, welche die Farbe
 *    zurückgibt
 * 5. begruesse() soll auch die Farbe des Roboters nennen 
*/