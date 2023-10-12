package seminar01.task04;

import org.junit.jupiter.api.*;
import seminar01.task04.Calculator;

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
        System.out.print("Hiii!!!!!");
    }

    @AfterAll
    public static void tearDownAll() {
        System.out.print("END!");    }

    @AfterEach
    public void tearDown() {
        calculator = null; // Очистка после каждого теста
    }

    @Test
    @DisplayName("Проверка равенства значений")
    void testAssertEquals() {
        assertEquals(4, calculator.add(2, 2));
    }

    @Test
    @DisplayName("Проверка неравенства значений")
    void testAssertNotEquals() {
        assertNotEquals(5, calculator.add(2, 2));
    }

    @Test
    @DisplayName("Проверка истинного условия")
    void testAssertTrue() {
        assertTrue(calculator.add(2, 2) == 4);
    }

    @Test
    @DisplayName("Проверка ложного условия")
    void testAssertFalse() {
        assertFalse(calculator.add(2, 2) == 5);
    }

    @Test
    @DisplayName("Проверка наличия объекта")
    void testAssertNotNull() {
        assertNotNull(calculator);
    }

    @Test
    @DisplayName("Проверка отсутствия объекта")
    void testAssertNull() {
        calculator = null;
        assertNull(calculator);
    }

    @Test
    @DisplayName("Проверка равенства массивов")
    void testAssertArrayEquals() {
        int[] expected = {1, 2, 3};
        int[] actual = {1, 2, 3};
        assertArrayEquals(expected, actual);
    }

    @Test
    @DisplayName("Проверка на генерацию исключений")
    void testAssertThrows() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(1, 0));
    }

    // Дополнительные ассерты
    @Test
    @DisplayName("Проверка с сообщением")
    void testAssertWithMessage() {
        assertEquals(4, calculator.add(2, 2), "2 + 2 должно быть равно 4");
    }

    @Test
    @DisplayName("Проверка с использованием лямбда-выражения для сообщения")
    void testAssertWithLambdaMessage() {
        assertEquals(4, calculator.add(2, 2), () -> "2 + 2 должно быть равно 4");
    }

    @Test
    @DisplayName("Проверка метода calculateDiscount для вычисления скидки по сумме покупки и проценту")
    void testCalculateDiscountCorrect() {

        double res = calculator.calculateDiscount(500, 20);
        assertThat(res).isEqualTo(400);

        res = calculator.calculateDiscount(1100, 10 );
        assertThat(res).isEqualTo(990);
    }

    @Test
    @DisplayName("Проверка метода calculateDiscount c некорректными аргументами")
    void testCalculateDiscountIncorrect() {
        // sum <= 0
        assertThatThrownBy(() -> calculator.calculateDiscount(-100, 5))
                .isInstanceOf(ArithmeticException.class);

        // percent <= 0
        assertThatThrownBy(() -> calculator.calculateDiscount(100, -5))
                .isInstanceOf(ArithmeticException.class);

        // percent >= 100
        assertThatThrownBy(() -> calculator.calculateDiscount(100, 150))
                .isInstanceOf(ArithmeticException.class);
    }
}
