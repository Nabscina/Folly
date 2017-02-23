package follybot.response.question;

import follybot.response.ResponseBank;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BotQuestionTest {

    BotQuestion bq;
    ResponseBank rb;

    public BotQuestionTest() {
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
        bq = new BotQuestion(rb);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void polarsListaanLisataanSisaltoa() {

        assertFalse(bq.getPolarsList().isEmpty());
        assertTrue(bq.getPolarsList().contains("do "));
        assertTrue(bq.getPolarsList().contains("can't "));
    }

    @Test
    public void questionCheckTunnistaaKysymyksen() {

        assertTrue(bq.questionCheck("?"));
        assertTrue(bq.questionCheck("is this a question?"));
        assertTrue(bq.questionCheck("WHAT ABOUT THIS IS THIS A QUESTION?????????"));
        assertFalse(bq.questionCheck("this is clearly not a question"));
        assertFalse(bq.questionCheck("is it true that it is not a question if there is no question mark"));
    }

    @Test
    public void questionCheckPoistaaYlimaaraisetValilyonnit() {

        assertTrue(bq.questionCheck("?        "));
        assertTrue(bq.questionCheck("bafjbafsk ? "));
        assertTrue(bq.questionCheck("  ?  ? ?? ? ?  ? "));
        assertFalse(bq.questionCheck("?."));
    }

    @Test
    public void polarQuestionCheckMeneeLapiJosAlkuListassa() {

        assertTrue(bq.polarQuestionCheck("will i die tomorrow?"));
        assertTrue(bq.polarQuestionCheck("will somebody die tomorrow?"));
        assertTrue(bq.polarQuestionCheck("would you eat castor beans for $5000"));
        assertTrue(bq.polarQuestionCheck("is hl3 ever coming out"));
        assertTrue(bq.polarQuestionCheck("can bots fly"));

        assertTrue(bq.getPolarsList().contains("will "));
        assertTrue(bq.getPolarsList().contains("would "));
        assertTrue(bq.getPolarsList().contains("is "));
        assertTrue(bq.getPolarsList().contains("can "));
    }

    @Test
    public void polarQuestionCheckEiMeneLapiMuillaKysymyksilla() {

        assertFalse(bq.polarQuestionCheck("what"));
        assertFalse(bq.polarQuestionCheck("wssdgsgdshsh"));
        assertFalse(bq.polarQuestionCheck("how are you"));
        assertFalse(bq.polarQuestionCheck("where are you"));
        assertFalse(bq.polarQuestionCheck("why"));
        assertFalse(bq.polarQuestionCheck(""));
    }

    @Test
    public void polarQuestionCheckMuuttaaMerkitPieniksi() {

        assertTrue(bq.polarQuestionCheck("IS THIS A YES OR NO QUESTION?"));
        assertTrue(bq.getPolarsList().contains("is "));
    }
    
    @Test
    public void answerQuestionVastaaOsuvasti() {
        
        assertTrue(rbListaSisaltaa(rb.getYesOrNoAnswers(), "Are you me?"));
        assertTrue(rbListaSisaltaa(rb.getOtherAnswers(), "How are you?"));
        assertFalse(rbListaSisaltaa(rb.getYesOrNoAnswers(), "What is your favorite Tamagotchi version?"));
    }
    
    public boolean rbListaSisaltaa(ArrayList<String> lista, String kysymys) {
        
        String vastaus = bq.answerQuestion(kysymys);
        
        for (String s : lista) {
            if (vastaus.contains(s)) {
                return true;
            }
        }
        
        return false;
    }
}
