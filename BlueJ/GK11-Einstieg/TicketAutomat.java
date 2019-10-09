import java.util.Scanner;

public class TicketAutomat {
    private Scanner tastaturEingabe;
    private int einzelpreis;
    private int gewuenschteAnzahl;
    private int gesamtPreis;
    private int bezahlterBetrag;

    public TicketAutomat() {
        tastaturEingabe = new Scanner(System.in);
        einzelpreis = 28;
        gewuenschteAnzahl = -1;
        gesamtPreis = -1;
        bezahlterBetrag = -1;

        zeigeMenu();
    }

    private void begruesse() {
        System.out.println(
            "Willkommen im Phantaseeland!\n" +
            "1 Ticket kostet " + einzelpreis + "€\n"
        );
        
        bezahlterBetrag = 0;
    }

    // Abfragen Scanner
    private void frageAnzahlTicketsAb() {
        System.out.print("Wie viele Tickets? ");
        gewuenschteAnzahl = tastaturEingabe.nextInt();
        System.out.print("Aha, Sie wollen also " +
            gewuenschteAnzahl +
            " Tickets!"
        );
    }

    private void berechneGesamtpreis() {
        gesamtPreis = gewuenschteAnzahl * einzelpreis;
        System.out.println("Bitte werfen Sie " + gesamtPreis + "€ ein");
    }

    private void verabschiedeDich() {
        System.out.println("Ciao! Der Nächste bitte.");
    }

    private void nimmGeldAn() {
        // 0. tue das Folgende **so lange wie**.....
        while (bezahlterBetrag < gesamtPreis) {
            // 1. Fordere Benutzer auf, ein Geldstück/-schein einzuwerfen
            System.out.print("Wieviel Geld werfen Sie ein: ");

            // 2. Lies den eingeworfenen Betrag über die Tastatur ein
            int eingeworfen; // lokale Variable
            eingeworfen = tastaturEingabe.nextInt();

            // 3. Addiere den Betrag <eingeworfen> zu <bezahlterBetrag>
            bezahlterBetrag = bezahlterBetrag + eingeworfen;
            
            System.out.print("Sie haben bislang " + bezahlterBetrag +
                " eingeworfen");
        }
    }

    private void berechneWechselgeld() {
    }

    public void zeigeMenu() {
        begruesse();
        frageAnzahlTicketsAb();
        berechneGesamtpreis();
        nimmGeldAn();
        berechneWechselgeld();
        verabschiedeDich();
    }
}
