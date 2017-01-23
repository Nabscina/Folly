package follybot.follybot;

public class Human {

    private String name;
    private String question;

    public Human(String name) {

        if (name.toLowerCase().equals("folly")) {
            ResponseBank rb = new ResponseBank();
            this.name = rb.returnAName();
        } else {
            this.name = name;
        }

        this.question = "";
    }

    public void ask(String q) {

        this.question = q;
    }

    public String getName() {

        return this.name;
    }

    public String getQuestion() {

        return this.question;
    }
}
