package follybot.response.codelanguage;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Tämä luokka lukee tiedostoja resources-kansiosta ja decryptaa niiden koodikielen, minkä
 * jälkeen tiedostojen sisältö palautetaan listana ResponseBankin käyttöön.
 * Sisältää metodin myös encryptaamiselle, vaikka ohjelma ei sitä ominaisuutta
 * käytäkään (minä käytän). Hyödyntää HashMappia, jossa jokaista merkkiä vastaa
 * jokin eri merkki.
 */
public class CodeLanguage {

    private HashMap<Character, Character> map;
    private String characters;
    private String charactersShuffled;

    /**
     * alustaa HashMap-olion, johon talletetaan loopissa avaimiksi
     * this.characters-merkkijonon kirjaimet ja arvoiksi
     * this.charactersShuffled-merkkijonon kirjaimet. Palauttaa
     * CodeLanguage-olion.
     */
    public CodeLanguage() {

        this.map = new HashMap<>();
        this.characters = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789.,!?^_:;´~<>åäöÅÄÖ\"*'/+-\\()&%#@|€$=0";
        this.charactersShuffled = "4</@+\\hZRö*,m>=\"(rLu_HPgI9^Fno;#~Ä´ecÅ!Vq5-iGA€vDpb.S Wå&wCUa8jMX?J%B3OäEQTf2ydYKs$7zÖ1)|N6:ktxl'0";

        for (int i = 0; i < 97; i++) {
            map.put(characters.charAt(i), charactersShuffled.charAt(i));
        }
    }

    /**
     * Muuntaa normaalia kieltä koodiksi käymällä jokaisen merkkijonon s
     * kirjaimen läpi, hakemalla sen avaimena HashMapista ja lisäämällä
     * merkkijonoon ret sitä vastaavan arvon (tai merkin ?, jos avainta ei
     * löydy).
     *
     * @param s koodiksi muunnettava merkkijono.
     *
     * @return koodiksi muunnettu merkkijono.
     */
    public String normalToCode(String s) {

        String ret = "";

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                ret += map.get(s.charAt(i));
            } else {
                ret += "?";
            }
        }

        return ret;
    }

    /**
     * Muuntaa koodia normaaliksi kieleksi käymällä jokaisen merkkijonon s
     * kirjaimen läpi ja aloittaa jokaisen kohdalla toisen loopin (aikavaativuus
     * O(feelsbadman)), joka käy HashMapin avaimet läpi ja tarkistaa, vastaako
     * senhetkinen kirjain avaimen arvoa, missä tapauksessa avain lisätään
     * palautettavaan merkkijonoon ret.
     *
     * @param s normaaliksi kieleksi muunnettava koodimerkkijono.
     *
     * @return muunnettu merkkijono.
     */
    public String codeToNormal(String s) {

        String ret = "";

        for (int i = 0; i < s.length(); i++) {
            for (Character c : map.keySet()) {
                if (map.get(c) == s.charAt(i)) {
                    ret += c;
                }
            }
        }

        return ret;
    }

    /**
     * Luo uuden Scanner-olion, joka annetaan tyhjän ArrayListin kanssa
     * addToList-metodille. Ympäröity try-catchilla siltä varalta, että
     * filename-nimistä tiedostoa tai määriteltyä tiedostopolkua ei löydy.
     * Epäonnistuminen tulostaa "", eli ei mitään.
     *
     * @param filename polku tiedostoon, jota yritetään lukea.
     *
     * @return addToListin luoma lista tai uusi, tyhjä lista, jos tiedoston
     * lukeminen epäonnistui (mutta ei se epäonnistu, dw).
     */
    public ArrayList<String> codeToNormalList(String filename) {

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(filename);
            Scanner reader = new Scanner(is);
            return addToList(reader, new ArrayList<>());
        } catch (Exception e) {
            System.out.print("");
        }

        return new ArrayList<>();
    }

    /**
     * Tänne tullaan codeToNormalList-metodin tiedostontunnistamisen
     * onnistuessa, jolloin voidaan lukea tiedoston sisältöä Scannerilla ja
     * lisätä jokainen rivi erikseen ArrayListiin.
     *
     * @param reader codeToNormalList-metodin luoma Scanner-olio, jolla luetaan
     * tiedostoa.
     * @param list tyhjä lista, johon Scannerin lukema tiedosto lisätään rivi
     * riviltä.
     *
     * @return lista, kun jokainen tiedoston rivi on luettu ja lisätty.
     */
    public ArrayList<String> addToList(Scanner reader, ArrayList<String> list) {

        while (reader.hasNextLine()) {
            list.add(codeToNormal(reader.nextLine()));
        }

        return list;
    }
}
