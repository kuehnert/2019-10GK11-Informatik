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
    
    private void verabschiedeDich() {
        System.out.println("Ciao! Der Nächste bitte.");
    }
    
    public void zeigeMenu() {
        begruesse();
        frageAnzahlTicketsAb();
        
        // ...
        
        verabschiedeDich();
    }
}
