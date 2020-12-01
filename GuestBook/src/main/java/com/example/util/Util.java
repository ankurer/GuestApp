package com.example.util;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Util {

	public static Date getDate(String date) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = null;

        try {
        	if(date != null){
            date1 = formatter.parse(date);
            System.out.println("Inside Util get date after parse--->"+date1);
        	}

        } catch (Exception e) {
            e.printStackTrace();
        }

        return date1;
    }

    public static String getDate(Date indate) {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MM/yyyy");
        /*
         * you can also use DateFormat reference instead of SimpleDateFormat
         * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
         */
        try {
            dateString = sdfr.format(indate);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return dateString;
    }

    public static String convertStringToDate(Date indate) {
        String dateString = null;
        SimpleDateFormat sdfr = new SimpleDateFormat("dd/MMM/yyyy");
        /*
         * you can also use DateFormat reference instead of SimpleDateFormat
         * like this: DateFormat df = new SimpleDateFormat("dd/MMM/yyyy");
         */
        try {
            dateString = sdfr.format(indate);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return dateString;
    }
}
