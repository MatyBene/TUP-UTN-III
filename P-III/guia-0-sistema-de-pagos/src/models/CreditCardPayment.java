package models;

import exceptions.InvalidPaymentException;

import java.util.Date;

public class CreditCardPayment extends PhysicalPayment{

    private String cardNumber;
    private Date expirationDate;

    public CreditCardPayment(String id, String name, String lastName, double amount, String cardNumber, Date expirationDate) {
        super(id, name, lastName, amount);
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    @Override
    public void process() throws InvalidPaymentException {

    }

    @Override
    public String getPaymentMethod() {
        return "Credit card";
    }
}
