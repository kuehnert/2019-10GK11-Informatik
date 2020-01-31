import java.util.Scanner;

// TODO:
// 1. Zähle die Rate-Versuche (13) ✔
// 2. Wiederhole Spiel wenn gewünscht (7) ✔
// 3. Highscore speichern (4)
// 4. "Wärmer"/"kälter" (5.5)

public class RateSpiel {
    private Scanner tastaturEingabe; // Deklaration
    private int highscore; 
    private String heldin;

    public RateSpiel() {
        tastaturEingabe = new Scanner(System.in);
        highscore = 10000000;
        heldin = "";
    }
    
    private void spieleRunde() {
        int richtigeZahl = (int) (Math.random() * 100) + 1;
        int benutzerZahl = -1;
        int versuche = 0;

        while (benutzerZahl != richtigeZahl) {
            System.out.print("Dein Tipp: ");
            benutzerZahl = tastaturEingabe.nextInt();
            versuche = versuche + 1; // versuche += 1;

            if (richtigeZahl > benutzerZahl) {
                System.out.println("Meine Zahl ist größer");
            } else {
                System.out.println("Meine Zahl ist kleiner");
            }
        }

        System.out.println("Hurra, Du hast die Zahl geraten! :-)");
        System.out.println("Du hast " + versuche + " gebraucht.");
        
        if (versuche < highscore) {
            System.out.println("Du hast die Highscore geknackt!");
            // Wie heißt Du?
            heldin = "Anna";
        }
    }

    public void spielen() {
        boolean spielLaeuft = true;

        while (spielLaeuft) {
            System.out.println("Willkommen beim Ratespiel");
            System.out.println("Den Highscore von " + highscore + 
            "Versuchen hat " + heldin);
            System.out.println("Rate eine Zahl zwischen 1 und 100");

            spielen();

            System.out.print("Möchtest Du noch einmal spielen (j/n)? ");
            String antwort = tastaturEingabe.next();
            System.out.println("antwort: " + antwort);

            // antwort == "j" überprüft, ob die Speicheradressen
            //                gleich sind
            if (antwort.equals("n")) {
                spielLaeuft = false;
            } 
        }
    }
}
