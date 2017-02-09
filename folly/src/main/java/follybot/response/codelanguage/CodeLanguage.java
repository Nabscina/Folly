package follybot.response.codelanguage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Tämä luokka lukee files-tiedostoja ja decryptaa niiden koodikielen, minkä jälkeen tiedostojen sisältö
 * palautetaan listana ResponseBankin käyttöön. Sisältää metodin myös encryptaamiselle,
 * vaikka ohjelma ei sitä ominaisuutta käytäkään (minä käytän).
 * Hyödyntää HashMappia, jossa jokaista merkkiä vastaa jokin eri merkki.
 */
public class CodeLanguage {

    private HashMap<Character, Character> map;
    private String characters;
    private String charactersShuffled;

    public CodeLanguage() {

        this.map = new HashMap<>();
        this.characters = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789.,!?^_:;´~<>åäöÅÄÖ\"*'/+-\\()&%#@|€$=0";
        this.charactersShuffled = "4</@+\\hZRö*,m>=\"(rLu_HPgI9^Fno;#~Ä´ecÅ!Vq5-iGA€vDpb.S Wå&wCUa8jMX?J%B3OäEQTf2ydYKs$7zÖ1)|N6:ktxl'0";

        for (int i = 0; i < 97; i++) {
            map.put(characters.charAt(i), charactersShuffled.charAt(i));
        }
    }

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

    public ArrayList<String> codeToNormalList(String filename) {

        try {
            Scanner reader = new Scanner(new File(filename), "UTF-8");
            return addToList(reader, new ArrayList<>());
        } catch (Exception e) {
            System.out.print("");
        }

        return new ArrayList<>();
    }

    public ArrayList<String> addToList(Scanner reader, ArrayList<String> list) {

        while (reader.hasNextLine()) {
            list.add(codeToNormal(reader.nextLine()));
        }

        return list;
    }
}
