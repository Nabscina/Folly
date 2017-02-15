package follybot.response;

import follybot.response.math.BotMath;
import java.util.Random;

/**
 * Tämä luokka tarkastelee sitä, mitä käyttäjä sanoo, ja pyrkii palauttamaan
 * siihen sopivan vastauksen, esimerkiksi jotain muuta loogista luokkaa
 * hyödyntämällä (BotMath). Voidaan mm. siistiä käyttäjän syötettä tai etsiä
 * kysymysmerkkiä. Hoitaa tarkastelun myös esittelyn osalta. Ehkä ei pitäisi.
 */
public class ResponseLogic {

    private ResponseBank rb;
    private BotMath math;
    private Random random;

    public ResponseLogic() {

        this.rb = new ResponseBank();
        this.math = new BotMath();
        this.random = new Random();
    }

    /**
     * Tutkii käyttäjän syötettä if-ehdoin ja tarkistaa muita luokkiakin
     * hyödyntämällä, mikä vastaus kannattaa palauttaa. Tällä hetkellä jos
     * huomataan, että sanottiin heippa, hyvästellään, jos ei huomattu,
     * tarkistetaan, sisältääkö syöte matikkaa ja palautetaan vastaus
     * tarvittaessa. Muussa tapauksessa palautetaan elämänohje eli rb.quote().
     *
     * @return if-ehdoilla sopivimmaksi todettu vastaus.
     */
    public String respond(String question) {

        if (simplified(question).equals("bye")) {
            return "Bye.";
        } else if (math.mathCheck(question)) {
            return math.doMath(question).toString();
        }

        return rb.quote();
    }

    /**
     * @return ResponseBank-luokasta uusi nimi merkkijonona.
     */
    public String newName() {

        return rb.getAName();
    }

    /**
     * Tarkistaa, pitääkö käyttäjän nimi vaihtaa, eli toisin sanoen onko se
     * simplified-metodin jälkeen yhtä kuin "folly".
     *
     * @param name nimi, jonka käyttäjä yrittää itselleen asettaa.
     *
     * @return true, jos nimi on folly ja false, jos ei.
     */
    public boolean needsChanging(String name) {

        return simplified(name).equals("folly");
    }

    /**
     * Hoitaa esittäytymisen, eli tarkastelee käyttäjän antamaa nimeä
     * needsChanging()-metodilla ja antaa newName()-metodilla uuden nimen
     * tarvittaessa.
     *
     * @param name käyttäjän antama nimi.
     *
     * @return annetaan uniikille nimelle sopiva vastaus, jos needsChanging()
     * totesi nimen Follysta eroavaksi, muuten vastataan siihen, että nimeksi
     * valittiin Folly ja käytetään vastausmetodille annettavana parametrinä
     * uutta nimeä newName.
     */
    public String introduction(String name) {

        if (needsChanging(name)) {
            String newName = newName();
            return respondToEqualName(newName);
        } else {
            return respondToUniqueName(name);
        }
    }

    /**
     * Kutsuu ResponseBankin metodia, joka saa parametrinä nimen ja asettaa sen
     * käyttäjän nimeksi.
     *
     * @param name käyttäjän nimi, joka on tässä tapauksessa muutettu nimi,
     * koska kutsutaan juuri tätä metodia.
     *
     * @return satunnainen vastaus Folly-nimen valintaan.
     */
    public String respondToEqualName(String name) {

        rb.setHumanName(name);
        return rb.equalNameResponse();
    }

    /**
     * Kutsuu ResponseBankin metodia, joka saa parametrinä nimen ja asettaa sen
     * käyttäjän nimeksi.
     *
     * @param name käyttäjän nimi, joka on tässä tapauksessa aina käyttäjän
     * valitsema, muuttamaton nimi.
     *
     * @return satunnainen vastaus uniikin nimen valintaan.
     */
    public String respondToUniqueName(String name) {

        rb.setHumanName(name);
        return rb.uniqueNameResponse();
    }

    /**
     * Poistaa merkkijonosta kaikki merkit, jotka eivät ole kirjaimia a-z tai A-Z (korvaa nämä tyhjällä
     * replaceAll()-metodia hyödyntäen) ja vaihtaa myös kaikki kirjaimet pieniksi metodilla toLowerCase().
     * 
     * @param question Käyttäjän "kysymys", eli syöte, joka "simplifoidaan".
     * 
     * @return simplifoitu versio käyttäjän syötteestä.
     */
    public String simplified(String question) {

        return question.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }
}
