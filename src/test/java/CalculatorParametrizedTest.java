import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorParametrizedTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp(){
        calculator = new Calculator();
    }

    public static int[][] data() {
        return new int[][] { { 1 , 2, 2 }, { 5, 3, 15 }, { 121, 4, 484 } };
    }

    @ParameterizedTest
    @MethodSource(value = "data")
    void testWithMethodSourceParameter(int[] data) {
        int m1 = data[0];
        int m2 =  data[1];
        int expected = data[2];
        assertEquals(expected, calculator.multiply(m1, m2));
    }

    @ParameterizedTest
    @ValueSource(ints = { 5, 3, 15 }) //can take only one parameter per test
    void testWithValueSourceParameter(int value) {
        int m1 = value;
        int expected = value * 5;
        assertEquals(expected, calculator.multiply(m1, 5));
    }

    @ParameterizedTest
    @CsvSource(value = { "1, 2, 2 ", "5, 3, 15", "121, 4, 484" })
    void testWithCsvSourceParameter(int first, int second, int result) {
        int m1 = first;
        int m2 = second;
        int expected = result;
        assertEquals(expected, calculator.multiply(m1, m2));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/testData.csv", numLinesToSkip = 1)
    void testWithCsvFileSourceParameter(int first, int second, int result) {
        int m1 = first;
        int m2 = second;
        int expected = result;
        assertEquals(expected, calculator.multiply(m1, m2));
    }
}