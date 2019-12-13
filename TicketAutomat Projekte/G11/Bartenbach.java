import java.util.Scanner;

public class Ticketautomat {
    private Scanner tastaturEingabe;
    private int kind;
    private int erwachsen;
    private int einzelpreis;
    private int einzelpreisKind;
    private int einzelpreisFam;
    private int gewuenschteAnzahl;
    private int gewuenschteAnzahlKind;
    private int gewuenschteAnzahlFam;
    private int gesamtPreis;
    private int gesamtPreisKind;
    private int gesamtpreisFam;
    private int bezahlterBetrag;
    private int bezahlterBetragKind;
    private int bezahlterBetragFam;

    public Ticketautomat() {
        tastaturEingabe = new Scanner(System.in);
        einzelpreis = 28;
        einzelpreisKind = 20;
        einzelpreisFam = 75;
        gewuenschteAnzahl = -1;
        gesamtPreis = 0;
        bezahlterBetrag = 0;
        bezahlterBetragKind = 0;
        anrede();
        auswahl();
    }

    private void anrede() {
        System.out.println("Wilkommen im Traumland,\n bei mehr als 3 Erwachsenentickets gibt es 10€ Rabatt,\n bei mehr als 2 Kindertickets bibt es 7€ Rabatt");
    }
    
    private void auswahl() {
      System.out.println("Welche art von Ticket möchten Sie?");
      System.out.println("Für ein Kinderticket (" + einzelpreisKind + "€) drücken sie die 1");
      System.out.println("Für ein Erwachsenenticket (" + einzelpreis + "€) drücken sie 2x hintereinander die 2");
      System.out.println("Für ein FamilienTicket (2 Erwachsene - 2 Kinder) (" + einzelpreisFam + "€) drücken sie 2x hintereinander die 3");
      
      if (tastaturEingabe.nextInt() == 1) {
           zeigeMenuKind(); 
        } 
      else if (tastaturEingabe.nextInt() == 2) {
           zeigeMenu(); 
        }
      else {
           zeigeMenuFam();
        }
    }
    
    private void begruesse() {
        System.out.println(
            "Willkommen im Traumland\n" +
            "1 Ticket kostet " + einzelpreis + "€\n"
        );
        
        bezahlterBetrag = 0;
    }

    private void begruesseKind() {
        System.out.println(
            "Willkommen im Traumland\n" +
            "1 Kinderticket kostet " + einzelpreisKind + "€\n"
        );
        
        bezahlterBetragKind = 0;
    }
    
    private void begruesseFam() {
        System.out.println(
            "Willkommen im Traumland\n" +
            "1 Familienticket kostet " + einzelpreisFam + "€\n"
        );
        
        bezahlterBetragFam = 0;
    }
    // Abfragen Scanner
    private void frageAnzahlTicketsAb() {
        System.out.print("Wie viele Tickets möchten Sie haben? ");
        gewuenschteAnzahl = tastaturEingabe.nextInt();
        System.out.print("also möchten sie " +
            gewuenschteAnzahl +
            " Ticket/s!"
        );
    }

    private void frageAnzahlTicketsAbKind() {
        System.out.print("Wie viele Kindertickets möchten Sie haben? ");
        gewuenschteAnzahlKind = tastaturEingabe.nextInt();
        System.out.print("also möchten sie " +
            gewuenschteAnzahlKind +
            " Kinderticket/s!"
        );
    }
    
    private void frageAnzahlTicketsAbFam() {
        System.out.print("Wie viele Familientickets möchten Sie haben? ");
        gewuenschteAnzahlFam = tastaturEingabe.nextInt();
        System.out.print("also möchten sie " +
            gewuenschteAnzahlFam +
            " Familienticket/s!\n"
        );
    }
    
    private void berechneGesamtpreis() {
        gesamtPreis = gewuenschteAnzahl * einzelpreis;
        if (gewuenschteAnzahl >= 3) {
        gesamtPreis = gesamtPreis - 10;
        }
        System.out.println("Bitte werfen sie " + gesamtPreis + "€ in die Geldeinwurfstelle");
    }

    private void berechneGesamtpreisKind() {
        gesamtPreisKind = gewuenschteAnzahlKind * einzelpreisKind;
        if (gewuenschteAnzahlKind >= 2) {
        gesamtPreisKind = gesamtPreisKind - 7;
        }
        System.out.println("Bitte werfen sie " + gesamtPreisKind + "€ in die Geldeinwurfstelle");
    }
    
    private void berechneGesamtpreisFam() {
        gesamtpreisFam = gewuenschteAnzahlFam * einzelpreisFam;
        
        System.out.println("Bitte werfen sie " + gesamtpreisFam + "€ in die Geldeinwurfstelle");
    }
    
    private void verabschiedeDich() {
        System.out.println("Viel spass und einen schönen Tag!");
    }

