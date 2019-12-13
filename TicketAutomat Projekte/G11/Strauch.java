//Tiketautomat von Fabian Strauch :)
import java.util.Scanner;

public class TicketAutomatFabianStrauch {
    private Scanner tastaturEingabe;
    private int einzelpreis;
    private int gewuenschteAnzahl;
    private int gewuenschteKinderAnzahl;
    private int gesamtPreis;
    private int bezahlterBetrag;
    private int gesamtpreis;
    private int kinderpreis;
    private int familienRabattProzent;
    private int gruppenRabattProzent;
    private int bestätigung;

    public TicketAutomatFabianStrauch() {
        tastaturEingabe = new Scanner(System.in);
        einzelpreis = 28;
        kinderpreis = 20;
        familienRabattProzent = 15;
        gruppenRabattProzent = 20;
        gewuenschteKinderAnzahl = -1;
        gewuenschteAnzahl = -1;
        gesamtPreis = -1;
        bezahlterBetrag = -1;
        bestätigung = 2;
        
        zeigeMenue();
    }

    private void begruesse() {
        System.out.print(
            "Herzlich Wilkommen im Phantasia Land!\n"+
            "Ein Erwachsenenticket kostet " + einzelpreis + "€\n" + 
            "Ein Kinderticket (bis 12 Jahre) kostet " + kinderpreis + "€\n" +
            "Bei 2 Erwachsenen und 2 Kindern gibt es " + familienRabattProzent +
            "% Familienrabatt\n" +
            "Bei 5 Erwachsenen gibt es " + gruppenRabattProzent + "% Gruppenrabatt\n"
        );
        bezahlterBetrag = 0;
    }
    
    private void frageAnzahlTickets(){
        while(bestätigung != 1){
            //Setzte die gewünschte Anzahl auf 0, für den Fall, dass der Benutzer seine
            //Eingabe nicht bestätigt und statdessen mehr/weniger Tickets kaufen will.
            gewuenschteAnzahl = 0;
            gewuenschteKinderAnzahl = 0;
            
            System.out.print("Wie viele Erwachsenentickets möchten sie kaufen? ");
            gewuenschteAnzahl = tastaturEingabe.nextInt();
            
            System.out.print("Wie viele Kindertickets möchten sie kaufen?");
            gewuenschteKinderAnzahl = tastaturEingabe.nextInt();
            
            //Benutze Den Singular, wenn er enutzer nur ein Ticket will, sonst benutze den Plural
            if(gewuenschteAnzahl != 1){
                System.out.print("Sie wollen also " + gewuenschteAnzahl + " Erwachsenentickets");
            }
            else{
                System.out.print("Sie wollen also ein Erwachsenenticket");
            }
            
            if(gewuenschteKinderAnzahl != 1){
                System.out.print(" und " + gewuenschteKinderAnzahl + " Kindertickets");
            }
            else{
                System.out.print(" und ein Kinderticket");
            } 
            //Frage nach einer Bestätigung vom Nutzer
            System.out.print(
                ", ist das korrekt?\n" +
                " Ja  [1]\n" +
                "Nein [2]"
            );
            bestätigung = tastaturEingabe.nextInt();
        }
    }
    
    private void berechneGesamtpreis() {
        gesamtPreis = einzelpreis * gewuenschteAnzahl + kinderpreis * gewuenschteKinderAnzahl;
        //Berechne den Familien- bzw. Gruppenrabatt:
        //  Erstelle neue Variablen, von denen in der Schleife sutrahiert werden kann, falls
        //  ein Rabat mehr als ein mal berechnet werden kann 
        //      (Variable "gewuenschte Anzahl" lässt sich hier nicht verwenden, da sonst
        //      zu wenig Tickets gedruckt werden)
        int erwachsenenTicketsUebrig = gewuenschteAnzahl;
        int kinderTicketsUebrig = gewuenschteKinderAnzahl;
        //Erstelle eine lokale Variale für den Preisnachlass der Rabatte
        //  =>Notwendig, da bei übrigen Tickets außerhalb des Rabattes der Rabatt nicht auf 
        //  den gesamt Preis berechent werden soll, sondern nur auf den Preis der vom Rabatt
        //  umfassenden Tickets
        int preisnachlass = 0;
        
        //(Berechne zuerst Familienrabatt)
        //Familienrabatt:
        while(erwachsenenTicketsUebrig >= 2 && kinderTicketsUebrig >= 2){
            preisnachlass = (2 * einzelpreis + 2 * kinderpreis) * familienRabattProzent / 100;        
            System.out.print("1x Familienrabatt, -" + familienRabattProzent + "%\n");
            erwachsenenTicketsUebrig = erwachsenenTicketsUebrig - 2;
            kinderTicketsUebrig = kinderTicketsUebrig -2;
            gesamtPreis = gesamtPreis - preisnachlass;
        }
        //Gruppenrabbat:
        while(erwachsenenTicketsUebrig >= 5){
            preisnachlass = 5 * einzelpreis * familienRabattProzent / 100;
            System.out.print("1x Grupppenrabatt, -" + gruppenRabattProzent + "%\n");
            erwachsenenTicketsUebrig = erwachsenenTicketsUebrig - 5;
            gesamtPreis = gesamtPreis - preisnachlass;
        }
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
        
        //0. Tue das Folgende so lange, wie...
        while(bezahlterBetrag < gesamtPreis) {
            //1. Fordere Benutzer auf, Geld einzuwerfen
            System.out.print("Wie viel Geld werfen sie ein?");
            //2. Lies den eingeworfenen Betrag (über die Tastatur) ein
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
        int nochKinderZuDrucken = gewuenschteKinderAnzahl;
        if(gewuenschteAnzahl == 1 && gewuenschteKinderAnzahl == 0
            || gewuenschteKinderAnzahl == 1 && gewuenschteAnzahl == 0
        ){
            System.out.println("\nHier ist ihr Ticket:");
        }
        else{
            System.out.println("\nHier sind ihre Ticktes:");
        }
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
        "wir wünschen ihnen viel Spaß bei ihrem Aufenthalt!\n\n");
    }
    
    private void zeigeMenue() {
        //Endlosschleife
        while(true){
            begruesse();
            frageAnzahlTickets();
            berechneGesamtpreis();
            bestätigung = 2; 
            nimmGeldan();
            druckeTickets();
            verabschiede();
        }
    }
}
