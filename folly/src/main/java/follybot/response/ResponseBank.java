package follybot.response;

import java.util.ArrayList;
import java.util.Collections;
import follybot.response.codelanguage.CodeLanguage;

public class ResponseBank {

    private String humanName = "";
    
    private ArrayList<String> names;
    private ArrayList<String> equals;
    private ArrayList<String> uniques;

    private ArrayList<String> quotes1;
    private ArrayList<String> quotes2;

    private CodeLanguage cl;

    public ResponseBank() {

        cl = new CodeLanguage();

        equals = cl.codeToNormalList("src/main/java/follybot/response/files/equalnameresponse.txt");
        uniques = cl.codeToNormalList("src/main/java/follybot/response/files/uniquenameresponse.txt");
        names = cl.codeToNormalList("src/main/java/follybot/response/files/names.txt");
        quotes1 = cl.codeToNormalList("src/main/java/follybot/response/files/quotes1.txt");
        quotes2 = cl.codeToNormalList("src/main/java/follybot/response/files/quotes2.txt");
    }

    public String quote() {

        Collections.shuffle(quotes1);
        Collections.shuffle(quotes2);

        return quotes1.get(0) + quotes2.get(0);
    }

    public String getAName() {

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

        Collections.shuffle(uniques);
        return humanName + uniques.get(0);
    }

    public String equalNameResponse() {

        Collections.shuffle(equals);
        return equals.get(0) + humanName + ".";
    }
}
