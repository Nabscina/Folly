package follybot.response.math;

import java.util.ArrayList;
import java.util.Collections;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

/**
 * Matikkalogiikkaluokka, eli ResponseLogic voi tarkastella käyttäjän syötettä
 * tämän luokan mathCheck-metodilla, joka modailee syötettä ja päättää, onko
 * syöte matemaattinen lauseke. Jos on, etsitään ratkaisu hyödyntämällä
 * ScriptEnginea ja palautetaan ratkaisu ResponseLogicille.
 */
public class BotMath {

    private ScriptEngineManager manager;
    private ScriptEngine engine;

    /**
     * Alustaa oliot ScriptEngineManager ja ScriptEngine, joiden avulla voidaan
     * laskea merkkijonomuotoisen matemaattisen lausekkeen arvo. Palauttaa
     * BotMath-olion.
     */
    public BotMath() {

        this.manager = new ScriptEngineManager();
        this.engine = manager.getEngineByName("JavaScript");
    }

    /**
     * Poistetaan käyttäjän syötteestä merkit, jotka eivät ole numeroita 0-9 tai
     * esimerkiksi plus- tai miinusmerkkejä tai pilkkuja, muunnetaan jäljelle
     * jääneet pilkut pisteiksi, poistetaan mahdolliset pisteet lauseen
     * alkuosasta sekä myös loppuosasta.
     *
     * @param line käyttäjän syöte.
     *
     * @return siistitty merkkijono, jonka matemaattisen lausekkeen ScriptEngine
     * voi ratkaista, jos alkuperäinen syöte sisälsi oikeamuotoisen lausekkeen.
     */
    public String createMathExpression(String line) {

        String newLine = line.replaceAll("[^0-9-+*/(),.]", "");
        newLine = newLine.replaceAll(",", ".");

        while (newLine.startsWith(".") || newLine.endsWith(".")) {
            if (newLine.endsWith(".")) {
                newLine = newLine.substring(0, newLine.length() - 1);
            }
            if (newLine.startsWith(".")) {
                newLine = newLine.substring(1, newLine.length());
            }
        }

        return newLine;
    }

    /**
     * Siistitään käyttäjän syöte metodilla createMathExpression() ja pyritään
     * ratkaisemaan siinä oleva lauseke ScriptEnginella. Try-catch sen varalta,
     * että lausekkeen ratkaiseminen ei onnistu.
     *
     * @param line käyttäjän syöte.
     *
     * @return ratkaisu lausekkeeseen, jossa ei jaeta nollalla, "DO NOT DIVIDE
     * BY ZERO! EVER" jos ScriptEnginen palauttamasta vastauksesta päätellään,
     * että jaettiin nollalla, tai "ERROR" jos ratkaiseminen ei onnistunut
     * (virheellinen lauseke).
     */
    public Object doMath(String line) {

        String expression = createMathExpression(line);

        try {
            Object ret = this.engine.eval(expression);
            if (ret.toString().equals("Infinity") || ret.toString().equals("-Infinity") || ret.toString().equals("NaN")) {
                return "DO NOT DIVIDE BY ZERO! EVER!";
            } else if (ret.toString().equals("-0.0")) {
                return "0.";
            }
            return ret + ".";
        } catch (Exception e) {
            return "ERROR";
        }
    }

    /**
     * Tarkistetaan, onko käyttäjän syötteessä laskettavissa oleva matemaattinen
     * lauseke.
     *
     * @param line käyttäjän syöte.
     *
     * @return false, jos syöte on tyhjä, symbolCheck() palauttaa false tai
     * lauseke on virheellinen (doMath() palauttaa ERROR), muuten true.
     */
    public boolean mathCheck(String line) {

        if (line.isEmpty()) {
            return false;
        }

        String expression = createMathExpression(line);

        if (!symbolCheck(expression)) {
            return false;
        }

        if (doMath(expression).toString().equals("ERROR")) {
            return false;
        }

        return true;
    }

    /**
     * Ensimmäinen "siistitylle" (createMathExpression suoritettu) lausekkeelle
     * suoritettava tarkastus, jossa katsotaan, onko siinä symboleja +, -, * tai
     * / muualla kuin alussa, eli lähdetäänkö yrittämään sen tatkaisua ("-5" ei
     * mene läpi, yksi miinus alussa, "5" ei mene läpi, ei symboleja.)
     *
     * @param line käyttäjän syöte, joka on siistitty metodilla
     * createMathExpression.
     *
     * @return true, jos line sisältää matemaattisia symboleja muualla kuin
     * indeksissä 0, muuten false.
     */
    public boolean symbolCheck(String line) {

        ArrayList<Character> symbols = new ArrayList<>();
        Collections.addAll(symbols, '+', '-', '*', '/');

        for (int i = 1; i < line.length(); i++) {
            if (symbols.contains(line.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
