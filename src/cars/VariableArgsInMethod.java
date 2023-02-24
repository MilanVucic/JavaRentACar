package cars;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalField;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class VariableArgsInMethod {
    public static void main(String[] args) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("03-04-1994", dtf);
        System.out.println(date.plusDays(20));
    }

    private static void newDateTimeClasses() {
        LocalDate localDate = LocalDate.now();
        LocalDate tenDaysAfter = localDate.plusDays(10);

        LocalTime localTime = LocalTime.of(23, 59);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(timeFormatter.format(localTime));
        System.out.println(dateFormatter.format(tenDaysAfter));

        LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println(dateTimeFormatter.format(localDateTime));
    }

    private static void legacyDateClasses() {
        Date date = new Date(102, Calendar.MARCH, 22);
        System.out.println(date);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MMM/dd Z");
        Calendar calelndar = new GregorianCalendar(2002, Calendar.MARCH, 31);

        System.out.println(dateFormat.format(calelndar.getTime()));
    }

    public static void something(int a, String... args) {
        System.out.println(args.length);
    }
}
