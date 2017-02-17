package follybot.response.question;

import follybot.response.ResponseBank;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Kysymyslogiikkaluokka, jota ResponseLogic saattaa käyttää käyttäjän syötteen
 * analysoimiseen, jos syötteen lopusta löytyy kysymysmerkki.
 */
public class BotQuestion {

    private ArrayList<String> polars;
    private ResponseBank rb;

    /**
     * Alustaa oliomuuttujan rb ja ArrayListin, johon lisätään sanoja, joilla
     * alkaviin kysymyksiin voidaan todennäköisesti vastata joko kyllä tai ei.
     * Palauttaa BotQuestion-olion.
     *
     * @param rb oliomuuttujan this.rb ResponseBank-olio
     */
    public BotQuestion(ResponseBank rb) {

        this.rb = rb;
        polars = new ArrayList<>();
        Collections.addAll(polars, "is ", "can ", "am i", "are ", "will ", "should ",
                "could ", "would ", "isn't ", "can't ", "aren't ", "won't ", "shouldn't ",
                "couldn't ", "wouldn't ", "does ", "doesn't ", "do ", "don't ", "must ",
                "mustn't ", "may ", "shall ");
    }

    /**
     * Tarkistaa, loppuuko käyttäjän kysymys kysymysmerkkiin. Käyttää vielä
     * metodia trim() mahdollisten kysymysmerkin jälkeisten välilyöntien
     * poistoon.
     *
     * @param question käyttäjän syöte.
     *
     * @return true, jos "trimmattu" syöte loppuu kysymysmerkkiin, muuten false.
     */
    public boolean questionCheck(String question) {

        return question.trim().endsWith("?");
    }

    /**
     * Metodi päättää, vastataanko kyllä tai ei -kysymykseen vai muuhun
     * kysymykseen polarQuestionCheck()-metodin avulla.
     *
     * @param question käyttäjän syöte.
     *
     * @return ResponseBankin listasta haettu vastaus kyllä tai ei -kysymykseen,
     * jos polarQuestionCheck palauttaa true, muuten vastaus muuhun kysymykseen.
     */
    public String answerQuestion(String question) {

        if (polarQuestionCheck(question)) {
            return rb.answerAPolarQuestion();
        } else {
            return rb.answerSomeOtherQuestion();
        }
    }

    /**
     * Käy polars-listan merkkijonot läpi ja tarkistaa, alkaako käyttäjän syöte
     * jollain niistä. Muuttaa tarkistusta ennen käyttäjän syötteen isot merkit
     * pieniksi.
     *
     * @param question käyttäjän syöte.
     *
     * @return true, jos lista sisältää merkkijonon, jolla käyttäjän syöte
     * alkaa, muuten false.
     */
    public boolean polarQuestionCheck(String question) {

        for (String s : polars) {
            if (question.toLowerCase().startsWith(s)) {
                return true;
            }
        }
        return false;
    }
}
