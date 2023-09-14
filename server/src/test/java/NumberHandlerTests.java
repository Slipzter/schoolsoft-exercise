import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import util.NumberHandler;

import java.util.ArrayList;
import java.util.List;

public class NumberHandlerTests {

    private NumberHandler numberHandler;

    @BeforeEach
    public void setUp() {
        numberHandler = new NumberHandler();
    }

    @Test
    public void addZerosShouldAddZeroToTheLeftOfInput() {
        int input = 12345;
        String result = numberHandler.addZeros(input);
        Assertions.assertEquals("012345", result);
    }

    @Test
    public void addZerosShouldAddCorrectAmountOfZeros() {
        int input1 = 1234;
        int input2 = 2;
        String result1 = numberHandler.addZeros(input1);
        String result2 = numberHandler.addZeros(input2);
        Assertions.assertEquals("001234", result1);
        Assertions.assertEquals(6, result1.length());
        Assertions.assertEquals("00", String.join("", result1.split("1234")));
        Assertions.assertEquals("00000", String.join("", result2.split("2")));
        Assertions.assertEquals("2", String.join("", result2.split("0")));
    }

    @Test
    public void nthLargestNumberShouldReturnNthLargestNumber() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(2);
        integerList.add(45);
        integerList.add(123);
        int nthNumber1 = 1;
        int nthNumber2 = 2;
        String result1 = numberHandler.nthLargestNumber(integerList, nthNumber1);
        String result2 = numberHandler.nthLargestNumber(integerList, nthNumber2);
        Assertions.assertEquals("123", result1);
        Assertions.assertEquals("45", result2);
    }





}
