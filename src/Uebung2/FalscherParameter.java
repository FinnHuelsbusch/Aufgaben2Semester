package Uebung2;

public class FalscherParameter extends Exception {

    public FalscherParameter(String farbe) {
        super("Die Parameterkombination aus Ledersitz und " + farbe + " ist ungültig.");
    }
}
