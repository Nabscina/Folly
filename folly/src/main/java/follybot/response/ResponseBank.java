package follybot.response;

import java.util.ArrayList;
import java.util.Collections;
import follybot.response.codelanguage.CodeLanguage;
import follybot.response.quotemaker.QuoteMaker;

/**
 * Vastauspankki, eli (ehkä vähän nimensä vastaisesti?) palauttaa
 * ResponseLogicin valitsemasta listasta jotain sanottavaa. Joka tapauksessa
 * tallettaa listoihin sisällön files-pakkauksen tidostoista, mitä lähinnä
 * tarkoitan vastauspankilla. Shufflaa myös listat ennen palautusta, niin
 * saadaan satunnaisuutta. Tallettaa käyttäjän nimen, koska sitä tarvitsee
 * joissain vastauksissa.
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
     * random-elementtinä).
     *
     * @return hyödyntää QuoteMakeria, joka saattaa muokata parametrinä
     * annettujen listojen ensimmäisestä alkiosta koostuvaa lausetta, ja joka
     * palauttaa uuden lauseen, jonka tämä välittää eteenpäin.
     */
    public String quote() {

        Collections.shuffle(quotes1);
        Collections.shuffle(quotes2);
        Collections.shuffle(words);
        return qm.makeAQuote(quotes1.get(0) + quotes2.get(0), words, humanName);
    }

    public String answerAPolarQuestion() {

        Collections.shuffle(yesornoanswers);
        return qm.makeAQuote(yesornoanswers.get(0), words, humanName);
    }

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
