package follybot.follybot;

import follybot.response.ResponseLogic;
/**
 * Tämä luokka palauttaa merkkijonomuotoisen vastauksen käyttäjän
 * kysymykseen tai muuhun lauseeseen. Oliomuuttujana boolean introductionIsDone,
 * eli tiedetäänkö nimi ja voidaanko vastata "tavallisesti".
 */
public class Folly {

    private ResponseLogic rl;
    
    private boolean introductionIsDone;

    public Folly() {

        this.rl = new ResponseLogic();
        
        this.introductionIsDone = false;
    }

    public String respond(String q) {

        if (!introductionIsDone) {
            introductionIsDone = true;
            return rl.introduction(q);
        }

        return rl.respond(q);
    }

    public boolean introductionIsDone() {

        return introductionIsDone;
    }
}
