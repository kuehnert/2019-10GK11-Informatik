Lieber Herr Kühnert,
Hier ist der Code für den Ticketautomaten.
Schönen Sonntag noch!
Lg
Leon Parg


//Ticketautomat von Leon Parg

import java.util.Scanner;

public class Ticketautomat {
    private Scanner tastaturEingabe;
    private int einzelpreis;
    private int gewuenschteAnzahl;
    private int gewuenschteAnzahlKind;
    private int gesamtPreis;
    private int bezahlterBetrag;
    private int gesamtpreis;
    private int kinderpreis;

    public Ticketautomat() {
        tastaturEingabe = new Scanner(System.in);
        einzelpreis = 28;
        kinderpreis = 20;
        gewuenschteAnzahlKind = -1;
        gewuenschteAnzahl = -1;
        gesamtPreis = -1;
        bezahlterBetrag = -1;

        zeigeMenue();
    }

    private void begruesse() {
        System.out.print(
            "Herzlich Wilkommen im Phantasia Land!\n"+
            "Ein Erwachsenenticket kostet " + einzelpreis + "€\n" +
            "Ein Kinderticket (bis 12 Jahre) kostet " + kinderpreis + "€\n"
        );
        bezahlterBetrag = 0;
    }

    private void frageAnzahlTickets(){
            System.out.print("Wie viele Erwachsenentickets möchten sie kaufen? ");
            gewuenschteAnzahl = tastaturEingabe.nextInt();

            System.out.print("Wie viele Kindertickets möchten sie kaufen?");
            gewuenschteAnzahlKind = tastaturEingabe.nextInt();

            System.out.print("Sie  wollen also ");
    }

    private void berechneGesamtpreis() {
        gesamtPreis = einzelpreis * gewuenschteAnzahl + kinderpreis * gewuenschteAnzahlKind;
        System.out.println("Bitte werfen sie "  + gesamtPreis + "€ ein.");
    }

    private void berechneWechselgeld(){
        //Berechne das Wechselgeld wenn zu viel Geld eingewerofen wurde
        int wechselgeld = bezahlterBetrag - gesamtPreis;
            //TODO Gib das Wechselgeld gestückelt aus
        while(wechselgeld > 0){
                if(wechselgeld >= 100){
                    System.out.print("[ 100€ ]");
                    wechselgeld = wechselgeld -100;
                }
                else if(wechselgeld >= 50){
                    System.out.print("[ 50€ ]");
                    wechselgeld = wechselgeld -50;
                }
                else if(wechselgeld >= 20){
                    System.out.print("[ 20€ ]");
                    wechselgeld = wechselgeld -20;
                }
                else if(wechselgeld >= 10){
                    System.out.print("[ 10€ ]");
                    wechselgeld = wechselgeld -10;
                }
                else if(wechselgeld >= 5){
                    System.out.print("[ 5€ ]");
                    wechselgeld = wechselgeld -5;
                }
                else if(wechselgeld >= 2){
                    System.out.print("(2€)");
                    wechselgeld = wechselgeld -2;
                }
                else{
                    System.out.print("(1€)");
                    wechselgeld = wechselgeld -1;
                }
        }
    }

    private void nimmGeldan(){
        //TODO:
        //1. Automat soll nur gültige Wert annehmen: 1, 2, 5, 10, 20, 50, 100
        //

           while(bezahlterBetrag < gesamtPreis) {
            //1. Fordere Benutzer auf, Geld einzuwerfen
            System.out.print("Wie viel Geld werfen sie ein?");
            //2. Lies den eingeworfenen Betrag ein
            int eingeworfen; // = lokale Variable
            eingeworfen = tastaturEingabe.nextInt();
            //Füge Betrag nur dann hinzu, wenn er 1, 2 ... ist
            if(eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5
             || eingeworfen == 10 || eingeworfen == 20 || eingeworfen == 50
             || eingeworfen == 100){
                //3. Addiere den Betrag <eingeworfen> zu <bezahlterBetrag>
                bezahlterBetrag = bezahlterBetrag + eingeworfen;
                //4. Wenn bezahlterBetrag < gesamtPreis gib, springe zu 1.
                System.out.print("\nSie haben bislang " + bezahlterBetrag +
                "€ eingeworfen!\n");
            }
            else{
                System.out.println("Ungültige Eingabe, bitte werfen sie 1, 2, 5, 10, 20, "+
                "50 oder 100 Euro ein.");
            }
        }
        berechneWechselgeld();
    }

    private void druckeTicket(){
        System.out.println(
            " _____________\n" +
            "|             |\n" +
            "|Phantasialand|\n" +
            "| Erwachsenen-|\n" +
            "|   ticket    |\n" +
            "|     " + einzelpreis + "€     |\n" +
            "|             |\n" +
            " _____________\n");
    }

    private void druckeKinderTicket(){
        System.out.println(
            " _____________\n" +
            "|             |\n" +
            "|Phantasialand|\n" +
            "| Kinderticket|\n" +
            "|             |\n" +
            "|     " + kinderpreis + "€     |\n" +
            "|             |\n" +
            " _____________\n");
    }

    private void druckeTickets() {
        int nochZuDrucken = gewuenschteAnzahl;
        int nochKinderZuDrucken = gewuenschteAnzahlKind;
        System.out.print("Hier  sind ihre Tickets\n");
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
        System.out.print("Vielen Dank für ihren Besuch im Phantasialand, " +
        "ich hoffe wir sehen sie bald wieder!\n\n");
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
