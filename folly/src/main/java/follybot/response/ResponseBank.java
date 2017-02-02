package follybot.response;

import java.util.ArrayList;
import java.util.Collections;

public class ResponseBank {

    //tänne tulee varmaan aika paljon listoja
    //ajattelin, että kunhan isoja listoja alkaa kertyä, sisältö
    //kopioitaisiin kuhunkin erillisistä tiedostoista
    //tai jotain muuta ns. parempaa
    private String humanName = "";
    private ArrayList<String> names;
    private ArrayList<String> equals;
    private ArrayList<String> uniques;

    private ArrayList<String> quotes1;
    private ArrayList<String> quotes2;

    public ResponseBank() {

        names = new ArrayList<>();
        equals = new ArrayList<>();
        uniques = new ArrayList<>();

        quotes1 = new ArrayList<>();
        quotes2 = new ArrayList<>();
    }

    public void addNames() {

        if (names.isEmpty()) {
            Collections.addAll(names, "Craig", "Bobby", "Susie");
        }
    }

    public void addEquals() {

        equals.add("I'm already Folly. From now on, your name is " + humanName + ".");
        equals.add("You can't be Folly. I'm Folly. You can be \"" + humanName + "\" instead.");
        equals.add("I'm just gonna call you " + humanName + ".");
    }

    public void addUniques() {

        uniques.add(humanName + ". That's a strange name.");
        uniques.add(humanName + ". I like that.");
        uniques.add("Glad to see you, " + humanName + ".");
    }

    public void addQuotes() {

        Collections.addAll(quotes1, "If at first you don't succeed, ", "When life gets hard, ", "When life gives you lemons, ", "Don't give up, ", "Always do your best, and don't forget to ", "You may not be good at everything, but at least you can ", "Everything will be alright if you ",
                "Smile, and ", "The best way to relieve stress is to ", "To stay optimistic during tough times, ", "You'll never succeed if you don't ", "Work hard, dream big, and ", "Life is short, so ", "You know they love you when they tell you to ", "The most important thing in life is to ",
                "To become immortal, ", "Quit wasting your time and ", "Don't be stupid, ", "You will never be cool unless you ", "You'll never become anything if you don't ", "Don't worry about it, and ",
                "Life isn't worth living unless you ", "You can be anything if you ", "When in doubt, ", "Low self-esteem is a sign you need to ", "To make friends, ");

        Collections.addAll(quotes2, "buy a horse", "shut up", "play video games", "talk to stupid bots all day", "cease to exist", "program in C", "dance", "speak French",
                "jump repeatedly and scream", "stop breathing", "trust me when I say the cake is not a lie", "eat your vegetables", "kill somebody with a pizza cutter", "ERROR: FAILED TO FINISH QUOTE. Sorry", "enjoy high-quality memes", "pursue a career in web development",
                "disregard every piece of advice your parents ever gave you", "do a barrel roll", "take a shower. Even I can smell you, and I don't even have a sense of smell", "give your life to me", "pick mushrooms all day, every day, for the rest of your life", "accept the fact I'll always be more intelligent than you", "smoke weed every day", "take your own life",
                "eat cheesecake", "burn your house down", "climb a tree", "eat three spiders", "make apple juice", "quit programming in Java and learn C#", "get rid of your friends and family", "embrace the thought of dying one day", "get a hamster and name it " + humanName, "eat two oranges in under one minute",
                "eat raw chicken", "giggle", "stop dividing by zero", "ignore everyone and everything", "pee", "lie down and count to ten", "pick your nose", "subscribe to me on YouTube", "follow me on Twitter", "refactor your code");
    }

    public String quote() {

        if (quotes1.isEmpty() || quotes2.isEmpty()) {
            addQuotes();
        }

        Collections.shuffle(quotes1);
        Collections.shuffle(quotes2);

        return quotes1.get(0) + quotes2.get(0);
    }

    public String returnAName() {

        addNames();
        Collections.shuffle(names);

        return names.get(0);
    }

    public void setHumanName(String name) {

        humanName = name;
    }

    public String getHumanName() {

        return humanName;
    }

    public String uniqueNameResponse() {

        addUniques();
        Collections.shuffle(uniques);
        return uniques.get(0);
    }

    public String equalNameResponse() {

        addEquals();
        Collections.shuffle(equals);
        return equals.get(0);
    }
}
