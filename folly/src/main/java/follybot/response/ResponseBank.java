package follybot.response;

import java.util.ArrayList;
import java.util.Collections;
import follybot.response.codelanguage.CodeLanguage;
import follybot.response.quotemaker.QuoteMaker;

/**
 * Vastauspankki, eli (ehkä vähän nimensä vastaisesti?) palauttaa
 * ResponseLogicin tai BotQuestionin valitsemasta listasta jotain sanottavaa.
 * Joka tapauksessa tallettaa listoihin sisällön files-pakkauksen tidostoista,
 * mitä lähinnä tarkoitan vastauspankilla. Shufflaa myös listat ennen
 * palautusta, niin saadaan satunnaisuutta. Tallettaa käyttäjän nimen, koska
 * sitä tarvitaan joissain vastauksissa.
 */
public class ResponseBank {

    private String humanName = "";

    private ArrayList<String> names;
    private ArrayList<String> equals;
    private ArrayList<String> uniques;
    private ArrayList<String> quotes1;
    private ArrayList<String> quotes2;
    private ArrayList<String> words;
    private ArrayList<String> yesornoanswers;
    private ArrayList<String> otheranswers;

    private CodeLanguage cl;
    private QuoteMaker qm;

    /**
     * Alustaa uudet CodeLanguage- ja QuoteMaker-oliot luokan käyttöön,
     * hyödyntää CodeLanguage-luokan codeToNormalList-metodia ja tallentaa
     * ArrayListiin sisällön metodille parametrina annetusta tiedostosta.
     * Palauttaa ResponseBank-olion.
     */
    public ResponseBank() {

        cl = new CodeLanguage();
        qm = new QuoteMaker();

        equals = cl.codeToNormalList("src/main/java/follybot/response/files/equalnameresponse.txt");
        uniques = cl.codeToNormalList("src/main/java/follybot/response/files/uniquenameresponse.txt");
        names = cl.codeToNormalList("src/main/java/follybot/response/files/names.txt");
        quotes1 = cl.codeToNormalList("src/main/java/follybot/response/files/quotes1.txt");
        quotes2 = cl.codeToNormalList("src/main/java/follybot/response/files/quotes2.txt");
        words = cl.codeToNormalList("src/main/java/follybot/response/files/words.txt");
        yesornoanswers = cl.codeToNormalList("src/main/java/follybot/response/files/yesornoanswers.txt");
        otheranswers = cl.codeToNormalList("src/main/java/follybot/response/files/otheranswers.txt");
    }

    /**
     * Sekoittaa kaikki palautettavaan lauseeseen tarvittavat listat (toimii
     * ikään kuin random-elementtinä).
     *
     * @return hyödyntää QuoteMakeria, joka saattaa muokata parametrinä
     * annettujen listojen ensimmäisistä alkioista koostuvaa lausetta, ja joka
     * palauttaa uuden lauseen, jonka tämä välittää eteenpäin.
     */
    public String quote() {

        Collections.shuffle(quotes1);
        Collections.shuffle(quotes2);
        Collections.shuffle(words);
        return qm.makeAQuote(quotes1.get(0) + quotes2.get(0), words, humanName);
    }

    /**
     * Sekoittaa yesornoanswers-listan kyllä tai ei -kysymykseen vastaamista
     * varten.
     *
     * @return hyödyntää QuoteMakeria, joka voi satunnaisesti lisätä sille
     * annettavan lauseen perään käyttäjän nimen, ja jonka se sitten palauttaa
     * tälle.
     */
    public String answerAPolarQuestion() {

        Collections.shuffle(yesornoanswers);
        return qm.makeAQuote(yesornoanswers.get(0), words, humanName);
    }

    /**
     * Sekoittaa otheranswers-listan ja vastaa kysymykseen, joka ei ole kyllä
     * tai ei -ksymys.
     *
     * @return hyödyntää QuoteMakeria, joka voi satunnaisesti lisätä sille
     * annettavan lauseen perään käyttäjän nimen, ja jonka se sitten palauttaa
     * tälle.
     */
    public String answerSomeOtherQuestion() {

        Collections.shuffle(otheranswers);
        return qm.makeAQuote(otheranswers.get(0), words, humanName);
    }

    /**
     * Sekoittaa names-listan satunnaisen nimen palauttamista varten.
     *
     * @return palauttaa listan ensimmäisen alkion.
     */
    public String getAName() {

        Collections.shuffle(names);
        return names.get(0);
    }

    /**
     * Sekoittaa uniques-listan satunnaisen vastauksen palauttamista varten.
     *
     * @return palauttaa listan ensimmäisen alkion ja sitä ennen käyttäjän
     * nimen, koska se on ominaista tälle vastaustyypille.
     */
    public String uniqueNameResponse() {

        Collections.shuffle(uniques);
        return humanName + uniques.get(0);
    }

    /**
     * Sekoittaa equals-listan satunnaisen vastauksen palauttamista varten.
     *
     * @return palauttaa listan ensimmäisen alkion ja käyttäjän nimen.
     */
    public String equalNameResponse() {

        Collections.shuffle(equals);
        return equals.get(0) + humanName + ".";
    }

    /**
     * Asettaa humanName-muuttujaan käyttäjän antaman nimen.
     *
     * @param name käyttäjän nimi.
     */
    public void setHumanName(String name) {

        humanName = name;
    }

    /**
     * Palauttaa käyttäjän nimen merkkijonona.
     *
     * @return käyttäjän nimi.
     */
    public String getHumanName() {

        return humanName;
    }
}
