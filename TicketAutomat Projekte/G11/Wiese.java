import java.util.Scanner;

public class TicketautomatLeon{
    private int preisKinder;
    private int preisJugendliche;
    private int preisErwachsene;
    private int preisKleinkinder;
    
    private String zweihunderter;
    private String hunderter;
    private String fuenfziger;
    private String zwanziger;
    private String zehner;
    private String fuenfer;
    private String zweier;
    private String einer;
    
    private int anzahlErwachsenenTickets;
    private int anzahlJugendlichenTickets;
    private int anzahlKinderTickets;
    private int anzahlKleinkinderTickets;
    private int gesamtAnzahlTickets;
    
    private int rueckzweihundert;
    private int rueckhundert;
    private int rueckfuenfzig;
    private int rueckzwanzig;
    private int rueckzehn;
    private int rueckfuenf;
    private int rueckzwei;
    private int rueckeins;
    
    private int gesamtpreis;
    private int restsumme;
    private int bezahlterBetrag;
    
    private boolean einwurf;
    private boolean rueckgeld;
    
    private Scanner input;
    
    public TicketautomatLeon() {
        input = new Scanner(System.in);
        preisKinder = 20;
        preisJugendliche = 35;
        preisErwachsene = 45;
        preisKleinkinder = 0;
        
        anzahlErwachsenenTickets = -1;
        anzahlJugendlichenTickets = -1;
        anzahlKinderTickets = -1;
        anzahlKleinkinderTickets = -1;
        gesamtAnzahlTickets = -1;
        
        gesamtpreis = -1;
        restsumme = -1;
        bezahlterBetrag = 0;
        
        rueckzweihundert = 0;
        rueckhundert = 0;
        rueckfuenfzig = 0;
        rueckzwanzig = 0;
        rueckzehn = 0;
        rueckfuenf = 0;
        rueckzwei = 0;
        rueckeins = 0;
        
        zweihunderter = "200€\n";
        hunderter = "100€\n";
        fuenfziger = "50€\n";
        zwanziger = "20€\n";
        zehner = "10€\n";
        fuenfer = "5€\n";
        zweier = "2€\n";
        einer = "1€\n";
        
        einwurf = true;
        rueckgeld = true;
    }
    
    
    
