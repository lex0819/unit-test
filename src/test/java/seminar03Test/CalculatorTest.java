package seminar03Test;

import org.junit.jupiter.api.*;
import seminar03.Calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @BeforeAll
    public static void initAll() {
        System.out.print("Tests have started");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.print("Tests have ended");    }

    @AfterEach
    public void tearDown() {
        calculator = null; // Очистка после каждого теста
    }

    @Test
    @DisplayName("Checking evenOddNumber for true")
    public void testEvenOddNumberTrue(){
        assertTrue(calculator.evenOddNumber(12));
    }

    @Test
    @DisplayName("Checking evenOddNumber for false")
    public void testEvenOddNumberFalse(){
        assertFalse(calculator.evenOddNumber(11));
    }

    @Test
    @DisplayName("Checking does the transmitted number fall within the interval (25;100)")
    public void testNumberInIntervalTrue(){
        assertTrue(calculator.numberInInterval(50));
    }

    @Test
    @DisplayName("Checking doesn't the transmitted number fall within the interval (25;100)")
    public void testNumberInIntervalFalse(){
        assertFalse(calculator.numberInInterval(20));
    }

    @Test
    @DisplayName("Checking the minimum interval (25;100) boundary")
    public void testNumberInIntervalMin(){
        assertFalse(calculator.numberInInterval(25));
    }

    @Test
    @DisplayName("Checking the maximum interval (25;100) boundary")
    public void testNumberInIntervalMax(){
        assertFalse(calculator.numberInInterval(100));
    }
}
