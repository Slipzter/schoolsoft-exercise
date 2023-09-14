import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.StringHandler;

import java.util.List;

public class StringHandlerTests {

    private StringHandler stringHandler;

    @BeforeEach
    public void setUp() {
        stringHandler = new StringHandler();
    }

    @Test
    public void reverseStringShouldReverseString() {
        String input1 = "Hello";
        String input2 = "World";
        String result1 = stringHandler.reverseString(input1);
        String result2 = stringHandler.reverseString(input2);
        Assertions.assertEquals("olleH", result1);
        Assertions.assertEquals("dlroW", result2);
    }

    @Test
    public void isStringPalindromeShouldDetectPalindrome() {
        String input1 = "Abba";
        String input2 = "Abrakadabra";
        String input3 = "Saippuakivikauppias";
        boolean result1 = stringHandler.isStringPalindrome(input1);
        boolean result2 = stringHandler.isStringPalindrome(input2);
        boolean result3 = stringHandler.isStringPalindrome(input3);
        Assertions.assertTrue(result1);
        Assertions.assertFalse(result2);
        Assertions.assertTrue(result3);
    }

    @Test
    public void stringToIntListShouldReturnListOfIntegers() {
        String input1 = "123";
        String input2 = "1,2,3,4,5,666";
        List<Integer> result1 = stringHandler.stringToIntList(input1);
        List<Integer> result2 = stringHandler.stringToIntList(input2);
        Assertions.assertEquals(Integer.class, result1.get(0).getClass());
        Assertions.assertEquals(1, result1.size());
        Assertions.assertEquals(6, result2.size());
        Assertions.assertEquals(666, result2.get(result2.size() - 1));

    }
}
