import java.util.Scanner;
public class KartenAutomat {
   private int einbezahlterBetrag;
   private int anzahlKartenKind;
   private int anzahlKartenErwachsenen;
   private int anzahlKartenRentner;
   private int gesamtpreis;
   private int wechselgeld;
   private int kartenpreisKind;
   private int kartenpreisErwachsen;
   private int kartenpreisRentner;
   private Scanner tastaturEingabe;
   public KartenAutomat() {
        tastaturEingabe = new Scanner(System.in);
        kartenpreisKind = 15;
        kartenpreisRentner = 20;
        kartenpreisErwachsen = 25;
        hauptprogramm();
      }
   public void verschiedeneKarten(){
       System.out.println("Es git Drei Karten Kategorien.");
       System.out.println("Die Kinder Karte, Die Erwachsenen Karte, die Rentner Karte .");
       System.out.println(" Kinder Karte: < 15 Jahre \n Erwachsenen Karte: 15 Jahre - 64 Jahre \n Rentner Karte: 65 +");
    }
   public void zeigeMenu() {
        einbezahlterBetrag = 0;
        System.out.println("Willkommen im Phantaseeland");
        verschiedeneKarten();
        System.out.println("Eine Kinder Karte kostet " + kartenpreisKind + " €");
        System.out.println("Eine Erwachsenen Karte kostet " + kartenpreisErwachsen + " €");
        System.out.println("Eine Rentner Karte kostet " + kartenpreisRentner + " €");
      }
   public void berechneGesamtpreis() {
        gesamtpreis = kartenpreisKind * anzahlKartenKind + kartenpreisErwachsen * anzahlKartenErwachsenen +
                      kartenpreisRentner * anzahlKartenRentner;
        System.out.println("Sie müssen " + gesamtpreis + " € bezahlen");
       }
   public void nimmGeldAn() {
        while (einbezahlterBetrag < gesamtpreis) {
            System.out.println("Es fehlen noch " +
                (gesamtpreis - einbezahlterBetrag) + " €.");
            System.out.print("Welche Münze oder welchen Schein " +
                "werfen Sie ein? ");
            int wert = tastaturEingabe.nextInt();

            if (wert== 1 || wert == 2 || wert== 5 ||wert == 10 || wert== 20 || wert == 50 || wert == 100) {
                einbezahlterBetrag = einbezahlterBetrag + wert;
            }else{
                System.out.println("Sorry, kann " + wert + " $ nicht annehmen");
            }
        }
       }
   public void ermittleAnzahlKind() {
        System.out.print("Wie viele Kinder Karten möchten Sie? ");
        anzahlKartenKind = tastaturEingabe.nextInt();
       }
   public void ermittleAnzahlErwachsenen() {
        System.out.print("Wie viele Erwachsenen Karten möchten Sie? ");
        anzahlKartenErwachsenen = tastaturEingabe.nextInt();
       }
   public void ermittleAnzahlRentner() {
        System.out.print("Wie viele Rentner Karten möchten Sie? ");
        anzahlKartenRentner = tastaturEingabe.nextInt();
       }
   public void gibWechselgeld() {
        int wechselgeld = einbezahlterBetrag - gesamtpreis;

        if (wechselgeld > 0) {
            System.out.println("Sie bekommen noch " + wechselgeld
                + " € zurück.");
            while (wechselgeld >= 100) {
                System.out.println("Hier sind 100 € zurück");
                wechselgeld = wechselgeld -100;
            }
            while (wechselgeld >= 50){
                System.out.println("Hier sind 50 € zurück");
                wechselgeld = wechselgeld - 50;
            }
            while (wechselgeld >= 20){
                System.out.println("Hier sind 20 € zurück");
                wechselgeld = wechselgeld - 20;
            }
            while (wechselgeld >= 10){
                System.out.println("Hier sind 10 € zurück");
                wechselgeld = wechselgeld - 10;
            }
            while (wechselgeld >= 5){
                System.out.println("Hier sind 5 € zurück");
                wechselgeld = wechselgeld - 5;
            }
            while (wechselgeld >= 2){
                System.out.println("Hier sind 2 € zurück");
                wechselgeld = wechselgeld - 2;
            }
            while (wechselgeld >= 1){
                System.out.println("Hier sind 1 € zurück");
                wechselgeld = wechselgeld - 1;
            }
            }
       }
   public void druckeKarteKind() {
        System.out.println("#########################################");
        System.out.println("# Eine Kinder Karte fürs Phantaseeland         #");
        System.out.println("#########################################");
       }
   public void druckeKarteErwachsen() {
        System.out.println("#########################################");
        System.out.println("# Eine Erwachsenen Karte fürs Phantaseeland         #");
        System.out.println("#########################################");
       }
   public void druckeKarteRentner() {
        System.out.println("#########################################");
        System.out.println("# Eine Rentner Karte fürs Phantaseeland         #");
        System.out.println("#########################################");
       }
   public void druckeKarten() {
       while (anzahlKartenKind > 0) {
            druckeKarteKind();
            anzahlKartenKind = anzahlKartenKind - 1;
           }
       while (anzahlKartenErwachsenen > 0) {
            druckeKarteErwachsen();
            anzahlKartenErwachsenen = anzahlKartenErwachsenen - 1;
           }
       while (anzahlKartenRentner > 0) {
            druckeKarteRentner();
            anzahlKartenRentner = anzahlKartenRentner - 1;
           }
       }
   public void hauptprogramm() {
        zeigeMenu();
        ermittleAnzahlKind();
        ermittleAnzahlErwachsenen();
        ermittleAnzahlRentner();
        berechneGesamtpreis();
        nimmGeldAn();
        gibWechselgeld();
        druckeKarten();
       }
}

