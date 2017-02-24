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
    private ArrayList<String> yesOrNoAnswers;
    private ArrayList<String> otherAnswers;

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

        equals = cl.codeToNormalList("equalnameresponse.txt");
        uniques = cl.codeToNormalList("uniquenameresponse.txt");
        names = cl.codeToNormalList("names.txt");
        quotes1 = cl.codeToNormalList("quotes1.txt");
        quotes2 = cl.codeToNormalList("quotes2.txt");
        words = cl.codeToNormalList("words.txt");
        yesOrNoAnswers = cl.codeToNormalList("yesornoanswers.txt");
        otherAnswers = cl.codeToNormalList("otheranswers.txt");
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

        Collections.shuffle(yesOrNoAnswers);
        return qm.makeAQuote(yesOrNoAnswers.get(0), words, humanName);
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

        Collections.shuffle(otherAnswers);
        return qm.makeAQuote(otherAnswers.get(0), words, humanName);
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

    public void setHumanName(String name) {

        humanName = name;
    }

    public String getHumanName() {

        return humanName;
    }

    public ArrayList<String> getYesOrNoAnswers() {

        return yesOrNoAnswers;
    }

    public ArrayList<String> getOtherAnswers() {

        return otherAnswers;
    }
}
