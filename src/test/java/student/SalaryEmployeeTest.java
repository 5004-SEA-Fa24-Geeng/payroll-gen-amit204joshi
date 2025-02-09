package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryEmployeeTest {

    SalaryEmployee employee1;

    @BeforeEach
    void setUp() {
        employee1 = new SalaryEmployee("Tony", "A001",240000, 0,0,500);
    }

    @Test
    void getName() {
        assertEquals("Tony", employee1.getName());
    }

    @Test
    void getID() {
        assertEquals("A001", employee1.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(240000, employee1.getPayRate());
    }

    @Test
    void getEmployeeType() {
        assertEquals("SALARY", employee1.getEmployeeType());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(0, employee1.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(0, employee1.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(500, employee1.getPretaxDeductions());
    }

    @Test
    void testInvalidSetUp() {
        assertThrows(IllegalArgumentException.class, () -> new HourlyEmployee("Tony", "A001",-240000, 0,0,500));
        assertThrows(IllegalArgumentException.class, () -> new HourlyEmployee("Tony", "A001",240000, -2,0,500));
        assertThrows(IllegalArgumentException.class, () -> new HourlyEmployee("Tony", "A001",240000, 0,-5,500));
        assertThrows(IllegalArgumentException.class, () -> new HourlyEmployee("Tony", "A001",240000, 0,0,-500));
    }

    @Test
    public void testRunPayroll() {
        double hoursWorked = 30.0;
        IPayStub stub = employee1.runPayroll(hoursWorked);
        assertNotNull(stub);

        double expectedNetPay = 7348.25;
        double expectedTaxes = 2151.75;
        assertEquals(expectedNetPay, stub.getPay());
        assertEquals(expectedTaxes, stub.getTaxesPaid());

        assertEquals(expectedNetPay, employee1.getYTDEarnings());
        assertEquals(expectedTaxes, employee1.getYTDTaxesPaid());
    }


    @Test
    public void testRunPayrollNegativeHours() {
        IPayStub stub = employee1.runPayroll(-10.0);
        assertNull(stub);
    }

    @Test
    public void testToCSV() {
        assertEquals("SALARY,Tony,A001,240000.00,500.00,0.00,0.00", employee1.toCSV());
    }
}