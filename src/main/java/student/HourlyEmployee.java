package student;

import java.math.BigDecimal;

/**
 * The HourlyEmployee class represents an employee who is paid on an hourly basis.
 */
public class HourlyEmployee extends Employee {

    /**
     * Constructs an HourlyEmployee with the specified details.
     *
     * @param name              the name of the employee
     * @param id                the identification number of the employee
     * @param payRate           the hourly pay rate for the employee
     * @param ytdEarnings       the year-to-date earnings of the employee
     * @param ytdTaxesPaid      the year-to-date taxes paid by the employee
     * @param pretaxDeductions  the pre-tax deductions for the employee
     */
    public HourlyEmployee(String name, String id, double payRate,
                          double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
        this.employeeType = "HOURLY";
    }

    /**
     * Calculates the gross pay for an hourly employee based on the number of hours worked.
     *
     * @param hoursWorked the number of hours worked
     * @return the calculated gross pay as a BigDecimal
     */
    @Override
    protected BigDecimal calculateGrossPay(double hoursWorked) {
        // Separate the hours into regular hours (up to 40) and overtime hours (beyond 40)
        BigDecimal regularHours = BigDecimal.valueOf(Math.min(40, hoursWorked));
        BigDecimal overtimeHours = BigDecimal.valueOf(Math.max(hoursWorked - 40, 0));

        // Calculate regular pay based on the hourly rate
        BigDecimal regularPay = regularHours.multiply(BigDecimal.valueOf(getPayRate()));

        // Calculate overtime pay at 1.5 times the hourly rate
        BigDecimal overtimePay = overtimeHours.multiply(BigDecimal.valueOf(getPayRate() * 1.5));

        // Sum regular and overtime pay to determine the total gross pay
        BigDecimal totalPay = regularPay.add(overtimePay);

        return totalPay;
    }
}
