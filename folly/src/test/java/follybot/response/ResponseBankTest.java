package follybot.response;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ResponseBankTest {

    ResponseBank rb;

    public ResponseBankTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        rb = new ResponseBank();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void humanNameTest() {

        rb.setHumanName("coolname");
        assertEquals(rb.getHumanName(), "coolname");

        rb.setHumanName("folly");
        assertEquals(rb.getHumanName(), "folly");
    }

    @Test
    public void uniqueNameResponseThrowsNoException() {

        rb.uniqueNameResponse();
    }

    @Test
    public void equalNameResponseThrowsNoException() {

        rb.equalNameResponse();
    }

    @Test
    public void quoteThrowsNoException() {

        rb.quote();
    }
}
