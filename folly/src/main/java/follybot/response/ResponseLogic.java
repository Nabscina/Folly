package follybot.response;

public class ResponseLogic {

    private ResponseBank rb;

    public ResponseLogic() {

        this.rb = new ResponseBank();
    }

    public String respond(String question) {

        //alkeellinen
        return "Hi " + rb.getHumanName() + ".";
    }

    public String newName() {

        return rb.returnAName();
    }

    public boolean needsChanging(String name) {

        String ret = name.replaceAll("[^a-zA-Z]", "").toLowerCase();
        return ret.equals("folly");
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
}
