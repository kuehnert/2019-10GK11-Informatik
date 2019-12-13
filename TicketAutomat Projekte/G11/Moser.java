//Ticketautomat von Andreas Moser GK10 G11/
import java.util.Scanner;
public class TicketAutomat {
    private Scanner tastaturEingabe;
    private int einzelpreis_erwachsener;
    private int einzelpreis_erwachsener_rabatt;
    private int einzelpreis_kind;
    private int einzelpreis_kind_rabatt;
    private int gewuenschteAnzahl;
    private int gewuenschtePersonenAnzahl;
    private int gesamtPreis;
    private int bezahlterBetrag;
    public TicketAutomat() {
        tastaturEingabe = new Scanner(System.in);
        einzelpreis_erwachsener = 28;
        einzelpreis_kind = 14;
        einzelpreis_erwachsener_rabatt = 21;
        einzelpreis_kind_rabatt = 11;
        gewuenschteAnzahl = -1;
        gewuenschtePersonenAnzahl = -1;
        gesamtPreis = -1;
        bezahlterBetrag = -1;
        zeigeMenu();
    }
    private void begruesse() {
        System.out.println("******************************************");
        System.out.println("Willkommen im Phantasialand!\n" + "1 Ticket für einen Erwachsenen kostet " + einzelpreis_erwachsener + "€ und für ein Kind " + einzelpreis_kind + "€.");
        System.out.println("Bei einer Buchung von mindestens 5 Kindern oder Erwachsenen erhalten sie einen Mengenrabatt von 25%.");
        System.out.println("\n");
        bezahlterBetrag = 0;
    }
    private void preisklasse(){
        System.out.println("Bitte 1 drücken um den Erwachsenenpreis und 2 um den Kinderpreis zu erhalten.");
        int eingeworfen2;
        eingeworfen2 = tastaturEingabe.nextInt();
        if(eingeworfen2 == 1) {
         System.out.println("Sie haben sich für den Erwachsenenpreis entschieden.");
         System.out.println("................................");
         System.out.print("Wie viele Tickets? ");
         gewuenschteAnzahl = tastaturEingabe.nextInt();
         if(gewuenschteAnzahl == 1 || gewuenschteAnzahl == 2 || gewuenschteAnzahl == 3 || gewuenschteAnzahl == 4) {
         System.out.println("Aha, Sie wollen also " + gewuenschteAnzahl + " Tickets!");
         System.out.println("******************************************");
         gesamtPreis = gewuenschteAnzahl * einzelpreis_erwachsener;
         
         System.out.println(" Bitte werfen Sie " + gesamtPreis + "€ ein");
         while (bezahlterBetrag < gesamtPreis) {
            System.out.print("Wieviel Geld werfen Sie ein: ");
            int eingeworfen;
            eingeworfen = tastaturEingabe.nextInt();
            if (eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5 || eingeworfen == 10 || eingeworfen == 20 || eingeworfen == 50 || eingeworfen == 100) {
                bezahlterBetrag = bezahlterBetrag + eingeworfen;
                System.out.print("Sie haben bislang " + bezahlterBetrag + " eingeworfen");
            }
            else {
                System.out.println("!! Der Automat nimmt nur 1, 2, 5, 10, 20, 50 und 100€ Münzen/Scheine an !!");
                System.out.println("Sie bekommen noch " + eingeworfen + "€ zurück");
            }
        }
        int wechselgeld = bezahlterBetrag - gesamtPreis;
        if (wechselgeld > 0) {
            System.out.println("Sie bekommen noch " + wechselgeld + "€ zurück");
            while (wechselgeld >= 50) {
                System.out.print("[50€-Schein ]");
                wechselgeld = wechselgeld - 50;
            }
            while (wechselgeld >= 100) {
                System.out.print("[100€-Schein ]");
                wechselgeld = wechselgeld - 100;
            }
            while (wechselgeld >= 20) {
                System.out.print("[20€-Schein ]");
                wechselgeld = wechselgeld - 20;
            }
            while (wechselgeld >= 10) {
                System.out.print("[10€-Schein ]");
                wechselgeld = wechselgeld - 10;
            }
            while (wechselgeld >= 5) {
                System.out.print("[5€-Schein  ]");
                wechselgeld = wechselgeld - 5;
            }
            while (wechselgeld >= 2) {
                System.out.print("[2€-Münze ]");
                wechselgeld = wechselgeld - 2;
            }
            while (wechselgeld >= 1) {
                System.out.print("[1€-Münze ]");
                wechselgeld = wechselgeld - 1;
            }
        }
        }
        else {
         System.out.println("Aha, Sie wollen also " + gewuenschteAnzahl + " Tickets!");
         System.out.println("******************************************");
         gesamtPreis = gewuenschteAnzahl * einzelpreis_erwachsener_rabatt;
         
         System.out.println(" Bitte werfen Sie " + gesamtPreis + "€ ein");
         while (bezahlterBetrag < gesamtPreis) {
            System.out.print("Wieviel Geld werfen Sie ein: ");
            int eingeworfen;
            eingeworfen = tastaturEingabe.nextInt();
            if (eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5 || eingeworfen == 10 || eingeworfen == 20 || eingeworfen == 50 || eingeworfen == 100) {
                bezahlterBetrag = bezahlterBetrag + eingeworfen;
                System.out.print("Sie haben bislang " + bezahlterBetrag + " eingeworfen");
            }
            else {
                System.out.println("!! Der Automat nimmt nur 1, 2, 5, 10, 20, 50 und 100€ Münzen/Scheine an !!");
                System.out.println("Sie bekommen noch " + eingeworfen + "€ zurück");
            }
        }
        int wechselgeld = bezahlterBetrag - gesamtPreis;
        if (wechselgeld > 0) {
            System.out.println("Sie bekommen noch " + wechselgeld + "€ zurück");
            while (wechselgeld >= 50) {
                System.out.print("[50€-Schein ]");
                wechselgeld = wechselgeld - 50;
            }
            while (wechselgeld >= 100) {
                System.out.print("[100€-Schein ]");
                wechselgeld = wechselgeld - 100;
            }
            while (wechselgeld >= 20) {
                System.out.print("[20€-Schein ]");
                wechselgeld = wechselgeld - 20;
            }
            while (wechselgeld >= 10) {
                System.out.print("[10€-Schein ]");
                wechselgeld = wechselgeld - 10;
            }
            while (wechselgeld >= 5) {
                System.out.print("[5€-Schein  ]");
                wechselgeld = wechselgeld - 5;
            }
            while (wechselgeld >= 2) {
                System.out.print("[2€-Münze ]");
                wechselgeld = wechselgeld - 2;
            }
            while (wechselgeld >= 1) {
                System.out.print("[1€-Münze ]");
                wechselgeld = wechselgeld - 1;
            }
        }
        }
        }
        if (eingeworfen2 == 2) {
         System.out.println("Sie haben sich für den Kinderpreis entschieden.");
         System.out.println("................................");
         System.out.print("Wie viele Tickets? ");
         gewuenschteAnzahl = tastaturEingabe.nextInt();
         if(gewuenschteAnzahl == 1 || gewuenschteAnzahl == 2 || gewuenschteAnzahl == 3 || gewuenschteAnzahl == 4){
         System.out.println("Aha, Sie wollen also " + gewuenschteAnzahl + " Tickets!");
         System.out.println("******************************************");
         gesamtPreis = gewuenschteAnzahl * einzelpreis_kind;
         
         System.out.println(" Bitte werfen Sie " + gesamtPreis + "€ ein");
         while (bezahlterBetrag < gesamtPreis) {
            System.out.print("Wieviel Geld werfen Sie ein: ");
            int eingeworfen;
            eingeworfen = tastaturEingabe.nextInt();
            if (eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5 || eingeworfen == 10 || eingeworfen == 20 || eingeworfen == 50 || eingeworfen == 100) {
                bezahlterBetrag = bezahlterBetrag + eingeworfen;
                System.out.print("Sie haben bislang " + bezahlterBetrag + " eingeworfen");
            }
            else {
                System.out.println("!! Der Automat nimmt nur 1, 2, 5, 10, 20, 50 und 100€ Münzen/Scheine an !!");
                System.out.println("Sie bekommen noch " + eingeworfen + "€ zurück");
            }
        }
        int wechselgeld = bezahlterBetrag - gesamtPreis;
        if (wechselgeld > 0) {
            System.out.println("Sie bekommen noch " + wechselgeld + "€ zurück");
            while (wechselgeld >= 50) {
                System.out.print("[50€-Schein ]");
                wechselgeld = wechselgeld - 50;
            }
            while (wechselgeld >= 100) {
                System.out.print("[100€-Schein ]");
                wechselgeld = wechselgeld - 100;
            }
            while (wechselgeld >= 20) {
                System.out.print("[20€-Schein ]");
                wechselgeld = wechselgeld - 20;
            }
            while (wechselgeld >= 10) {
                System.out.print("[10€-Schein ]");
                wechselgeld = wechselgeld - 10;
            }
            while (wechselgeld >= 5) {
                System.out.print("[5€-Schein  ]");
                wechselgeld = wechselgeld - 5;
            }
            while (wechselgeld >= 2) {
                System.out.print("[2€-Münze ]");
                wechselgeld = wechselgeld - 2;
            }
            while (wechselgeld >= 1) {
                System.out.print("[1€-Münze ]");
                wechselgeld = wechselgeld - 1;
            }
        }
        }
        else {
         System.out.println("Aha, Sie wollen also " + gewuenschteAnzahl + " Tickets!");
         System.out.println("******************************************");
         gesamtPreis = gewuenschteAnzahl * einzelpreis_kind_rabatt;
         
         System.out.println(" Bitte werfen Sie " + gesamtPreis + "€ ein");
         while (bezahlterBetrag < gesamtPreis) {
            System.out.print("Wieviel Geld werfen Sie ein: ");
            int eingeworfen;
            eingeworfen = tastaturEingabe.nextInt();
            if (eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5 || eingeworfen == 10 || eingeworfen == 20 || eingeworfen == 50 || eingeworfen == 100) {
                bezahlterBetrag = bezahlterBetrag + eingeworfen;
                System.out.print("Sie haben bislang " + bezahlterBetrag + " eingeworfen");
            }
            else {
                System.out.println("!! Der Automat nimmt nur 1, 2, 5, 10, 20, 50 und 100€ Münzen/Scheine an !!");
                System.out.println("Sie bekommen noch " + eingeworfen + "€ zurück");
            }
        }
        int wechselgeld = bezahlterBetrag - gesamtPreis;
        if (wechselgeld > 0) {
            System.out.println("Sie bekommen noch " + wechselgeld + "€ zurück");
            while (wechselgeld >= 50) {
                System.out.print("[50€-Schein ]");
                wechselgeld = wechselgeld - 50;
            }
            while (wechselgeld >= 100) {
                System.out.print("[100€-Schein ]");
                wechselgeld = wechselgeld - 100;
            }
            while (wechselgeld >= 20) {
                System.out.print("[20€-Schein ]");
                wechselgeld = wechselgeld - 20;
            }
            while (wechselgeld >= 10) {
                System.out.print("[10€-Schein ]");
                wechselgeld = wechselgeld - 10;
            }
            while (wechselgeld >= 5) {
                System.out.print("[5€-Schein  ]");
                wechselgeld = wechselgeld - 5;
            }
            while (wechselgeld >= 2) {
                System.out.print("[2€-Münze ]");
                wechselgeld = wechselgeld - 2;
            }
            while (wechselgeld >= 1) {
                System.out.print("[1€-Münze ]");
                wechselgeld = wechselgeld - 1;
            }
        }
        }
    }
    }
    private void verabschiedeDich() {
        System.out.println("Viel Spaß im Phantasialand");
        System.out.println("******************************************");
    }
    
    private void druckeTickets() {
        int nochZuDrucken = gewuenschteAnzahl;
        while (nochZuDrucken > 1) {
            System.out.println("Drucke noch " + nochZuDrucken + " Tickets...");
            druckeTicket();
            nochZuDrucken = nochZuDrucken - 1;
        }
        if (nochZuDrucken < 2) {
            System.out.println("Drucke noch 1 Ticket...");
            druckeTicket();
        }            
    }
    private void druckeTicket(){
        System.out.println(" ");
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println("~Ihr Ticket fürs~");
        System.out.println("~~PhantasiaLand~~");
        System.out.println("~Datum: 13.11.19~");
        System.out.println("~Gruppenanzahl: ~");
        System.out.println("~~~~~~~ " + gewuenschteAnzahl + " ~~~~~~~");
        System.out.println("~~~~~~~~~~~~~~~~~");
        System.out.println(" ");
    }
    public void zeigeMenu() {
        while (true) {
            begruesse();
            preisklasse();
            druckeTickets();
            verabschiedeDich();
        }
    }
}
//Andreas Moser