package follybot.follybot;

import follybot.gui.GUI;

/**
 * Main-luokka, eli täältä aloitetaan luokkien käynnistysketju käynnistämällä
 * GUI.
 */
public class Main {

    /**
     * main-metodi alustaa uuden GUI:n ja kutsuu metodia run(), ja sitä mukaan
     * muutkin luokat tulevat mukaan.
     */
    public static void main(String[] args) {

        new GUI().run();
    }
}
