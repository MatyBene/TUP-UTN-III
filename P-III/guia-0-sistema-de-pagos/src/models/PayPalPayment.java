package models;

public class PayPalPayment extends VirtualPayment{

    public PayPalPayment(String id, String name, String lastName, double amount, String email) {
        super(id, name, lastName, amount, email);
    }

    @Override
    public void process() {

    }

    @Override
    public String getPaymentMethod() {
        return "Paypal";
    }
}
