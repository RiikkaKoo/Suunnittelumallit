import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class CalendarToNewDateAdapterTest {

    @Test
    void setDay() {
        NewDateInterface newDate = new CalendarToNewDateAdapter(Calendar.getInstance());

        // THE 31st DAY TESTS:
        // Month does have 31 days --> Day is the 31st of that month:
        newDate.setYear(2026);
        newDate.setMonth(5);
        newDate.setDay(31);

        assertEquals(31, newDate.getDay());
        assertEquals(5, newDate.getMonth());

        // Month does not have 31 days --> Day is the first of the next month:
        newDate.setYear(2026);
        newDate.setMonth(4);
        newDate.setDay(31);

        assertEquals(1, newDate.getDay());
        assertEquals(5, newDate.getMonth());


        // LEAP YEAR TESTS:
        // Is a leap year --> Day is 29th of February:
        newDate.setYear(2028);
        newDate.setMonth(2);
        newDate.setDay(29);

        assertEquals(29, newDate.getDay());
        assertEquals(2, newDate.getMonth());

        // Is not a leap year --> Day is 1st of March:
        newDate.setYear(2026);
        newDate.setMonth(2);
        newDate.setDay(29);

        assertEquals(1, newDate.getDay());
        assertEquals(3, newDate.getMonth());
    }

    @Test
    void setMonth() {
    }

    @Test
    void setYear() {
    }

    @Test
    void advanceDays() {
    }
}