    private void begruesse() {
        System.out.print("\n\nGuten Tag!" + "\nWillkommen im Phantasialand\n");
    }
    private void zeigePreistabelle() {
        System.out.print(
            "*************************************\n" + "Preistabelle:" +
            "\nKleinkinder (bis 6 Jahre):      " + preisKleinkinder + "€" +
            "\nKinder (bis 12 Jahre):          " + preisKinder + "€" +
            "\nJugendliche (bis 16 Jahre):     " + preisJugendliche + "€" +
            "\nErwachsene:                     " + preisErwachsene + "€\n" +
            "\n                                " +
            "\n             Aktion!            " +
            "\n      Beim kauf von über 5      " +
            "\n    kostenpflichtigen Tickets   " +
            "\n              -30%              \n" + 
            "*************************************\n");
    }
    private void frageAnzahlTickets() {
        System.out.print("Wie viele Erwachsenentickets wollen sie?\n ");
        anzahlErwachsenenTickets = input.nextInt();
        System.out.print("Wie viele Jugendlichentickets wollen sie?\n ");
        anzahlJugendlichenTickets = input.nextInt();
        System.out.print("Wie viele Kindertickets wollen sie?\n ");
        anzahlKinderTickets = input.nextInt();
        System.out.print("Wie viele Kleinkindertickets wollen sie?\n ");
        anzahlKleinkinderTickets = input.nextInt();
        System.out.print("\nSie wollen also " + anzahlErwachsenenTickets + " Erwachsenentickets, " +
            anzahlJugendlichenTickets + " Jugendlichentickets, " + anzahlKinderTickets + " Kindertickets und " +
            anzahlKleinkinderTickets + " Kleinkindertickets haben!\n");        
    }
    private void berechneGesamtanzahlTickets() {
        gesamtAnzahlTickets = anzahlErwachsenenTickets + anzahlJugendlichenTickets + anzahlKinderTickets;
    }
    private void gibGesamtpreis() {
        if(gesamtAnzahlTickets >= 5) {
            gesamtpreis = (anzahlErwachsenenTickets * preisErwachsene +
                anzahlJugendlichenTickets * preisJugendliche + anzahlKinderTickets * preisKinder +
                anzahlKleinkinderTickets * preisKleinkinder);
            gesamtpreis = gesamtpreis / 10;
            gesamtpreis = gesamtpreis * 7;
            restsumme = gesamtpreis;
            System.out.print("Zu zahlen:    " + restsumme + "€");
        }
        else {
            gesamtpreis = (anzahlErwachsenenTickets * preisErwachsene +
                anzahlJugendlichenTickets * preisJugendliche + anzahlKinderTickets * preisKinder +
                anzahlKleinkinderTickets * preisKleinkinder);
            restsumme = gesamtpreis;            
            System.out.print("Zu zahlen:    " + restsumme + "€");
        }
    }
    private void nimmGeldAn() {
        while(einwurf) {
            if(restsumme > 0) {
                int eingeworfen; //lokale Variable
                System.out.print("\nBitte werfen sie Geld ein.\n");
                eingeworfen = input.nextInt();
                if(eingeworfen == 1 || eingeworfen == 2 || eingeworfen == 5 || eingeworfen == 10 || eingeworfen ==20 ||
                    eingeworfen == 50 || eingeworfen == 100 || eingeworfen == 200) {
                    bezahlterBetrag = bezahlterBetrag + eingeworfen;
                    restsumme = restsumme - eingeworfen;
                    System.out.print("Sie haben " + bezahlterBetrag + " bezahlt!\n" +
                    "Es fehlen noch " + restsumme + "€!");
                }
                else {
                    System.out.print("Dieser Schein wird nicht angenommen");
                }
            }
            else if(restsumme == 0) {
                einwurf = false;
            }
            else {
                einwurf = false;
                restsumme = restsumme * -1;
                System.out.print("\nSie bekommen " + restsumme + "€ zurück.\n");
            }
        }
    }
    private void gibWechselgeld() {
        if (restsumme > 0) {
            System.out.print("Hier, ihr Rückgeld:\n\n" );        
        }
        while(rueckgeld) {
            if(restsumme >= 200) {
                rueckzweihundert = rueckzweihundert + 1;
                restsumme = restsumme - 200;
            }
            else if(restsumme >= 100) {
                rueckhundert = rueckhundert + 1;
                restsumme = restsumme - 100;
            }
            else if(restsumme >= 50) {
                rueckfuenfzig = rueckfuenfzig + 1;
                restsumme = restsumme - 50;
            }
            else if(restsumme >= 20) {
                rueckzwanzig = rueckzwanzig +1;
                restsumme = restsumme - 20;
            }
            else if(restsumme >= 10) {
                rueckzehn = rueckzehn + 1;
                restsumme = restsumme - 10;
            }
            else if(restsumme >= 5) {
                rueckfuenf = rueckfuenf + 1;
                restsumme = restsumme - 5;
            }
            else if(restsumme >= 2) {
                rueckzwei = rueckzwei + 1;
                restsumme = restsumme - 2;
            }
            else if(restsumme >= 1) {
                rueckeins = rueckeins + 1;
                restsumme = restsumme - 1;
            }
            else {
                rueckgeld = false;
            }
        }
        for(int i=0; i<rueckzweihundert; i++) {
            System.out.print(gibZweihunni());
        }
        for(int i=0; i<rueckhundert; i++) {
            System.out.print(gibHunni());
        }
        for(int i=0; i<rueckfuenfzig; i++) {
            System.out.print(gibFuffi());
        }
        for(int i=0; i<rueckzwanzig; i++) {
            System.out.print(gibZwanni());
        }
        for(int i=0; i<rueckzehn; i++) {
            System.out.print(gibZehner());
        }
        for(int i=0; i<rueckfuenf; i++) {
            System.out.print(gibFuenfer());
        }
        for(int i=0; i<rueckzwei; i++) {
            System.out.print(gibZweier());
        }
        for(int i=0; i<rueckeins; i++) {
            System.out.print(gibEiner());
        }
    }   
    private void druckeTickets() {
        System.out.print("\nHier die Tickets:");
        for(int i=0; i<anzahlErwachsenenTickets; i++) {
            druckeErwachsenenTicket();
        }
        for(int i=0; i<anzahlJugendlichenTickets; i++) {
            druckeJugendlichenTicket();
        }
        for(int i=0; i<anzahlKinderTickets; i++) {
            druckeKinderTicket();
        }
        for(int i=0; i<anzahlKleinkinderTickets; i++) {
            druckeKleinkinderTicket();
        }
    }
    private void verabschiedeDich() {
        System.out.print("Tschüss!" +
            "\nEinen schönen aufenthalt im Park wünscht ihnen das Phantasialand Team!");
    }
    private void setzezurueck() {
        anzahlErwachsenenTickets = -1;
        anzahlJugendlichenTickets = -1;
        anzahlKinderTickets = -1;
        anzahlKleinkinderTickets = -1;
        gesamtAnzahlTickets = -1;
        
        gesamtpreis = -1;
        restsumme = -1;
        bezahlterBetrag = 0;
        
        rueckzweihundert = 0;
        rueckhundert = 0;
        rueckfuenfzig = 0;
        rueckzwanzig = 0;
        rueckzehn = 0;
        rueckfuenf = 0;
        rueckzwei = 0;
        rueckeins = 0;
        
        einwurf = true;
        rueckgeld = true;        
    }
    
    
    private void druckeErwachsenenTicket() {
        System.out.print(
            "\n***************************" +
            "\n*                         *" +
            "\n*       1x Eintritt       *" +
            "\n*  für einen Erwachsenen  *" +
            "\n*    ins Phantasialand    *" +
            "\n*                         *" +
            "\n***************************\n");
    }    
    private void druckeJugendlichenTicket() {
        System.out.print(
            "\n****************************" +
            "\n*                          *" +
            "\n*       1x Eintritt        *" +
            "\n*  für einen Jugendlichen  *" +
            "\n*    ins Phantasialand     *" +
            "\n*                          *" +
            "\n****************************\n");
    }    
    private void druckeKinderTicket() {
        System.out.print(
            "\n****************************" +
            "\n*                          *" +
            "\n*        1x Eintritt       *" +
            "\n*       für ein Kind       *" +
            "\n*     ins Phantasialand    *" +
            "\n*                          *" +
            "\n****************************\n");
    }
    private void druckeKleinkinderTicket() {
        System.out.print(
            "\n***************************" +
            "\n*                         *" +
            "\n*       1x Eintritt       *" +
            "\n*    für ein Kleinkind    *" +
            "\n*    ins Phantasialand    *" +
            "\n*                         *" +
            "\n***************************\n");
    }
    private String gibZweihunni() {
        return zweihunderter;
    }
    private String gibHunni() {
        return hunderter;
    }
    private String gibFuffi() {
        return fuenfziger;
    }
    private String gibZwanni() {
        return zwanziger;
    }
    private String gibZehner() {
        return zehner;
    }
    private String gibFuenfer() {
        return fuenfer;
    }
    private String gibZweier() {
        return zweier;
    }
    private String gibEiner() {
        return einer;
    }

    
    
    public void fuehreAus() {
        while (true) {
            begruesse();
            zeigePreistabelle();
            frageAnzahlTickets();
            berechneGesamtanzahlTickets();
            gibGesamtpreis();
            nimmGeldAn();
            gibWechselgeld();
            druckeTickets();
            verabschiedeDich();
            setzezurueck();
        }
    }
}