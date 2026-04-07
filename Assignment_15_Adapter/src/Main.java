import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        NewDateInterface newDate = new CalendarToNewDateAdapter(Calendar.getInstance());

        // Set the date
        newDate.setYear(2023);
        newDate.setMonth(12);
        newDate.setDay(17);

        // Print date
        System.out.println("Original date:");
        System.out.println(newDate.getDay() + "." + newDate.getMonth() + "." + newDate.getYear());
        System.out.println();

        // Advance 32 days
        newDate.advanceDays(32);

        // Print new date
        System.out.println("Date after 32 days:");
        System.out.println(newDate.getDay() + "." + newDate.getMonth() + "." + newDate.getYear());
        System.out.println();
    }

}
