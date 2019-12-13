public class Kommazahlen {
    public void m1() {
        float kommazahl;
        // 1,23456789 / 10;
        kommazahl = 0.0000000000123456789123456789f;
        System.out.println(kommazahl);        

        kommazahl = 0.123456789123456789f;
        System.out.println(kommazahl);        

        kommazahl = 1.23456789123456789f;
        System.out.println(kommazahl);        

        kommazahl = 12.3456789123456789f;
        System.out.println(kommazahl);        

        kommazahl = 123456789.123456789f;
        System.out.println(kommazahl);        
        // 123456792.xxxE8
    }

    public void m2() {
        System.out.println(10 /3f);
        System.out.println( 1f/3);
        System.out.println( 4f/3f);
    }

    public void m3() {
        double zahl; // 15 Stellen Genauigkeit

        zahl = 1.123456789102345678912345789;
    }

    public void m4() {
        double zahl; // 15 Stellen Genauigkeit

        zahl = 10   / 3.0;
        zahl = 10.0 / 3;
        zahl = 10   / 3d;
        System.out.println(zahl);
    }

    public void bevoelkerungsEntwicklung() {
        double bevoelkerung = 7600000000.0;
        double zuwachs      = 80000000;
        double wachstum     = 1.0 + zuwachs / bevoelkerung;
        int    jahr         = 2019;

        while (jahr <= 2050) {
            System.out.printf(jahr + ": " + bevoelkerung);
            bevoelkerung = bevoelkerung * wachstum;
            jahr = jahr + 1;
        }
    }

    public void ausgabe() {
        double z = 1.051453455050604E10;
        System.out.printf( "--!%.0f!--", z ); 
    }

    public void pony() {
        int kaeuferinnen = 3;
        double pony = 11000.0 / kaeuferinnen;
        System.out.printf("Jeder der %d Käuferinnen zahlt %.2f €\n", kaeuferinnen, pony);
    }
}