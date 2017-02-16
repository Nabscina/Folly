package follybot.response.question;

import follybot.response.ResponseBank;
import java.util.ArrayList;
import java.util.Collections;

public class BotQuestion {

    private ArrayList<String> polars;
    private ResponseBank rb;

    public BotQuestion(ResponseBank rb) {

        this.rb = rb;
        polars = new ArrayList<>();
        Collections.addAll(polars, "is ", "can ", "am i", "are ", "will ", "should ",
                "could ", "would ", "isn't ", "can't ", "aren't ", "won't ", "shouldn't ",
                "couldn't ", "wouldn't ", "does ", "doesn't ", "do ", "don't ", "must ",
                "mustn't ", "may ", "shall ");
    }

    public boolean questionCheck(String question) {

        return question.trim().endsWith("?");
    }

    public String answerQuestion(String question) {

        if (polarQuestionCheck(question)) {
            return rb.answerAPolarQuestion();
        } else {
            return rb.answerSomeOtherQuestion();
        }
    }

    public boolean polarQuestionCheck(String question) {

        for (String s : polars) {
            if (question.toLowerCase().startsWith(s)) {
                return true;
            }
        }
        return false;
    }
}
