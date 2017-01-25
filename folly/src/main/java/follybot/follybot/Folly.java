package follybot.follybot;

import follybot.response.ResponseLogic;

public class Folly {

    private String name;

    private ResponseLogic rl;
    private boolean introductionIsDone;

    public Folly() {

        this.name = "folly";

        this.rl = new ResponseLogic();
        this.introductionIsDone = false;
    }

    public String getName() {

        return this.name;
    }

    public String respond(String q) {

        if (!introductionIsDone) {
            introductionIsDone = true;
            return "Folly: " + rl.introduction(q);
        }

        return "Folly: " + rl.respond(q);
    }
}
