package follybot.response.codelanguage;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CodeLanguageTest {

    CodeLanguage cl;

    public CodeLanguageTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        this.cl = new CodeLanguage();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void normalToCodeWorks() {

        assertEquals("€´eA4A#q€#qo#4eA4~F!A#", cl.normalToCode("this sentence is false"));
        assertEquals("4</@+\\hZRö*,m>=\"(rLu_HPgI9^Fno;#~Ä´ecÅ!Vq5-iGA€vDpb.S Wå&wCUa8jMX?J%B3OäEQTf2ydYKs$7zÖ1)|N6:ktxl'", cl.normalToCode(" ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789.,!?^_:;´~<>åäöÅÄÖ\"*'/+-\\()&%#@|€$="));
    }

    @Test
    public void codeToNormalWorks() {

        assertEquals("this sentence is false", cl.codeToNormal("€´eA4A#q€#qo#4eA4~F!A#"));
        assertEquals(" ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456789.,!?^_:;´~<>åäöÅÄÖ\"*'/+-\\()&%#@|€$=", cl.codeToNormal("4</@+\\hZRö*,m>=\"(rLu_HPgI9^Fno;#~Ä´ecÅ!Vq5-iGA€vDpb.S Wå&wCUa8jMX?J%B3OäEQTf2ydYKs$7zÖ1)|N6:ktxl'"));
    }

    @Test
    public void unknownCharacterIsAQuestionMark() {

        assertEquals("?", cl.normalToCode("µ"));
    }

    @Test
    public void unknownCharacterToNormalIsEmpty() {

        assertEquals("", cl.codeToNormal("µ"));
    }

    @Test
    public void codeToNormalListCatchesException() {

        ArrayList<String> list = cl.codeToNormalList("file lmao");
        assertTrue(list.isEmpty());
    }

    @Test
    public void codeToNormalListReadsExistingFile() {

        ArrayList<String> list = cl.codeToNormalList("src/main/java/follybot/response/files/names.txt");
        assertFalse(list.isEmpty());
    }
}
