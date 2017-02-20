package follybot.response.question;

import java.util.HashMap;

/**
 * Luokka pitää kirjaa käyttäjän kysymistä kyllä tai ei -kysymyksistä ja Follyn
 * vastauksista niihin. Tarkoitus on, että ensimmäinen vastaus tallennetaan
 * kysymys-avaimen arvoksi, ja kun sama kysymys kysytään uudestaan, palautetaan
 * aina se yksi alkuperäinen vastaus.
 */
public class QuestionTracker {

    private HashMap<String, String> answers;

    /**
     * Alustaa HashMap-olion talletettaville kysymyksille ja vastauksille,
     * palauttaa QuestionTracker-olion.
     */
    public QuestionTracker() {

        answers = new HashMap<>();
    }

    /**
     * Lisää mappiin avaimeksi käyttäjän kysymyksen, jos se ei jo ole siellä.
     * Arvoksi Follyn ResponseBank-lähtöinen vastaus. Muunnetaan kysymyksen
     * merkit pieniksi, jotta myöhemmin sama vastaus voidaan antaa, vaikka
     * avaimen ja kysymyksen merkkien koolla olisikin eroa.
     *
     * @param question käyttäjän syöte, tässä tapauksessa kysymys.
     * @param answer Follyn vastaus, jonka BotQuestion välittää
     * ResponseBankilta.
     */
    public void addAnswer(String question, String answer) {

        if (!answers.containsKey(question.toLowerCase())) {
            answers.put(question.toLowerCase(), answer);
        }
    }

    /**
     * Tarkistaa, että answers sisältää avaimena käyttäjän pienikirjaimisen
     * kysymyksen (vaikka BotQuestion huolehtiikin aina sen lisäyksestä) ja
     * etsii sen arvon.
     *
     * @param question käyttäjän syöte, nyt kysymys.
     *
     * @return pienimerkkisen question-kysymyksen arvo answers-mapista jos (kun)
     * se sieltä löytyy, muuten null (mutta ei se palauta null, dw).
     */
    public String getAnswer(String question) {

        if (answers.containsKey(question.toLowerCase())) {
            return answers.get(question.toLowerCase());
        }

        return null;
    }

}
