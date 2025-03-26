package service;

import java.util.ArrayList;
import java.util.List;

public class PaymentManager<T> implements I_PaymentManager<T> {

    private List<T> payments = new ArrayList<>();

    @Override
    public void addPayment(T payment) {
        payments.add(payment);
    }

    @Override
    public void processPayments() {

    }
}
