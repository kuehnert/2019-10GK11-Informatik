public class Weihnachten {
    public void wichtelGeschenk() {
        // 5x etwas machen
        int zaehler2 = 0;
        while (zaehler2 < 5) {
            System.out.println("Etwas");
            zaehler2 += 1;
        }

        // Geschenk
        // Zählschleife
        for (int zaehler = 0; zaehler < 5; zaehler += 1) {
            System.out.println("Etwas");
        }
    }

    public void baum1() {
        System.out.println();
        int sterne = 1;

        while (sterne <= 5) {
            System.out.println("###############");
            sterne += 1;
        }
    }

    public void baum2() {
        System.out.println();
        int zeilen = 10;
        int sterne = 1;

        // Schleife für Zeilen
        while (sterne <= zeilen) {
            sternchen(sterne);
            sterne += 1;
        }
    }

    private void zeichen(int anzahl, String zeichen) {
        while (anzahl > 0) {
            int rand = (int) (Math.random() * zeichen.length());
            String s = zeichen.substring(rand, rand+1);
            System.out.print(s);
            anzahl = anzahl - 1;
        }
    }

    private void sternchen(int anzahl) {
        zeichen(anzahl, "*************^O$&%");
    }

    private void leerzeichen(int anzahl) {
        zeichen(anzahl, " ");
    }

    private void zeile(int sternchen, int laenge) {
        leerzeichen( (laenge - sternchen)/2 );
        sternchen(sternchen);
        System.out.println();
    }

    private void abschnitt(int sterne, int zeilenLaenge) {
        for (int i = 0; i < 5; i += 1) {
            zeile(sterne, zeilenLaenge);
            sterne += 2;
        }
    }

    private void stamm(int breite) {
        for (int i = 0; i < 2; i += 1) {
            leerzeichen( (breite - 4)/2 );
            zeichen(4, "#");
            System.out.println();
        }
    }

    public void baum4() {
        System.out.println();
        int abschnitte = 3;
        int breite = 1;

        for (int i = 0; i < abschnitte; i += 1) {
            abschnitt(breite, 60);
            breite += 4;
        }

        stamm(60);
    }
}
