package follybot.follybot;

public class ResponseLogic {

    private ResponseBank rb;

    public ResponseLogic() {

        this.rb = new ResponseBank();
    }

    public String respond(String question) {

        return "Hi " + rb.getHumanName() + ".";
    }

    public String newName() {

        return rb.returnAName();
    }

    public boolean needsChanging(String name) {

        return name.toLowerCase().equals("folly");
    }

    public String respondToEqualName(String name) {

        rb.setHumanName(name);
        return rb.equalNameResponse();
    }

    public String respondToUniqueName(String name) {

        rb.setHumanName(name);
        return rb.uniqueNameResponse();
    }
}
