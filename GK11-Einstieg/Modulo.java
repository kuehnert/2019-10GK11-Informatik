public class Modulo {
    public void moduloDemo() {
        int zaehler = 1;

        while (zaehler <= 100) {
            System.out.print((zaehler % 7) + " ");
            zaehler = zaehler + 1;
        }
    }

    public void stellen(int zahl) {
        // zahl = 2183768
        System.out.println("Letzte beiden: " + (zahl % 100)); // => 68
        // => 6
    }

    public int letzteStelle(int zahl) {
        return zahl % 10;
    }

    public int vorletzteStelle(int zahl) {
        return zahl / 10 % 10;
    }

    public void meinProgramm() {
        int z = 1236734;
        System.out.println( letzteStelle(z) );
    }
}
