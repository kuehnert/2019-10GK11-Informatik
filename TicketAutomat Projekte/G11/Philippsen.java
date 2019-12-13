import java.util.Scanner;

public class TicketAutomat {
    private int preisKinder;
    private int preisJugendliche;
    private int preisErwachsene;
    private int preisKleinkinder;

    private String zweihunderter;
    private String hunderter;
    private String fuenfziger;
    private String zwanziger;
    private String zehner;
    private String fuenfer;

    private int anzahlKinderTickets;
    private int anzahlJugendlichenTickets;
    private int anzahlErwachsenenTickets;
    private int anzahlKleinkinderTickets;
    private int gewuenschteAnzahl;
    private int rueckzweihundert;
    private int rueckhundert;
    private int rueckfuenfzig;
    private int rueckzwanzig;
    private int rueckzehn;
    private int rueckfuenf;

    private int gesamtpreis;
    private int restsumme;
    private int bezahlterBetrag;

    private boolean einwurf;
    private boolean rueckgeld;

    private Scanner input;

    public TicketAutomat()  {
        input = new Scanner(System.in);
        preisKinder = 20;
        preisJugendliche = 35;
        preisErwachsene = 45;
        preisKleinkinder = 0;

        anzahlKinderTickets = -1;
        anzahlJugendlichenTickets = -1;
        anzahlErwachsenenTickets = -1;
        anzahlKleinkinderTickets = -1;

        gesamtpreis = -1;
        restsumme = -1;
        bezahlterBetrag = -1;

        rueckzweihundert = 0;
        rueckhundert = 0;
        rueckfuenfzig = 0;
        rueckzwanzig = 0;
        rueckzehn = 0;
        rueckfuenf = 0;

        zweihunderter = "200€\n";
        hunderter = "100€\n";
        fuenfziger = "50€\n";
        zwanziger = "20€\n";
        zehner = "10€\n";
        fuenfer = "5€\n";

        einwurf = true;
        rueckgeld = true;
    }

    private void  begruesse(){
        System.out.println("Hallo, Willkommen im Phantasialand.\n" +
            "1 Kindeticket kostet " + preisKinder + "€ (bis 12 Jahre)\n" +
            "1 Erwachsenenticket kostet " + preisErwachsene + "€\n" +
            "1 Jugendlichenticket kostet " + preisJugendliche + "€ (bis 16 Jahre)\n" +
            "1 Kleinkindeticket kostet " + preisKleinkinder + "€ (bis 6 Jahre)\n");
    }

    private void verabschiede() { 
        System.out.println("Viel Spaß! Der Nächste bitte :-)");
    }
    
    private void frageAnzahlTickets() {
        System.out.print("Wie viele Erwachsenentickets wollen sie?\n ");
        anzahlErwachsenenTickets = input.nextInt();
        System.out.print("Wie viele Jugentlichentickets wollen sie?\n");
        anzahlJugendlichenTickets = input.nextInt();
        System.out.print("Wie viele Kindertickets wollen sie?\n");
        anzahlKinderTickets = input.nextInt();
        System.out.print("Wie viele Kleinkindertickets wollen sie?\n");
        anzahlKleinkinderTickets = input.nextInt();
        System.out.print("Sie wollen also " + anzahlErwachsenenTickets + " "  +
            "Erwachsenentickets" + anzahlJugendlichenTickets + " " + "Jugendlichentickets" +
            anzahlKinderTickets + " " + "Kindertickets" + anzahlKleinkinderTickets + " " +
            "Kleinkindertickets");
        gewuenschteAnzahl = anzahlErwachsenenTickets + anzahlJugendlichenTickets + 
        anzahlKinderTickets + anzahlKleinkinderTickets;
    }  
    
    private void berechneGesamtpreis() {
        gesamtpreis = preisKinder * anzahlKinderTickets + 
        preisErwachsene * anzahlErwachsenenTickets + preisJugendliche * 
        anzahlJugendlichenTickets + preisKleinkinder * anzahlKleinkinderTickets;
    }
    
    private void nimmGeldAn() {
        while (bezahlterBetrag < gesamtpreis) {
            System.out.println("Das beträgt: " + gesamtpreis);
            System.out.print("Wie viel Geld werfen Sie ein: ");
            int eingeworfen;
            eingeworfen = input.nextInt();
            if (eingeworfen == 1 || eingeworfen == 2) { 
              bezahlterBetrag = bezahlterBetrag + eingeworfen;
              System.out.print("Sie habe bislang " + bezahlterBetrag + " eingeworfen."); 
            }
        }
    }
    
    private void berechneWechselgeld() {
        int wechselgeld = bezahlterBetrag - gesamtpreis;
        if (wechselgeld > 0) { 
            System.out.println("Sie bekommen noch " + wechselgeld + "€ zurück");
            
            while (wechselgeld > 100) { 
                System.out.print("[100€-Schein]");
                wechselgeld = wechselgeld - 100;
                
            }
            
            while (wechselgeld > 50) { 
                System.out.print("[50€-Schein]");
                wechselgeld = wechselgeld - 50;
                
            }
            
            while (wechselgeld > 20) { 
                System.out.print("[20€-Schein]");
                wechselgeld = wechselgeld - 20;
                
            }
            
            while (wechselgeld > 10) { 
                System.out.print("[10€-Schein]");
                wechselgeld = wechselgeld - 10;
                
            }
            
            while (wechselgeld > 5) { 
                System.out.print("[5€-Schein]");
                wechselgeld = wechselgeld - 5;
                
            }
            
            while (wechselgeld > 2) { 
                System.out.print("[2€-Münze]");
                wechselgeld = wechselgeld - 2;
                
            }
            
            while (wechselgeld > 1) { 
                System.out.print("[1€-Münze]");
                wechselgeld = wechselgeld - 1;
                
            }
        }
    }
    
    private void druckeTicket() {
        System.out.println("###########################");
        System.out.println("## Ihr Ticket fürs Glück ##");
        System.out.println("###########################\n");
    }
    
    private void druckeTickets() {
        int nochZuDrucken = gewuenschteAnzahl;
        while (nochZuDrucken > 0) {
            System.out.println("Drucke noch" + nochZuDrucken + " Tickets...");
            druckeTicket();
            nochZuDrucken = nochZuDrucken - 1;
        }   
    }       
    
    public void zeigeMenu() {
        while (true) {
            begruesse();
            frageAnzahlTickets();
            berechneGesamtpreis();
            nimmGeldAn();
            berechneWechselgeld();
            druckeTickets();
            verabschiede();
        }
    }
}