import java.util.Scanner; //Scanner muss zuerst importiert werden

public class TicketAutomat{
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
            "1 Ticket kostet " + einzelpreis + "€.\n"
        );
        
        bezahlterBetrag = 0;
    }
    
    // Abfragen Scanner
    private void frageAnzahlTicketsAb() {
        System.out.print("Wie viele Tickets möchten Sie? ");
        gewuenschteAnzahl = tastaturEingabe.nextInt();
        System.out.print("Aha, Sie wollen also " + 
            gewuenschteAnzahl + " Tickets!\n" 
        );
    }
    
    private void berechneGesamtpreis() {
        gesamtPreis = gewuenschteAnzahl * einzelpreis;
        System.out.println("Bitte werfen Sie " + gesamtPreis + "€ ein.");
    }
    
    private void nimmGeldAn() {
        while (bezahlterBetrag < gesamtPreis) {
            System.out.print("Wieviel Geld werfen Sie ein: ");

            int eingeworfen; // lokale Variable
            eingeworfen = tastaturEingabe.nextInt();

                if (eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5 ||
                    eingeworfen == 10 || eingeworfen == 20 || eingeworfen == 50 ||
                    eingeworfen == 100) {
                bezahlterBetrag = bezahlterBetrag + eingeworfen;

                System.out.print("Sie haben bislang " + bezahlterBetrag +
                    " eingeworfen.\n");
            }
        }
    }
    
    public void berechneWechselgeld() {
        if ( bezahlterBetrag > gesamtPreis ) {
        int wechselgeld = bezahlterBetrag - gesamtPreis;

        if (wechselgeld > 0) {
            System.out.println("Sie bekommen noch " + wechselgeld + "€ zurück.");
           
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
                System.out.println("(2€-Stück)");
                wechselgeld = wechselgeld - 2;
            }
            
            while (wechselgeld >= 1) {
                System.out.println("(1€-Stück)");
                wechselgeld = wechselgeld - 1;
            }
        }
       }
    }
    
    private void druckeTicket() {
        System.out.println("########################\n");
        System.out.println("#Ihr Ticket fürs Glück!#\n");
        System.out.println("########################\n");
    }
    
    private void druckeTickets() {
        int nochZuDrucken = gewuenschteAnzahl;
        while (nochZuDrucken > 0) {
            System.out.println("Drucke noch " + nochZuDrucken + " Tickets...\n");
            druckeTicket();
            // Verringere nochZuDrucken um 1
            nochZuDrucken = nochZuDrucken - 1;
        }
    }
    
    private void verabschiedeDich() {
        System.out.println("Einen schönen Aufenthalt! Der Nächste bitte.\n");
    }
    
    public void zeigeMenu() {
        while (true) {
            begruesse();
            frageAnzahlTicketsAb();
            berechneGesamtpreis();
            nimmGeldAn();
            berechneWechselgeld();
            druckeTicket();
            druckeTickets();
            verabschiedeDich();
        }
    }
}