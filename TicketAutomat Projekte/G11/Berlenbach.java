import java.util.Scanner;
public class Ticketautomat{
    private Scanner tastaturEingabe;
    private int erwachsenenpreis;
    private int kinderpreis;
    private int gewuenschteAnzahl;
    private int gesamtPreis;
    private int bezahlterBetrag;
    private int Restbetrag;
    private int kartenArt;
    private int preisArt;
    private String ticketArt;
    private int bestellungsVerlauf;
    private int zwischenPreis;
    private int anzahlErwachsenenKarten;
    private int anzahlKinderKarten;
    private int bestätigung;
    private int familienpreis;
    private int gruppenpreis;
    private int anzahlFamilienKarten;
    private int anzahlGruppenKarten;
    private int quickpassPreis;
    private int quickpassAnzahl;
    
 public Ticketautomat() {
     tastaturEingabe = new Scanner(System.in);
     erwachsenenpreis = 28;
     kinderpreis = 15;
    gewuenschteAnzahl  = 0;
    gesamtPreis = -1;
    bezahlterBetrag = 0;
    Restbetrag = -1;
    kartenArt = 0;
    preisArt = 0;
    bestellungsVerlauf = 1;
    zwischenPreis = 0;
    anzahlErwachsenenKarten = 0;
    anzahlFamilienKarten = 0;
    anzahlGruppenKarten = 0;
    anzahlKinderKarten = 0;
    bestätigung = 0;
    familienpreis = 55;
    gruppenpreis = 22;
    quickpassPreis = 5;
    quickpassAnzahl = 0;
    
    
}
private void begruesse(){
    System.out.print("\nGuten Tag Willkommen im Phantasialand. Hier sehen sie den Überblick von unseren verschieden Preisen und Rabatten: \n\n1: Erwachsenenkarte(+11Jahre): " + 
    erwachsenenpreis + "€" + "\n2: Kinderkarte(1-11 Jahre): " + 
    kinderpreis + "€(pro Person)\n3: Familienkarte(2x Erwachsene + 1x Kinder): " + familienpreis + "€\n4: Gruppenrabatt(+10 Personen => 20% Rabatt): " + gruppenpreis + "€\n");
}
private void frageAnzahlTicketsAb(){
    while (bestellungsVerlauf != 2){
     if(bestellungsVerlauf == 1){
         
     System.out.print("\nBitte geben Sie die Nummer für die gewuenschte Kartenart ein: \nAuswahl:");
     kartenArt = tastaturEingabe.nextInt();
     if (kartenArt == 1 || kartenArt == 2 || kartenArt == 3 || kartenArt == 4){
     System.out.print("\nBitte geben Sie nun die gewuenschte Anzahl ein: \nAuswahl:"); 
     gewuenschteAnzahl = tastaturEingabe.nextInt();
     

     System.out.print("\nEingabe bestätigen: \nBestätigen(1)\nAbbruch(2)\nAuswahl:");
     bestätigung = tastaturEingabe.nextInt();
     if (bestätigung == 1){
              if(kartenArt == 1){
         preisArt = erwachsenenpreis;
         ticketArt = "Erwachsenenkarte";
         anzahlErwachsenenKarten = anzahlErwachsenenKarten + gewuenschteAnzahl;
        }
     else if(kartenArt == 2){
                  preisArt = kinderpreis;
                  ticketArt = "Kinderkarte";
                  anzahlKinderKarten = anzahlKinderKarten + gewuenschteAnzahl;
        }
        else if(kartenArt == 3){
                  preisArt = familienpreis;
                  ticketArt = "Familienkarte";
                  anzahlFamilienKarten = anzahlFamilienKarten + gewuenschteAnzahl;
        }
        else if(kartenArt == 4){
                  preisArt = gruppenpreis;
                  ticketArt = "Gruppenkarte";
                  anzahlGruppenKarten = anzahlGruppenKarten + gewuenschteAnzahl;
        }
     if (anzahlGruppenKarten == 0 || anzahlGruppenKarten >= 10){
     zwischenPreis = gewuenschteAnzahl * preisArt;
     gesamtPreis = gesamtPreis + zwischenPreis;
     System.out.print("\nZwischenauswahl: \n" + anzahlErwachsenenKarten + "x Erwachsenenkarte\n" + anzahlKinderKarten + "x Kinderkarte\n" 
     + anzahlFamilienKarten + "x Familienkarte\n" + anzahlGruppenKarten + "x Gruppenkarte\nZwischenbetrag:" + 
     gesamtPreis + "€.\n");
    }
    else{
        System.out.print("\nZu wenige Personen, um eine Gruppenkarte zu kaufen!");
        anzahlGruppenKarten = anzahlGruppenKarten - gewuenschteAnzahl;
    }
}
    else if(bestätigung == 2){
     System.out.print("\nZwischenauswahl: \n" + anzahlErwachsenenKarten + "x Erwachsenenkarte\n" + anzahlKinderKarten + "x Kinderkarte\n" 
     + anzahlFamilienKarten + "x Familienkarte\n" + anzahlGruppenKarten + "x Gruppenkarte\nZwischenbetrag:" + 
     gesamtPreis + "€.\n\n Zwischenauswahl löschen?\nJa(1)\nNein(2)\nAuswahl: ");
     bestätigung = 0;
     bestätigung = tastaturEingabe.nextInt();
     if (bestätigung == 1){
         gesamtPreis = 0;
         anzahlErwachsenenKarten = 0;
         anzahlKinderKarten = 0;
         anzahlFamilienKarten = 0;
         anzahlGruppenKarten = 0;
         System.out.print("\nZwischenauswahl: \n" + anzahlErwachsenenKarten + "x Erwachsenenkarte\n" + anzahlKinderKarten + "x Kinderkarte\n" 
     + anzahlFamilienKarten + "x Familienkarte\n" + anzahlGruppenKarten + "x Gruppenkarte\nZwischenbetrag:" + 
     gesamtPreis + "€.\n");

    }
    else if(bestätigung == 2){    
         System.out.print("\nZwischenauswahl wurde beibehalten!\n");
        }
    else{    
         System.out.print("\nUngültiger Eingabe!");
        }

    }
            bestätigung = 0;
        System.out.print("\nMit der Bestellung fortfahren?: \nJa(1)\nZur Kasse(2)\n\nAuswahl:\n");
        bestellungsVerlauf = tastaturEingabe.nextInt();
    }


}
    else if(bestellungsVerlauf != 1 || bestellungsVerlauf != 2){
        System.out.print("\nUngültige Eingabe!");
        System.out.print("\nMit der Bestellung fortfahren?: \nJa(1)\nZur Kasse(2)\n\nAuswahl:\n");
        bestellungsVerlauf = tastaturEingabe.nextInt();
    }
}
    System.out.print("\nWollen sie zusätzlich noch einen Quickpass(" + quickpassPreis + "€ je Stück) dazukaufen?\nJa(1)\nNein(2)\nAuswahl:\n");
    bestätigung = tastaturEingabe.nextInt();
    if (bestätigung == 1){
        System.out.print("\nWie viele benötigen sie?\nAuswahl:");
    quickpassAnzahl = 0;
    quickpassAnzahl = tastaturEingabe.nextInt();
    quickpassPreis = quickpassPreis * quickpassAnzahl;
    gesamtPreis = gesamtPreis + quickpassPreis;
}
    else if(bestätigung == 2){
        System.out.print("Sie können den Quickpass auch noch im Nachhinein kaufen, falls sich Ihre Meinung geändert haben sollte.");
        bestätigung = 2;
}
        else{System.out.print("\nFalsche Eingabe");
        }
     
         
    }



