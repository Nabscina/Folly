package follybot.response;

public class ResponseLogic {

    private ResponseBank rb;

    public ResponseLogic() {

        this.rb = new ResponseBank();
    }

    public String respond(String question) {

        if (simplified(question).equals("bye")) {
            return "Bye.";
        }
        return "Hi " + rb.getHumanName() + ".";
    }

    public String newName() {

        return rb.returnAName();
    }

    public boolean needsChanging(String name) {

        return simplified(name).equals("folly");
    }

    public String introduction(String name) {

        if (needsChanging(name)) {
            String newName = newName();
            return respondToEqualName(newName);
        } else {
            return respondToUniqueName(name);
        }
    }

    public String respondToEqualName(String name) {

        rb.setHumanName(name);
        return rb.equalNameResponse();
    }

    public String respondToUniqueName(String name) {

        rb.setHumanName(name);
        return rb.uniqueNameResponse();
    }

    public String simplified(String question) {

        return question.replaceAll("[^a-zA-Z]", "").toLowerCase();
    }
}
