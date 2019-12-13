import java.util.Scanner;

public class KartenAutomatKuehnert{
    private Scanner tastaturEingabe;
    private int kartenpreis;
    private int einbezahlterBetrag;
    private int anzahlKarten;
    private int gedruckteKarten;
    private int gesamtpreis;
    private int wechselgeld;
    private int anzahlErwachsene;
    private int anzahlKinder;
    private int anzahlCollin;
    private int preisErwachsene;
    private int preisKinder;
    private int preisCollin;
  
    // Konstruktor
  public KartenAutomatKuehnert() {
     tastaturEingabe = new Scanner(System.in);
     //kartenpreis = 37;
     
     
     preisErwachsene = 35;
     preisKinder = 15;
     preisCollin = 55;
     
     hauptprogramm();
  }
  
  public void zeigeMenu() {
       einbezahlterBetrag = 0;
       //System.out.println("Willkommen im Phantaseeland");
       //System.out.println("Eine Karte kostet " + kartenpreis + " €");
       
       System.out.println("Willkommen im Seeland");
       System.out.println("Eine Erwachsenenkarte kostet " + preisErwachsene + " €," + 
            "eine Kinderkarte kostet " + preisKinder + "€" + "und eine Collinkarte kostet" +
            preisCollin + " €");
       
  }
  
  public void berechneGesamtpreis() {
      //gesamtpreis = kartenpreis * anzahlKarten;
      //System.out.println("Sie müssen " + gesamtpreis + "€ bezahlen");
      
      gesamtpreis = preisErwachsene * anzahlErwachsene + preisKinder * anzahlKinder +
            preisCollin * anzahlCollin;
      System.out.println("Sie müssen " + gesamtpreis + "€ bezahlen");
  }
    
  public void nimmGeldAn() {
      // Der Benutzer wirft nacheinander Euro-Münzen oder Scheine ein 
      // bis genügend Geld eingeworfen wurde
      while (einbezahlterBetrag < gesamtpreis) {
          System.out.println("Es fehlen noch " + (gesamtpreis - einbezahlterBetrag) + "€.");
          System.out.println("Welche Münzen oder Scheine " + 
            "werfen Sie ein?");
          int wert = tastaturEingabe.nextInt();
          
          // Wenn wert 5 ist oder wert gleich 10 ist ...
          if (wert == 1 || wert == 2 || wert == 5 || wert == 10 || wert == 20 || 
            wert == 50 || wert == 100 ) {
            einbezahlterBetrag = einbezahlterBetrag + wert;
          } else {
            System.out.println("Sorry, kann " + wert + " € nicht annehmen");
          }
      }
  }
  
  public void ermittleAnzahl() {
    //System.out.print("Wieviele Karten möchten Sie?");
    //anzahlKarten = tastaturEingabe.nextInt();
    
    System.out.print("Wieviele Erwachsene sind sie?");
    anzahlErwachsene = tastaturEingabe.nextInt();
    System.out.print("Wieviele Kinder sind sie?");
    anzahlKinder = tastaturEingabe.nextInt();
    System.out.print("Wieviele Collins sind bei ihnen?");
    anzahlCollin = tastaturEingabe.nextInt();
  }

  public void gibWechselgeld() {
    int wechselgeld = einbezahlterBetrag - gesamtpreis;
    
    if (wechselgeld > 0) {
        System.out.println("Sie bekommen noch " + wechselgeld
            + " € zurück.");
        // TODO: Gib Wechselgeld in echten Münzen/Scheinen 
        //gestückelt zurück
        
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
            System.out.println("(2€)");
            wechselgeld = wechselgeld - 2;
        }
        
        while (wechselgeld >= 1)  {
            System.out.println("(1€)");
            wechselgeld = wechselgeld - 1;        
        }
    }
  }
     
  public void druckeKarte() {
    System.out.println("#################################");
    System.out.println("# Eine Karte fürs Phantaseeland #");
    System.out.println("#################################");
    try { Thread.sleep(1000); } catch (Exception e) {}
  }
    
  public void druckeKarten() {
    // Solange wie noch nicht alle Karten gedruckt sind 
    // Drucke  eine Karte
    // Verringere die Anzahl der noch zu druckenden Karten um eins
    int gedruckteKarte = 0;
    
    while (gedruckteKarten < anzahlKarten){
        druckeKarte();
        gedruckteKarten = gedruckteKarten + 1;
        System.out.println("Es wurden schon " + gedruckteKarten + " von " + anzahlKarten +
            " Kartengedruckt");
    }
  }
  
  public void hauptprogramm(){
    zeigeMenu();
    ermittleAnzahl();
    berechneGesamtpreis();
    nimmGeldAn();
    gibWechselgeld();
    druckeKarten();
  }  
}