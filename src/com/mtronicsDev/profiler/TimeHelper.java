package com.mtronicsDev.profiler;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.spi.DateFormatProvider;
import java.util.Date;

public class TimeHelper {

    static long getCurrentTime() {
        return System.currentTimeMillis();
    }

    static String getCurrentDateAndTime() {
        DateFormat formatter = new SimpleDateFormat("d:MM:yyyy HH:mm:ss");
        Date date = new Date();

        return formatter.format(date);
    }

}
