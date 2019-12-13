 import java.util.Scanner;
public class kartenAutomat {
 private Scanner tastaturEingabe;
 private int kartenpreisKind;
 private int einbezahlterBetrag;
 private int anzahlKarten;
 private int gesamtpreis;
 private int wechselGeld;
 private int kartenpreisErwachsen;
 private int kartenpreisFamilie;
 
 public kartenAutomat() {
    tastaturEingabe = new Scanner(System.in);
    kartenpreisKind = 37;
    kartenpreisErwachsen = 20;
    kartenpreisFamilie = 100;
    zeigemenu();
} 

 public void druckeKarte() {
    System.out.println("");
    System.out.println("");
    System.out.println("");
    try {Thread.sleep(1000); } catch (Exception e) {}
} 

public void druckeKarten() {
    int gedruckteKarten = 0;
    while (gedruckteKarten < anzahlKarten) {
        druckeKarte();
        gedruckteKarten = gedruckteKarten + 1;
        System.out.println("Es wurden schon" + gedruckteKarten + "von"
        + anzahlKarten + "Karten gedruckt");
    } 
} 

public void zeigemenu() {
    einbezahlterBetrag = 0;
    System.out.println("Willkommen im phantasialand!");
    System.out.println("Wie viele kinderkarten wollen Sie?");
    System.out.println("Wie viele erwachsenenkarten wollen Sie?");
    System.out.println("Wie viele familienkarten wollen Sie?");
    System.out.println(" Eine kinderkarte kostet "+ kartenpreisKind + "€");
    System.out.println(" Eine erwachsenenkarte kostet "+ kartenpreisErwachsen + "€");
    System.out.println(" Eine familienkarte kostet "+ kartenpreisFamilie + "€");
}

public void nimmGeldAn() {
 // der benutzer wirft nacheinander Euro-Münzen oder Scheine ein
 // bis genügend Geld eingeworfen wurde.
 // TODO nimm nur gültige Werte an: 1, 2, 5, 10, 20, 50, 100
   while (einbezahlterBetrag < gesamtpreis) {
    System.out.println("Es fehlen noch " +
    (gesamtpreis - einbezahlterBetrag) + "€");
    System.out.println("Welche Münze oder welchen Schein werfen Sie ein?");
    int wert = tastaturEingabe.nextInt();
    einbezahlterBetrag = einbezahlterBetrag + wert;
    // Wenn wert 5 ist oder wert gleich 10 ist...
    if (wert == 1 || wert == 2 ||wert == 5 ||wert == 10 ||wert == 20
    ||wert == 50 ||wert == 100) {
      einbezahlterBetrag = einbezahlterBetrag + wert;
    } else{
      System.out.println("Sorry, kann " + wert + "€ nicht annehmen");
    }
 }
} 

public void ermittleAnzahl() {
    System.out.println("Wieviele Karten möchten Sie?");
    anzahlKarten = tastaturEingabe.nextInt();
} 

public void gibWechselgeld() {
    int wechselgeld = einbezahlterBetrag - gesamtpreis;
  if (wechselgeld < 0) {
    System.out.println("Sie bekommen noch " + wechselgeld
    + "Euro zurück");
    // TODO: Gib Wechselgeld in echten Scheinen/ Münzen gestückelt zurück
    // gestückelt zurück
    // 100, 50, 20, 10, 5, 2, 1
    if(wechselgeld > 100) {
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
        System.out.println("2€");
        wechselgeld = wechselgeld - 2;
    }
   
    while (wechselgeld >= 1) {
        System.out.println("1€");
        wechselgeld = wechselgeld - 1;
    }
  }
} 

public void berechneGesamtpreis() {
    gesamtpreis = kartenpreisKind * anzahlKarten;
    System.out.println("Sie müssen " + gesamtpreis + "€ bezahlen");
}

 public void hauptprogramm() {
    zeigemenu();
    ermittleAnzahl();
    berechneGesamtpreis();
}
} 