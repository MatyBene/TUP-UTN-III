package models;

import exceptions.InvalidPaymentException;

public class CryptoPayment extends VirtualPayment{

    private String walletName;
    private String walletId;

    public CryptoPayment(String id, String name, String lastName, double amount, String email, String walletName, String walletId) {
        super(id, name, lastName, amount, email);
        this.walletName = walletName;
        this.walletId = walletId;
    }

    public String getWalletName() {
        return walletName;
    }

    public String getWalletId() {
        return walletId;
    }

    @Override
    public void process() throws InvalidPaymentException {

    }

    @Override
    public String getPaymentMethod() {
        String message = "Crypto from the " + walletName + " wallet";
        return message;
    }
}
