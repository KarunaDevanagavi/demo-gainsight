package org.teamn.helper;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateConversion {

    public static Date stringToDate(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyyMMdd’T'HHmmss.SSSZ", Locale.ENGLISH);
        return format.parse(date);
    }

    public static String dateToString(Date date){
        DateFormat df = new SimpleDateFormat("yyyyMMdd’T'HHmmss.SSSZ");
        return df.format(date);
    }
}
