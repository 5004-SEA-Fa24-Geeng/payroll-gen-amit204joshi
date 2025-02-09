package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BuilderTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void testBuildHourlyEmployeeValid() {
        String csv = "HOURLY, Alice, A001, 20.0, 50.0, 0.0, 0.0";
        IEmployee emp = Builder.buildEmployeeFromCSV(csv);
        assertEquals("HOURLY", emp.getEmployeeType());
        assertEquals("Alice", emp.getName());
        assertEquals("A001", emp.getID());
        assertEquals(20.0, emp.getPayRate());
        assertEquals(50.0, emp.getPretaxDeductions());
        assertEquals(0.0, emp.getYTDEarnings());
        assertEquals(0.0, emp.getYTDTaxesPaid());
    }

    @Test
    public void testBuildSalaryEmployeeValid() {
        String csv = "SALARY, Bob, B001, 2400.0, 20.0, 0.0, 0.0";
        IEmployee emp = Builder.buildEmployeeFromCSV(csv);
        assertEquals("SALARY", emp.getEmployeeType());
        assertEquals("Bob", emp.getName());
        assertEquals("B001", emp.getID());
        assertEquals(2400.0, emp.getPayRate());
        assertEquals(20.0, emp.getPretaxDeductions());
        assertEquals(0.0, emp.getYTDEarnings());
        assertEquals(0.0, emp.getYTDTaxesPaid());
    }

    @Test
    public void testBuildEmployeeInvalidType() {
        String csv = "UNKNOWN, Charlie, C001, 100.0, 0.0, 0.0, 0.0";
        assertThrows(IllegalArgumentException.class, () -> Builder.buildEmployeeFromCSV(csv));
    }

    @Test
    public void testBuildEmployeeInvalidNumber() {
        String csv = "HOURLY, Alice, A001, not_a_number, 50.0, 0.0, 0.0";
        assertThrows(IllegalArgumentException.class, () -> Builder.buildEmployeeFromCSV(csv));
    }

    @Test
    public void testBuildEmployeeIncorrectColumns() {
        String csv = "HOURLY, Alice, A001, 20.0";
        assertThrows(IllegalArgumentException.class, () -> Builder.buildEmployeeFromCSV(csv));
    }

    @Test
    public void testBuildEmployeeFromCSV_InvalidType() {
        String csv = "UNKNOWN, Charlie, C001, 100.0, 0.0, 0.0, 0.0";
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Builder.buildEmployeeFromCSV(csv));
    }

    @Test
    public void testBuildEmployeeFromCSV_InvalidNumberFormat() {
        String csv = "HOURLY, Alice, A001, aaa, 50.0, 0.0, 0.0";
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                Builder.buildEmployeeFromCSV(csv));
    }

    @Test
    public void testBuildTimeCardValid() {
        String csv = "A001, 8.0";
        ITimeCard timeCard = Builder.buildTimeCardFromCSV(csv);
        assertEquals("A001", timeCard.getEmployeeID());
        assertEquals(8.0, timeCard.getHoursWorked());
    }

    @Test
    public void testBuildTimeCardIncorrectColumns() {
        String csv = "A001";
        assertThrows(IllegalArgumentException.class, () -> Builder.buildTimeCardFromCSV(csv));
    }

    @Test
    public void testBuildTimeCardInvalidNumber() {
        String csv = "A001, abc";
        assertThrows(IllegalArgumentException.class, () -> Builder.buildTimeCardFromCSV(csv));
    }
}