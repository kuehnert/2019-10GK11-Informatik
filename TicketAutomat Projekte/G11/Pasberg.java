import java.util.Scanner;

public class TicketAutomatSimone{
    private Scanner tastaturEingabe;
    private int erwachsenerpreis;
    private int kindpreis;
    private int gewuenschteAnzahlE;
    private int gewuenschteAnzahlK;
    private int gesamtPreis;
    private int bezahlterBetrag;

    public TicketAutomatSimone() {
        tastaturEingabe = new Scanner(System.in);
        erwachsenerpreis = 28;
        kindpreis = 8;
        gewuenschteAnzahlE = -1;
        gewuenschteAnzahlK = -1;
        gesamtPreis = -1;
        bezahlterBetrag = -1;

        zeigeMenu();
    }

    private void begruesse() {
        System.out.println(
            "Willkommen im Phantasee-Land!\n" +
            "Ein Ticket für einen Erwachsenen kostet " + erwachsenerpreis +
            "€ und für ein Kind " + kindpreis + "€\n"
        );
        bezahlterBetrag = 0;
    }

    // Abfragen Scanner
    private void frageAnzahlTicketsAb() {
        System.out.print("Wie viele Tickets für Erwachsene hätten Sie gerne? ");
        gewuenschteAnzahlE = tastaturEingabe.nextInt();
        System.out.print("Aha, Sie wollen also " +
            gewuenschteAnzahlE + " Erwachsenen-Tickets!\n");
            
        System.out.print("Wie viele Tickets für Kinder hätten Sie gerne? ");
        gewuenschteAnzahlK = tastaturEingabe.nextInt();
        System.out.print("Aha, Sie wollen also " +
            gewuenschteAnzahlK + " Kinder-Tickets!\n"
        );
    }

    private void berechneGesamtpreis() {
        gesamtPreis = gewuenschteAnzahlE * erwachsenerpreis +
        gewuenschteAnzahlK * kindpreis;
        System.out.println("Sehr schön. Das macht " +
            gesamtPreis + "€.\nBitte werfen Sie Geld ein.\n");
    }

    private void nimmGeldAn() {
        // TODO:
        // 1. Automat soll nur gültige Werte annehmen: 1, 2, 5 , 20, 50, 100

        // 0. Tue das Folgende <so lange wie>...
        // Ausdruck
        while (bezahlterBetrag < gesamtPreis) {
            // 1. Fordere Benutzer auf, ein Geldstück/-schein einzuwerfen
            System.out.println("Wieviel Geld werfen Sie ein?");

            // 2. Lies den eingeworfenen Betrag ein
            int eingeworfen; // temporäre/lokale Variable (nur in diesem Block verfügbar)
            eingeworfen = tastaturEingabe.nextInt(); // Rechts vom Gleicheitszeichen wird ausgwertet

            // Füge Betrag nur dann hinzu, wenn er 1 oder 2 oder ... ist
            // Bedingung
            if (eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5 ||
            eingeworfen == 10 || eingeworfen == 20 || eingeworfen == 50 ||
            eingeworfen == 100) {
                // 3. Addiere den Betrag <eingeworfen> zu bezahlterBetrag
                bezahlterBetrag = bezahlterBetrag + eingeworfen;

                System.out.println(" Sie haben " + bezahlterBetrag +
                    "€ eingeworfen.");
            }
            else {
                System.out.println("Der Wert wird nicht akzeptiert.");
            }
        }
    }

    private void berechneWechselgeld() {
        // 20€ = 100€ - 80€
        int wechselgeld = bezahlterBetrag - gesamtPreis;

        // Gib wechselgeld aus, wenn es wechselgeld gibt
        if (wechselgeld > 0) {
            System.out.println("Sie bekommen " + wechselgeld + "€ zurück.");
            
            // TODO: Gib Wechselgeld richtig gestückelt aus
            while (wechselgeld >= 100) {
                System.out.println("[100€-Schein]");
                wechselgeld = wechselgeld - 100;
            }
            while (wechselgeld >= 50) {
                System.out.println("[50€-Schein]");
                wechselgeld = wechselgeld - 50;
            }
            while (wechselgeld >= 20) {
                System.out.println("[20€-Schein]");
                wechselgeld = wechselgeld - 20;
            }
            while (wechselgeld >= 10) {
                System.out.println("[10€-Schein]");
                wechselgeld = wechselgeld - 10;
            }
            while (wechselgeld >= 5) {
                System.out.println("[5€-Schein]");
                wechselgeld = wechselgeld - 5;
            }
            while (wechselgeld >= 2) {
                System.out.println("[2€-Münze]");
                wechselgeld = wechselgeld - 2;
            }
            while (wechselgeld >= 1) {
                System.out.println("[1€-Münze]");
                wechselgeld = wechselgeld - 1;
            }
        }
    }

    private void druckeTicketE() {
        System.out.println(
            "#####################\n" +
            "# Erwachsenenticket #\n" +
            "# für               #\n" +
            "# Phantaseeland     #\n" +
            "#####################\n");
    }
    
        private void druckeTicketK() {
        System.out.println(
            "#####################\n" +
            "# Kinderticket      #\n" +
            "# für               #\n" +
            "# Phantaseeland     #\n" +
            "#####################\n");
    }

    private void druckeTicketsE() {
        int nochZuDrucken = gewuenschteAnzahlE;
        while (nochZuDrucken > 1) {
            System.out.println("Drucke noch " + nochZuDrucken + " Tickets...");
            druckeTicketE();
            //Verringere nochZuDrucken um 1
            nochZuDrucken =  nochZuDrucken -1;
        }
        if (nochZuDrucken > 0) {
            System.out.println("Drucke noch " + nochZuDrucken + " Ticket...");
            druckeTicketE();
            //Verringere nochZuDrucken um 1
            nochZuDrucken =  nochZuDrucken -1;
        }
    }
    
    private void druckeTicketsK() {
        int nochZuDrucken = gewuenschteAnzahlK;
        while (nochZuDrucken > 1) {
            System.out.println("Drucke noch " + nochZuDrucken + " Tickets...");
            druckeTicketK();
            //Verringere nochZuDrucken um 1
            nochZuDrucken =  nochZuDrucken -1;
        }
        if (nochZuDrucken > 0) {
            System.out.println("Drucke noch " + nochZuDrucken + " Ticket...");
            druckeTicketK();
            //Verringere nochZuDrucken um 1
            nochZuDrucken =  nochZuDrucken -1;
        }
    }
    
    private void verabschiedeDich() {
        System.out.println("Vielen Dank für Ihren Besuch. Haben Sie einen schönen Tag!");
    }

    public void zeigeMenu() {
        //Endlosschleife
        while (true) {
            begruesse();
            frageAnzahlTicketsAb();
            berechneGesamtpreis();
            nimmGeldAn();
            berechneWechselgeld();
            druckeTicketsE();
            druckeTicketsK();
            verabschiedeDich();
        }
    }
}