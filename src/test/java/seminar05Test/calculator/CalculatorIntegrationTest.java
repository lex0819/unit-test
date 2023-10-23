package seminar05Test.calculator;

import org.junit.jupiter.api.Test;
import java.util. List;
import static org.junit.jupiter.api.Assertions.assertEquals;

import seminar05.calculator.Calculator;
import seminar05.calculator.Logger;

public class CalculatorIntegrationTest {
    @Test
    public void testCalculatorIntegration(){

        //Создаем тестовый логер
        Logger logger = new Logger();

        //Создаем калькулятор и передаем в него фейковый логер
        Calculator calculator = new Calculator(logger);

        //Выполняем операции с калькулятором
        calculator.add(5,3);
        calculator.subtract(10,4);

        //Получаем логи из логера
        List<String> logs = logger.getLogs();

        //Проверяем что логи записаны правильно
        assertEquals(2, logs.size());
        assertEquals("Сложение: 5 + 3 = 8", logs.get(0));
        assertEquals("Вычитание: 10 - 4 = 6", logs.get(1));
    }


}
