package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HourlyEmployeeTest {
    private HourlyEmployee employee;

    @BeforeEach
    void setUp() {
        this.employee = new HourlyEmployee("Luffy", "s192", 30, 20000, 4530, 0);
    }

    @Test
    void constructor_NegativePayRate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("Luffy", "s192", -30, 20000, 4530, 0);
        });
    }

    @Test
    void constructor_NegativeYTDEarnings() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("Luffy", "s192", 30, -20000, 4530, 0);
        });
    }

    @Test
    void constructor_NegativeYTDTaxes() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("Luffy", "s192", 30, 20000, -4530, 0);
        });
    }

    @Test
    void constructor_NegativePretaxDeductions() {
        assertThrows(IllegalArgumentException.class, () -> {
            new HourlyEmployee("Luffy", "s192", 30, 20000, 4530, -20);
        });
    }

    @Test
    void getName() {
        assertEquals("Luffy", employee.getName());
    }

    @Test
    void getID() {
        assertEquals("s192", employee.getID());
    }

    @Test
    void getPayRate() {
        assertEquals(30, employee.getPayRate());
    }

    @Test
    void getEmployeeType_AlwaysReturnsHourly() {
        assertEquals("Hourly", employee.getEmployeeType());
    }

    @Test
    void getYTDEarnings() {
        assertEquals(20000, employee.getYTDEarnings());
    }

    @Test
    void getYTDTaxesPaid() {
        assertEquals(4530, employee.getYTDTaxesPaid());
    }

    @Test
    void getPretaxDeductions() {
        assertEquals(0, employee.getPretaxDeductions());
    }




//    @Test
//    void runPayroll() {
//    }
//
//    @Test
//    void toCSV() {
//    }
}