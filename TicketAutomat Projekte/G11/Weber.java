import java.util.Scanner;

public class Automat{
    private Scanner tastaturEingabe;
    private int kindereinzelpreis;
    private int einzelpreis;
    private int gewuenschteZahl;
    private int gewuenschteZahlKinderticket;
    private int gesamtPreis;
    private int bezahlterBetrag;
    private int FZer =0;
    private int ZZer ;
    private int ZEZer ;
    private int FÜZer ;
    private int ZEer ;
    private int EEer ;

    public Automat(){
        tastaturEingabe = new Scanner(System.in);
        einzelpreis = 28;
        kindereinzelpreis =  18;
        gewuenschteZahlKinderticket = -1;
        gewuenschteZahl = -1;
        gesamtPreis = -1;
        bezahlterBetrag = 0;
        FZer = 0;
        ZZer =0;
        ZEZer =0;
        FÜZer =0;
        ZEer =0;
        EEer =0;

    }

    private void begruesse(){
        System.out.println("Wilkommen im Phantasialand von Tim: \nHier können sie Eintrittskarten kaufen\n\n\n\n");
    }

    private void zeigePreistabelle(){
        System.out.println("Preistabelle:");
        System.out.println("##################################################");
        System.out.println("#Der Preis für ein  Kinderticket beträgt "+kindereinzelpreis+"€     #");
        System.out.println("#Der Preis für ein  Erwachsenenticket beträgt "+einzelpreis+"€#");
        System.out.println("#Ab 5 Tickets gibt es einen Mengenrabatt von 15€ #");
        System.out.println("##################################################\n\n\n\n");
    }

    private void frageAnzahlTickets(){
        System.out.println("Wieviel Kindertickets  benötigen sie?");
        gewuenschteZahlKinderticket = tastaturEingabe.nextInt();
        System.out.println("Wieviel Erwachsenentickets  benötigen sie?");
        gewuenschteZahl = tastaturEingabe.nextInt();
    }

    private void berechneGesamtpreis(){
        gesamtPreis = gewuenschteZahlKinderticket*kindereinzelpreis + gewuenschteZahl* einzelpreis;
        System.out.println("Der Gesamtpreis für deine Tickets beträgt  "+gesamtPreis+"€\n\n");
        if(gewuenschteZahlKinderticket + gewuenschteZahl >=5){
            System.out.println("Sie kriegen einen mengenrabatt von 15€\n");
            gesamtPreis= gesamtPreis-15;
            System.out.println("Der Gesamtpreis für deine Tickets beträgt nun  "+gesamtPreis+"€\n\n");
        }
    }

    public void zeigeMenü(){
        while(true) {
            begruesse();
            zeigePreistabelle();
            frageAnzahlTickets();
            berechneGesamtpreis();
            geldAnnehmen();
            wechselgeldBerechnen();
            druckeTickets();
            druckeKindertickets();
            verabschiede();
        }
    }

    private void geldAnnehmen(){
        //solange wie ...
        //Automat soll nur gültige Werte annhemen: 1,2,3,5,10,20,50,100
        while (bezahlterBetrag < gesamtPreis){
            System.out.println("Werfen sie bitte das Geld mittig rechts in den Schlitz\n");

            int eingeworfen;//loakle Variable

            eingeworfen = tastaturEingabe.nextInt();
            if(eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5 ||eingeworfen == 10 ||eingeworfen == 20 ||eingeworfen == 50 ||eingeworfen == 100){
                bezahlterBetrag = bezahlterBetrag+ eingeworfen;
                if(bezahlterBetrag < gesamtPreis){
                    System.out.println("Sie haben bisher "+bezahlterBetrag+"€ eingeworfen\n");
                    System.out.println("Werfen sie bitte das restliche Geld mittig rechts in den Schlitz\n");
                }

            } else{ System.out.println("Wir nehmen hier nur  1 und 2 Euro Münzen und 5;10;20;50;100 Euro Scheine an\n");}
        }
    }

    private void wechselgeldBerechnen(){
        int wechselgeld = bezahlterBetrag - gesamtPreis;
        if (wechselgeld > 0) {
            System.out.println("Sie bekommen noch "+wechselgeld+"€ zurück\n");
        }
        while (wechselgeld >= 50){
            FZer=FZer+1;
            wechselgeld=wechselgeld-50;

        }
        while (wechselgeld >= 20){
            ZZer=ZZer+1;
            wechselgeld=wechselgeld-20;

        }
        while (wechselgeld >= 10){
            ZEZer=ZEZer+1;
            wechselgeld=wechselgeld-10;

        }
        while (wechselgeld >= 5){
            FÜZer=FÜZer+1;
            wechselgeld=wechselgeld-5;

        }
        while (wechselgeld >= 2){
            ZEer=ZEer+1;
            wechselgeld=wechselgeld-2;

        }
        while (wechselgeld >=1){
            EEer=EEer+1;
            wechselgeld=wechselgeld-1;

        }
        if (wechselgeld == 0){
            System.out.println("Hier haben sie:");
            System.out.println(FZer+" 50€ Schein(e)");
            System.out.println(ZZer+" 20€ Schein(e)");
            System.out.println(ZEZer+" 10€ Schein(e)");
            System.out.println(FÜZer+" 5€ Schein(e)");
            System.out.println(ZEer+" 2€ Münze(n)");
            System.out.println(EEer+" 1€ Münze(n)\n\n");

        }
    }

    private  void hiertickets(){
    System.out.println("Entnehmen sie bitte ihre Tickets:\n\n");
    }
    private void druckeTicket(){
        System.out.println("#####################################");
        System.out.println("# Ihr Ticket fürs Glück");
        System.out.println("#####################################\n\n");

    }

    private void druckeTicketKinder(){
        System.out.println("#####################################");
        System.out.println("# Ihr Kinderticket fürs Glück");
        System.out.println("#####################################\n\n");

    }

    private void druckeKindertickets(){
        int nochZuDrucken = gewuenschteZahlKinderticket;
        while(nochZuDrucken > 0){
            druckeTicketKinder();
            nochZuDrucken = nochZuDrucken -1;
        }
    }

    private void druckeTickets(){
        int nochZuDrucken = gewuenschteZahl;
        while(nochZuDrucken > 0){
            druckeTicket();
            nochZuDrucken = nochZuDrucken -1;
        }
    }

    private void verabschiede(){
        System.out.println("Viel Spaß  im Phantasialand.\nDer Automat  ist gleich wieder für den nächsten Kunden Verfügbar...\n\n\n\n\n\n\n\n\n");
    }

}