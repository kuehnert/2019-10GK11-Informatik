//Maximilian Baumeister
import java.util.Scanner;



public class TicketAutomat {
    private Scanner eingabe;
    private Scanner eingabeT;
    private int einzelpreis;
    private int Spreis;
    private int Kpreis;
    private int Tart;
    private int anzahl;
    private int gesamtpreis;
    private int bezahlterBetrag;
    private int wechselgeld;
    private int STicketA;
    private int KTicketA;
    private String JaNein;
    private int rabatt;
   
    private void abr() {
       
        System.out.println("Abbruch...");
       
        zeigeMenu();
    }

    public TicketAutomat() {
        eingabe = new Scanner(System.in);
        eingabeT = new Scanner(System.in);
       

        zeigeMenu();
    }
   
    //Men�
    public void zeigeMenu() {
       
        einzelpreis = 30;
        Spreis = 25;
        Kpreis = 20;
        anzahl = 0;
        gesamtpreis = -1;
        bezahlterBetrag = -1;
        STicketA = 0;
        KTicketA = 0;
        Tart = 0;
       
       
        String neu = "d";
        System.out.println("\n\n\n\n\n\n\nbitte ein beliebiges Zeichen eingeben um fortzufahren...\n\n\n\n\n");
        neu = eingabe.next();
       
        if(neu.equals("d")){
           
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            begruesse();
            gibAnzahl();
            gibgesamtpreis();
            geldAnnehmen();
            RueckGeld();
            ticketsdrucken();
            verabschieden();
            zeigeMenu();
           
        }else {
           
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n");
            begruesse();
            gibAnzahl();
            gibgesamtpreis();
            geldAnnehmen();
            RueckGeld();
            ticketsdrucken();
            verabschieden();
            zeigeMenu();
        }

       
    }

    //beg��ung + Tickets
    private void begruesse() {

        System.out.println("Guten Tag, Willkommen bei Max's funhouse!\n bei 5 Tickets der gleichen art gibt es 10� Mengenrabatt!!!\n bei 15 Tickests Insgesamt au�erdem noch mal 10�!!!\n\n");
        
        bezahlterBetrag = 0;
        anzahl = 0;
        STicketA = 0;
        KTicketA = 0;
    }

    // Abfragen Scanner
    //Ticket abfrage
    private void gibAnzahl() {
        System.out.println(" Ein Standard Ticket (1) kostet " + einzelpreis + "�" +
        "\n Ein Sch�lerticket (2) kostet " + Spreis + "�" +
        "\n Ein Kinderticket (3) kostet " + Kpreis + "�");
        System.out.println("\nwelche art von Ticket h�tten sie gerne?\n\n");
        Tart = eingabe.nextInt();
        if(Tart == 1) {
            System.out.println("also ein Standard Ticket");
            System.out.println("Wie viele Tickets h�tten sie gern?");
            anzahl = eingabe.nextInt();
        } else if(Tart == 2){
            System.out.println("also ein Sch�lerticket");
            System.out.println("Wie viele Tickets h�tten sie gern?");
            STicketA = eingabe.nextInt();
        } else if(Tart ==3){
            System.out.println("also ein Kinderticket");
            System.out.println("Wie viele Tickets h�tten sie gern?");
            KTicketA = eingabe.nextInt();
        } else {
            System.out.println("bitte die den Tickets zugeordnenten Zahlen angeben");
            gibAnzahl();
        }
   
        bestellung();
    }
   