 private void berechneGesamtpreis(){
             System.out.print("\n\n\n\nIhre Bestellung: \n" + anzahlErwachsenenKarten + "x Erwachsenenkarte\n" + anzahlKinderKarten + "x Kinderkarte\n" 
     + anzahlFamilienKarten + "x Familienkarte\n" + anzahlGruppenKarten + "x Gruppenkarte\n" + quickpassAnzahl + "x Quickpass\nEndbetrag:" + 
     gesamtPreis + "€.\n");
    }
private void berechneWechselgeld(){
        Restbetrag = gesamtPreis;
        while(Restbetrag > 0){
                
                System.out.print("\n" + Restbetrag + "€ fehlen noch.\n ");
                System.out.print("Geldeinwurf: "); 
                bezahlterBetrag = tastaturEingabe.nextInt();     
               if (bezahlterBetrag == 1 || bezahlterBetrag == 2 || bezahlterBetrag == 5 || bezahlterBetrag == 10 || bezahlterBetrag == 20 || bezahlterBetrag == 50 || bezahlterBetrag == 100 ){
                Restbetrag = Restbetrag - bezahlterBetrag; 
                System.out.print("Vielen Dank!");
                
            }
            else {
                System.out.print("\nFalsche Eingabe!");
                
            }
        }
        Restbetrag = (Restbetrag -1) * (-1);
    }
private void gibWechselgeldaus(){
        while (Restbetrag > 1){
        
        if (Restbetrag -  100 > 0){
            System.out.print("\nWrumm: 100€");
            Restbetrag = Restbetrag - 100;
        }
        else if (Restbetrag -  50 > 0){
                        System.out.print("\nWrumm: 50€");
            Restbetrag = Restbetrag - 50;
        }
                else if (Restbetrag -  20 > 0){
                        System.out.print("\nWrumm: 20€");
            Restbetrag = Restbetrag - 20;
        }
                else if (Restbetrag -  10 > 0){
                        System.out.print("\nWrumm: 10€");
            Restbetrag = Restbetrag - 10;
        }
                else if (Restbetrag -  5 > 0){
                        System.out.print("\nWrumm: 5€");
            Restbetrag = Restbetrag - 5;
        }
                else if (Restbetrag -  2 > 0){
                        System.out.print("\nWrumm: 2€");
            Restbetrag = Restbetrag - 2;
        }
                else if (Restbetrag -  1 > 0){
                        System.out.print("\nWrumm: 1€");
            Restbetrag = Restbetrag - 1;
        }
        
    }
    System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
}   
    



private void druckeTickets(){
    for (int i = 1; i < anzahlErwachsenenKarten  + 1; i++){
    System.out.print("\n" + i + " Ticket: " + "\n----------------------\n|    Phantasialand   |\n\n|     Tageskarte     |\n\n|    Erwachsener     |\n\n|                    |\n\n|                    |\n\n|     Viel Spaß!     |\n\n----------------------\n");            
}
    for (int i = 1; i < anzahlKinderKarten  + 1; i++){
    System.out.print("\n" + i + " Ticket: " + "\n----------------------\n|    Phantasialand   |\n\n|     Tageskarte     |\n\n|      Kinder        |\n\n|                    |\n\n|                    |\n\n|     Viel Spaß!     |\n\n----------------------\n");            
}
    for (int i = 1; i < anzahlFamilienKarten  + 1; i++){
    System.out.print("\n" + i + " Ticket: " + "\n----------------------\n|    Phantasialand   |\n\n|     Tageskarte     |\n\n|       Familie      |\n\n|                    |\n\n|                    |\n\n|     Viel Spaß!     |\n\n----------------------\n");            
}
    for (int i = 1; i < anzahlGruppenKarten  + 1; i++){
    System.out.print("\n" + i + " Ticket: " + "\n----------------------\n|    Phantasialand   |\n\n|     Tageskarte     |\n\n|    Erwachsener     |\n\n|   (Gruppenrabatt)  |\n\n|                    |\n\n|     Viel Spaß!     |\n\n----------------------\n");            
}
    for (int i = 1; i < quickpassAnzahl  + 1; i++){
    System.out.print("\n" + i + " Ticket: " + "\n----------------------\n|    Phantasialand   |\n\n|     Tageskarte     |\n\n|     Quickpass      |\n\n|                    |\n\n|                    |\n\n|     Viel Spaß!     |\n\n----------------------\n");            
}
}
private void verabschiede(){
    System.out.print("\n\nVielen Dank für Ihren Kauf. Bitte entnehmen Sie Ihr Wechselgeld. Wir wünschen Ihnen noch einen schönene Tag.\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
}
private void setzeWertezurück(){
        tastaturEingabe = new Scanner(System.in);
    erwachsenenpreis = 28;
    kinderpreis = 15;
    gewuenschteAnzahl  = 0;
    gesamtPreis = -1;
    bezahlterBetrag = 0;
    Restbetrag = -1;
    kartenArt = 0;
    preisArt = 0;
    bestellungsVerlauf = 1;
    zwischenPreis = 0;
    anzahlErwachsenenKarten = 0;
    anzahlKinderKarten = 0;
    bestätigung = 0;
    anzahlFamilienKarten = 0;
}
public void zeigeMenu(){
    while(true){
    begruesse();
    frageAnzahlTicketsAb();
    berechneGesamtpreis();
    berechneWechselgeld();
    verabschiede();
    gibWechselgeldaus();
    druckeTickets();
    setzeWertezurück();
}
}
}