package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeCardTest {
    private TimeCard timeCard;

    @BeforeEach
    void setUp() {
        timeCard = new TimeCard("s101",52);
    }

    @Test
    void getEmployeeID() {
        assertEquals("s101",timeCard.getEmployeeID());
    }

    @Test
    void getHoursWorked() {
        assertEquals(52,timeCard.getHoursWorked());
    }

    @Test
    void testNegativeTimeCard() {
        assertThrows(IllegalArgumentException.class, () -> new TimeCard("s101",-52));
    }
}