public class RoemischeZahlen {
    public String toRoman(int zahl) {
        String rueckgabe = "";

        while (zahl >= 1000) {
            rueckgabe = rueckgabe + "M";
            zahl = zahl - 1000;
        }

        if (zahl >= 500)  {
            rueckgabe = rueckgabe + "D";
            zahl = zahl - 500;
        }

        while (zahl >= 100) {
            rueckgabe = rueckgabe + "C";
            zahl = zahl - 100;
        }

        if (zahl >= 50)  {
            rueckgabe = rueckgabe + "L";
            zahl = zahl - 50;
        }

        while (zahl >= 10) {
            rueckgabe = rueckgabe + "X";
            zahl = zahl - 10;
        }

        if (zahl >= 5)  {
            rueckgabe = rueckgabe + "V";
            zahl = zahl - 5;
        }

        while (zahl >= 1) {
            rueckgabe = rueckgabe + "I";
            zahl = zahl - 1;
        }

        return rueckgabe;
    }

    public void testeRoman() {
        int z;
        z = 1324;
        System.out.print(z + " MCCCXXIIII: ");
        toRoman(z);

        z = 2772;
        System.out.print("\n\n" + z + " MMDCCLXXII: ");
        toRoman(z);

        z = 3689;
        System.out.print("\n\n" + z + " MMMDCLXXXVIIII: ");
        toRoman(z);

        z = 999;
        System.out.print("\n\n" + z + " DCCCCLXXXXVIIII: ");
        toRoman(z);
    }

    public String asBinary(int zahl) {
        String rueckgabe = "";

        if (zahl >= 8) {
            zahl = zahl - 8;
            rueckgabe = rueckgabe + "1";
        } else {
            rueckgabe = rueckgabe + "0";            
        }

        if (zahl >= 4) {
            zahl = zahl - 4;
            rueckgabe = rueckgabe + "1";
        } else {
            rueckgabe = rueckgabe + "0";            
        }

        if (zahl >= 2) {
            zahl = zahl - 2;
            rueckgabe = rueckgabe + "1";
        } else {
            rueckgabe = rueckgabe + "0";            
        }

        if (zahl >= 1) {
            zahl = zahl - 1;
            rueckgabe = rueckgabe + "1";
        } else {
            rueckgabe = rueckgabe + "0";            
        }

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

    public void testAsBinary() {
        test("0011", asBinary(3));
        test("1111", asBinary(15));
        test("0111", asBinary(7));
        test("100000", asBinary(32));
    }
}
