import java.util.Scanner;

public class RateSpiel {
    public void rateSpiel() {
        Scanner tastaturEingabe = new Scanner(System.in);
        int richtigeZahl = (int) (Math.random() * 100) + 1;
        int benutzerZahl = -1;

        System.out.println("Willkommen beim Ratespiel");
        System.out.println("Rate eine Zahl zwischen 1 und 100");

        while (benutzerZahl != richtigeZahl) {
            System.out.print("Dein Tipp: ");
            benutzerZahl = tastaturEingabe.nextInt();

            if (richtigeZahl > benutzerZahl) {
                System.out.println("Meine Zahl ist größer");
            } else {
                System.out.println("Meine Zahl ist kleiner");
            }
        }

        System.out.println("Hurra, Du hast die Zahl geraten! :-)");
    }
}
