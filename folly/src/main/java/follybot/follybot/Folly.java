package follybot.follybot;

public class Folly {

    private String name;

    private ResponseLogic rl;

    public Folly() {

        this.name = "folly";

        this.rl = new ResponseLogic();
    }

    public String getName() {

        return this.name;
    }

    public void respond(String q) {

        System.out.println("Folly: " + rl.respond(q));
    }

    public String respondToName(String name) {

        if (rl.needsChanging(name)) {
            String newName = rl.newName();
            System.out.println("Folly: " + rl.respondToEqualName(newName));
            return newName;
        }
        System.out.println("Folly: " + rl.respondToUniqueName(name));
        return name;
    }
}
