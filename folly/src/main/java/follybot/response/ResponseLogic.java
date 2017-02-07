package follybot.response;

import follybot.response.math.BotMath;
import java.util.Random;

public class ResponseLogic {

    private ResponseBank rb;
    private BotMath math;
    private Random random;

    public ResponseLogic() {

        this.rb = new ResponseBank();
        this.math = new BotMath();
        this.random = new Random();
    }

    public String respond(String question) {

        if (simplified(question).equals("bye")) {
            return "Bye.";
        } else if (math.mathCheck(question)) {
            return math.doMath(question).toString();
        }

        return rb.quote() + endQuote();
    }

    public String newName() {

        return rb.getAName();
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

    public String endQuote() {

        int zerotoseven = random.nextInt(8);

        if (zerotoseven == 7) {
            return ", " + rb.getHumanName() + ".";
        } else {
            return ".";
        }
    }
}
