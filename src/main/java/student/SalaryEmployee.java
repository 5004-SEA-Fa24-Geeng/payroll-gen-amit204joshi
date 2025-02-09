package student;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SalaryEmployee extends Employee {
    public SalaryEmployee(String name, String id, double payRate,
                            double ytdEarnings, double ytdTaxesPaid,
                            double pretaxDeductions) {
        super(name, id,  payRate, ytdEarnings, ytdTaxesPaid, pretaxDeductions);
        this.employeeType = "SALARY";
    }

    @Override
    protected BigDecimal calculateGrossPay(double hoursWorked) {
        // Calculate total pay
        BigDecimal totalPay = BigDecimal.valueOf(getPayRate()).divide(BigDecimal.valueOf(24), 2, RoundingMode.HALF_UP);
        return totalPay;
    }
}
