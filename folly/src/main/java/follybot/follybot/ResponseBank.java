package follybot.follybot;

import java.util.ArrayList;
import java.util.Collections;

public class ResponseBank {

    private ArrayList<String> names;

    public ResponseBank() {

        names = new ArrayList<>();
        addNames();
    }

    public void addNames() {

        Collections.addAll(names, "Craig", "Human #1", "Susie");
    }

    public String returnAName() {

        Collections.shuffle(names);

        return names.get(0);
    }

}
