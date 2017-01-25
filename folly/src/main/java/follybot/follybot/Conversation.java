package follybot.follybot;

import java.util.Scanner;

public class Conversation implements Runnable {

    private Scanner reader;
    private Folly folly;

    public Conversation(Scanner reader) {

        this.reader = reader;
        this.folly = new Folly();
    }
    
    public Conversation() {
        
    }

    @Override
    public void run() {

        System.out.println("What's your name?");

        while (true) {

            String question = reader.nextLine();
            String answer = folly.respond(question);
            System.out.println(answer);

            if (end(answer)) {
                break;
            }
        }
    }

    public boolean end(String answer) {

        return answer.equals("Folly: Bye.");
    }
}
