package seminar04Test;

import seminar04.PaymentGateway;

// Просто пустой класс-фиктивный объект
public class DummyPaymentGateway implements PaymentGateway {


    @Override
    public boolean processPayment(double amount) {
        // Не выполняем никаких действий, просто фиктивный объект
        return true; }
}
