package utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {

//Print Month & Year
    public static String returnNextMonth() {
//        Create Date object
        Date dNow = new Date();
//        Create calender object for Gregorian Calender
        Calendar calendar = new GregorianCalendar();
//        Set calendar date to current date
        calendar.setTime(dNow);

//Create object of SimpleDateFormat
//Defining Date format to - example: (Jan-2022)
        SimpleDateFormat sdf = new SimpleDateFormat("MMM-yyyy");
//Incrementing the current month, 1 month at a time
        calendar.add(Calendar.MONTH,1);

//   Generating date based on the specified format
    String date = sdf.format(calendar.getTime());

    return date;
    }
}