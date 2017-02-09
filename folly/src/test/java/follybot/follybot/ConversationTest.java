package follybot.follybot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConversationTest {

    Conversation c;

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

        c = new Conversation();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void answerTest1() {

        assertTrue(c.converse("Name").contains("Name"));
        assertEquals("Bye.", c.converse("bye"));
        assertEquals("-2.", c.converse("3-5"));
    }
}
