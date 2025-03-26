package models;

public abstract class Payment {

    protected String id;
    protected String name;
    protected String lastName;
    protected double amount;

    public Payment(String id, String name, String lastName, double amount) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public double getAmount() {
        return amount;
    }
}
