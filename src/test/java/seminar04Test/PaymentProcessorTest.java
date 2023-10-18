package seminar04Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seminar04.PaymentGateway;
import seminar04.PaymentProcessor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PaymentProcessorTest {

    @Test
    @DisplayName("Checking DummyPaymentGateway for true")
    public void testDummyPaymentGateway(){

        PaymentGateway Dummy = new DummyPaymentGateway();
        PaymentProcessor processor = new PaymentProcessor(Dummy);

        assertTrue(processor.makePayment(1000.0));
    }

    @Test
    @DisplayName("Checking StubPaymentGateway for true and false")
    public void testStubPaymentGateway(){

        PaymentGateway Stub = new StubPaymentGateway();
        PaymentProcessor processor = new PaymentProcessor(Stub);

        assertTrue(processor.makePayment(1000.0));
        assertFalse(processor.makePayment(0.0));
    }

    @Test
    @DisplayName("Checking SpyPaymentGateway for counts of payments")
    public void testSpyPaymentGateway(){

        PaymentGateway Spy = new SpyPaymentGateway();
        PaymentProcessor processor = new PaymentProcessor(Spy);

        //Проверяем результат платежа истина
        assertTrue(processor.makePayment(100.0));

        //Проверяем, что метод makePayment был вызван один раз
        assertEquals(1, ((SpyPaymentGateway) Spy).getPaymentCount());
    }

    @Test
    @DisplayName("Checking FakePaymentGateway for some payments")
    public void testFakePaymentGateway(){

        PaymentGateway Fake = new FakePaymentGateway();
        PaymentProcessor processor = new PaymentProcessor(Fake);

        //Create some payments for the test
        processor.makePayment(100.0);
        processor.makePayment(50.0);
        processor.makePayment(200.0);

        //Получаем историю платежей
        List<Double> paymentHistory = ((FakePaymentGateway) Fake).getPaymentHistory();

        //Проверяем что платежи были записаны правильно
        assertEquals(3, paymentHistory.size());
        assertEquals(100.0, paymentHistory.get(0));
        assertEquals(50.0, paymentHistory.get(1));
        assertEquals(200.0, paymentHistory.get(2));
    }

}