    //bestellung + Hinzuf�gen
    private void bestellung() {
       
        System.out.println("Ihre Bestellung:");
      if(anzahl == 1) {
           
            System.out.println("\n" + anzahl + " Standard Ticket");
        }else if(anzahl >= 2) {
           
            System.out.println("\n" + anzahl + " Standard Tickets");
        }
       
        if(STicketA == 1) {
           
            System.out.println("\n" + STicketA + " Sch�lerticket");
        }else if(STicketA >= 2) {
           
            System.out.println("\n" + STicketA + " Sch�lertickets");
        }
       
        if(KTicketA == 1 ) {
           
             System.out.println("\n" + KTicketA + " Kinderticket");
        }else if(KTicketA >= 2) {
           
             System.out.println("\n" + KTicketA + " Kindertickets");
        }
       
       
        System.out.println("\n\n\nIst Ihre Bestellung vollst�ndig? \n  ja/nein?\n\n Abbrechen? --> <Abbruch> eingeben");
        JaNein = eingabe.next();
       
        if(JaNein.equals("ja") || JaNein.equals("Ja") ){
            System.out.println("okay");
           
        } else if(JaNein.equals("nein") || JaNein.equals("Nein") ){
           
            gibAnzahl();
        }else if(JaNein.equals("Abbruch")) {
           
            abr();
        }else {
               System.out.println("bitte nur Ja/Nein/Abbruch angeben");
               bestellung();
        }
       
    }

   

    //Berechnung: Gesamtpreis + Rabatt
    public void gibgesamtpreis() {

        gesamtpreis = anzahl * einzelpreis + STicketA * Spreis + KTicketA * Kpreis;
        if (anzahl >=5) {
           
            gesamtpreis = gesamtpreis - 10;
        }
        if (STicketA >=5) {
           
            gesamtpreis = gesamtpreis - 10;
        }
        if (KTicketA >= 5) {
           
            gesamtpreis = gesamtpreis - 10;
        }
        int RabattA = anzahl + STicketA + KTicketA;
        if (RabattA >= 15) {
           
            gesamtpreis = gesamtpreis -10;
        }
       
        System.out.println("der Gesamtpreis betr�gt: " + gesamtpreis + "�");

    }

    //Einzahlen
    public void geldAnnehmen() {

        //tue das Folgende **so lange wie **
        while (bezahlterBetrag < gesamtpreis) {

            System.out.println("Bitte Geld einwerfen");
            //lokale Variable V wird am ende er Funktion gel�scht

            int eingeworfen;
            int nochZuBezahlen;

            eingeworfen = eingabe.nextInt();

              if (eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5 || eingeworfen == 10 || eingeworfen == 20 ||eingeworfen == 50 || eingeworfen == 100 || eingeworfen == 200){

                bezahlterBetrag =  bezahlterBetrag + eingeworfen;

                System.out.println("sie haben bisher " + bezahlterBetrag + "� eingeworfen");
                nochZuBezahlen = gesamtpreis - bezahlterBetrag;
                 if (nochZuBezahlen <0){
                   
                   
                 }else if (nochZuBezahlen == 0) {
                   
                    System.out.println("Ihr bezahlter betrag ist auf den cent genau!!!");
                 }else {
                System.out.println("es fehlen noch " + nochZuBezahlen + "�");
               
             }

              } else{
                System.out.println("Das Geld bite einzeln einwerfen (nur g�ltige scheine/m�nzen einwerfen ( 500� Scheine k�nnen nicht angenommen werden)");
            }
        }

    }

