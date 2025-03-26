package models;

import exceptions.InvalidPaymentException;

public class CashPayment extends PhysicalPayment{

    public CashPayment(String id, String name, String lastName, double amount) {
        super(id, name, lastName, amount);
    }

    @Override
    public void process() throws InvalidPaymentException {

    }

    @Override
    public String getPaymentMethod() {
        return "Cash";
    }
}
