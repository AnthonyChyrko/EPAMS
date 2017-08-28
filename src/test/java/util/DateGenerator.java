package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DateGenerator {
    private Calendar calendar;
    private SimpleDateFormat dateFormat;

    public DateGenerator(){
        calendar = new GregorianCalendar();
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
    }

    public String getTomorrowDay(){
        int currentDay = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.set(Calendar.DAY_OF_MONTH, currentDay + 1);
        String date = dateFormat.format(calendar.getTime());
        calendar.set(Calendar.DAY_OF_MONTH, currentDay);
        return date;
    }

}
