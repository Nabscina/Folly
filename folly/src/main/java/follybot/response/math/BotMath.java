package follybot.response.math;

import java.util.ArrayList;
import java.util.Collections;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

/**
 * Matikkalogiikkaluokka, eli ResponseLogic voi tarkastella käyttäjän syötettä
 * tämän luokan mathCheck-metodilla, joka modailee syötettä ja päättää, onko syöte matemaattinen lauseke.
 * Jos on, etsitään ratkaisu hyödyntämällä ScriptEnginea ja palautetaan ratkaisu ResponseLogicille. 
 */
public class BotMath {

    private ScriptEngineManager manager;
    private ScriptEngine engine;

    public BotMath() {

        this.manager = new ScriptEngineManager();
        this.engine = manager.getEngineByName("JavaScript");
    }

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
