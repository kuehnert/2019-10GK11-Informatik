import java.util.Scanner;
public class KartenAutomat {
    private Scanner tastaturEingabe;
    private int einbezahlterBetrag;
    private int anzahlKindKarten;
    private int anzahlErwachsenenKarten;
    private int gesamtpreis;
    private int wechselgeld;
    private int gedruckteKarten;
    private Karte kind = new Karte(12);
    private Karte erwachsen = new Karte (20);

    public KartenAutomat() {
        tastaturEingabe = new Scanner(System.in);
        hauptprogramm();
    }

    public void hauptprogramm () {
        zeigeMenu();
        ermittleAnzahl();
        berechneGesamtpreis();
        nimmGeldAn();
        gibWechselgeld();
        druckeKarten();
        verabschiedeDich();
    }

    public void zeigeMenu(){
        einbezahlterBetrag = 0;

        System.out.println("\nDies ist der Kartenautomat. Hier gibt es Karten. ");
        System.out.println("Eine Erwachsenenkarte kostet "+ erwachsen.preis() +" Euro.");
        System.out.println("Eine Kinderkarte kostet "+ kind.preis() +" Euro.");
    }

    public void ermittleAnzahl() {
        System.out.print("Wie viele Karten für Erwachsene möchten Sie?");
        anzahlErwachsenenKarten = tastaturEingabe.nextInt();
        System.out.print("Wie viele Karten fürs Kind möchten Sie?");
        anzahlKindKarten = tastaturEingabe.nextInt();
    }

    public void berechneGesamtpreis() {
        gesamtpreis = kind.preis() * anzahlKindKarten + erwachsen.preis() * anzahlErwachsenenKarten;
        System.out.println("Bitte zahlen " + gesamtpreis + " Euro.");
    }

    public void druckeKindKarte() {
        System.out.println("##################################################################");
        System.out.println("# Kinderkarte für Schlittschuhlaufbahn                           #");
        System.out.println("##################################################################\n");
    }

    public void druckeErwachsenenKarte() {
        System.out.println("##################################################################");
        System.out.println("# Erwachsenenkarte für Schlittschuhlaufbahn                      #");
        System.out.println("##################################################################\n");
    }

    public void druckeKarten() {
        gedruckteKarten = 0;
        while (gedruckteKarten < anzahlKindKarten) {
            druckeKindKarte();
            gedruckteKarten = gedruckteKarten + 1;
        }
        gedruckteKarten = 0;
        while (gedruckteKarten < anzahlErwachsenenKarten) {
            druckeErwachsenenKarte();
            gedruckteKarten = gedruckteKarten + 1;
        }

    }

    public void nimmGeldAn() {
        while (einbezahlterBetrag < gesamtpreis) {
            System.out.println("");
            int wert = tastaturEingabe.nextInt();
            if (wert == 1 || wert == 2 || wert == 5 || wert == 10 || wert == 20 || wert == 50 || wert == 100) {
                einbezahlterBetrag = einbezahlterBetrag + wert;
                System.out.println("Es fehlen noch " +
                    (gesamtpreis - einbezahlterBetrag) + " Euro. ");
            } else {
                System.out.println("Sorry, kann "+ wert +" nicht annehmen. ");
            }
        }
    }

    public void gibWechselgeld() {
        int wechselgeld = einbezahlterBetrag - gesamtpreis;
        if (wechselgeld > 0) {
            System.out.println("Sie bekommen noch " + wechselgeld
                + " Euro zurück.");

            while (wechselgeld >= 100) {
                System.out.println("[100 €]");
                wechselgeld = wechselgeld - 100;
            }

            while (wechselgeld >= 50) {
                System.out.println("[50 €]");
                wechselgeld = wechselgeld - 50;
            }

            while (wechselgeld >= 20) {
                System.out.println("[20 €]");
                wechselgeld = wechselgeld - 20;
            }

            while (wechselgeld >= 10) {
                System.out.println("[10 €]");
                wechselgeld = wechselgeld - 10;
            }

            while (wechselgeld >= 5) {
                System.out.println("[5 €]");
                wechselgeld = wechselgeld - 5;
            }

            while (wechselgeld >= 2) {
                System.out.println("(2€)");
                wechselgeld = wechselgeld - 2;
            }

            while (wechselgeld >= 1) {
                System.out.println("(1€)");
                wechselgeld = wechselgeld - 1;
            }
        }
    }

    public void verabschiedeDich() {
        System.out.println("");
        System.out.println("Danke für Ihren Einkauf, einen schönen Aufenthalt auf der Schlittschuhbahn!");
     }
}

class Karte {
  private int preis;

  public Karte(int preis) {
      this.preis = preis;
  }

  public int preis() {
      return preis;
  }
}
