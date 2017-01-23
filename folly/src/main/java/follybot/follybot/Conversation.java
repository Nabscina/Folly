package follybot.follybot;

import java.util.Scanner;

public class Conversation implements Runnable {

    private Scanner reader;
    private Folly folly;
    private Human human;

    private ResponseBank rb;

    public Conversation() {

        this.reader = new Scanner(System.in);
        this.folly = new Folly();

        this.rb = new ResponseBank();
    }

    @Override
    public void run() {

    }
}
