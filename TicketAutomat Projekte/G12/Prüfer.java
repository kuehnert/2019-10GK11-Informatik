import java.util.Scanner;

public class CardMachine {

    private Scanner input;

    private int cardCountAdult;
    private int cardCountChild;
    private int totalPrice;
    private int payment;
    private int change;
    private int given;

    private Card adult;
    private Card child;

    public CardMachine() {
        input = new Scanner(System.in);

        adult = new Card(20);
        child = new Card(12);
    }

    private void sayHello() {
        System.out.println("\nHallo, möchten Sie Karten kaufen?");
    }

    private void sayGoodbye() {
        System.out.println("\nVielen Dank für Ihren Einkauf. \nEinen angenehmen Aufenthalt noch.");
    }

    private void countCards() {
        System.out.println("Wie viele Erwachsenen-Karten möchten Sie kaufen?");
        cardCountAdult = input.nextInt();
        System.out.println("Wie viele Kinder-Karten möchten Sie kaufen?");
        cardCountChild = input.nextInt();
        System.out.println("Sie haben " + cardCountAdult +  " Erwachsenen-Karten und " + cardCountChild + " Kinder-Karten gekauft.");
    }

    private void pay() {
        given = input.nextInt();
        if(given == 1 || given == 2 || given == 5 || given == 10 || given == 20 || given == 50 || given == 100) {
            payment += given;
        }
        else if(given ==200 || given == 500) {
            System.out.println("Kann " + given + "€-Schein wegen Fälschungsgefahr nicht annehmen.");
        }
        else if(given > 5) {
            System.out.println("Es existiert kein " + given + "€-Schein!");
        }
        else if(given > 0) {
            System.out.println("Es existiert keine " + given + "€-Münze!");
        }
    }

    private void solve() {
        totalPrice = cardCountAdult * adult.price() + cardCountChild * child.price();

        System.out.println("Der Gesamtpreis beträgt " + totalPrice + "€. Bitte Geld einwerfen.");

        pay();

        change = payment - totalPrice;

        while(change < 0) {
            System.out.println("Es fehlen noch " + (change * -1) + "€.");
            pay();
            change = payment - totalPrice;
        }

        if(change > 0) {
            System.out.println("Sie bekommen " + change + "€ zurück.");
        }
        else{
            System.out.println("Sie haben genau passend bezahlt.");
        }
    }

    public void main() {
        sayHello();
        countCards();
        solve();
        sayGoodbye();
    }
}

class Card {

    private Integer price;

    public Card(Integer price) {
        this.price = price;
    }

    public Integer price() {
        return price;
    }

}
