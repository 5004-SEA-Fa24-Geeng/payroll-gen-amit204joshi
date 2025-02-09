package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The Employee abstract class represents a generic employee and provides common properties
 * and functionalities for processing payroll.
 */
public abstract class Employee implements IEmployee {

    /**
     * The employee's name.
     */
    private String name;

    /**
     * The employee's id number.
     */
    private String id;

    /**
     * The type of employee.
     */
    private String employeeType;

    /**
     * The pay rate of the employee.
     */
    private double payRate;

    /**
     * The employee's year-to-date earnings.
     */
    private double ytdEarnings;

    /**
     * The employee's year-to-date taxes paid.
     */
    private double ytdTaxesPaid;

    /**
     * The pre-tax deductions applied to the employee's earnings.
     */
    private double pretaxDeductions;

    /**
     * Constructs a new Employee with the specified details.
     *
     * @param name             the name of the employee
     * @param id               the identification number of the employee
     * @param payRate          the pay rate of the employee
     * @param ytdEarnings      the year-to-date earnings of the employee
     * @param ytdTaxesPaid     the year-to-date taxes paid by the employee
     * @param pretaxDeductions the pre-tax deductions for the employee
     * @throws IllegalArgumentException if any of the numeric parameters are negative
     */
    public Employee(String name, String id, double payRate, double ytdEarnings,
                    double ytdTaxesPaid, double pretaxDeductions) {
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

    /**
     * Returns the employee's name.
     *
     * @return the employee's name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the employee's id number.
     *
     * @return the employee's ID
     */
    @Override
    public String getID() {
        return this.id;
    }

    /**
     * Returns the employee's pay rate.
     *
     * @return the pay rate
     */
    @Override
    public double getPayRate() {
        return this.payRate;
    }

    /**
     * Returns the employee type.
     *
     * @return the employee type
     */
    @Override
    public String getEmployeeType() {
        return this.employeeType;
    }

    /**
     * Set the employee type
     *
     * @param employeeType the employee type to be set
     */

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    /**
     * Returns the employee's year-to-date earnings.
     *
     * @return the year-to-date earnings
     */
    @Override
    public double getYTDEarnings() {
        return this.ytdEarnings;
    }

    /**
     * Returns the employee's year-to-date taxes paid.
     *
     * @return the year-to-date taxes paid
     */
    @Override
    public double getYTDTaxesPaid() {
        return this.ytdTaxesPaid;
    }

    /**
     * Returns the employee's pre-tax deductions.
     *
     * @return the pre-tax deductions
     */
    @Override
    public double getPretaxDeductions() {
        return this.pretaxDeductions;
    }

    /**
     * Processes the payroll for the employee based on the number of hours worked.
     *
     * @param hoursWorked the number of hours worked by the employee
     * @return an IPayStub containing the payroll details, or null if hoursWorked is negative
     */
    @Override
    public IPayStub runPayroll(double hoursWorked) {
        if (hoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative");
        }

        // Calculate gross pay based on the employee's specific compensation structure.
        BigDecimal grossPay = calculateGrossPay(hoursWorked);
        // Subtract pre-tax deductions to determine net pay before taxes.
        BigDecimal pretax = BigDecimal.valueOf(pretaxDeductions);
        BigDecimal netBeforeTax = grossPay.subtract(pretax);
        // Calculate taxes using a fixed tax rate of 22.65%.
        BigDecimal taxRate = new BigDecimal("0.2265");
        BigDecimal taxes = netBeforeTax.multiply(taxRate);
        // Calculate net pay by subtracting taxes from net before tax.
        BigDecimal netPay = netBeforeTax.subtract(taxes);

        // Update year-to-date earnings and taxes paid.
        this.ytdEarnings = BigDecimal.valueOf(this.ytdEarnings)
                .add(netPay)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
        this.ytdTaxesPaid = BigDecimal.valueOf(this.ytdTaxesPaid)
                .add(taxes)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        return new PayStub(
                name,
                netPay.setScale(2, RoundingMode.HALF_UP).doubleValue(),
                taxes.setScale(2, RoundingMode.HALF_UP).doubleValue(),
                this.ytdEarnings,
                this.ytdTaxesPaid
        );
    }

    /**
     * Calculates the gross pay for the employee based on the number of hours worked.
     *
     * @param hoursWorked the number of hours worked by the employee
     * @return the gross pay as a BigDecimal
     */
    protected abstract BigDecimal calculateGrossPay(double hoursWorked);

    /**
     * Returns a CSV (Comma-Separated Values) representation of the employee's details.
     * The CSV string includes the employee type, name, ID, pay rate, pre-tax deductions, year-to-date earnings,
     * and year-to-date taxes paid, formatted accordingly.
     *
     * @return a CSV formatted string representing the employee's details
     */
    @Override
    public String toCSV() {
        return String.format("%s,%s,%s,%.2f,%.2f,%.2f,%.2f",
                employeeType, name, id, payRate, pretaxDeductions, ytdEarnings, ytdTaxesPaid);
    }
}
