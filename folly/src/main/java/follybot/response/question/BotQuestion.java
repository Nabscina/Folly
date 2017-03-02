package follybot.response.question;

import follybot.response.ResponseBank;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * Kysymyslogiikkaluokka, jota ResponseLogic saattaa käyttää käyttäjän syötteen
 * analysoimiseen, jos syötteen lopusta löytyy kysymysmerkki.
 */
public class BotQuestion {

    private ArrayList<String> polars;
    private ResponseBank rb;
    private QuestionTracker qt;

    private HashMap<String, String> knownAnswers;

    /**
     * Alustaa oliomuuttujan rb ja ArrayListin, johon lisätään sanoja, joilla
     * alkaviin kysymyksiin voidaan todennäköisesti vastata joko kyllä tai ei.
     * Palauttaa BotQuestion-olion.
     *
     * @param rb oliomuuttujan this.rb ResponseBank-olio
     */
    public BotQuestion(ResponseBank rb) {

        this.rb = rb;
        qt = new QuestionTracker();
        polars = new ArrayList<>();
        Collections.addAll(polars, "is ", "can ", "am i", "are ", "will ", "should ",
                "could ", "would ", "isn't ", "can't ", "aren't ", "won't ", "shouldn't ",
                "couldn't ", "wouldn't ", "does ", "doesn't ", "do ", "don't ", "must ",
                "mustn't ", "may ", "shall ", "have ", "has ", "haven't ", "hasn't ",
                "did ", "didn't ", "had ", "hadn't ", "was ", "wasn't ", "were ", "weren't ");

        knownAnswers = new HashMap<>();
        addAnswers();
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
     * kysymykseen polarQuestionCheck()-metodin avulla. Jos check menee läpi,
     * lisätään kysymys ja Follyn vastaus QuestionTracker-luokan mappiin
     * (yritetään, luokka voi torjua lisäyksen) ja palautetaan sinne tallennettu
     * vastaus.
     *
     * @param question käyttäjän syöte.
     *
     * @return ResponseBankin listasta haettu vastaus kyllä tai ei -kysymykseen,
     * jos polarQuestionCheck palauttaa true, muuten vastaus muuhun kysymykseen.
     */
    public String answerQuestion(String question) {

        if (polarQuestionCheck(question)) {
            String answer = rb.answerAPolarQuestion();
            qt.addAnswer(question, answer);
            return qt.getAnswer(question);
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

    public ArrayList<String> getPolarsList() {

        return polars;
    }

    private void addAnswers() {

        knownAnswers.put("never gonna give you up", "Never gonna let you down.");
        knownAnswers.put("never gonna let you down", "Never gonna run around.");
        knownAnswers.put("never gonna run around", "And desert you.");
        knownAnswers.put("and desert you", "Never gonna make you cry.");
        knownAnswers.put("never gonna make you cry", "Never gonna say goodbye.");
        knownAnswers.put("never gonna say goodbye", "Never gonna tell a lie.");
        knownAnswers.put("never gonna tell a lie", "And hurt you.");
        knownAnswers.put("who you gonna call", "GHOSTBUSTERS!");
        knownAnswers.put("what is love", "Baby don't hurt me.");
        knownAnswers.put("baby don't hurt me", "Don't hurt me.");
        knownAnswers.put("don't hurt me", "No more.");
    }
}
