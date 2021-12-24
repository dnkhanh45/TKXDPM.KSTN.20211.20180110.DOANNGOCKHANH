package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.DateFormat;


public class MyDateTime {
    public static String getToday() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
