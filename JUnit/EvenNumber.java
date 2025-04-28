import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class EvenNumber {


    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6})
    public void testIsEvenWithEvenNumbers(int number) {
        assertTrue(isEven(number), number + " should be even");
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 9})
    public void testIsEvenWithOddNumbers(int number) {
        assertFalse(isEven(number), number + " should be odd");
    }
}
