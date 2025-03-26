package models;

public abstract class VirtualPayment extends Payment implements I_Payment {

    protected String email;

    public VirtualPayment(String id, String name, String lastName, double amount, String email) {
        super(id, name, lastName, amount);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
