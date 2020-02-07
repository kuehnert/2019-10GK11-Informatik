public class Zeichenketten {
    private String geheDurchString(String input) {
        String output = "";

        // Zählschleife, fang bei 0 an
        for (int i = 0; i < input.length(); i = i + 1) {
            char zeichen = input.charAt(i);
            output = output + zeichen;
        }

        return output;
    }

    private String jedesZweite(String input) {
        String output = "";

        // Zählschleife, fang bei 0 an
        for (int i = 0; i < input.length(); i = i + 2) {
            char zeichen = input.charAt(i);
            output = output + zeichen;
        }

        return output;
    }

    private String reverse1(String input) {
        String output = "";

        // Zählschleife, fang bei 0 an
        for (int i = 0; i < input.length(); i = i + 1) {
            char zeichen = input.charAt(i);
            output = zeichen + output;
        }

        return output;
    }

    private String reverse2(String input) {
        String output = "";

        // Zählschleife, fang bei 0 an
        for (int i = input.length()-1; i >= 0; i = i - 1) {
            char zeichen = input.charAt(i);
            output = output + zeichen;
        }

        return output;
    }

    private String ersetzeA(String input) {
        String output = "";

        // Zählschleife, fang bei 0 an
        for (int i = 0; i < input.length(); i = i + 1) {
            char zeichen = input.charAt(i);

            if (zeichen == 'a') {
                output = output + 'u';
            } else if (zeichen == 'A') {
                output = output + 'U';
            } else {
                output = output + zeichen;
            }
        }

        return output;
    }

    public void testeGeheDurchString() {
        test("", reverse1(""));
        test("ollaH", reverse1("Hallo"));
        test("ZYXWVUTSRQPONMLKJIHGFEDCBA", reverse1("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        test("einnegermitgazellezagtimregennie", reverse1("einnegermitgazellezagtimregennie"));

        test("", reverse2(""));
        test("ollaH", reverse2("Hallo"));
        test("ZYXWVUTSRQPONMLKJIHGFEDCBA", reverse2("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        test("einnegermitgazellezagtimregennie", reverse2("einnegermitgazellezagtimregennie"));
        
        test("Junu", ersetzeA("Jana"));
        test("Ubruhum", ersetzeA("Abraham"));
    }

    private void test(String erwartet, String ergebnis) {
        if (erwartet.equals(ergebnis)) {
            System.out.print(".");
        } else {
            System.out.println("\nFEHLER! " + 
                erwartet + " != " + ergebnis );
        }
    }
}

/*
 * Hausaufgabe: „Drei Chinesen mit dem Kontrabass“
 * 1. Schreiben Sie eine Methode, mit der alle Vokale in einem 
 *    String durch 'o' ersetzt werden
 * 2. Im 2. Schritt soll der Vokal, durch den ersetzt wird, 
 *    frei wählbar sein.
 */
