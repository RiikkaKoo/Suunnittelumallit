import java.util.Calendar;

public class Main {

    public static void main(String[] args) {
        NewDateInterface newDate = new CalendarToNewDateAdapter(Calendar.getInstance());

        newDate.setMonth(2);
        newDate.setDay(29);
        newDate.setYear(2023);

        System.out.println(newDate.getDay());
        System.out.println(newDate.getMonth());
        System.out.println(newDate.getYear());
        System.out.println();

        newDate.setMonth(5);
        newDate.setDay(31);
        newDate.setMonth(4);
        newDate.setYear(2023);

        System.out.println(newDate.getDay());
        System.out.println(newDate.getMonth());
        System.out.println(newDate.getYear());
        System.out.println();
    }

}
