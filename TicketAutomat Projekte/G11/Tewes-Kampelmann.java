import java.util.Scanner;

public class TicketAutomat {
    private Scanner tastaturEingabe;
    private int kinderpreis ;
    private int erwachsenenpreis; 
    private int gewünschteAnzahl;
    private int gesamtPreis;
    private int bezahlterBetrag;
    private int gewünschteAnzahlkinder;
    private int gewünschteAnzahlerwachsene;
    private int gesamtheitallerkinderTickets;
    private int gesamtheitallerTicketsfürErwachsene;
    private int gesamtheitallerkinder;
    private int gesamtheitallererwachsene;
    private int gesamtheitallererwachsenenTickets;

    public TicketAutomat() {
        tastaturEingabe = new Scanner(System.in);
        erwachsenenpreis = 48; 
        kinderpreis = 14;
        gewünschteAnzahl = 0;
        gesamtPreis = -1;
        bezahlterBetrag = -1;
    }

    private void begrüsse () {
        System.out.println(
            "Willkommen in Theresas Freizeitspaßland."+
            "Ein Kinderticket kostet" + kinderpreis +"€ und ein Ticket für Erwachsene kostet" +
             erwachsenenpreis + "€\n.");
             

    }
   
    private void berechneGesamtpreis() {
        gesamtPreis = gewünschteAnzahlkinder * kinderpreis +
        gewünschteAnzahlerwachsene * erwachsenenpreis
        ;
        System.out.println("Bitte werfen Sie" + gesamtPreis + "€ ein"); 
    }
    
    
    
    private void verabschiedeDich(){
        System.out.println("Auf Wiedersehen! Der Nächste Bitte.");
    }

    public void zeigmenu() {
        begrüsse(); 
        frageNachAnzahlErwachseneUndKinder();
        berechneGesamtpreis();
        berechneWechselgeld();
        druckeTicketskind();
        druckeTicketserwachsen();
        verabschiedeDich();
        
        
    }
    
    private void druckeTicketskind(){
        gesamtheitallerkinderTickets = gewünschteAnzahlkinder;
        while (gesamtheitallerkinder > 1){
            System.out.println("Drucke noch" + gesamtheitallerkinderTickets + "Tickets...");
            druckeTicketkind();
            gesamtheitallerkinder = gesamtheitallerkinder -1;
        }
        
        if (gesamtheitallerkinder > 0){
            System.out.println("Drucke noch" + gesamtheitallerkinder + "Tickets...");
            druckeTicketkind();
            gesamtheitallerkinder = gesamtheitallerkinder -1;
        }
    }
    
    private void druckeTicketkind(){
        
        System.out.println("##################################");
        System.out.println("# Ihr Ticket fürs Glück!(kind)   #");
        System.out.println("##################################\n");
    }
    
    private void druckeTicketserwachsen(){
        gesamtheitallererwachsenenTickets = gewünschteAnzahlerwachsene;
        while (gesamtheitallererwachsene > 1){
            System.out.println("Drucke noch" + gesamtheitallererwachsenenTickets + "Tickets...");
            druckeTicketerwachsen();
            gesamtheitallererwachsene = gesamtheitallererwachsene -1;
        }
        
        if (gesamtheitallererwachsene > 0){
            System.out.println("Drucke noch" + gesamtheitallererwachsene + "Tickets...");
            druckeTicketerwachsen();
            gesamtheitallererwachsene = gesamtheitallererwachsene -1;
        }
    }
    
    private void druckeTicketerwachsen(){
        gesamtheitallerTicketsfürErwachsene = gewünschteAnzahlerwachsene;
        System.out.println("####################################");
        System.out.println("# Ihr Ticket fürs Glück!(erwachsen)#");
        System.out.println("####################################\n");
    }

    private void berechneWechselgeld() { 
        //100€ - 80€

        int wechselgeld = bezahlterBetrag - gesamtPreis; 

        // Gib wechselgeld aus, wenn es wechselgeld gibt 

        if (wechselgeld > 0) { 
            System.out.println("Sie bekommen noch" + wechselgeld + "€ zurück");

            // TODO: Gib Wechselgeld richtig gestückelt aus 

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
                System.out.print("[2€-Schein]");
                wechselgeld = wechselgeld - 2; 
            }

            while (wechselgeld >= 1) { 
                System.out.print("[1€-Schein]");
                wechselgeld = wechselgeld - 1; 
            }

        }
    }
    private void frageNachAnzahlErwachseneUndKinder(){
        System.out.print("Wie viele Kindertickets benötigen sie?");
        gewünschteAnzahlkinder = tastaturEingabe.nextInt();
        System.out.print("okay, und wie viele Tickets für Erwachsene benötigen sie?");
        gewünschteAnzahlerwachsene = tastaturEingabe.nextInt();
        System.out.print("okay, sie wollen also" + 
        gewünschteAnzahlkinder + 
        "Kindertickets und"
        + gewünschteAnzahlerwachsene +
        "Tickets für Erwachsene."
        );
    }
}  
 