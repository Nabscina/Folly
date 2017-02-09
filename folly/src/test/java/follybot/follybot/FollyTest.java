package follybot.follybot;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FollyTest {

    Folly folly;

    public FollyTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        folly = new Folly();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void introductionIsDoneBooleanWorksCorrectly() {

        assertFalse(folly.introductionIsDone());
        assertTrue(folly.respond("Kek").contains("Kek"));
        assertTrue(folly.introductionIsDone());
    }

    @Test
    public void responseTest() {

        assertTrue(folly.respond("Name").contains("Name"));
        assertTrue(folly.respond("Bye").equals("Bye."));
        assertTrue(folly.respond("100*1000").equals("100000."));
        assertTrue(folly.respond("100/0").equals("DO NOT DIVIDE BY ZERO! EVER!"));
        assertFalse(folly.respond("").isEmpty());
        assertFalse(folly.respond("sgdnsgghd (YDG/GDU DGUAIADGIGD").isEmpty());
    }
}