    private void nimmGeldAn() {
        // 0. tue das Folgende so lange wie.....
        // Automat soll nur gültige werte annehmen: 1,2,5,10,20,50,100
        
        
        
       while (bezahlterBetrag < gesamtPreis) {
            // 1. Fordere Benutzer auf, ein Geldstück/-schein einzuwerfen
            System.out.print("Wieviel Geld werfen Sie ein: ");

            // 2. Lies den eingeworfenen Betrag über die Tastatur ein
            int eingeworfen; // lokale Variable
            eingeworfen = tastaturEingabe.nextInt();
          if (eingeworfen == 1||eingeworfen == 2||eingeworfen == 5||
          eingeworfen == 10||eingeworfen == 20||eingeworfen == 50||
          eingeworfen ==100) {
            // 3. Addiere den Betrag <eingeworfen> zu <bezahlterBetrag>
            bezahlterBetrag = bezahlterBetrag + eingeworfen;
            
            System.out.print("bis jetzt haben sie " + bezahlterBetrag +
                "€ eingeworfen");
            }
            else {
            System.out.println("Bitte 1€,2€,5€,10€,20€,50€ oder 100€ einwerfen!");
            }
        }
    }

    private void nimmGeldAnKind() {
        // 0. tue das Folgende so lange wie.....
        // Automat soll nur gültige werte annehmen: 1,2,5,10,20,50,100
        
        
        
       while (bezahlterBetragKind < gesamtPreisKind) {
            // 1. Fordere Benutzer auf, ein Geldstück/-schein einzuwerfen
            System.out.print("Wieviel Geld werfen Sie ein: ");

            // 2. Lies den eingeworfenen Betrag über die Tastatur ein
            int eingeworfenKind; // lokale Variable
            eingeworfenKind = tastaturEingabe.nextInt();
          if (eingeworfenKind == 1||eingeworfenKind == 2||eingeworfenKind == 5||
          eingeworfenKind == 10||eingeworfenKind == 20||eingeworfenKind == 50||
          eingeworfenKind ==100) {
            // 3. Addiere den Betrag <eingeworfen> zu <bezahlterBetrag>
            bezahlterBetragKind = bezahlterBetragKind + eingeworfenKind;
            
            System.out.print("bis jetzt haben sie " + bezahlterBetragKind +
                "€ eingeworfen");
            }
            else {
            System.out.println("Bitte 1€,2€,5€,10€,20€,50€ oder 100€ einwerfen!");
            }
        }
    }
    
    private void nimmGeldAnFam() {
        // 0. tue das Folgende so lange wie.....
        // Automat soll nur gültige werte annehmen: 1,2,5,10,20,50,100
        
        
        
       while (bezahlterBetragFam < gesamtpreisFam) {
           
            System.out.print("Wieviel Geld werfen Sie ein: ");

           
            int eingeworfenFam; // lokale Variable
            eingeworfenFam = tastaturEingabe.nextInt();
          if (eingeworfenFam == 1||eingeworfenFam == 2||eingeworfenFam == 5||
          eingeworfenFam == 10||eingeworfenFam == 20||eingeworfenFam == 50||
          eingeworfenFam ==100) {
            // 3. Addiere den Betrag <eingeworfen> zu <bezahlterBetrag>
            bezahlterBetragFam = bezahlterBetragFam + eingeworfenFam;
            
            System.out.print("bis jetzt haben sie " + bezahlterBetragFam +
                "€ eingeworfen");
            }
            else {
            System.out.println("Bitte 1€,2€,5€,10€,20€,50€ oder 100€ einwerfen!");
            }
        }
    }
    
