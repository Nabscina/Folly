package follybot.response.quotemaker;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class QuoteMakerTest {

    QuoteMaker qm;

    public QuoteMakerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        qm = new QuoteMaker();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void makeAQuoteReplaceAllWorks() {

        ArrayList<String> al = new ArrayList<>();
        al.add("word");
        qm.makeAQuote("this is a quote thaÅt needs Åfixing", al, "name");

        assertTrue(qm.makeAQuote("this is a quote thaÅt needs Åfixing", al, "name").contains("this is a quote thawordt needs wordfixing"));
        assertFalse(qm.makeAQuote("no special character here so no fixing needed", al, "name").contains("word"));
    }
    
    @Test
    public void anAttemptToTestEndQuoteEvenThoughItsRandom() {
        
        assertTrue(qm.endQuote("Folly").equals(", Folly.") || qm.endQuote("Folly").equals("."));
    }
}
