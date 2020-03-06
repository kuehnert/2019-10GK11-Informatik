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
        
    }
}
