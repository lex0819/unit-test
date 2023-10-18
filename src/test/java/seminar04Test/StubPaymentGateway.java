package seminar04Test;

import seminar04.PaymentGateway;

// Заглушка, всегда возвращает успешное выполнение платежа
public class StubPaymentGateway implements PaymentGateway {
    /**
     * @param amount сумма платежа
     * @return если сумма больше нуля - возвращаем true, иначе возвращаем false
     */
    @Override
    public boolean processPayment(double amount) { return amount > 0; }
}
