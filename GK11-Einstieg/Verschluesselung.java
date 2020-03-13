// Desiderata:
// 1. Mit Kleinbuchstaben umgehen => 'a' => 'B'
// 2. Leer- und Sonderzeichen => filtern
// 4. Umlaute: 'ä' => 'AE'
// 5. Ungültige Verschiebungen, z.B. key = 30
// 6. Ausgabe in Blöcken von 5 Zeichen
// 7b. Zahlen => 7 => SIEBEN
// a. (Vigenère)

public class Verschluesselung {
    private char caesarZeichen(char i, int key) {
       int o = i + key;
       
       if (o < 'A') {
           o = o + 26;
        }
       
       if (o > 'Z') {
           o = o - 26;
       } 
       
       return (char) o;
    }
    
    public String caesar(String input, int key) {
        if (key > 25) {
            System.out.println("Alisa sagt: Nein!");
            return "FEHLER!!!!!";
        }
        
        String output = "";

        for (int i = 0; i < input.length(); i = i + 1) {
            char c = input.charAt(i);
            output = output + caesarZeichen(c, key);           
        }

        return output;
    }

    public String decaesar(String input, int key) {
        return caesar(input, -key);
    }
    
    private String clean(String input) {
        String out = "";
        input = input.toUpperCase();
        
        for (int i = 0; i < input.length(); i = i + 1) {
            char c = input.charAt(i);
            
            if (c >= 'A' && c <= 'Z') {
                out += Character.toString(c);
            } else if (c == 'Ä') {
                out += "AE";
            } else if (c == 'Ö') {
                out += "OE";
            } else if (c == 'Ü') {
                out += "UE";
            } 
        }
        
        return out;
    }
    
    // Hausaufgabe
    private String bloecke(String input) {
        // "ABCDEFGHJKL" =>
        return "ABCDE FGHJK L";
    }
    
    public void testCaesar() {
        Utils.test("JCWUCWHICDGPB", caesar("HAUSAUFGABENZ", 2));
        Utils.test("QGOTYINRGKMZGHKR", caesar("KAINSCHLAEGTABEL", 6));
        Utils.test("A", caesar("Z", 1));
        Utils.test("Y", caesar("Z", 25));

        Utils.test("Z", caesar("A", 25));
        Utils.test("Z", decaesar("A", 1));
        Utils.test("A", decaesar("A", -0));
        Utils.test("FOBCEMREXQOXCYVVDOWKXXKMRQOLOXGOBGOSCCYLCSOGSONOBUYWWOXYCMKBGSVNO", 
            caesar("VERSUCHUNGENSOLLTEMANNACHGEBENWERWEISSOBSIEWIEDERKOMMENOSCARWILDE", 10));
        Utils.test("VERSUCHUNGENSOLLTEMANNACHGEBENWERWEISSOBSIEWIEDERKOMMENOSCARWILDE", 
            decaesar("FOBCEMREXQOXCYVVDOWKXXKMRQOLOXGOBGOSCCYLCSOGSONOBUYWWOXYCMKBGSVNO", 10));
        
        Utils.test("DASOESTEINHUND", clean("Das öst ein Hund.?!?!"));
    }
}
