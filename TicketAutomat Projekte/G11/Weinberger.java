Guten Tag Herr Kühnert

Es hatten sich noch ein paar kleine Fehler eingeschlichen welche mir nicht angezeigt worden sind. Deshalb einmal ohne Fehler .

Viele Grüße
Jana Weinberger



import java.util.Scanner;

public class KartenAutomat {
    private Scanner tastaturEingabe;
    private int kartenpreisErwachsener;
    private int kartenpreisKind;
    private int einbezahlterBetrag;
    private int kartenanzahlErwachsener;
    private int kartenanzahlKind;
    private int gesamtpreis;
    private int wechselgeld;
    private int gedruckteKartenErwachsener;
    private int gedruckteKartenKind;
    private int rabattPreis;
    private int gewuenschteAnzahl;

    private void begruesse() {
       System.out.println(" Willkommen im Phantasialand!\n"
       + "Ein Erwachsenenticket kostet " + kartenpreisErwachsener
       + "€ und ein Kinderticket kostet." + kartenpreisKind + "€\n.");
    }
    public KartenAutomat() {

        kartenpreisErwachsener = 12;
        kartenpreisKind = 10;
        gewuenschteAnzahl = -1;
        gesamtpreis = -1;
        einbezahlterBetrag = -1;
        wechselgeld = -1;
       rabattPreis = -10;

        zeigeMenu();

        tastaturEingabe = new Scanner(System.in);

    }
    private void druckeKarteErwachsener() {
        System.out.println("-------------------------------------");

        System.out.println("Phantasialand Eintrittskarte Erwachsener");

        System.out.println("Preis: " + kartenpreisErwachsener);

        System.out.println("-------------------------------------");

    }
    private void druckeKarteKind() {
        System.out.println("-------------------------------------");

        System.out.println("Phantasialand Eintrittskarte Kind");

        System.out.println("Preis: " + kartenpreisKind);

        System.out.println("-------------------------------------");

    }

    private void berechneRabatt(){
       int rabatt = gewuenschteAnzahl - rabattPreis;
        if (gewuenschteAnzahl>5){

            System.out.println("Sie kriegen für mehr als 5 Karten " +
            "die weitern Karten für 10€ weniger");
       }
    }

    public void druckeKartenErwachsener () {

        gedruckteKartenErwachsener = 0;

        System.out.println("Erwachsenenkarten  werden gedruckt");

        while (gedruckteKartenErwachsener < kartenanzahlErwachsener) {

            druckeKarteErwachsener();

            gedruckteKartenErwachsener = gedruckteKartenErwachsener + 1;

            System.out.println("Es wurden schon " + gedruckteKartenErwachsener + " von "+ kartenanzahlErwachsener + " gedruckt.");

        }
    }

    public void druckeKartenKind () {

        gedruckteKartenKind = 0;

        System.out.println("Kinderkarten werden gedruckt");

        while (gedruckteKartenKind < kartenanzahlKind) {

            druckeKarteKind();

            gedruckteKartenKind = gedruckteKartenKind + 1;

            System.out.println("Es wurden schon " + gedruckteKartenKind + " von "+ kartenanzahlKind + " gedruckt.");

        }
    }
    public void zeigeMenu() {

        System.out.println("#####################################");

        System.out.println("Willkomen im Phantasialand!!");

        System.out.println("#####################################");
        System.out.println("Eine Erwachsenenkart kostet: " + kartenpreisErwachsener + "€. ");
        System.out.println("Eine Kinderkarte  kostet: " + kartenpreisKind + "€. ");



    }

    public void berechneGesamtpreis() {
        gesamtpreis = kartenanzahlErwachsener * kartenpreisErwachsener + kartenanzahlKind * kartenpreisKind;
        System.out.print("Sie müssen " + gesamtpreis + "Euro bezahlen.");

     }

    private void  nimmGeldAn(){
        // TODO:
        // Automat soll nur gültige Werte annehmen: 1,2,5,10,20,50,100

        // 0. Tue  das Folgende solange wie, ....
       while (einbezahlterBetrag < gesamtpreis) {

          // 1. Fordere Benutzer auf, ein Geldstück/-Schein einzuwerfen
          System.out.print("Wieviel Geld werfen Sie ein: ");

          // 2. Lies den eingeworfenen Betrag über die Tastatur ein
          int eingeworfen; // lokale (temporäre) Variable
           eingeworfen = tastaturEingabe.nextInt();

          // Füge Betrag nur hinzu wenn er 1 oder 2 oder...ist
           if( eingeworfen == 1 || eingeworfen == 2  || eingeworfen == 5  || eingeworfen == 10  ||
            eingeworfen == 20 || eingeworfen == 50  || eingeworfen == 100 ) {
             // 3. Addiere den Betrag <eingeworfen> zu <bezahlterBetrag>
             einbezahlterBetrag = eingeworfen + einbezahlterBetrag;

             System.out.print("Sie haben bis jetzt " + einbezahlterBetrag + " eingeworfen.");
          }else{
             System.out.println("Der Wert wird nicht akzeptiert.");
             System.out.println("Die Werte 1,2,5,10,20,50 und 100 bitte einwerfen");
            }
       }
    }

    public void ermittleAnzahl() {

        System.out.print("Wieviele Karten wollen Sie?");

        kartenanzahlErwachsener = tastaturEingabe.nextInt();
        kartenanzahlKind = tastaturEingabe.nextInt();

    }

    public void gibWechselgeld() {

        wechselgeld = 0;

        if (gesamtpreis < einbezahlterBetrag) {

            wechselgeld = einbezahlterBetrag - gesamtpreis;

            System.out.println("Sie bekommen noch " + wechselgeld + "€ zurück.");

            while (wechselgeld >= 100) {
                System.out.println("[100€]");
                wechselgeld = wechselgeld - 100;
            }

            while (wechselgeld >= 50) {
                System.out.println("[50€]");
                wechselgeld = wechselgeld - 50;
            }

            while (wechselgeld >= 20) {
                System.out.println("[20€]");
                wechselgeld = wechselgeld - 20;
            }

            while (wechselgeld >= 10) {
                System.out.println("[10€]");
                wechselgeld = wechselgeld - 10;
            }

            while (wechselgeld >= 5) {
                System.out.println("[5€]");
                wechselgeld = wechselgeld - 5;
            }

            while (wechselgeld >= 2) {
                System.out.println("[2€]");
                wechselgeld = wechselgeld - 2;
            }

            while (wechselgeld >= 1) {
                System.out.println("[1€]");
                wechselgeld = wechselgeld - 1;
            }

        }
    }


    private void druckeTickets() {
        int nochZuDrucken = gewuenschteAnzahl;
        while ( nochZuDrucken > 0 ) {
           System.out.println("Drucke noch " + nochZuDrucken + " Tickets...");
            druckeTickets();
           // Verringere nochZuDrucken um 1
           nochZuDrucken = nochZuDrucken - 1;
        }
    }

    public void  verabschiede() {
        System.out.println("Vielen Dank.Bitte entnehmen sie ihre Karten.Viel Spaß bei Ihrem Aufenthalt.");
    }

    public void zeigeMenue() {
       //Endlosschleife
        while (true) {
        begruesse();
        zeigeMenu();

        ermittleAnzahl();

        berechneGesamtpreis();
        nimmGeldAn();
        gibWechselgeld();

        druckeKartenErwachsener();
        druckeKartenKind();


        verabschiede();
       }
    }
}

Gesendet von Mail für Windows 10

