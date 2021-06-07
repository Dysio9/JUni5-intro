import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    static int counter = 0;
    private Calculator calculator;

    @BeforeAll
    public static void beforeMethod() {
        System.out.println("Testing begin...");
    }

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
        System.out.println("Performing test no: " + ++counter);
    }

    @Test
    @Order(1)
    @DisplayName("First test")
    public void testMultiply() {
        assertEquals(20, calculator.multiply(4,5),
                "Simple multiplication works");
    }

    @Test
    @Order(2)
    @DisplayName("Second test")
//    @Disabled("disabling reason")
    public void testMultiplyGWT() {

// Given
        int first = 2;
        int second = 3;
        int expected = 6;

// When
        int result = calculator.multiply(first, second);

// Then
        assertEquals(expected, result, "Simple multiplication works");
    }

    @RepeatedTest(5)
    @Order(3)
    @DisplayName("Ensure correct handling of zero")
    public void testMultiplyWithZero() {
        assertEquals(0, calculator.multiply(0,5), "Multiple with zero should be zero");
        assertEquals(0, calculator.multiply(5,0), "Multiple with zero should be zero");
    }

    @Test
    @Order(4)
    @DisplayName("Ensure correct handling of zero - Grouped assertion")
    public void testMultiplyWithZeroGroupedAssertion() {
        assertAll(
                () -> assertEquals(0, calculator.multiply(0,5), "Multiple with zero should be zero"),
                () -> assertEquals(0, calculator.multiply(5,0), "Multiple with zero should be zero")
        );
    }

    @AfterAll
    public static void afterMethod() {
        System.out.println("Tests finished");
    }
}