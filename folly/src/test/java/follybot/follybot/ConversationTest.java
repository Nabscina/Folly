package follybot.follybot;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConversationTest {

    ByteArrayOutputStream stream;

    public ConversationTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        stream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(stream));
    }

    @After
    public void tearDown() {
    }

    @Test
    public void convoLoopWorksAsIntended() {

        String input = form("randomname", "asd", "bye");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertTrue(output.contains("What's your name?"));
        assertTrue(output.contains("Folly: "));
        assertTrue(output.contains("randomname"));
        assertTrue(output.contains("Folly: Bye."));
    }

    @Test
    public void convoLoopWorksAsIntended2() {

        String input = form("Kek", "bye");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertTrue(output.contains("What's your name?"));
        assertTrue(output.contains("Folly: "));
        assertTrue(output.contains("Kek"));
        assertTrue(output.contains("Folly: Bye."));
    }

    @Test
    public void particularOutputIfHumansNameIsFolly() {

        String input = form("Folly", "bye");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertFalse(output.contains("That's a strange name."));
        assertFalse(output.contains("I like that."));
        assertFalse(output.contains("Glad to see you, "));
        assertTrue(output.contains("Bye."));
    }

    @Test
    public void particularOutputIfHumansNameIsFolly2() {

        String input = form("!FOL¤¤)=#%LY!!!!!", "bye");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertFalse(output.contains("That's a strange name."));
        assertFalse(output.contains("I like that."));
        assertFalse(output.contains("Glad to see you, "));
        assertTrue(output.contains("Bye."));
    }

    @Test
    public void particularOutputIfHumansNameIsUnique() {

        String input = form("Polly", "bye");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertFalse(output.contains("I'm already Folly."));
        assertFalse(output.contains("You can't be Folly."));
        assertFalse(output.contains("I'm just gonna call you "));
    }

    @Test
    public void byeBreaksLoop() {

        String input = form("x", "Bye.");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertTrue(output.contains("Bye."));
    }

    @Test
    public void byeBreaksLoop2() {

        String input = form("x", "BYE!!!!!!!!!!!!!");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertTrue(output.contains("Bye."));
    }

    @Test
    public void byeBreaksLoop3() {

        String input = form("x", "bYe?");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertTrue(output.contains("Bye."));
    }

    @Test
    public void byeBreaksLoop4() {

        String input = form("x", "¤(//%BY!?¤(E*");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertTrue(output.contains("Bye."));
    }

    @Test
    public void follyDetectsMath() {

        String input = form("x", "What's 4 - 5 + 6?", "bye");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertTrue(output.contains("Folly: 5."));
    }

    @Test
    public void follyDetectsMath2() {

        String input = form("x", "Tell me what (2,5 + 4)*(-33.3 + 900) is.", "bye");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertTrue(output.contains("Folly: 5633.55."));
    }

    @Test
    public void follyDetectsMath3() {

        String input = form("x", "255.0/0", "bye");

        Conversation c = new Conversation(new Scanner(input));
        c.run();
        String output = stream.toString();

        assertTrue(output.contains("Folly: DO NOT DIVIDE BY ZERO! EVER!"));
    }

    @Test
    public void methodEndWorks() {

        assertTrue(new Conversation().end("Folly: Bye."));
        assertFalse(new Conversation().end("Bye."));
        assertFalse(new Conversation().end("BWKFBKWBKWBRIUBG"));
    }

    private String form(String... lines) {

        String linesWithEnter = "";
        for (String line : lines) {
            linesWithEnter += line + "\n";
        }
        return linesWithEnter;
    }
}
