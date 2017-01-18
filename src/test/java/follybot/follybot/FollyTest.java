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
    public void name() {

        assertEquals("folly", folly.getName());
    }
}
