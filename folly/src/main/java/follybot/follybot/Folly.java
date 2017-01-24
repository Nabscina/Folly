package follybot.follybot;

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

    public void respond(String q) {

        if (!introductionIsDone) {
            System.out.println("Folly: " + rl.introduction(q));
            introductionIsDone = true;
            return;
        }

        System.out.println("Folly: " + rl.respond(q));
    }
}
