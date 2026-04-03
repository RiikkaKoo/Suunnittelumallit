import java.util.Calendar;

public class CalendarToNewDateAdapter implements NewDateInterface {

    private Calendar calendar;

    public CalendarToNewDateAdapter(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void setDay(int day) {
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        // System.out.println("Month Maximum: " + maxDays);
        if (day > maxDays || day < 1) {
            System.out.println("Not a valid day. Try again.");
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, day);
        }
    }

    @Override
    public void setMonth(int month) {
        if (month > 12 || month < 1) {
            System.out.println("Not a valid month. Try again.");
        } else {
            calendar.set(Calendar.MONTH, month - 1);
        }
    }

    @Override
    public void setYear(int year) {
        if (year < 1) {
            System.out.println("Not a valid year. Try again.");
        } else {
            calendar.set(Calendar.YEAR, year);
        }
    }

    @Override
    public int getDay() {
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getMonth() {
        return calendar.get(Calendar.MONTH) + 1;
    }

    @Override
    public int getYear() {
        return calendar.get(Calendar.YEAR);
    }

    @Override
    public void advanceDays(int days) {
        calendar.add(Calendar.DAY_OF_MONTH, days);
    }
}
