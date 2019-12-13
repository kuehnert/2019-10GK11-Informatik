import java.util.Scanner;
public class TicketAutomat {
    private Scanner tastaturEingabe;
    private int einzelpreis;
    private int gewünschteAnzahl;
    private int gesamtPreis;
    private int bezahlterBetrag;
    private int druckeTickets;
    private int wechselgeld;
    public TicketAutomat() {
        tastaturEingabe = new Scanner(System.in);
        einzelpreis = 28;
        gewünschteAnzahl = -1;
        gesamtPreis = -1;
        bezahlterBetrag = -1;

        zeigeMenü();
    }

    private void begruesse() {
        System.out.println(
            "Willkommen im Disneyland!\n" +
            "1 Ticket kostet " + einzelpreis + "€\n"
        );

        bezahlterBetrag = 0;
    }

    // Abfragen Scanner
    private void frageAnzahlTicketsAb() {
        System.out.print("Wie viele Tickets? ");
        gewünschteAnzahl = tastaturEingabe.nextInt();
        System.out.print("Aha, Sie wollen also " +
            gewünschteAnzahl +
            " Tickets!"
        );
    }

    private void berechneGesamtpreis() {
        gesamtPreis = gewünschteAnzahl * einzelpreis;
        System.out.println(" Bitte werfen Sie " + gesamtPreis + "€ ein");
    }

    private void verabschiedeDich() {
        System.out.println("Ciao! Der Nächste bitte.");
    }

    private void nimmGeldAn() {
        // TODO:
        // Automat soll nur gültige Werte annehmen: 1, 2, 5, 10, 20, 50, 100

        // 0. tue das Folgende **so lange wie**.....
        while (bezahlterBetrag < gesamtPreis) {
            // 1. Fordere Benutzer auf, ein Geldstück/-schein einzuwerfen
            System.out.print("Wieviel Geld werfen Sie ein:\n ");

            // 2. Lies den eingeworfenen Betrag über die Tastatur ein
            int eingeworfen; // lokale Variable
            eingeworfen = tastaturEingabe.nextInt();

            // Füge Betrag nur dann hinzu wenn er 1 oder 2 oder ... ist

            if (eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5 || eingeworfen == 10
            || eingeworfen == 20 || eingeworfen == 50 || eingeworfen == 100) {

                // 3. Addiere den Betrag <eingeworfen> zu <bezahlterBetrag>
                bezahlterBetrag = bezahlterBetrag + eingeworfen;

                System.out.print("Sie haben bislang " + bezahlterBetrag +
                    " eingeworfen\n");
            } else {
                System.out.println("Der Wert wird nicht akzeptiert.");
            }
        }
    }

    private void berechneWechselgeld() {
        int wechselgeld = bezahlterBetrag - gesamtPreis;
        if (wechselgeld > 0) {
            System.out.println("Sie bekommen noch " + wechselgeld + "€ zurück\n");
            
            // TODO: Gib Wechselgeld richtig gestückelt aus
            while (wechselgeld >= 50) {
               System.out.print("[50€-Schein] ");
               wechselgeld = wechselgeld - 50;
            }
            
            while (wechselgeld >= 100) {
               System.out.print("[100€-Schein] ");
               wechselgeld = wechselgeld - 100;
            }
            
            while (wechselgeld >= 20) {
               System.out.print("[20€-Schein] ");
               wechselgeld = wechselgeld - 20;
            } 
            
            while (wechselgeld >= 10) {
               System.out.print("[10€-Schein] ");
               wechselgeld = wechselgeld - 10;
            }
            
            while (wechselgeld >= 5) {
               System.out.print("[5€-Schein] ");
               wechselgeld = wechselgeld - 5;
            }
            
            while (wechselgeld >= 2) {
               System.out.print("[2€-Münze] ");
               wechselgeld = wechselgeld - 2;
            }
            
            while (wechselgeld >= 1) {
               System.out.print("[1€-Münze] ");
               wechselgeld = wechselgeld - 1;
            }
        }
    }

    private  void druckeTickets() {
        int nochZuDrucken = gewünschteAnzahl;
        while (nochZuDrucken > 1){
            System.out.println("Drucke noch " + nochZuDrucken + " Tickets...");
            druckeTicket();
            nochZuDrucken = nochZuDrucken - 1;
        }
        
        if (nochZuDrucken > 0){
            System.out.println("Drucke noch " + nochZuDrucken + " Ticket...");
            druckeTicket();
            nochZuDrucken = nochZuDrucken - 1;
        }
    }

    private void druckeTicket() {
        System.out.println(
            "      ###############\n" +
            "      # Ein Ticket  #\n" +
            "      #  Für das    #\n" +
            "      # Disneyland  #\n" +
            "      ###############\n");

    }

    public void zeigeMenü() {
        while (true) {
            begruesse();
            frageAnzahlTicketsAb();
            berechneGesamtpreis();
            nimmGeldAn();
            berechneWechselgeld();
            druckeTickets();
            verabschiedeDich();
        }
    }
}
