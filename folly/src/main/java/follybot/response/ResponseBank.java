package follybot.response;

import java.util.ArrayList;
import java.util.Collections;
import follybot.response.codelanguage.CodeLanguage;

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

    private CodeLanguage cl;

    public ResponseBank() {

        names = new ArrayList<>();
        equals = new ArrayList<>();
        uniques = new ArrayList<>();

        quotes1 = new ArrayList<>();
        quotes2 = new ArrayList<>();

        cl = new CodeLanguage();
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

        Collections.addAll(quotes1, "ö~4F€4~eGA€4.5v4;5q$€4Avoo##;M4", "g´#q4!e~#4Ä#€A4´FG;M4", "g´#q4!e~#4ÄeD#A4.5v4!#V5qAM4", "+5q$€4ÄeD#4v-M4", "<!pF.A4;54.5vG4n#A€M4Fq;4;5q$€4~5GÄ#€4€54", "_´#4VFeq4G#FA5q4G5n5€A4FG#4n#€€#G4€´Fq4.5v4eA4n#oFvA#4.5v4p5v!;4q#D#G4", "\\D#G.€´eqÄ4pe!!4n#4F!GeÄ´€4e~4.5v4",
                "uVe!#M4Fq;4", "_´#4n#A€4pF.4€54G#!e#D#4A€G#AA4eA4€54", "_54A€F.45-€eVeA€eo4;vGeqÄ4€5vÄ´4€eV#AM4", "95v$!!4q#D#G4Avoo##;4e~4.5v4;5q$€4", "g5GÅ4´FG;M4;G#FV4neÄM4Fq;4", "me~#4eA4A´5G€M4A54", "95v4Åq5p4€´#.4!5D#4.5v4p´#q4€´#.4€#!!4.5v4€54", "_´#4V5A€4eV-5G€Fq€4€´eqÄ4eq4!e~#4eA4€54",
                "_54n#o5V#4eVV5G€F!M4", "rve€4pFA€eqÄ4.5vG4€eV#4Fq;4", "+5q$€4n#4A€v-e;M4", "95v4pe!!4q#D#G4n#4o55!4vq!#AA4.5v4", "95v$!!4q#D#G4n#o5V#4Fq.€´eqÄ4e~4.5v4;5q$€4", "+5q$€4p5GG.4Fn5v€4e€M4Fq;4",
                "me~#4eAq$€4p5G€´4!eDeqÄ4vq!#AA4.5v4", "95v4oFq4n#4Fq.€´eqÄ4e~4.5v4", "g´#q4eq4;5vn€M4", "m5p4A#!~Ö#A€##V4eA4F4AeÄq4.5v4q##;4€54", "_54VFÅ#4~Ge#q;AM4");

        Collections.addAll(quotes2, "nv.4F4´5GA#", "A´v€4v-", "-!F.4De;#54ÄFV#A", "€F!Å4€54A€v-e;4n5€A4F!!4;F.", "o#FA#4€54#beA€", "-G5ÄGFV4eq4@", ";Fqo#", "A-#FÅ4hG#qo´",
                "cvV-4G#-#F€#;!.4Fq;4AoG#FV", "A€5-4nG#F€´eqÄ", "€GvA€4V#4p´#q4ö4AF.4€´#4oFÅ#4eA4q5€4F4!e#", "#F€4.5vG4D#Ä#€Fn!#A", "Åe!!4A5V#n5;.4pe€´4F4-eSSF4ov€€#G", "\\LL\"LB4h<öm\\+4_\"4hö=öuR4rH\"_\\j4u5GG.", "#qc5.4´eÄ´ÖivF!e€.4V#V#A", "-vGAv#4F4oFG##G4eq4p#n4;#D#!5-V#q€",
                ";eAG#ÄFG;4#D#G.4-e#o#45~4F;Deo#4.5vG4-FG#q€A4#D#G4ÄFD#4.5v", ";54F4nFGG#!4G5!!", "€FÅ#4F4A´5p#Gj4\\D#q4ö4oFq4AV#!!4.5vM4Fq;4ö4;5q$€4#D#q4´FD#4F4A#qA#45~4AV#!!", "ÄeD#4.5vG4!e~#4€54V#", "-eoÅ4VvA´G55VA4F!!4;F.M4#D#G.4;F.M4~5G4€´#4G#A€45~4.5vG4!e~#", "Foo#-€4€´#4~Fo€4ö$!!4F!pF.A4n#4V5G#4eq€#!!eÄ#q€4€´Fq4.5v", "AV5Å#4p##;4#D#G.4;F.", "€FÅ#4.5vG45pq4!e~#",
                "#F€4o´##A#oFÅ#", "nvGq4.5vG4´5vA#4;5pq", "o!eVn4F4€G##", "#F€4€´G##4A-e;#GA", "VFÅ#4F--!#4cveo#", "ive€4-G5ÄGFVVeqÄ4eq4*FDF4Fq;4!#FGq4@:", "Ä#€4Ge;45~4.5vG4~Ge#q;A4Fq;4~FVe!.", "#VnGFo#4€´#4€´5vÄ´€45~4;.eqÄ45q#4;F.", "Ä#€4F4´FVA€#G", "#F€4€p545GFqÄ#A4eq4vq;#G45q#4Veqv€#",
                "#F€4GFp4o´eoÅ#q", "ÄeÄÄ!#", "A€5-4;eDe;eqÄ4n.4S#G5", "eÄq5G#4#D#G.5q#4Fq;4#D#G.€´eqÄ", "o!5A#4.5vG4#.#A4Fq;4-##4F4!e€€!#", "!e#4;5pq4Fq;4o5vq€4€54€#q", "-eoÅ4.5vG4q5A#", "AvnAoGen#4€54V#45q495v_vn#", "~5!!5p4V#45q4_pe€€#G", "G#~Fo€5G4.5vG4o5;#", "Gvq4pe€´4AoeAA5GA", "-v€45v€4F4ÄG#FA#4~eG#4pe€´4pF€#G", "-!F.4LvAAeFq4G5v!#€€#", "€´G5p4FpF.4.5vG4€5FA€#G", "o5VVe€4FGA5q",
                "Aq##S#4eq4A5V#5q#$A4~Fo#", "F;5-€4F4-v--.", "-vqo´4A5V#5q#4eq4€´#4~Fo#4Fq;4Gvq", "!eA€#q4€54€´#4F;Deo#45~4-eqÅ4vqeo5GqA", "o5qA€Gvo€4F;;e€e5qF!4-.!5qA", "€FÅ#45~~4.5vG4o!5€´#A", "G#€´eqÅ4.5vG4!e~#", "A€5-4€F!ÅeqÄ4€54V#j4ö$V4Åe;;eqÄj4(!#FA#4;5q$€4!#FD#4V#");
    }

    public String quote() {

        if (quotes1.isEmpty() || quotes2.isEmpty()) {
            addQuotes();
        }

        Collections.shuffle(quotes1);
        Collections.shuffle(quotes2);

        return cl.codeToNormal(quotes1.get(0)) + cl.codeToNormal(quotes2.get(0));
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