    private void berechneWechselgeld() {
        int wechselgeld = bezahlterBetrag - gesamtPreis;
    if (wechselgeld > 0) {
        System.out.println("jetzt bekommen sie noch " + wechselgeld + "€ zurück");
    
        while (wechselgeld >= 100) {
            System.out.println("[100€-Schein]");
            wechselgeld = wechselgeld - 100;
        }
        while (wechselgeld >= 50) {
            System.out.println("[50€-Schein]");
            wechselgeld = wechselgeld - 50;
        }
        while (wechselgeld >= 20) {
            System.out.println("[20€-Schein]");
            wechselgeld = wechselgeld - 20;
        }
        while (wechselgeld >= 10) {
            System.out.println("[10€-Schein]");
            wechselgeld = wechselgeld - 10;
        }
        while (wechselgeld >= 5) {
            System.out.println("[5€-Schein]");
            wechselgeld = wechselgeld - 5;
        }
        while (wechselgeld >= 2) {
            System.out.println("[2€-Münze]");
            wechselgeld = wechselgeld - 2;
        }
        while (wechselgeld >= 1) {
            System.out.println("[1€-Münze]");
            wechselgeld = wechselgeld - 1;
        }
    }
}

private void berechneWechselgeldKind() {
        int wechselgeldKind = bezahlterBetragKind - gesamtPreisKind;
    if (wechselgeldKind > 0) {
        System.out.println("jetzt bekommen sie noch " + wechselgeldKind + "€ zurück");
    
        while (wechselgeldKind >= 100) {
            System.out.println("[100€-Schein]");
            wechselgeldKind = wechselgeldKind - 100;
        }
        while (wechselgeldKind >= 50) {
            System.out.println("[50€-Schein]");
            wechselgeldKind = wechselgeldKind - 50;
        }
        while (wechselgeldKind >= 20) {
            System.out.println("[20€-Schein]");
            wechselgeldKind = wechselgeldKind - 20;
        }
        while (wechselgeldKind >= 10) {
            System.out.println("[10€-Schein]");
            wechselgeldKind = wechselgeldKind - 10;
        }
        while (wechselgeldKind >= 5) {
            System.out.println("[5€-Schein]");
            wechselgeldKind = wechselgeldKind - 5;
        }
        while (wechselgeldKind >= 2) {
            System.out.println("[2€-Münze]");
            wechselgeldKind = wechselgeldKind - 2;
        }
        while (wechselgeldKind >= 1) {
            System.out.println("[1€-Münze]");
            wechselgeldKind = wechselgeldKind - 1;
        }
    }
}

private void berechneWechselgeldFam() {
        int wechselgeldFam = bezahlterBetragFam - gesamtpreisFam;
    if (wechselgeldFam > 0) {
        System.out.println("jetzt bekommen sie noch " + wechselgeldFam + "€ zurück");
    
        while (wechselgeldFam >= 100) {
            System.out.println("[100€-Schein]");
            wechselgeldFam = wechselgeldFam - 100;
        }
        while (wechselgeldFam >= 50) {
            System.out.println("[50€-Schein]");
            wechselgeldFam = wechselgeldFam - 50;
        }
        while (wechselgeldFam >= 20) {
            System.out.println("[20€-Schein]");
            wechselgeldFam = wechselgeldFam - 20;
        }
        while (wechselgeldFam >= 10) {
            System.out.println("[10€-Schein]");
            wechselgeldFam = wechselgeldFam - 10;
        }
        while (wechselgeldFam >= 5) {
            System.out.println("[5€-Schein]");
            wechselgeldFam = wechselgeldFam - 5;
        }
        while (wechselgeldFam >= 2) {
            System.out.println("[2€-Münze]");
            wechselgeldFam = wechselgeldFam - 2;
        }
        while (wechselgeldFam >= 1) {
            System.out.println("[1€-Münze]");
            wechselgeldFam = wechselgeldFam - 1;
        }
    }
}

private void druckeTicket() {
    System.out.println("###########################");
    System.out.println("#  ihr ticket fürs glück  #");
    System.out.println("###########################");
    System.out.println("\n\n");
}

private void druckeTicketKind() {
    System.out.println("###########################");
    System.out.println("#  ihr ticket fürs kind   #");
    System.out.println("###########################");
    System.out.println("\n\n");
}

private void druckeTicketFam() {
    System.out.println("#################################");
    System.out.println("#  ihr ticket für die Familie   #");
    System.out.println("#################################");
    System.out.println("\n\n");
}

private void druckeTickets() {
    int nochZuDrucken = gewuenschteAnzahl;
    while (nochZuDrucken > 0) {
        System.out.println("Drucke noch " + nochZuDrucken + " Ticket/s...");
        druckeTicket();
        nochZuDrucken = nochZuDrucken - 1;
    }
}

private void druckeTicketsKind() {
    int nochZuDruckenKind = gewuenschteAnzahlKind;
    while (nochZuDruckenKind > 0) {
        System.out.println("Drucke noch " + nochZuDruckenKind + " Ticket/s...");
        druckeTicketKind();
        nochZuDruckenKind = nochZuDruckenKind - 1;
    }
}

private void druckeTicketsFam() {
    int nochZuDruckenFam = gewuenschteAnzahlFam;
    while (nochZuDruckenFam > 0) {
        System.out.println("Drucke noch " + nochZuDruckenFam + " Ticket/s...");
        druckeTicketFam();
        nochZuDruckenFam = nochZuDruckenFam - 1;
    }
}

public void zeigeMenu() {
    while (true) {
        begruesse();
        frageAnzahlTicketsAb();
        berechneGesamtpreis();
        nimmGeldAn();
        berechneWechselgeld();
        verabschiedeDich();
        druckeTickets();
        auswahl();
    }
}

public void zeigeMenuKind() {
    while (true) {
        begruesseKind();
        frageAnzahlTicketsAbKind();
        berechneGesamtpreisKind();
        nimmGeldAnKind();
        berechneWechselgeldKind();
        verabschiedeDich();
        druckeTicketsKind();
        auswahl();
    }
}

public void zeigeMenuFam() {
    while (true) {
        begruesseFam();
        frageAnzahlTicketsAbFam();
        berechneGesamtpreisFam();
        nimmGeldAnFam();
        berechneWechselgeldFam();
        verabschiedeDich();
        druckeTicketsFam();
        auswahl();
    }
}
}