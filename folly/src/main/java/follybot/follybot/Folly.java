package follybot.follybot;

public class Folly {

    private String name;
    private String answer;

    public Folly() {

        this.name = "folly";
        this.answer = "What's your name?";
    }

    public String getName() {

        return this.name;
    }

    public void setAnswer(String a) {

        this.answer = a;
    }

    public String respond() {

        return "Folly: " + this.answer;
    }
}
