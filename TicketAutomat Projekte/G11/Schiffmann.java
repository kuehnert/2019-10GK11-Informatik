import java.util.Scanner;



public class TicketAutomat{
     private Scanner tastaturEingabe;
     private int einzelpreis;
     private int bezahlterBetrag;
     private int gewuenschteAnzahl;
     private int gesammtPreis;
     
    public TicketAutomat() {
         einzelpreis = 28;
         tastaturEingabe= new Scanner(System.in);
         gewuenschteAnzahl = -1;
         gesammtpreis = -1;
         bezahlterBetrag = -1;
        }
        
    public void begruesse() {
        System.out.println(  
        "Willkommen im Phanthasia-Land!\n" +
        "Ein Tickit kostet" + einzelpreis + " $\n"
        );
         
        }
        
    public void frageAnzahlTicketsAb(){ 
       System.out.println("Wie viele Ticket/s?");
       gewuenschteAnzahl = tastaturEingabe.nextInt();
       System.out.print("Aha, Sie wollen also" + gewuenschteAnzahl + "Tickets!");
       
       
    }
    
   
    public int gesamtpreis(){ 
        
        gesammtpreis = einzelpreis * gewuenschteAnzahl;
        
    }
    
    public int nenneGesammtPreis(){
       
    }
        
    public void verabschiede() {
        System.out.println("Danke für ihren Besuch auf Wiedersehn");
    }
    
        
        
        
       
         
         
         
}      
