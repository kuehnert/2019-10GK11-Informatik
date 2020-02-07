public class RoemischeZahlen {
    public String toRoman(int zahl) {
        String rueckgabe = "";

        while (zahl >= 1000) {
            rueckgabe = rueckgabe + "M";
            zahl = zahl - 1000;
        }

        if (zahl >= 900)  {
            rueckgabe = rueckgabe + "CM";
            zahl = zahl - 900;
        }

        if (zahl >= 500)  {
            rueckgabe = rueckgabe + "D";
            zahl = zahl - 500;
        }

        if (zahl >= 400)  {
            rueckgabe = rueckgabe + "CD";
            zahl = zahl - 400;
        }

        while (zahl >= 100) {
            rueckgabe = rueckgabe + "C";
            zahl = zahl - 100;
        }

        if (zahl >= 90)  {
            rueckgabe = rueckgabe + "XC";
            zahl = zahl - 90;
        }

        if (zahl >= 50)  {
            rueckgabe = rueckgabe + "L";
            zahl = zahl - 50;
        }

        if (zahl >= 40)  {
            rueckgabe = rueckgabe + "XL";
            zahl = zahl - 40;
        }

        while (zahl >= 10) {
            rueckgabe = rueckgabe + "X";
            zahl = zahl - 10;
        }

        if (zahl >= 9)  {
            rueckgabe = rueckgabe + "IX";
            zahl = zahl - 9;
        }

        if (zahl >= 5)  {
            rueckgabe = rueckgabe + "V";
            zahl = zahl - 5;
        }

        if (zahl >= 4)  {
            rueckgabe = rueckgabe + "IV";
            zahl = zahl - 4;
        }

        while (zahl >= 1) {
            rueckgabe = rueckgabe + "I";
            zahl = zahl - 1;
        }

        return rueckgabe;
    }

    public String asBinaryDoof(int zahl) {
        String rueckgabe = "";

        int stelle = 256;
        while (stelle > 0) {
            if (zahl >= stelle) {
                zahl = zahl - stelle;
                rueckgabe = rueckgabe + "1";
            } else {
                rueckgabe = rueckgabe + "0";            
            }

            stelle = stelle / 2;
        }
        return rueckgabe;
    }

    public String asBinary(int zahl) {
        // Erzeuge einen neuen, leeren String
        String rueckgabe = "";

        // Solange wie zahl > 0, zerteile sie
        while (zahl > 0) {
            // Wenn zahl ungerade, wird ausgabe zu ...1
            // sonst ...0
            if (zahl % 2 == 0)  {
                rueckgabe = "0" + rueckgabe;
            } else {
                rueckgabe = "1" + rueckgabe;
            }
            
            zahl = zahl / 2;
        }

        // Gebe den String als Ergebnis zurück
        return rueckgabe;
    }

    private void test(String erwartet, String ergebnis) {
        if (erwartet.equals(ergebnis)) {
            System.out.print(".");
        } else {
            System.out.println("\nFEHLER! " + 
                erwartet + " != " + ergebnis );
        }
    }

    public void testRoman() {
        test("MCCCXXIV", toRoman(1324));
        test("MMDCCLXXII", toRoman(2772));
        test("MMMDCLXXXIX", toRoman(3689));
        test("CMXCIX", toRoman(999));
    }

    public void testAsBinary() {
        test("11", asBinary(3));
        test("1111", asBinary(15));
        test("111", asBinary(7));
        test("100000", asBinary(32));
    }

    public void testAll() {
        testRoman();
        testAsBinary();
        String name = "Alisa die Kinderflüsterin";
    }
}
