public class Utils {
    public static void test(Object erwartet, Object ergebnis) {
        if (erwartet.equals(ergebnis)) {
            System.out.print(".");
        } else {
            System.out.println("\nFEHLER! " + 
                erwartet + " != " + ergebnis );
        }
    }
}
