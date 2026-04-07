import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

// AI generated unit tests:

class CalendarToNewDateAdapterTest {

    private Calendar calendar;
    private CalendarToNewDateAdapter adapter;

    @BeforeEach
    void setUp() {
        calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 15); // 15.1.2023
        adapter = new CalendarToNewDateAdapter(calendar);
    }

    @Test
    void testSetDay_valid() {
        adapter.setDay(10);
        assertEquals(10, adapter.getDay());
    }

    @Test
    void testSetDay_invalidTooHigh() {
        adapter.setDay(32); // tammikuussa max 31
        assertEquals(15, adapter.getDay()); // ei muutu
    }

    @Test
    void testSetDay_invalidTooLow() {
        adapter.setDay(0);
        assertEquals(15, adapter.getDay()); // ei muutu
    }

    @Test
    void testSetMonth_valid() {
        adapter.setMonth(12);
        assertEquals(12, adapter.getMonth());
    }

    @Test
    void testSetMonth_invalidTooHigh() {
        adapter.setMonth(13);
        assertEquals(1, adapter.getMonth()); // alkuperäinen kuukausi
    }

    @Test
    void testSetMonth_invalidTooLow() {
        adapter.setMonth(0);
        assertEquals(1, adapter.getMonth());
    }

    @Test
    void testSetYear_valid() {
        adapter.setYear(2025);
        assertEquals(2025, adapter.getYear());
    }

    @Test
    void testSetYear_invalid() {
        adapter.setYear(0);
        assertEquals(2023, adapter.getYear()); // ei muutu
    }

    @Test
    void testGetters() {
        assertEquals(15, adapter.getDay());
        assertEquals(1, adapter.getMonth());
        assertEquals(2023, adapter.getYear());
    }

    @Test
    void testAdvanceDays_positive() {
        adapter.advanceDays(5);
        assertEquals(20, adapter.getDay());
    }

    @Test
    void testAdvanceDays_negative() {
        adapter.advanceDays(-10);
        assertEquals(5, adapter.getDay());
    }

    @Test
    void testAdvanceDays_monthOverflow() {
        adapter.setDay(30);
        adapter.advanceDays(5); // pitäisi mennä helmikuulle
        assertEquals(2, adapter.getMonth());
    }

    @Test
    void testLeapYear_validFeb29() {
        calendar.set(2024, Calendar.FEBRUARY, 1); // 2024 on karkausvuosi
        adapter = new CalendarToNewDateAdapter(calendar);

        adapter.setDay(29);
        assertEquals(29, adapter.getDay());
    }

    @Test
    void testNonLeapYear_invalidFeb29() {
        calendar.set(2023, Calendar.FEBRUARY, 1); // ei karkausvuosi
        adapter = new CalendarToNewDateAdapter(calendar);

        adapter.setDay(29);
        assertEquals(1, adapter.getDay()); // ei muutu
    }

    @Test
    void testLeapYear_advanceOverFeb() {
        calendar.set(2024, Calendar.FEBRUARY, 27);
        adapter = new CalendarToNewDateAdapter(calendar);

        adapter.advanceDays(2);
        assertEquals(29, adapter.getDay()); // 29.2.2024
    }

    @Test
    void testNonLeapYear_advanceOverFeb() {
        calendar.set(2023, Calendar.FEBRUARY, 27);
        adapter = new CalendarToNewDateAdapter(calendar);

        adapter.advanceDays(2);
        assertEquals(1, adapter.getDay()); // 1.3.2023
        assertEquals(3, adapter.getMonth());
    }
}