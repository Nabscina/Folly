package follybot.response.quotemaker;

import java.util.ArrayList;
import java.util.Random;

/**
 * ResponseBank hyödyntää tätä luokkaa elämänviisauksien rakentamiseen. Täällä tarkastellaan
 * viisauksia ja etsitään sieltä Å-merkkiä, joka tarkoittaa, että merkin voi korvata satunnaisella
 * randomWords-listan sanalla. Jos merkkiä ei löydy, palautetaan käsitelty lause sellaisenaan.
 * (paitsi että saatetaan myös lisätä elämänviisauden loppuun käyttäjän nimi.)
 */
public class QuoteMaker {

    private Random random;
    
    public QuoteMaker() {

        random = new Random();
    }

    public String makeAQuote(String quote, ArrayList<String> randomWords, String name) {

        String newQuote = quote;

        if (quote.contains("Å")) {
            newQuote = quote.replaceAll("Å", randomWords.get(0));
        }

        return newQuote + endQuote(name);
    }

    public String endQuote(String name) {

        int zerotoseven = random.nextInt(8);

        if (zerotoseven == 7) {
            return ", " + name + ".";
        } else {
            return ".";
        }
    }
}
