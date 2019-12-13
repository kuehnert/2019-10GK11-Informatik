import java.util.Scanner;
public class Autolat {
    private Scanner tastaturEingabe;
    private int preis;
    private int menge;
    private int wert;
    private int wechselgeld;
    private int preisGesamt;
    private int einbezahlterBetrag;
    private int preisinkatzen;
    private int bezahlungsart;
    public Autolat () {
        tastaturEingabe = new Scanner(System.in);
        preis = 67 ;
        preisinkatzen = 12 ;
        hauptprogramm1();
    }
    public void zeigemenu() {
         System.out.println("Eine Karte Kostet"+ preis +" € / "+ preisinkatzen +" Katzen");

    }
    public void ermittleAnzahl() {
        System.out.print("Wieviele Karten möchten Sie? ");
        menge = tastaturEingabe.nextInt();
    }
     public void berechnegesamtpreis() {
        preisGesamt = menge * preis ;
        System.out.println("Sie müssen"+ preisGesamt + "€ bezahlen / Katzen bezahlen");
        nimmGeldAn();
    }
    public void berechnegesamtpreisinkatzen() {
        preisGesamt = menge * preisinkatzen ;
        System.out.println("Sie müssen"+ preisGesamt + "katzen bezahlen");
        nimmKatzenAn();
    }
    public void katzenodercash() {
        System.out.println("Wollen sie in Cash oder in Katzen bezahlen? Wenn sie in Cash bezahlen wollen drücken sie die 1. Wenn sie in Katzen bezahlen wollen drücken sie die 2.");
        int bezahlungsart = tastaturEingabe.nextInt();
        if (bezahlungsart == 1)
             berechnegesamtpreis();
           else {
            berechnegesamtpreisinkatzen();
        }
    }
    public void nimmGeldAn() {
        while (einbezahlterBetrag < preisGesamt)  {
           System.out.println("Ihnen fehlen noch"+(preisGesamt - einbezahlterBetrag) +"€/ Katzen");
           System.out.println("Welche Münze/Schein/ wollen sie einwerfen");
           int wert = tastaturEingabe.nextInt();
           if(wert == 1 || wert == 2 || wert == 5  || wert == 10 || wert == 20 || wert == 50 || wert == 100)
              einbezahlterBetrag = einbezahlterBetrag + wert;
             else {
              System.out.println("Diese Münze/Schein gibt es nicht!");
            }
        }
        wechselGeld();
    }
    public void nimmKatzenAn() {
        while (einbezahlterBetrag < preisGesamt)  {
           System.out.println("Es fehlen noch "+ (preisGesamt - einbezahlterBetrag) +" Katzen");
           int wert = tastaturEingabe.nextInt();
           einbezahlterBetrag = einbezahlterBetrag + wert;
        }
        wechselKatzen();
    }
    public void wechselKatzen() {
        int wechselgeld = einbezahlterBetrag - preisGesamt;
        if (wechselgeld > 0) {
            System.out.println("Sie kriegen noch"+ wechselgeld +"Katzen");
        }
        druckekarten();
    }
    public void wechselGeld() {
        int wechselgeld = einbezahlterBetrag - preisGesamt;
        if (wechselgeld > 0) {
            System.out.println("Sie kriegen noch"+ wechselgeld +"€");

            while (wechselgeld >= 100) {
                 System.out.println("[ 100 € ]");
                 wechselgeld = wechselgeld -100;
            }
            while (wechselgeld >= 50) {
                 System.out.println("[ 50 € ]");
                 wechselgeld = wechselgeld -50;
            }
            while (wechselgeld >= 20) {
                 System.out.println("[ 20 € ]");
                 wechselgeld = wechselgeld -20;
            }
            while (wechselgeld >= 10) {
                 System.out.println("[ 10 € ]");
                 wechselgeld = wechselgeld -10;
            }
            while (wechselgeld >= 5) {
                 System.out.println("[ 5 € ]");
                 wechselgeld = wechselgeld -5;
            }
            while (wechselgeld >= 2) {
                 System.out.println(" (2€) ");
                 wechselgeld = wechselgeld -2;
            }
            while (wechselgeld >= 1) {
                 System.out.println(" (1€) ");
                 wechselgeld = wechselgeld -1;
            }
        }
        druckekarten();
    }
    public void hauptprogramm1() {
        zeigemenu();
        ermittleAnzahl();
        katzenodercash();


    }
    public void druckekarten() {
        System.out.println(" Danke fürs Geld! Der richtige Automat ist rechts um die Ecke... ");
    }


}
