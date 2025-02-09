package student;

import java.math.BigDecimal;

public class HourlyEmployee extends Employee {
    public HourlyEmployee(String name, String id, double payRate,
                          double ytdEarnings, double ytdTaxesPaid,
                          double pretaxDeductions) {
        super(name, id,  payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
        this.employeeType = "Hourly";
    }

    @Override
    protected BigDecimal calculateGrossPay(double hoursWorked) {
        // separate working hours
        BigDecimal regularHours = BigDecimal.valueOf(Math.min(40, hoursWorked));
        BigDecimal overtimeHours = BigDecimal.valueOf(Math.max(hoursWorked - 40, 0));
        // calculate two parts of pay
        BigDecimal regularPay = regularHours.multiply(BigDecimal.valueOf(getPayRate()));
        BigDecimal overtimePay = overtimeHours.multiply(BigDecimal.valueOf(getPayRate() * 1.5));
        BigDecimal totalPay = regularPay.add(overtimePay);

        return totalPay;
    }
}
