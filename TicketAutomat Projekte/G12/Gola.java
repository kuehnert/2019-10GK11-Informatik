

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

    public KartenAutomat() {

        kartenpreisErwachsener = 12;
        kartenpreisKind = 10;

        //hauptprogramm();

        zeigeMenu();

        tastaturEingabe = new Scanner(System.in);


     }
    private void druckeKarteErwachsener() {
        System.out.println("-------------------------------------");

        System.out.println("Ponyland Eintrittskarte Erwachsener");

        System.out.println("Preis: " + kartenpreisErwachsener);

        System.out.println("-------------------------------------");

    }
    private void druckeKarteKind() {
        System.out.println("-------------------------------------");

        System.out.println("Ponyland Eintrittskarte Kind");

        System.out.println("Preis: " + kartenpreisKind);

        System.out.println("-------------------------------------");

    }



    public void druckeKartenErwachsener () {

        gedruckteKartenErwachsener = 0;

        System.out.println("Karten (Erwachsener) werden gedruckt");

        while (gedruckteKartenErwachsener < kartenanzahlErwachsener) {

            druckeKarteErwachsener();

            gedruckteKartenErwachsener = gedruckteKartenErwachsener + 1;

            System.out.println("Es wurden schon " + gedruckteKartenErwachsener + " von "+ kartenanzahlErwachsener + " gedruckt.");

        }
    }

    public void druckeKartenKind () {

        gedruckteKartenKind = 0;

        System.out.println("Karten (Kind) werden gedruckt");

        while (gedruckteKartenKind < kartenanzahlKind) {

            druckeKarteKind();

            gedruckteKartenKind = gedruckteKartenKind + 1;

            System.out.println("Es wurden schon " + gedruckteKartenKind + " von "+ kartenanzahlKind + " gedruckt.");

        }
    }
    public void zeigeMenu() {

        System.out.println("#####################################");

        System.out.println("Willkomen im Ponyland!!");

        System.out.println("#####################################");
        System.out.println("Eine Karte (Erwachsener) kostet: " + kartenpreisErwachsener + "€. ");
        System.out.println("Eine Karte (Kind) kostet: " + kartenpreisKind + "€. ");


        try { Thread.sleep(1000); } catch (Exception e) {}
    }

    public void berechneGesamtpreis() {
        gesamtpreis = kartenanzahlErwachsener * kartenpreisErwachsener + kartenanzahlKind * kartenpreisKind;
        System.out.print("Sie müssen " + gesamtpreis + " Euro bezahlen.");

     }

    public void nimmGeldAn() {

        // Derbenutzer wirft soalnge geld ein bis genügend geld eingeworfen wurde

      while (einbezahlterBetrag < gesamtpreis) {

        System.out.print("Es fehlen noch " + (gesamtpreis - einbezahlterBetrag) + "€.");

        System.out.print("Welchen Schein oder welche Münze werfen Sie ein?");

        int wert = tastaturEingabe.nextInt();

        if ( wert == 1 || wert ==  2 ||  wert == 5 || wert == 10 || wert == 20 || wert == 50 || wert == 100 ) {

           einbezahlterBetrag = einbezahlterBetrag + wert;

         }else {

            System.out.println("Sorry, kann " + wert + " nicht annehmen.");



           }
        }
    }

    public void ermittleAnzahl() {

        System.out.print("Wieviele Karten (Erwachsener) wollen Sie?");
        kartenanzahlErwachsener = tastaturEingabe.nextInt();

        System.out.print("Wieviele Karten (Kind) wollen Sie?");
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



    public void hauptprogramm() {

        zeigeMenu();

        ermittleAnzahl();

        berechneGesamtpreis();

        nimmGeldAn();

        gibWechselgeld();

        druckeKartenErwachsener();
        druckeKartenKind();



    }
}
