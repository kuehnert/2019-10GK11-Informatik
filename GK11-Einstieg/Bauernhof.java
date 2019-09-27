public class Bauernhof {
    private String besitzer;
    private Tier tier1;
    private Tier tier2;
    private Tier tier3;

    // Konstruktor
    public Bauernhof() {
        besitzer = "Herr Miedza";
        tier1 = new Tier("cat", "meow", "Lukas", "brown", "steaks", "3");
        tier2 = new Tier("dog", "woof", "Herold", "grey", "bones", "10");
        tier3 = new Tier("pig", "oink", "Nö", "pink", "people", "20");
    }
    
    private void singeStrophe(Tier strophenTier) {
        System.out.print(
            "Old " + besitzer + " had a farm\nE-A E-A O\n" + 
            "And on this farm there was a " +
            strophenTier.gibFarbe() + ",\n" + 
            strophenTier.gibAlter() + "-year-old, " + 
            strophenTier.gibFutter() + "-eating " +
            strophenTier.gibArt() + 
            "\nnamed " + strophenTier.gibName() + "\n"
        );
    } 

    public void singen() {
        singeStrophe(tier1);
        singeStrophe(tier2);
        singeStrophe(tier3);
    }
}
