package model;

public class Customer {

    private static int counter = 1;

    private int id;
    private String fullName;
    private String phoneNumber;
    private double debt;
    private boolean identified;

    public Customer(String fullName, String phoneNumber, double debt, boolean identified) {
        this.id = counter++;
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.debt = debt;
        this.identified = identified;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean isIdentified() {
        return identified;
    }

    public void setIdentified(boolean identified) {
        this.identified = identified;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() { 
        return this.id + ". "
                + this.fullName + " "
                + getBadge(this.identified) + " | "
                + this.debt + " | "
                + "+998" + this.phoneNumber;
    }

    private String getBadge(boolean identified) {
        return identified ? "✅" : "❌";
    }
}