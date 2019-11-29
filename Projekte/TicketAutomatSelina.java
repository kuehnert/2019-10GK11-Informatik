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



        bezahlterBetrag = 0;

    }



    // Abfragen Scanner

    private void frageAnzahlTicketsAb() {

        System.out.print("Wie viele Tickets? ");

        gewuenschteAnzahl = tastaturEingabe.nextInt();

        System.out.print("Aha, Sie wollen also " +

            gewuenschteAnzahl +

            " Tickets!\n"

        );

    }



    private void berechneGesamtpreis() {

        gesamtPreis = gewuenschteAnzahl * einzelpreis;

        System.out.println("Bitte werfen Sie " + gesamtPreis + "€ ein");

    }



    private void verabschiedeDich() {

        System.out.println("Ciao! Der Nächste bitte.");

    }



    private void nimmGeldAn() {

        // TODO:

        // 1. Automat soll nur gültige Werte annehmen: 1, 2, 5, 10, 20, 50, 100



        // 0. tue das Folgende **so lange wie**.....

        while (bezahlterBetrag < gesamtPreis) {

            // 1. Fordere Benutzer auf, ein Geldstück/-schein einzuwerfen

            System.out.print("Wieviel Geld werfen Sie ein: ");



            // 2. Lies den eingeworfenen Betrag über die Tastatur ein

            int eingeworfen; // lokale Variable

            eingeworfen = tastaturEingabe.nextInt();



            // Füge Betrag nur dann hinzu, wenn er 1 oder 2 oder ... ist

            if (eingeworfen == 1 || eingeworfen == 2) {

                // 3. Addiere den Betrag <eingeworfen> zu <bezahlterBetrag>

                bezahlterBetrag = bezahlterBetrag + eingeworfen;



                System.out.print("Sie haben bislang " + bezahlterBetrag +

                    " eingeworfen");

            }

        }

    }



    private void berechneWechselgeld() {

        // 100€ - 80€

        int wechselgeld = bezahlterBetrag - gesamtPreis;



        // Gib wechselgeld aus, wenn es wechselgeld gibt

        if (wechselgeld > 0) {

            System.out.println("Sie bekommen noch " + wechselgeld + "€ zurück");

            // TODO: Gib Wechselgeld richtig gestückelt aus

        }

    }



    private void druckeTicket() {

        System.out.println("##################################");

        System.out.println("# Ihr Ticket fürs Glück!         #");

        System.out.println("##################################\n");

    }



    private void druckeTickets() {

        int nochZuDrucken = gewuenschteAnzahl;

        while (nochZuDrucken > 0) {

            System.out.println("Drucke noch " + nochZuDrucken + " Tickets...");

            druckeTicket();

            // Verringere nochZuDrucken um 1

            nochZuDrucken = nochZuDrucken - 1;

        }

    }



    public void zeigeMenu() {

        // Endlosschleife 

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