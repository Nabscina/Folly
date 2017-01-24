package follybot.follybot;

import java.util.Scanner;

public class Conversation implements Runnable {

    private Scanner reader;
    private Folly folly;
    private Human human;

    public Conversation() {

        this.reader = new Scanner(System.in);
        this.folly = new Folly();
    }

    @Override
    public void run() {

        System.out.println("What's your name?");
        String name = reader.nextLine();
        this.human = new Human(name);

        folly.respond(human.getName());

        while (true) {
            String question = reader.nextLine();
            folly.respond(question);
        }
    }
}
