package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {

    HourlyEmployee employee1;

    @BeforeEach
    void setUp() {
        employee1 = new HourlyEmployee("Tony", "A001",20, 0,0,50);
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
        assertEquals(20, employee1.getPayRate());
    }

    @Test
    void getEmployeeType() {
        assertEquals("HOURLY", employee1.getEmployeeType());
    }

    @Test
    void setEmployeeType() {
        employee1.setEmployeeType("SALARY");
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
        assertEquals(50, employee1.getPretaxDeductions());
    }

    @Test
    void testInvalidSetUp() {
        assertThrows(IllegalArgumentException.class, () -> new HourlyEmployee("Tony", "A001",-20, 0,0,50));
        assertThrows(IllegalArgumentException.class, () -> new HourlyEmployee("Tony", "A001",20, -2,0,50));
        assertThrows(IllegalArgumentException.class, () -> new HourlyEmployee("Tony", "A001",20, 0,-5,50));
        assertThrows(IllegalArgumentException.class, () -> new HourlyEmployee("Tony", "A001",20, 0,0,-50));
    }

    @Test
    public void testRunPayrollRegularHours() {
        double hoursWorked = 30.0;
        IPayStub stub = employee1.runPayroll(hoursWorked);
        assertNotNull(stub);

        double expectedNetPay = 425.43;
        double expectedTaxes = 124.58;
        assertEquals(expectedNetPay, stub.getPay());
        assertEquals(expectedTaxes, stub.getTaxesPaid());

        assertEquals(expectedNetPay, employee1.getYTDEarnings());
        assertEquals(expectedTaxes, employee1.getYTDTaxesPaid());
    }

    @Test
    public void testRunPayrollOvertimeHours() {
        double hoursWorked = 45.0;
        IPayStub stub = employee1.runPayroll(hoursWorked);
        assertNotNull(stub);

        double expectedNetPay = 696.15;
        double expectedTaxes = 203.85;
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
        assertEquals("HOURLY,Tony,A001,20.00,50.00,0.00,0.00", employee1.toCSV());
    }
}