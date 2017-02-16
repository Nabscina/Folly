package follybot.response;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ResponseLogicTest {

    ResponseLogic rl;

    public ResponseLogicTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        rl = new ResponseLogic();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void byeReturnsBye() {

        assertEquals(rl.respond("bye"), "Bye. Press enter to leave.");
        assertEquals(rl.respond("BYE!"), "Bye. Press enter to leave.");
        assertEquals(rl.respond("by(¤#¤)e"), "Bye. Press enter to leave.");
        assertEquals(rl.respond("b.Y.E"), "Bye. Press enter to leave.");
    }

    @Test
    public void mathReturnsSolution() {

        assertEquals(rl.respond("2 + 5"), "7.");
        assertEquals(rl.respond("(640 - 6,5) + 1.222"), "634.722.");
        assertEquals(rl.respond("250 / 0"), "DO NOT DIVIDE BY ZERO! EVER!");
        assertEquals(rl.respond("1 + 2 + 3 + 4 - 6 - 8- 7,56+3*(0)*12/(34-(-11))"), "-11.559999999999999.");
    }

    @Test
    public void newNameReturnsANewName() {

        String name = rl.newName();
        assertTrue(name.equals("Craig") || name.equals("Susie") || name.equals("Bobby"));
    }

    @Test
    public void needsChangingWorks() {

        assertTrue(rl.needsChanging("folly"));
        assertTrue(rl.needsChanging("FOLLY123"));
        assertTrue(rl.needsChanging("13f9989ol3633l@Y"));

        assertFalse(rl.needsChanging("xyz"));
        assertFalse(rl.needsChanging("anythingthatisntfolly"));
        assertFalse(rl.needsChanging("Bobby"));
    }

    @Test
    public void simplifyingWorks() {

        assertEquals(rl.simplified("ABCDE"), "abcde");
        assertEquals(rl.simplified("%¤#(%)#)=¤&"), "");
        assertEquals(rl.simplified("Swag_M@st3R420"), "swagmstr");
    }

    @Test
    public void equalNameResponseContainsGivenName() {

        assertTrue(rl.respondToEqualName("name1").contains("name1"));
    }

    @Test
    public void uniqueNameResponseContainsGivenName() {

        assertTrue(rl.respondToEqualName("name200").contains("name200"));
    }

    @Test
    public void introductionChangesEqualName() {

        String intro = rl.introduction("Folly");
        assertTrue(intro.contains("Susie") || intro.contains("Craig") || intro.contains("Bobby"));
    }

    @Test
    public void introductionPreservesUniqueName() {

        String intro = rl.introduction("vitsinäätestitonhyviä");
        assertTrue(intro.contains("vitsinäätestitonhyviä"));
    }
}
