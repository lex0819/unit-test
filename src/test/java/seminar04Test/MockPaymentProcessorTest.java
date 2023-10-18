package seminar04Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import seminar04.*;

public class MockPaymentProcessorTest {

    @Test
    public void testMakePaymentWithSuccessfulPayment(){

        //Создаем мок-объект PaymentGateway
        PaymentGateway mockGateway = mock(PaymentGateway.class);

        //Устанавливаем, что с любой суммой при вызове processPayment должен вернуться true
        when(mockGateway.processPayment(anyDouble())).thenReturn(true);

        //Создаем экземпляр PaymentProcessor, передавая мок-объект
        PaymentProcessor processor = new PaymentProcessor(mockGateway);

        //Вызываем метод makePayment с суммой 100
        boolean result = processor.makePayment(100.0);

        //Проверяем, что метод processPayment был вызван ровно один раз с любой суммой
        verify(mockGateway, times(1)).processPayment(anyDouble());

        //Проверяем результат, который должен быть True
        assertTrue(result);
    }

}
