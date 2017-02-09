package follybot.follybot;

public class Conversation {

    private Folly folly;

    public Conversation() {

        folly = new Folly();
    }

    public String converse(String line) {

        return folly.respond(line);
    }
}
