package follybot.follybot;

import java.util.ArrayList;
import java.util.Collections;

public class ResponseBank {

    private String humanName = "";
    private ArrayList<String> names;
    private ArrayList<String> equals;
    private ArrayList<String> uniques;

    public ResponseBank() {

        names = new ArrayList<>();
        equals = new ArrayList<>();
        uniques = new ArrayList<>();
    }

    public void addNames() {

        if (names.isEmpty()) {
            Collections.addAll(names, "Craig", "Human #1", "Susie");
        }
    }

    public void addEquals() {

        equals.add("I'm already Folly. From now on, your name is " + humanName + ".");
        equals.add("You can't be Folly. I'm Folly. You can be " + humanName + ".");
        equals.add("I don't think so, " + humanName + ".");
    }

    public void addUniques() {

        uniques.add(humanName + ". That's a strange name.");
        uniques.add(humanName + ". I like that.");
        uniques.add("Glad to see you, " + humanName + ".");
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
