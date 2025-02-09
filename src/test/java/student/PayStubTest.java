package student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayStubTest {
    private PayStub paystub;

    @BeforeEach
    void setUp() {
        paystub = new PayStub("Jason", 52.22, 44.32, 444.05, 565.63);
    }

    @Test
    void getName() {
        assertEquals("Jason", paystub.getName());
    }

    @Test
    void getPay() {
        assertEquals(52.22, paystub.getPay());
    }

    @Test
    void getTaxesPaid() {
        assertEquals(44.32, paystub.getTaxesPaid());
    }

    @Test
    void getYtdEarnings() {
        assertEquals(444.05, paystub.getYtdEarnings());
    }

    @Test
    void getYtdTaxesPaid() {
        assertEquals(565.63, paystub.getYtdTaxesPaid());
    }

    @Test
    void toCSV() {
        assertEquals("Jason,52.22,44.32,444.05,565.63", paystub.toCSV());
    }
}