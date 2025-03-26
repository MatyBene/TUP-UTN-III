package models;

import exceptions.InvalidPaymentException;

public interface I_Payment {

    void process() throws InvalidPaymentException;
    String getPaymentMethod();

}
