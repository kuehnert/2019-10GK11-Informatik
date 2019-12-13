import java.util.Scanner;

public class TicketAutomat {
    private Scanner tastaturEingabe;
    private int ticketpreis;
    private int einbezahlterBetrag;
    private int anzahlTickets;
    private int gesamtpreis;
    private int wechselgeld;


    public TicketAutomat() {
        tastaturEingabe = new Scanner(System.in);
        ticketpreis = 37;
        hauptprogramm();
    }

    public void zeigeMenu() {
        einbezahlterBetrag = 0;

        System.out.println("Willkommen im Phantaseeland");
        System.out.println("Eine Ticket kostet " + ticketpreis + " €");
    }

    public void berechneGesamtpreis() {
        gesamtpreis = ticketpreis * anzahlTickets;
        System.out.println("Sie müssen " + gesamtpreis + " € bezahlen");
    }

    public void nimmGeldAn() {

        while (einbezahlterBetrag < gesamtpreis) {
            System.out.println("Es fehlen noch " +
                (gesamtpreis - einbezahlterBetrag) + " €.");
            System.out.print("Welche Münze oder welchen Schein " +
                "werfen Sie ein? ");
            int wert = tastaturEingabe.nextInt();


            if (wert == 1 || wert == 2 || wert == 5 || wert == 10 ||
                wert == 20 || wert == 50 || wert == 100) {
                einbezahlterBetrag = einbezahlterBetrag + wert;
            } else {
                System.out.println("Sorry, kann " + wert + " € nicht annehmen");
            }
        }
    }

    public void ermittleAnzahl() {
        System.out.print("Wieviele Tickets möchten Sie haben? ");
        anzahlTickets = tastaturEingabe.nextInt();
    }

    public void gibWechselgeld() {
        int wechselgeld = einbezahlterBetrag - gesamtpreis;

        if (wechselgeld > 0) {
            System.out.println("Sie bekommen noch " + wechselgeld
                + " € zurück.");

        }
    }

    public void druckeTicket() {
        System.out.println("#########################################");
        System.out.println("# Ein Ticket fürs Phantaseeland         #");
        System.out.println("#########################################\n");
        try { Thread.sleep(1000); } catch (Exception e) {}
    }

    public void druckeTickets() {

        int gedruckteTickets = 0;

        while (gedruckteTickets < anzahlTickets) {
            druckeTickets();
            gedruckteTickets = gedruckteTickets + 1;
            System.out.println("Es wurden schon " + gedruckteTickets +
            " von " + anzahlTickets + " Tickets gedruckt");
        }
    }

    public void hauptprogramm() {
        zeigeMenu();
        ermittleAnzahl();
        berechneGesamtpreis();
        nimmGeldAn();
        gibWechselgeld();
        druckeTickets();
    }
}
