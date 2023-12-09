import junit.framework.TestCase;
import org.example.StringProcessor;
import org.junit.Test;

public class CalculatorTest extends TestCase {

    public void testCases(){
        //StringProcessor st = new StringProcessor();
        assertTrue(StringProcessor.isStrongPassword("Sezim@1"));
        assertTrue(StringProcessor.isStrongPassword("Adolf3234*"));
        assertTrue(StringProcessor.isStrongPassword("wtfA@342"));
        assertTrue(StringProcessor.isStrongPassword("Sadf3r3qf*"));
        assertTrue(StringProcessor.isStrongPassword("suJs@1"));

        assertEquals(4, StringProcessor.calculateDigits("1234"));
        assertEquals(6, StringProcessor.calculateDigits("123456"));
        assertEquals(8, StringProcessor.calculateDigits("12345678"));
        assertEquals(9, StringProcessor.calculateDigits("123456789"));
        assertEquals(2, StringProcessor.calculateDigits("12"));
        assertEquals(3, StringProcessor.calculateDigits("124"));

        assertEquals(4, StringProcessor.calculateWords("sezim raheba aruuke amira"));
        assertEquals(1, StringProcessor.calculateWords("sezim"));
        assertEquals(2, StringProcessor.calculateWords("sezim raheba"));
        assertEquals(3, StringProcessor.calculateWords("sezim raheba aruuke"));
        assertEquals(5, StringProcessor.calculateWords("sezim raheba aruuke amira nurperi"));

        assertEquals(0.0, StringProcessor.calculateExpression("1+1-2"));
        assertEquals(380.0, StringProcessor.calculateExpression("18*21+2"));
        assertEquals(60.0, StringProcessor.calculateExpression("18+21*2"));
        assertEquals(14.0, StringProcessor.calculateExpression("2*1+6*2)"));
    }
}
