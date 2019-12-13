

import java.util.Scanner; 
//Luisa Pietschmann

public class TicketAutomat {
    private Scanner tastaturEingabe;
    private int einzelpreis;
    private int gewuenschteAnzahlErwachsenenTickets;
    private int gewuenschteAnzahlKinderTickets;
    private int gewuenschteAnzahlQuickpassTickets;
    private int erwachsenenTicket;
    private int kinderTicket;
    private int quickpassTicket;
    private int gesamtPreis;
    private int bezahlterBetrag;
    private int restBetrag;


    public TicketAutomat() {
        tastaturEingabe = new Scanner(System.in);
        einzelpreis = 28;
        gewuenschteAnzahlErwachsenenTickets = -1;
        erwachsenenTicket = 30;
        kinderTicket = 25;
        quickpassTicket = 45;
        gewuenschteAnzahlKinderTickets = -1;
        gewuenschteAnzahlQuickpassTickets = -1;
        gesamtPreis = -1;
        bezahlterBetrag = -1;
        restBetrag = -1;

        zeigeMenu();
    }
  
    private void begruesse() {
        System.out.println(
            "Willkommmen im Phantasialand.\n" 
            );
            
            bezahlterBetrag = 0;
    }
    
    
    private void frageArtDerTicketsAb() {
      System.out.print(
        "Erwachsenen(18+) Ticket: " + erwachsenenTicket + "€\n" +
        "Kinder(6-18) Ticket: " + kinderTicket + "€\n" +
        "Quickpass Ticket : " + quickpassTicket + "€\n" +
        "Ab einer Anzahl von insgesamt 20 Tickets, egal welcher Art bekommen Sie einen Massenrabatt von 15%" + "\n"+
        "Wie viele Erwachsenen Tickets wollen Sie?"
        );
        gewuenschteAnzahlErwachsenenTickets = tastaturEingabe.nextInt();
        System.out.print("Wie viele Kinder Tickets wollen Sie?");
        gewuenschteAnzahlKinderTickets = tastaturEingabe.nextInt();
        System.out.print("Wie viele Quickpass Tickets wollen Sie?");
        gewuenschteAnzahlQuickpassTickets = tastaturEingabe.nextInt();
    }
    
    
    private void berechneGesamtpreis() {
        gesamtPreis = gewuenschteAnzahlErwachsenenTickets * erwachsenenTicket + gewuenschteAnzahlKinderTickets * kinderTicket + gewuenschteAnzahlQuickpassTickets * quickpassTicket;
        if (gewuenschteAnzahlErwachsenenTickets + gewuenschteAnzahlKinderTickets + gewuenschteAnzahlQuickpassTickets >= 20) {
            gesamtPreis = gesamtPreis - gesamtPreis * 15 / 100; 
        }
        System.out.println("Bitte werfen Sie " + gesamtPreis + "€ ein.");
    }
    
     private void verabschiedeDich() {

        System.out.println("Ciao! Der Nächste bitte. \n");

    }
    
     private void nimmGeldAn() {
        // TODO:
        // 1. Automat soll nur gültige Werte annehmen: 1, 2, 5, 10, 20, 50, 100
        // 0. tue das Folgende **so lange wie**.....
        while (bezahlterBetrag < gesamtPreis) {
            // 1. Fordere Benutzer auf, ein Geldstück/-schein einzuwerfen
           System.out.print("Wieviel Geld werfen Sie ein? Der Automat nimmt höchstens 100€-Scheine an. ");
            // 2. Lies den eingeworfenen Betrag über die Tastatur ein
            int eingeworfen; // lokale Variable
            eingeworfen = tastaturEingabe.nextInt();
            // Füge Betrag nur dann hinzu, wenn er 1 oder 2 oder ... ist
            if (eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5 || eingeworfen == 10 || eingeworfen == 20 || eingeworfen == 50 || eingeworfen == 100) {
                // 3. Addiere den Betrag <eingeworfen> zu <bezahlterBetrag>
                bezahlterBetrag = bezahlterBetrag + eingeworfen;
                restBetrag = gesamtPreis - bezahlterBetrag;
                System.out.print("Sie haben bislang " + bezahlterBetrag +
                    "€ eingeworfen. \n"); 
                if ( restBetrag > 0) {
                  System.out.print("Sie müssen noch " + restBetrag + "€ einwerfen. \n " );
                }               
            }
        }
    }
   
    
    private void berechneWechselgeld() {
        // 100€ - 80€
        int wechselgeld = bezahlterBetrag - gesamtPreis;
        // Gib wechselgeld aus, wenn es wechselgeld gibt
        if (wechselgeld > 0  ) {
            System.out.println("Sie bekommen noch " + wechselgeld + "€ zurück");
            while (wechselgeld >= 100) {
                System.out.print("[100€-Schein]");
                wechselgeld = wechselgeld - 100;
            }
            
            while (wechselgeld >= 50) {
                System.out.print("[50€-Schein]");
                wechselgeld = wechselgeld - 50;
            }
            
            while (wechselgeld >= 20) {
                System.out.print("[20€-Schein]");
                wechselgeld = wechselgeld - 20;
            }
            
            while (wechselgeld >= 10) {
                System.out.print("[10€-Schein]");
                wechselgeld = wechselgeld - 10;
            }
            
            while (wechselgeld >= 5) {
                System.out.print("[5€-Schein]");
                wechselgeld = wechselgeld - 5;
            }
            
            while (wechselgeld >= 2) {
                System.out.print("[2€-Münze]");
                wechselgeld = wechselgeld - 2;
            }
            
            while (wechselgeld >= 1) {
                System.out.print("[1€-Münze]");
                wechselgeld = wechselgeld - 1;
            }
                // Wenn Wechselgeld gröser gleich 100 dann 100 € drucken und 100€ von wechselgeld abziehen
        }
         // TODO: Gib Wechselgeld richtig gestückelt aus
         
    }
        
    
    
    private void druckeTicket() {
        System.out.println(" ");
        System.out.println("***********************");
        System.out.println("*Ihr Ticket fürs Glück*");
        System.out.println("***********************");
        System.out.println(" ");
    }
    
    private void druckeTickets() {
        int nochZuDrucken = gewuenschteAnzahlErwachsenenTickets + gewuenschteAnzahlKinderTickets + gewuenschteAnzahlQuickpassTickets;
        while (nochZuDrucken > 1) {
            System.out.println("Drucke noch " + nochZuDrucken + " Tickets...");
            druckeTicket();
            nochZuDrucken = nochZuDrucken -1; 
        }
        
        while (nochZuDrucken == 1) {
            System.out.println("Drucke noch " + nochZuDrucken + " Ticket...");
            druckeTicket();
            nochZuDrucken = nochZuDrucken -1; 
        }
    }
    
    public void zeigeMenu() {
        // Endlosschleife 
        while (true) {
            begruesse();
            frageArtDerTicketsAb();
            berechneGesamtpreis();
            nimmGeldAn();
            berechneWechselgeld();
            druckeTickets();
            verabschiedeDich();
        }
    }
}




