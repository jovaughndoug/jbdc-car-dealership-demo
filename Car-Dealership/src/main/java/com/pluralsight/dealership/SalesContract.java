package com.pluralsight.dealership;

public class SalesContract extends Contract{
    private double salesTax = 0.05;
    private double recordingFee = 100.00;
    private double processingFee;
    private boolean isFinanced;
    private double annualInterestRate;
    private int loanterm;

    public SalesContract(String date, String customerName, String customerEmail, int customerID, Vehicle vehicle, double totalPrice, double monthlypayment, double salesTax, double recordingFee, double processingFee, boolean isFinanced, double annualInterestRate, int loanterm) {
        super(date, customerName, customerEmail, customerID, vehicle, totalPrice, monthlypayment);
        if (vehicle.getPrice()<10000) {
            this.processingFee = 295.00;
        } else {
            this.processingFee = 495.00;
        }
        this.isFinanced = isFinanced;
        if (isFinanced && vehicle.getPrice()>= 10000){
            this.annualInterestRate = 0.0525;
            this.loanterm = 48;
        } else {
            this.annualInterestRate =0.0;
        }
        this.salesTax = salesTax;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;

       // this.annualInterestRate = annualInterestRate;
       // this.loanterm = loanterm;
    }

    @Override
    public double getTotalPrice() {
        return Math.round(getVehicle().getPrice() + salesTax + recordingFee +processingFee);
    }

    @Override
    public double getMonthlyPayment() {
        return getTotalPrice()/loanterm;
    }

    @Override
    public String contractFormatting(Contract contract, Vehicle vehicle) {
        return String.format("SALE |%-15s|%-15s|%-15s|%-15d|%-15d|%-15s|%-15s|%-15s|%-15s|%-15d|%-15.2f|%-15.2f|%-15.2f|%-15.2f|%-15.2f|%-15b|%-15.2f",
        contract.getDate(), contract.getCustomerName(), contract.getCustomerEmail(), vehicle.getVin(), vehicle.getYear(), vehicle.getMake(),
                vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), contract.getCustomerID(), vehicle.getPrice(), salesTax, recordingFee,
                processingFee, getTotalPrice(), isFinanced, annualInterestRate);


    }
}

