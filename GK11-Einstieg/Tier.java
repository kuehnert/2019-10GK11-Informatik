public class Tier {
    private String art;
    private String geraeusch;
    private String name;
    private String farbe;
    private String futter;
    private String alter;

    public Tier(String neueArt, String neuesGeraeusch, 
    String neuerName, String neueFarbe, String neuesFutter,
    String neuesAlter) { 
        art = neueArt;
        geraeusch = neuesGeraeusch;
        name = neuerName;
        farbe = neueFarbe;
        futter = neuesFutter;
        alter = neuesAlter;
    }

    public String gibArt() {
        return art;
    }

    public String gibFarbe() {
        return farbe;
    }

    public String gibGeraeusch() {
        return geraeusch;
    }

    public String gibName() {
        return name;
    }

    public String gibAlter() {
        return alter;
    }

    public String gibFutter() {
        return futter;
    }

    public void begruesse() {
        System.out.println("Hallo, ich bin " + name + ", das "+ 
            farbe + " " + art + ". Ich mache " + 
            geraeusch + " und mein Lieblingsfutter ist " + futter + ".");
    }
}
