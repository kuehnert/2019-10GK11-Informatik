//Ticketautomat von Simon W.
import java.util.Scanner;

public class TicketAutomat {
    private Scanner tastaturEingabe;
    private int einzelPreis;
    private int gewuenschteAnzahl;
    private int gewuenschteKinderAnzahl;
    private int gesamtPreis;
    private int bezahlterBetrag;
    private int gesamtpreis;
    private int kinderPreis;
    private int familienRabattProzent;
    private int gruppenRabattProzent;

    public TicketAutomat() {
        tastaturEingabe = new Scanner(System.in);
        einzelPreis = 28;
        kinderPreis = 20;
        familienRabattProzent = 20;
        gruppenRabattProzent = 24;
        gewuenschteKinderAnzahl = -1;
        gewuenschteAnzahl = -1;
        gesamtPreis = -1;
        bezahlterBetrag = -1;
        
        zeigeMenue();
    }

    private void begruesse() {
        System.out.print(
            "Herzlich Wilkommen im Grönalund!\n"+
            "Ein Erwachsenenticket kostet " + einzelPreis + "€\n" + 
            "Ein Kinderticket (bis 12 Jahre) kostet " + kinderPreis + "€\n" +
            "Bei 2 Erwachsenen und 2 Kindern gibt es " + familienRabattProzent +
            "% Familienrabatt\n" +
            "Bei 5 Erwachsenen gibt es " + gruppenRabattProzent + "% Gruppenrabatt\n"
        );
        bezahlterBetrag = 0;
    }
    
    private void frageAnzahlTickets(){
        System.out.print("Wie viele Erwachsenentickets möchten sie erwerben? ");
        gewuenschteAnzahl = tastaturEingabe.nextInt();
        
        System.out.print("Wie viele Kindertickets möchten sie erwerbem?");
        gewuenschteKinderAnzahl = tastaturEingabe.nextInt();

        if(gewuenschteAnzahl != 1){
            System.out.print("Sie möchten also " + gewuenschteAnzahl + " Erwachsenentickets");
        }
        else{
            System.out.print("Sie möchten also ein Erwachsenenticket");
        }
        
        if(gewuenschteKinderAnzahl != 1){
            System.out.print(" und " + gewuenschteKinderAnzahl + " Kindertickets.\n");
        }
        else{
            System.out.print(" und ein Kinderticket.\n");
        }      
    }
    
    private void berechneGesamtpreis() {
        gesamtPreis = einzelPreis * gewuenschteAnzahl + kinderPreis * gewuenschteKinderAnzahl;
        int erwachsenenTicketsUebrig = gewuenschteAnzahl;
        int kinderTicketsUebrig = gewuenschteKinderAnzahl;
        int preisnachlass = 0;
        
        while(erwachsenenTicketsUebrig >= 2 && kinderTicketsUebrig >= 2){
            preisnachlass = (2 * einzelPreis + 2 * kinderPreis) * familienRabattProzent / 100;        
            System.out.print("1x Familienrabatt, -" + familienRabattProzent + "%\n");
            erwachsenenTicketsUebrig = erwachsenenTicketsUebrig - 2;
            kinderTicketsUebrig = kinderTicketsUebrig -2;
            gesamtPreis = gesamtPreis - preisnachlass;
        }

        while(erwachsenenTicketsUebrig >= 5){
            preisnachlass = 5 * einzelPreis * familienRabattProzent / 100;
            System.out.print("1x Grupppenrabatt, -" + gruppenRabattProzent + "%\n");
            erwachsenenTicketsUebrig = erwachsenenTicketsUebrig - 5;
            gesamtPreis = gesamtPreis - preisnachlass;
        }
        System.out.println("Bitte werfen sie "  + gesamtPreis + "€ ein.");
    }
    
    private void berechneWechselgeld(){
        int wechselgeld = bezahlterBetrag - gesamtPreis;
        if(wechselgeld > 0){
                while(wechselgeld >= 100){
                    System.out.print("[100€]");
                    wechselgeld = wechselgeld -100;
                }
                while(wechselgeld >= 50){
                    System.out.print("[50€]");
                    wechselgeld = wechselgeld -50;
                }
                while(wechselgeld >= 20){
                    System.out.print("[20€]");
                    wechselgeld = wechselgeld -20;
                }
                while(wechselgeld >= 10){
                    System.out.print("[10€]");
                    wechselgeld = wechselgeld -10;
                }
                while(wechselgeld >= 5){
                    System.out.print("[5€]");
                    wechselgeld = wechselgeld -5;
                }
                while(wechselgeld >= 2){
                    System.out.print("(2€)");
                    wechselgeld = wechselgeld -2;
                }
                while(wechselgeld == 1){
                    System.out.print("(1€)");
                    wechselgeld = wechselgeld -1;
                }
        }
    }
    
    private void nimmGeldan(){
        while(bezahlterBetrag < gesamtPreis) {
            System.out.print("Wie viel Geld möchten sie einwerfen?");
            int eingeworfen; 
            eingeworfen = tastaturEingabe.nextInt();
            if(eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5
             || eingeworfen == 10 || eingeworfen == 20 || eingeworfen == 50
             || eingeworfen == 100){
                bezahlterBetrag = bezahlterBetrag + eingeworfen;
                System.out.print("\nSie haben bislang " + bezahlterBetrag +
                "€ eingeworfen!\n");
            }
            else{
                System.out.println("Bitte nur 1€, 2€, 5€, 10€, 20€, 50€, oder 100€");
            }
        }
        berechneWechselgeld();
    }
    
    private void druckeTicket(){
        System.out.println("##################################");
        System.out.println("#       Erwachsenenticket         #");
        System.out.println("##################################\n");
    }
    
    private void druckeKinderTicket(){
        System.out.println("##################################");
        System.out.println("#          Kinderticket           #");
        System.out.println("##################################\n");
    }
    
    private void druckeTickets() {
        int nochZuDrucken = gewuenschteAnzahl;
        int nochKinderZuDrucken = gewuenschteKinderAnzahl;
        if(gewuenschteAnzahl == 1 && gewuenschteKinderAnzahl == 0
            || gewuenschteKinderAnzahl == 1 && gewuenschteAnzahl == 0
        ){
            System.out.println("\nHier ist ihr Ticket:");
        }
        else{
            System.out.println("\nHier sind ihre Tickets:");
        }
        while(nochZuDrucken > 0){
            nochZuDrucken = nochZuDrucken -1; 
            druckeTicket();
        }
        while(nochKinderZuDrucken > 0){
            nochKinderZuDrucken = nochKinderZuDrucken -1;
            druckeKinderTicket();
        }
    }
    
    private void verabschiede(){
        System.out.print("Vielen Dank für ihren Besuch im Grönalund, " +
        "Wir wünschen ihnen viel Spaß!\n\n");
    }
    
    private void zeigeMenue() {
        while(true){
            begruesse();
            frageAnzahlTickets();
            berechneGesamtpreis();
            nimmGeldan();
            druckeTickets();
            verabschiede();
        }
    }
}