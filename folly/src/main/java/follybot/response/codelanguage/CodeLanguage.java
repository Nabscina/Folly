package follybot.response.codelanguage;

import java.util.HashMap;

public class CodeLanguage {

    private HashMap<Character, Character> map;
    private String characters;
    private String charactersShuffled;

    public CodeLanguage() {

        this.map = new HashMap<>();
        this.characters = " ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789.,!?^_:;´~<>åäöÅÄÖ\"*'/+-\\()&%#@|€$=";
        this.charactersShuffled = "4</@+\\hZRö*,m>=\"(rLu_HPgI9^Fno;#~Ä´ecÅ!Vq5-iGA€vDpb.S Wå&wCUa8jMX?J%B3OäEQTf2ydYKs$7zÖ1)|N6:ktxl'";

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
}
