package follybot.response.quotemaker;

import java.util.ArrayList;
import java.util.Random;

/**
 * ResponseBank hyödyntää tätä luokkaa elämänviisauksien rakentamiseen. Täällä
 * tarkastellaan viisauksia ja etsitään sieltä Å-merkkiä, joka tarkoittaa, että
 * merkin voi korvata satunnaisella randomWords-listan sanalla. Jos merkkiä ei
 * löydy, palautetaan käsitelty lause sellaisenaan. (paitsi että saatetaan myös
 * lisätä elämänviisauden loppuun käyttäjän nimi.)
 */
public class QuoteMaker {

    private Random random;

    /**
     * Alustaa uuden Random-olion, palauttaa QuoteMaker-olion.
     */
    public QuoteMaker() {

        random = new Random();
    }

    /**
     * Tarkistaa, sisältääkö quote-merkkijono merkkiä Å, jolloin se korvataan
     * satunnaisella sanalla listasta randomWords.
     *
     * @param quote ResponseBank-luokassa muodostettu lause.
     * @param randomWords ResponseBankin lista sanoja, joista jollain voidaan
     * tarvittaessa korvata Å-merkki quote-lauseessa.
     * @param name käyttäjän nimi.
     *
     * @return merkkijono, jossa on jotain muuta Å-merkin tilalla jos Å-merkki
     * löytyi tai alkuperäinen quote, jos Å-merkkiä ei löytynyt + lopetus
     * lauseelle metodilla endQuote.
     */
    public String makeAQuote(String quote, ArrayList<String> randomWords, String name) {

        String newQuote = quote;

        if (quote.contains("Å")) {
            newQuote = quote.replaceAll("Å", randomWords.get(0));
        }

        return newQuote + endQuote(name);
    }

    /**
     * Generoi satunnaisen kokonaisluvun välillä 0-7, ja luvun perusteella
     * päätetään, millainen lopetus palautetaan metodille makeAQuote. Käyttäjän
     * nimen sisältävällä lopetuksella on siis 1/8 chanssi, ajattelin sen olevan
     * sopiva.
     *
     * @param name käyttäjän nimi.
     *
     * @return pistelopetus, jos zerotoseven on muu kuin 7, muuten ", name.".
     */
    public String endQuote(String name) {

        int zerotoseven = random.nextInt(8);

        if (zerotoseven == 7) {
            return ", " + name + ".";
        } else {
            return ".";
        }
    }
}
