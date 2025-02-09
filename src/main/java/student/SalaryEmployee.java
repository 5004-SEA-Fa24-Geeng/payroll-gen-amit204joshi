package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * The SalaryEmployee class represents an employee with a fixed salary.
 */
public class SalaryEmployee extends Employee {

    /**
     * Constructs a SalaryEmployee with the specified details.
     *
     * @param name             the name of the employee
     * @param id               the identification number of the employee
     * @param payRate          the salary or pay rate of the employee
     * @param ytdEarnings      the year-to-date earnings of the employee
     * @param ytdTaxesPaid     the year-to-date taxes paid by the employee
     * @param pretaxDeductions the pre-tax deductions for the employee
     */
    public SalaryEmployee(String name, String id, double payRate,
                          double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(name, id, payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
        setEmployeeType("SALARY");
    }

    /**
     * Calculates the gross pay for a salary employee.
     *
     * @param hoursWorked the number of hours worked
     * @return the calculated gross pay as a BigDecimal
     */
    @Override
    protected BigDecimal calculateGrossPay(double hoursWorked) {
        // Calculate daily pay rate by dividing the pay rate by 24
        BigDecimal totalPay = BigDecimal.valueOf(getPayRate())
                .divide(BigDecimal.valueOf(24), 2, RoundingMode.HALF_UP);
        return totalPay;
    }
}
