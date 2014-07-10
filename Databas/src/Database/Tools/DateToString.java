package Database.Tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.GregorianCalendar;

public class DateToString {

    public DateToString() {}

    public static String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.YY");
        return format.format(date);
    }

    public String dateToString(GregorianCalendar date) {
        Formatter fr = new Formatter();
        fr.format("%td.%tm.%tY",date,date,date);
        return fr.toString();
    }
}