    //R�ckgeld
    public void RueckGeld() {
        int wechselgeld = bezahlterBetrag - gesamtpreis;
        // Gib wechselgeld aus, wenn es Wechselgeld gibt

        if(wechselgeld > 0){
            System.out.println("\nSie bekommen " + wechselgeld + "� zur�ck\n\n");
           
            int awechselgeld = wechselgeld;
            int FZS = 0;
            int ZS = 0;
            int ZH = 0;
            int FS = 0;
            int ZE = 0;
            int EE = 0;
           
            while(awechselgeld >= 50){
           
                awechselgeld = awechselgeld - 50;
                FZS = FZS + 1;
            }
            while(awechselgeld >= 20){
           
                awechselgeld = awechselgeld - 20;
                ZS = ZS + 1;
            }
            while(awechselgeld >= 10){
           
                awechselgeld = awechselgeld - 10;
                ZH = ZH + 1;
            }
            while(awechselgeld >= 5){
           
                awechselgeld = awechselgeld - 5;
                FS = FS + 1;
            }
            while(awechselgeld >= 2){
           
                awechselgeld = awechselgeld - 2;
                ZE = ZE + 1;
            }
            while(awechselgeld >= 1){
           
                awechselgeld = awechselgeld - 1;
                EE = EE + 1;
            }
            
            
            System.out.println("sie bekommen:");

           
            if(FZS == 1) {
                System.out.println(FZS +" F�nfzig-Euroschein");
            }
            if(FZS > 1) {
                System.out.println(FZS +" F�nfzig-Euroscheine");
            }
            
            if(ZS == 1) {
                System.out.println(ZS +" Zwanzig-Euroschein");
            }
            if(ZS > 1) {
                System.out.println(ZS +" Zwanzig-Euroscheine");
            }
            
            if(ZH == 1) {
                System.out.println(ZH +" Zehn-Euroschein");
            }
            if(ZH > 1) {
                System.out.println(ZH +" Zehn-Euroscheine");
            }
            
            if(FS == 1) {
                System.out.println(FS +" F�nf-Euroschein");
            }
            if(FS > 1) {
                System.out.println(FS +" F�nf-Euroscheine");
            }
            
            if(ZE == 1) {
                System.out.println(ZE +" Zwei-Eurost�ck");
            }
            if(ZE > 1) {
                System.out.println(ZE +" Zwei-Eurost�cke");
            }
            
            if(EE == 1) {
                System.out.println(EE +" Ein-Eurost�ck");
            }
            if(EE > 1) {
                System.out.println(EE +" Ein-Eurost�cke");
            }
           
        }
       System.out.println("\n\n");
    }

    //Tickets
    public void druckeTickets() {

        System.out.println("\n#########################");
        System.out.println("#        Ticket         #");
        System.out.println("#########################\n\n");
    }
   
    public void druckeSTickets() {

        System.out.println("\n#########################");
        System.out.println("#    Sch�lerTicket      #");
        System.out.println("#########################\n\n");
    }
   
    public void druckeKTickets() {

        System.out.println("\n#########################");
        System.out.println("#      KinderTicket     #");
        System.out.println("#########################\n\n");
    }

    //Ticketdruck
    public void ticketsdrucken() {

       
        int druck = anzahl;
        int druckS = STicketA;
        int druckK = KTicketA;

        System.out.println("Drucke Tickets");
       
        if(anzahl == 1){
         System.out.println("\n\n\n hier ist ihr StandartdTicket\n");
        }else if(anzahl == 0) {
           
           
        }else{
            System.out.println("\n\n\n hier sind ihre " + anzahl + " Standard Tickets\n");
        }
        while (druck > 0) {
           
            if(druck == 1){
                System.out.println("Drucke noch ein Standard Ticket");
            }
            else {
                System.out.println("Drucke noch " + druck + " Standard Tickets");
            }
       
            druckeTickets();
            druck = druck - 1;

        }
       
        if(STicketA == 1){
         System.out.println("\n\n\n hier ist ihr Sch�lerticket\n");
        }else if(STicketA == 0) {
           
           
        }else{
            System.out.println("\n\n\n hier sind ihre " + STicketA + " Sch�lertickets\n");
        }
        while (druckS > 0) {
           
            if(druckS == 1){
                System.out.println("Drucke noch ein Sch�lerticket");
            }
            else {
                System.out.println("Drucke noch " + druckS + " Sch�lertickets");
            }
       
            druckeSTickets();
            druckS = druckS - 1;

        }
       
        if(KTicketA == 1){
         System.out.println("\n\n\n hier ist ihr Kinderticket\n");
        }else if(KTicketA == 0) {
           
           
        }else{
            System.out.println("\n\n\n hier sind ihre " + KTicketA + " Kindertickets\n");
        }
        while (druckK > 0) {
           
            if(druckK == 1){
                System.out.println("Drucke noch ein Kinderticket");
            }
            else {
                System.out.println("Drucke noch " + druckK + " Kindertickets");
            }
       
            druckeKTickets();
            druckK = druckK - 1;

        }

    }

    //Verabschieden
    public void verabschieden() {

        System.out.println("Bitte entnehmen sie ihr R�ckgeld und Tickets!\n Viel Spa� im funhouse!!!");
    }

}
