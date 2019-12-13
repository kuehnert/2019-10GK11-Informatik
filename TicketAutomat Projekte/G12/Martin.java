import java.util.Scanner;
	public class KartenAutomat {
	    private int kartenpreiserw;
	    private int kartenpreiskind;
	    private int einbezahlterBetrag;
	    private int anzahlKartenerw;
	    private int anzahlKartenkind;
	    private int gesamtpreis;
	    private int wechselgeld;
	    private int x;
	    private int eingeworfenesGeld;
	    private int rückgeld;



	    public KartenAutomat(){
	        kartenpreiskind = 10;
	        kartenpreiserw = 20;
	        gesamtpreis = 0;
	        zeigeMenu();
	    }


	    public void druckeKarte() {
	        System.out.println("___________________________________________");
	        System.out.println("| Eintrittskarte für " + anzahlKartenerw + " Erwachsene.          |");
	        System.out.println("| Eintrittskarte für " + anzahlKartenkind + " Kinder.          |");
	        System.out.println("| Gesamtpreiß der Karte: " + gesamtpreis + "€               |");
	        System.out.println("___________________________________________");
	    }


	    public void zeigeMenu() {
	        System.out.println("Willkommen im Phantasialand! \n \n Eine Eintittskarte kostet für ein Kind: "
	            + kartenpreiskind + "€. Und für Erwachsenen:" + kartenpreiserw + "€. \n Wieviele Erwachsenen Karten möchtest sie haben?" );
	        Scanner input = new Scanner (System.in);
	        anzahlKartenerw = input.nextInt();
	        gesamtpreis = kartenpreiserw * anzahlKartenerw;
	        System.out.println("Wieviele Kinder Karten möchten sie haben?");
	        anzahlKartenkind = input.nextInt();
	        gesamtpreis = gesamtpreis + kartenpreiskind * anzahlKartenkind;
	        System.out.println("Das macht dann: " + gesamtpreis + "€ .");
	        nimmGeldAn();
	    }


	    public void nimmGeldAn() {
	        x = gesamtpreis;


	        while (x > 0){
	            Scanner input = new Scanner (System.in);
	            eingeworfenesGeld = input.nextInt();
	            if (eingeworfenesGeld == 1 || eingeworfenesGeld ==  2 || eingeworfenesGeld == 5 || eingeworfenesGeld == 10 || eingeworfenesGeld ==  20 || eingeworfenesGeld == 50 ||
	            eingeworfenesGeld == 100 || eingeworfenesGeld == 200 || eingeworfenesGeld ==  500) {
	                x = x - eingeworfenesGeld;
	                if (x>0){
	                    System.out.println("Es fehlen noch " + x + "€.");
	                }
	                if(x<0){
	                    rückgeld = x;
	                    System.out.println("Ihre Karten werden gedruckt.");
	                    gibWechselgeld();
	                }
	                if(x<=0){
	                    System.out.println("Ihre Karten werden gedruckt.");
	                }
	            }
	            else{
	                System.out.println("Das ist kein Zulässiges Geld. Der zu Zahlende Betrag beträgt " + x + "€.");
	            }
	        }
	        druckeKarte();
	    }


	    public void gibWechselgeld() {
	        rückgeld = rückgeld * -1;


	        System.out.println("Sie bekommen " + rückgeld + " Rückgeld.");


	        while (rückgeld > 0) {
	            if (rückgeld >= 500) {
	                rückgeld -= 500;
	                System.out.println("[500€]");


	            } else if (rückgeld >= 200) {
	                rückgeld -= 200;
	                System.out.println("[200€]");


	            } else if (rückgeld >= 100) {
	                rückgeld -= 100;
	                System.out.println("[100€]");


	            } else if (rückgeld >= 50) {
	                rückgeld -= 50;
	                System.out.println("[50€]");


	            } else if (rückgeld >= 20) {
	                rückgeld -= 20;
	                System.out.println("[20€]");


	            } else if (rückgeld >= 10) {
	                rückgeld -= 10;
	                System.out.println("[10€]");


	            } else if (rückgeld >= 5) {
	                rückgeld -= 5;
	                System.out.println("[5€]");


	            } else if (rückgeld >= 2) {
	                rückgeld -= 2;
	                System.out.println("(2€)");


	            } else if (rückgeld >= 1) {
	                rückgeld -= 1;
	                System.out.println("(1€)");


	            }


	        }
	    }
	}

