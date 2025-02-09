package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Employee implements IEmployee {
    private String name;
    private String id;
    protected String employeeType;
    private double payRate;
    private double ytdEarnings;
    private double ytdTaxesPaid;
    private double pretaxDeductions;

    public Employee(String name, String id, double payRate, double ytdEarnings, double ytdTaxesPaid, double pretaxDeductions) {
        if (payRate < 0 || ytdEarnings < 0 || ytdTaxesPaid < 0 || pretaxDeductions < 0) {
            throw new IllegalArgumentException("Negative values not allowed");
        }
        this.name = name;
        this.id = id;
        this.payRate = payRate;
        this.ytdEarnings = ytdEarnings;
        this.ytdTaxesPaid = ytdTaxesPaid;
        this.pretaxDeductions = pretaxDeductions;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getID() {
        return this.id;
    }

    @Override
    public double getPayRate() {
        return this.payRate;
    }

    @Override
    public String getEmployeeType() {
        return this.employeeType;
    }

    @Override
    public double getYTDEarnings() {
        return this.ytdEarnings;
    }

    @Override
    public double getYTDTaxesPaid() {
        return this.ytdTaxesPaid;
    }

    @Override
    public double getPretaxDeductions() {
        return this.pretaxDeductions;
    }

    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            return null;
        }

        // Calculate Gross pay
        BigDecimal grossPay = calculateGrossPay(hoursWorked).setScale(2, RoundingMode.HALF_UP);
        // Calculate net before tax
        BigDecimal pretax = BigDecimal.valueOf(pretaxDeductions);
        BigDecimal netBeforeTax = grossPay.subtract(pretax);
        // Calculate the taxes
        BigDecimal taxRate = new BigDecimal("0.2265");
        BigDecimal taxes = netBeforeTax.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
        // Calculate net pay
        BigDecimal netPay = netBeforeTax.subtract(taxes)
                .setScale(2, RoundingMode.HALF_UP);

        //update YTD value
        this.ytdEarnings += grossPay.doubleValue();
        this.ytdTaxesPaid += taxes.doubleValue();

        return new PayStub(name, netPay.doubleValue(), taxes.doubleValue(), this.ytdEarnings, this.ytdTaxesPaid);
    }

    protected abstract BigDecimal calculateGrossPay(double hoursWorked);

    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                employeeType, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
    }
}
