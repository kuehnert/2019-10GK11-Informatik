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

    private void test(Object erwartet, Object ergebnis) {
        if (erwartet.equals(ergebnis)) {
            System.out.print(".");
        } else {
            System.out.println("\nFEHLER! " + 
                erwartet + " != " + ergebnis );
        }
    }

    String text = "Drei Afghanen mit dem Kontrabass\n"+
        "saßen in der Örtlichkeit und erzählten sich was.\n"+
        "Da kam die Polizei, Ei was ist denn das?\n"+
        "Drei Chinesen mit dem Kontrabass.";

    public boolean enthaelt(String s, char c) {
        for (int i = 0; i < s.length(); i = i + 1) {
            if (s.charAt(i) == c) {
                return true;
            }
        }

        return false;
    }

    public boolean istVokal(char buchstabe) {
        return enthaelt("aeiouäöüAEIOUÄÖÜ", buchstabe);
    }

    public boolean istGrosserVokal(char buchstabe) {
        return enthaelt("AEIOUÄÖÜ", buchstabe);
    }

    public boolean istKleinerVokal(char buchstabe) {
        return enthaelt("aeiouäöü", buchstabe);
    }

    public int zaehleVokale(String s) {
        int anzahl = 0;

        for (int i = 0; i < s.length(); i = i + 1) {
            char c = s.charAt(i);

            if (istVokal(c)) {
                anzahl = anzahl + 1;
            }
        }

        return anzahl;
    }

    public void testZaehleVokale() {
        test(0, zaehleVokale(""));
        test(0, zaehleVokale("df"));
        test(1, zaehleVokale("abc"));
        test(2, zaehleVokale("Wörter"));
        test(2, zaehleVokale("Apfel"));
        test(3, zaehleVokale("abcdei"));
        test(18, zaehleVokale("AAAAAAAAAAAAAAAAAAAARGH"));
    }

    public void testIstVokal() {
        test(true, istVokal('a'));
        test(true, istVokal('e'));
        test(true, istVokal('E'));
        test(true, istVokal('Ä'));
        test(true, istVokal('ü'));
        test(true, istVokal('O'));
        test(false, istVokal('c'));
        test(false, istVokal('b'));
        test(false, istVokal('?'));
        test(false, istVokal('#'));
        test(false, istVokal('"'));
    }

    public String chinesen1(String input) {
        // 1. Definiere output
        String output = "";

        // 2. Bastel die Rückgabe Zeichen für Zeichen zusammen
        for (int i = 0; i < input.length(); i = i + 1) {
            char c = input.charAt(i);

            if (istKleinerVokal(c)) {
                output = output + 'ä';
            } else if (istGrosserVokal(c)) {
                output = output + 'Ä';
            } else {
                output = output + c;
            }
        }

        // 3. Gib das Ergebnis als Text zurück
        return output;
    }

    public void testChinesen1() {
        System.out.println( chinesen1(text) );
    }

    public double gibVokalProzente(String input) {
        int anzahlVokale = zaehleVokale(input);
        int anzahlZeichen = input.length();

        return (double) anzahlVokale / anzahlZeichen;
    }

    public String inProzent(double d) {
        return String.format("%.2f%%", d * 100.0);
    }

    public void testGibVokalProzente() {
        double anteil = gibVokalProzente("Hallo Liebe Welt");
        System.out.println("anteil: " + anteil);
        System.out.println( inProzent(anteil));
    }

    // Formatieren Sie diese Strings mit String.format
    /*
     * String.format("", ....)
     *  "5" <- 5
     *  "  4" <- 4
     *  "0003" <- 3
     *  "0,1" <- 0.1
     *  "Hans trinkt 2,55l Bier" <- "Hans", 2.56666
     */
}
