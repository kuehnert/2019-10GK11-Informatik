public class Klausur1 {
    public void kommentierePunkte(int punkte, String name) {
        if (punkte >= 13) {
            System.out.println("Spitze, " + name + "!");
        } else if (punkte >= 10) {
            System.out.println("Gu t, " + name + "!");
        } else if (punkte >= 7) {
            System.out.println("OK, " + name + "!");
        } else if (punkte >= 4) {
            System.out.println("Nicht so gut, " + name + "!");
        } else if (punkte >= 1) {
            System.out.println("Gar nicht gut, " + name + "!");
        } else {
            System.out.println("Wo??????" + name + "!");
        }
    }
}

class Geldzaehler {
    
}