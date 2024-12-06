package com.pluralsight.dealership;

abstract public class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private int customerID;
    private Vehicle vehicle;

    public String getDate() {
        return date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public int getCustomerID() {
        return customerID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    private double totalPrice;
    private double monthlypayment;

    public Contract(String date, String customerName, String customerEmail, int customerID, Vehicle vehicle, double totalPrice, double monthlypayment) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerID = customerID;
        this.vehicle = vehicle;
        this.totalPrice = getTotalPrice();
        this.monthlypayment = getMonthlyPayment();
    }
    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();
    public abstract String contractFormatting(Contract contract, Vehicle vehicle);
}
