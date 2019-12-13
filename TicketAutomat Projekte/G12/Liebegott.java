import java.util.Scanner;

public class CardMachine {

    private Scanner input;


    private int cardCountAdult;
    private int cardCountChild;
    private int totalPrice;
    private int payment;
    private int change;
    private int wert;
    private int h = 1;
    private Card adult = new Card(20, 2000);
    private Card child = new Card(12, 17);

    public CardMachine() {
        input = new Scanner(System.in);
        sayHello();
    }

    private void sayHello() {
        System.out.println("\nHallo, möchten Sie Karten kaufen?"+
            "\n Ab Einkaufswert über 60€ gibt es ein Gewinnspiel");
        countCards();
    }

    private void sayGoodbye() {
        System.out.println("\nVielen Dank für Ihren Einkauf. \nEinen angenehmen Aufenthalt noch.");
        reStart();
    }

    private void countCards() {
        System.out.println("Wie viele Erwachsenen-Karten im Preis von 20€ möchten Sie kaufen?");
        cardCountAdult = input.nextInt();
        System.out.println("Wie viele Kinder-Karten im Preis von 12€ möchten  Sie kaufen?");
        cardCountChild = input.nextInt();

        if(0 == cardCountAdult + cardCountChild ){
            System.out.println("Danke für ihr interrese."+
                " \n Bis zum nächsten Mal");
            reStart();

        }
        else {
            System.out.println("Sie haben " + cardCountAdult +  " Erwachsenen-Karten und " + cardCountChild + " Kinder-Karten gekauft.");
            solve();
        }
    }

    private void solve() {
        totalPrice = cardCountAdult * adult.price() + cardCountChild * child.price();

        System.out.println("Der Gesamtpreis beträgt " + totalPrice + "€. Bitte Geld einwerfen.");

        System.out.println("");
        change = payment - totalPrice;
        for(int i = 0; i < 1;) {
            if(change < 0 ) {
                System.out.println("Es fehlen noch " + (change * -1) + "€.");
                wert = input.nextInt();
                if (wert == 1 ||wert == 2 ||wert == 5 ||wert == 10 ||wert == 20 ||wert == 50 ||wert ==100 ) {
                    payment += wert ;
                    change = payment - totalPrice;
                }
                else
                { System.out.println("Ungültige eingabe an Geld");

                }
            }

            else if(change >= 0) {
                while(change != 0){
                    if(change >= 100){
                        System.out.println("100€");
                        change = change - 100 ;
                    }
                    else if(change >=50){
                        System.out.println("50€");
                        change = change -  50 ;
                    }
                    else if(change >= 20){
                        System.out.println("20€");
                        change = change - 20 ;
                    }
                    else if(change >=10){
                        System.out.println("10€");
                        change = change - 10 ;
                    }
                    else if(change >=5){
                        System.out.println("5€");
                        change = change - 5 ;
                    }
                    else if(change >=2){
                        System.out.println("2€");
                        change = change - 2 ;
                    }
                    else if(change >=1){
                        System.out.println("1€");
                        change = change - 1 ;

                    }

                } System.out.println("Karten werden im nachhinein gedruckt");
                if(totalPrice >= 60 ){

                    Lottery();
                }
                else{
                druckKarten();}
            }
        }
    }

    public void Lottery (){

        System.out.println("free Spin");
        try { Thread.sleep(1000); } catch (Exception e) {}

        int x = (int) (Math.random() * 4);

        if(x == 1){
            System.out.println("Sie haben einen Kuh-Gel-Schreiber gewonnen");
        }
        else if(x == 2){
            System.out.println("Sie haben eine Angel gewonnen");
        }
        else if(x == 3){
            System.out.println("Hurra, Sie haben den Hauptgewinn!");
        }
        else {
            System.out.println("Sie haben leider verloren! :-(");
        }
        druckKarten();
    }

    private void druckKarten(){
        while(cardCountAdult != 0 ){
            try { Thread.sleep(1000); } catch (Exception e) {}
            System.out.println("######################");
            System.out.println("#  Erwachsenen Karte #");
            System.out.println("######################");
            cardCountAdult = cardCountAdult - 1;
        }
        while(cardCountChild != 0 ){
            try { Thread.sleep(1000); } catch (Exception e) {}
            System.out.println("######################");
            System.out.println("#  Kinderkarte Karte #");
            System.out.println("######################");
            cardCountChild = cardCountChild - 1 ;
        }
        if(cardCountChild + cardCountAdult == 0 ){
            sayGoodbye();

        }
    }

    private void reStart(){

        cardCountAdult  =0;
        cardCountChild  =0;
        totalPrice      =0;
        payment         =0;
        change          =0;
        wert            =0;
        sayHello();
    }
}

class Card {

  private Integer price;
  private Integer maximumAllowedAge;

  public Card(Integer price, Integer maximumAllowedAge) {
     this.price = price;
     this.maximumAllowedAge = maximumAllowedAge;
  }

  public Integer price() {
      return price;
  }

  public Integer maximumAllowedAge() {
      return maximumAllowedAge;
  }

}
