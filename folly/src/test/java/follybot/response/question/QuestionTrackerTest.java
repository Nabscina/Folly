package follybot.response.question;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuestionTrackerTest {

    QuestionTracker qt;

    public QuestionTrackerTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        qt = new QuestionTracker();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void answersOnAlustettu() {

        assertTrue(qt.getAnswersMap() != null);
    }

    @Test
    public void answersOnTyhja() {

        assertTrue(qt.getAnswersMap().isEmpty());
    }

    @Test
    public void addAnswerLisaaVastauksen() {

        qt.addAnswer("what", "yes");
        assertTrue(qt.getAnswersMap().containsKey("what"));
    }

    @Test
    public void addAnswerEiLisaaVastaustaSamaanKysymykseen() {

        qt.addAnswer("what", "yes");
        assertEquals(qt.getAnswersMap().get("what"), "yes");
        assertTrue(qt.getAnswersMap().size() == 1);

        qt.addAnswer("what", "no");
        assertEquals(qt.getAnswersMap().get("what"), "yes");
        assertTrue(qt.getAnswersMap().size() == 1);
    }

    @Test
    public void addAnswerMuuttaaMerkitPieniksi() {

        qt.addAnswer("QUESTION", "answer");
        assertTrue(qt.getAnswersMap().containsKey("question"));
        assertFalse(qt.getAnswersMap().containsKey("QUESTION"));
    }

    @Test
    public void getAnswersPalauttaaVastauksenJosSellainenOn() {

        qt.addAnswer("question?", "answer");
        assertEquals(qt.getAnswer("question?"), "answer");
    }

    @Test
    public void getAnswersPalauttaaNullJosEiVastausta() {

        qt.addAnswer("x", "y");
        assertTrue(qt.getAnswer("question?") == null);
    }

    @Test
    public void getAnswersMuuttaaMerkitPieniksi() {

        qt.addAnswer("WHAAAAAAAAAAT?????!!!!!!!!!", "dude chill");
        assertEquals(qt.getAnswer("whaaaaaaaaaat?????!!!!!!!!!"), "dude chill");
    }

}
