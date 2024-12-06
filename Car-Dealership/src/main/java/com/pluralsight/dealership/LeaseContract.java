package com.pluralsight.dealership;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leasefee;

    public LeaseContract(String date, String customerName, String customerEmail, int customerID, Vehicle vehicle, double totalPrice, double monthlypayment, double expectedEndingValue, double leasefee) {
        super(date, customerName, customerEmail, customerID, vehicle, totalPrice, monthlypayment);
    }

    @Override
    public double getTotalPrice() {
        return (getVehicle().getPrice() + leasefee ) +(getVehicle().getPrice()+0.04);
    }

    @Override
    public double getMonthlyPayment() {
        return Math.round((getTotalPrice()/36) *100.0) /100.0;
    }

    @Override
    public String contractFormatting(Contract contract, Vehicle vehicle) {
        return String.format("LEASE |%-15s|%-15s|%-15s|%-15d|%-15d|%-15s|%-15s|%-15s|%-15s|%-15d|%-15.2s|%-15.2s|%-15.2f|%-15.2f|%-15.2f|%-15.2f",
                contract.getDate(), contract.getCustomerName(), contract.getCustomerEmail(), vehicle.getVin(), vehicle.getYear(), vehicle.getMake(),
                vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), contract.getCustomerID(), vehicle.getPrice(),
                getLeasefee(), contract.getTotalPrice(), contract.getMonthlyPayment());
    }
    public double getExpectedEndingValue(Vehicle vehicle){
        return vehicle.getPrice() * 0.5;
    }

    public double getLeasefee() {
        leasefee = Math.round(getVehicle().getPrice() * 0.07);
        return leasefee;
    }
}
