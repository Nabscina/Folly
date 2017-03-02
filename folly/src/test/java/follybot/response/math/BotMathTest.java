package follybot.response.math;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BotMathTest {

    BotMath bm;

    public BotMathTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        bm = new BotMath();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void mathCheckWorks1() {

        assertFalse(bm.mathCheck("hi"));
        assertFalse(bm.mathCheck(""));
        assertFalse(bm.mathCheck("1"));
        assertFalse(bm.mathCheck("12 45 67"));
        assertFalse(bm.mathCheck("dgfjnug43h8gbn83gR(B#(/#"));
        assertFalse(bm.mathCheck("There is nothing mathematical about this sentence, zero. Returns false."));

        assertTrue(bm.mathCheck("5 - 4"));
        assertTrue(bm.mathCheck("1.2 * 2.4 - 600"));
        assertTrue(bm.mathCheck("What's 1 + 1?"));
        assertTrue(bm.mathCheck("Tell me what 5 * (64 - 32) is."));
        assertTrue(bm.mathCheck("2 * (2,5 + 3,567 / (26 - 12 * 2) - 5 - 5 * -1,333) + 0,5"));
    }

    @Test
    public void mathCheckWorks2() {

        assertFalse(bm.mathCheck("+5"));
        assertFalse(bm.mathCheck("/+*"));
        assertFalse(bm.mathCheck("-2,50000"));
        assertFalse(bm.mathCheck("+"));
        assertFalse(bm.mathCheck("0 -"));
        assertFalse(bm.mathCheck("dgaskndgjknag +5"));
        assertFalse(bm.mathCheck("-5-"));
        assertFalse(bm.mathCheck("I have 79 dogs."));
    }

    @Test
    public void symbolCheckWorks() {

        assertFalse(bm.symbolCheck("*"));
        assertFalse(bm.symbolCheck("+600"));
        assertFalse(bm.symbolCheck("-700"));
        assertFalse(bm.symbolCheck("no symbols whatsoever"));
        assertTrue(bm.symbolCheck("no symbols whatsoever oh look /"));

        assertTrue(bm.symbolCheck("-700+"));
        assertTrue(bm.symbolCheck("++"));
        assertTrue(bm.symbolCheck("1.2 * 2.4 - 600"));
    }

    @Test
    public void expressionIsEmptyWhenNoNumbersOrSymbolsUsed() {

        assertEquals(bm.createMathExpression("abcdefgGHGHGH"), "");
        assertEquals(bm.createMathExpression("and by symbols i dont mean ones like these ^}%&#¤"), "");
        assertEquals(bm.createMathExpression("This sentence'll definitely be empty."), "");
    }

    @Test
    public void expressionIsNotEmptyWhenNumbersOrSymbolsUsed() {

        assertEquals(bm.createMathExpression("abcdefgGHGHGH45000"), "45000");
        assertEquals(bm.createMathExpression("0123456789-+*/()"), "0123456789-+*/()");
        assertEquals(bm.createMathExpression("This sentence won't be empty because 20 * 0."), "20*0");
        assertEquals(bm.createMathExpression("Tell me what 5 * (64 - 32) is."), "5*(64-32)");
        assertEquals(bm.createMathExpression("2 * (2,5 + 3,567 / (26 - 12 * 2) - 5 - 5 * -1,333) + 0,5"), "2*(2.5+3.567/(26-12*2)-5-5*-1.333)+0.5");
        assertEquals(bm.createMathExpression("fn5/*FNE67...2J8"), "5/*67...28");
    }

    @Test
    public void commasReplacedByPeriodsWhenExpressionIsCreated() {

        assertEquals(bm.createMathExpression("5,6"), "5.6");
        assertEquals(bm.createMathExpression("4,56888 + 2.4 * 13,7"), "4.56888+2.4*13.7");
        assertEquals(bm.createMathExpression("1,2,3,4,5,6.8.4.5"), "1.2.3.4.5.6.8.4.5");
    }

    @Test
    public void ifLineStartsWithCommaOrPeriodItIsRemoved() {

        assertEquals(bm.createMathExpression(".,,,5,6"), "5.6");
        assertEquals(bm.createMathExpression(".....4,56888 + 2.4 * 13,7"), "4.56888+2.4*13.7");
        assertEquals(bm.createMathExpression(".000"), "000");
        assertEquals(bm.createMathExpression("."), "");
        assertEquals(bm.createMathExpression("............"), "");
        assertEquals(bm.createMathExpression(","), "");
        assertEquals(bm.createMathExpression("...yep"), "");
    }

    @Test
    public void ifLineEndsWithCommaOrPeriodItIsRemoved() {

        assertEquals(bm.createMathExpression("5,6....,,,,,"), "5.6");
        assertEquals(bm.createMathExpression("4,56888 + 2.4 * 13,7....."), "4.56888+2.4*13.7");
        assertEquals(bm.createMathExpression("e.m.ptiness..."), "");
        assertEquals(bm.createMathExpression("i hate when people accidentally do this,,,"), "");
        assertEquals(bm.createMathExpression("1, 2, 3, 4, 5 + 6,"), "1.2.3.4.5+6");
    }

    @Test
    public void cannotDivideByZero() {

        assertEquals(bm.doMath("1 / 0"), "DO NOT DIVIDE BY ZERO! EVER!");
        assertEquals(bm.doMath("-1 / 0"), "DO NOT DIVIDE BY ZERO! EVER!");
        assertEquals(bm.doMath("-2 / -0"), "DO NOT DIVIDE BY ZERO! EVER!");
        assertEquals(bm.doMath("333 / (2 - 2) + 4"), "DO NOT DIVIDE BY ZERO! EVER!");
        assertEquals(bm.doMath("0 / 0"), "Are you trying to kill me or something?");
    }

    @Test
    public void minusZeroTurnsIntoZero() {

        assertEquals(bm.doMath("0 / -2"), "0.");
        assertEquals(bm.doMath("0.000 / -4,606"), "0.");
    }

    @Test
    public void erroneousExpressionReturnsError() {

        assertEquals(bm.doMath("0 /"), "ERROR");
        assertEquals(bm.doMath("dgsdgssgfhs"), "ERROR");
        assertEquals(bm.doMath("45 * kek"), "ERROR");
        assertEquals(bm.doMath("one * two plus 450"), "ERROR");
    }
}
