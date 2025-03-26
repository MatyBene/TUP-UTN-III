package models;

public abstract class PhysicalPayment extends Payment implements I_Payment {

    public PhysicalPayment(String id, String name, String lastName, double amount) {
        super(id, name, lastName, amount);
    }

}
