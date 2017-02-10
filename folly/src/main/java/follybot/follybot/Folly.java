package follybot.follybot;

import follybot.response.ResponseLogic;

/**
 * Tämä luokka palauttaa merkkijonomuotoisen vastauksen käyttäjän kysymykseen
 * tai muuhun lauseeseen. Oliomuuttujana boolean introductionIsDone, eli
 * tiedetäänkö nimi ja voidaanko vastata "tavallisesti".
 */
public class Folly {

    private ResponseLogic rl;

    private boolean introductionIsDone;

    public Folly() {

        this.rl = new ResponseLogic();

        this.introductionIsDone = false;
    }

    /**
     * Metodi antaa käyttäjän syötteen ResponseLogic-luokalle, joka sitten
     * hyödyntää muita tsydeemejä sopivan vastauksen löytämiseksi, ja tämä
     * sitten palauttaa vastauksen merkkijonona.
     *
     * @param q käyttäjän antama syöte (q niin kuin question)
     *
     * @return joko reagointi nimivalintaan tai vastaus muuhun syötteeseen
     */
    public String respond(String q) {

        if (!introductionIsDone) {
            introductionIsDone = true;
            return rl.introduction(q);
        }

        return rl.respond(q);
    }

    /**
     * Metodi antaa (vaikka toiselle luokalle) tiedon siitä, onko esittäytyminen tehty.
     *
     * @return introductionIsDone-booleanin tila
     */
    public boolean introductionIsDone() {

        return introductionIsDone;
    }
}
