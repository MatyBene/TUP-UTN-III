package service;

public interface I_PaymentManager<T> {

    void addPayment(T payment);
    void processPayments();

}
