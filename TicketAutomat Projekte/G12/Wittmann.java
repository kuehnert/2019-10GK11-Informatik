import java.util.Scanner;
public class Ticket{
  private Scanner tastaturEingabe;
  private int einzelpreis;
  private int kinderpreis;
  private int gewuenschteAnzahl;
  private int gesamtPreis;
  private int bezahlterBetrag;
  private int gegebenesGeld;
  private int restbetrag;
  private int gibWechselgeld;
  private int kartenanzahl;
  private int wechselgeld;
  private int gewuenschteAnzahlKinder;
 private int alleKarten;

public Ticket() {
  tastaturEingabe = new Scanner(System.in);
  einzelpreis = 28;
  kinderpreis = 14;
  gewuenschteAnzahl = 0;
  gesamtPreis = 0;
  bezahlterBetrag = 0;
  gegebenesGeld = 0;
  restbetrag = 0;
  kartenanzahl = gewuenschteAnzahl;
  alleKarten = 0;
  gewuenschteAnzahlKinder = 0;
  }

public void begruesse() {
  System.out.println(
  "Willkommmen im Phantasialand.\n" +
  "Ein Ticket kostet " + einzelpreis + "€\n Ein Kinderticket kostet "
+ kinderpreis  + "€\n");
  }



  public void frageAnzahlTicketsAb() {
  System.out.print("Wie viele Tickets wollen sie?");
  gewuenschteAnzahl = tastaturEingabe.nextInt();

System.out.print("Wie viele Kindertickets wollen sie?");
  gewuenschteAnzahlKinder = tastaturEingabe.nextInt();

  System.out.print("Aha sie wollen also " +
  gewuenschteAnzahl +
" Tickets." + gewuenschteAnzahlKinder + " Kindertickets."
  );
  }

private void berechneGesamtpreis() {
  gesamtPreis = gewuenschteAnzahl * einzelpreis + gewuenschteAnzahlKinder * kinderpreis;
  System.out.println("Ihr zu zahlender Preis beträgt " +
  gesamtPreis + "€");
}

public void nimmGeldAn() {
// 0. Tue das Folgende so lange wie
while (bezahlterBetrag < gesamtPreis) {

 // 1. Fordere Benutzer auf Geldstück/-schein einzuwefen
System.out.print("Wie viel Geld werfen Sie ein: ");

 // 2. Lies den eingeworfenen Betrag über die Tastatur ein
int gegebenesGeld; // lokale/temporäre Variable
gegebenesGeld = tastaturEingabe.nextInt();

 // 3. Addiere den Betrag <eingeworfen> zu <bezahlterBetrag>
//bezahlterBetrag = bezahlterBetrag + eingeworfen;


 if (gegebenesGeld == 5 || gegebenesGeld == 10 || gegebenesGeld == 1 ||
gegebenesGeld == 20 || gegebenesGeld == 50 || gegebenesGeld == 100) {
  bezahlterBetrag = bezahlterBetrag + gegebenesGeld;
 }
   else{
  System.out.println(" Sorry kann " + gegebenesGeld + " €  nicht annehmen");
 }
System.out.print("Sie haben bislang " + bezahlterBetrag + " eingeworfen ");
  }

}
//public void erkenneGegebenesGeld() {
  //gegebenesGeld = tastaturEingabe.nextInt();
  //}
//private void berechneRestbetrag() {
  //int restbetrag = gesamtPreis - gegebenesGeld;
  //}

//public void gebeRestbetragwieder() {
  //  System.out.println(
  //  "Sie müssen noch" + restbetrag + "€ geben");
  //}

public void gibWechselgeld() {
  //int wechselgeld = gegebenesGeld > gesamtPreis;
  if (gesamtPreis < bezahlterBetrag) {
  wechselgeld = bezahlterBetrag - gesamtPreis;

System.out.println("Sie bekommenn noch " + wechselgeld
+ " € zurück.");
while (wechselgeld >= 100){
  System.out.println("[100€]");
  wechselgeld = wechselgeld - 100;
  }
  while (wechselgeld >= 50){
  System.out.println("[50€]");
  wechselgeld = wechselgeld - 50;
  }
  while (wechselgeld >= 20){
 System.out.println("[20€]");
  wechselgeld = wechselgeld - 20;
  }
  while (wechselgeld >= 10){
  System.out.println("[10€]");
  wechselgeld = wechselgeld - 10;
  }
  while (wechselgeld >= 5){
  System.out.println("[5€]");
  wechselgeld = wechselgeld - 5;
  }
  while (wechselgeld >= 1){
  System.out.println("(1€)");
  wechselgeld = wechselgeld - 1;
  }
  }
  }

public void druckeKarten() {
  alleKarten = gewuenschteAnzahlKinder + gewuenschteAnzahl;
  int gedruckteKarten = alleKarten;

while (gedruckteKarten < kartenanzahl) {
  druckeKarten();
  gedruckteKarten = gedruckteKarten + 1  ;

  System.out.println("Es wurden schon " + gedruckteKarten +  " von " + alleKarten + " Karten gedruckt" );

}
  }

public void verabschiede() {
  System.out.println
  ("Vielen Dank. Bitte entnehmen sie ihre Karten. Viel Spaß bei ihrem Aufenthalt.");
  }


public void gesamt() {
begruesse();
frageAnzahlTicketsAb();
berechneGesamtpreis();
nimmGeldAn();
gibWechselgeld();
druckeKarten();
verabschiede();
  }
}
