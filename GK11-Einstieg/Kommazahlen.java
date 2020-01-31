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
}
