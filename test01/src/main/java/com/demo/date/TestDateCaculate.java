package com.demo.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: workspace-IDEAInit
 * @description: (计算两个日期之间相差的月数年份)
 * @author: lzz
 * @create: 2022-02-09 17:35
 */
public class TestDateCaculate {

    public static void main(String[] args) {
        int yearBetween = getYearBetween("2022-01-31", new Date());
        System.err.println(yearBetween);
    }

    public static int getYearBetween(String date, Date newDate){
        int year=0;

        try {
            Date formDate=parseStringToDate(date,null);
            Calendar from  =  Calendar.getInstance();
            from.setTime(formDate);
            Calendar  to  =  Calendar.getInstance();
            to.setTime(newDate);
            //只要年月
            int fromYear = from.get(Calendar.YEAR);
            int toYear = to.get(Calendar.YEAR);
            int fromMonth = from.get(Calendar.MONTH);
            int toMonth = to.get(Calendar.MONTH);
            int month = toYear *  12  + toMonth  -  (fromYear  *  12  +  fromMonth);
            year = toYear  -  fromYear;
            if (month%12==0) {
                return year;
            }else{
                year=(int) (Math.floor(month/12)+1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return year;
    }

    public static Date parseStringToDate(String dateValue, String strFormat) {
        if (dateValue == null)
            return null;
        if (strFormat == null)
            strFormat = "yyyy-MM-dd";

        SimpleDateFormat dateFormat = new SimpleDateFormat(strFormat);
        Date newDate = null;

        try {
            newDate = dateFormat.parse(dateValue);
        } catch (ParseException pe) {
            newDate = null;
        }
        return newDate;
    }
}
