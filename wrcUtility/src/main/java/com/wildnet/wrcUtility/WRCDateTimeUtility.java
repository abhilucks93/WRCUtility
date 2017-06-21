package com.wildnet.wrcUtility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by sanjiv on 12/8/16.
 */
public class WRCDateTimeUtility {

    // #DateTimeUtility

    public static String timeDifference(Date endDate) {

        //milliseconds
        StringBuilder updatedTime = new StringBuilder();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        Date startDate = null;
        try {
            startDate = dateFormat.parse(dateFormat.format(cal.getTime()));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        long different = startDate.getTime() - endDate.getTime();

        //       System.out.println("startDate : " + startDate);
        //       System.out.println("endDate : "+ endDate);
        //       System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays,
                elapsedHours, elapsedMinutes, elapsedSeconds);
        if (elapsedDays > 0) {
            updatedTime.append(elapsedDays + " days");
            return updatedTime.toString();

        }
        if (elapsedHours > 0) {
            updatedTime.append(elapsedHours + " hour");
            return updatedTime.toString();


        }
        if (elapsedMinutes > 0) {
            updatedTime.append(elapsedMinutes + " minutes");
            return updatedTime.toString();


        }
        if (elapsedSeconds > 0) {
            updatedTime.append(elapsedSeconds + " second");
            return updatedTime.toString();


        }
        return updatedTime.toString();

    }

    public static String printDuration(String _startDate, String _endDate) {

        // _startDate format : yyyy-MM-dd HH:mm:ss
        // _endDate format : yyyy-MM-dd HH:mm:ss

        //milliseconds
        StringBuilder updatedTime = new StringBuilder();

        //get current time
        /*  Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
        Date startDate = null;
        try {
            startDate = dateFormat.parse(dateFormat.format(cal.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date startDate = null;
        Date endDate = null;

        try {
            startDate = dateFormat.parse(_startDate);
            endDate = dateFormat.parse(_endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long different = endDate.getTime() - startDate.getTime();

        System.out.println("startDate : " + startDate);
        System.out.println("endDate : " + endDate);
        System.out.println("different : " + different);

        long secondsInMilli = 1000;
        long minutesInMilli = secondsInMilli * 60;
        long hoursInMilli = minutesInMilli * 60;
        long daysInMilli = hoursInMilli * 24;

        long elapsedDays = different / daysInMilli;
        different = different % daysInMilli;

        long elapsedHours = different / hoursInMilli;
        different = different % hoursInMilli;

        long elapsedMinutes = different / minutesInMilli;
        different = different % minutesInMilli;

        long elapsedSeconds = different / secondsInMilli;

        System.out.printf(
                "%d days, %d hours, %d minutes, %d seconds%n",
                elapsedDays,
                elapsedHours, elapsedMinutes, elapsedSeconds);
        if (elapsedDays > 0) {
            updatedTime.append(elapsedDays + " days");
            return updatedTime.toString();

        }
        if (elapsedHours > 0) {
            if (elapsedHours > 1)
                updatedTime.append(elapsedHours + " hrs");
            else
                updatedTime.append(elapsedHours + " hr");
            return updatedTime.toString();

        }
        if (elapsedMinutes > 0) {
            if (elapsedMinutes > 1)
                updatedTime.append(elapsedMinutes + " mins");
            else
                updatedTime.append(elapsedMinutes + " min");
            return updatedTime.toString();


        }
        if (elapsedSeconds > 0) {
            updatedTime.append(elapsedSeconds + " second");
            return updatedTime.toString();


        }
        return updatedTime.toString();

    }

    public static String getTimeFormat(String time1) {
        final String time = time1;
        String t2 = "";

        try {
            DateFormat sdf = new SimpleDateFormat("hh:mm");
            final Date dateObj = sdf.parse(time);
            System.out.println(dateObj);
            System.out.println(new SimpleDateFormat("K:mm a").format(dateObj));
            t2 = new SimpleDateFormat("KK:mm a").format(dateObj).toString();
        } catch (final ParseException e) {
            e.printStackTrace();
        }
        return t2;
    }

    public static long dateDiff(String dateStart, String dateEnd) {

        SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy");
        String inputString1 = dateStart;
        String inputString2 = dateEnd;
        long totDays = 0;

        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            totDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
            System.out.println("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return totDays;
    }

    public static String getDateFormat(String date1) {

        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = form.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat postFormater = new SimpleDateFormat("MMM dd, yyyy");
        String newDateStr = postFormater.format(date);

        return newDateStr;
    }

    public static String date_formatter(String inputDate) {

        SimpleDateFormat inputFormat = new SimpleDateFormat(
                "yyyy-dd-MM hh:mm:ss");

        SimpleDateFormat outputFormat_date = new SimpleDateFormat(
                "dd.mm.yyyy");

        SimpleDateFormat outputFormat_time = new SimpleDateFormat(
                "hh:mm");

        String outputDate = outputFormat_date.format(inputFormat);
        String input_Date = outputFormat_date.format(inputFormat);

        return outputDate;
    }

    private static String convertInto12HourFormat(String date) {
        DateFormat f1 = new SimpleDateFormat("HH:mm"); //HH for hour of the day (0 - 23)
        Date d = null;
        try {
            d = f1.parse(date);
            DateFormat f2 = new SimpleDateFormat("hh:mm a");
            return f2.format(d).toLowerCase();


            // "12:18am"
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    private int getCurrentHour() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat hourFormat = new SimpleDateFormat("hh");
        String Datetime = hourFormat.format(c.getTime());
        System.out.println(Datetime);
        return Integer.parseInt(Datetime);
    }

    private int getCurrentMinute() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("mm");
        String Datetime = timeFormat.format(c.getTime());
        String newTime = convertInto12HourFormat(Datetime);
        System.out.println(newTime);
        return Integer.parseInt(newTime);
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String str = sdf.format(new Date());
        String str2 = convertInto12HourFormat(str);
        return str;
    }

    public static String getTwoHoursCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR_OF_DAY, 2);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        String str = sdf.format(calendar.getTime());
        String AfterTwoHours = convertInto12HourFormat(str);
        return AfterTwoHours;
    }

    public static String convertTo24HourFormat(String convertdate) {
        SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
        SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
        Date date = null;
        try {
            date = parseFormat.parse(convertdate);
            System.out.println(parseFormat.format(date) + " = " + displayFormat.format(date));
            return displayFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String getCurrentDate2() {
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());
        SimpleDateFormat postFormater = new SimpleDateFormat("EEE, dd MMM");
        String newDateStr = postFormater.format(c.getTime());
        return newDateStr;
    }

    public static String getCurrentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    public static String getCurrentDateOrignal() {
        Date date = new Date();
        String modifiedDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
        return modifiedDate;
    }

    public static String getTwoDaysLaterDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 2);
        SimpleDateFormat postFormater = new SimpleDateFormat("EEE, dd MMM");
        String newDateStr = postFormater.format(c.getTime());
        return newDateStr;
    }

    public static String convertDateFormat(String date) {

        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date dater;
        try {
            dater = form.parse(date);
            SimpleDateFormat postFormater = new SimpleDateFormat("dd MMM yyyy");
            String newDateStr = postFormater.format(dater);
            return newDateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertdate(String date) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date dater;
        try {
            dater = form.parse(date);
            SimpleDateFormat postFormater = new SimpleDateFormat("EEE, MMM dd yyyy");
            String newDateStr = postFormater.format(dater);
            return newDateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String convertdateToEEEddMMMyyyy(String date) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date dater;
        try {
            dater = form.parse(date);
            SimpleDateFormat postFormater = new SimpleDateFormat("EEE, dd MMMM yyyy");
            String newDateStr = postFormater.format(dater);
            return newDateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String convertDateRecyclerView(String date) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date dater;
        try {
            dater = form.parse(date);
            SimpleDateFormat postFormater = new SimpleDateFormat("EEE, dd MMMM yyyy");
            String newDateStr = postFormater.format(dater);
            return newDateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String convertInto24HourFormat(String date) {
        DateFormat f1 = new SimpleDateFormat("hh:mm a"); //HH for hour of the day (0 - 12) am/pm
        Date d;
        try {
            d = f1.parse(date);
            DateFormat f2 = new SimpleDateFormat("HH:mm");
            return f2.format(d).toLowerCase();
            // "12:18am"
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getCurrentDateForDrawerLabel() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        return sdf.format(new Date());
    }

    public static String getCurrentDayOfWeek() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        switch (dayOfWeek) {
            case Calendar.SUNDAY:
                return "Sunday";

            case Calendar.MONDAY:
                return "Monday";

            case Calendar.TUESDAY:
                return "Tuesday";

            case Calendar.WEDNESDAY:
                return "Wednesday";

            case Calendar.THURSDAY:
                return "Thursday";

            case Calendar.FRIDAY:
                return "Friday";

            case Calendar.SATURDAY:
                return "Saturday";
        }
        return null;
    }

    public static String getCurrentMonth() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat month_date = new SimpleDateFormat("MMM, yyyy");
        String month_name = month_date.format(calendar.getTime());
        return month_name;
    }

    public static String getCurrentDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentDateTime = sdf.format(new Date());
        return currentDateTime;
    }

    public static boolean compare1HourCheckValid(String date, String time) { //"2016-07-29 "
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sdf.parse(date);
            String theirDate = sdf.format(d1);
            String todayDate = sdf.format(new Date());
            if (todayDate.trim().equalsIgnoreCase(theirDate.trim())) {
                Date theirTime = new SimpleDateFormat("HH:mm").parse(time);
                if (theirTime.getHours() - new Date().getHours() <= 1) {
                    return false;
                }
                return true;
            } else {
                return true;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static String convertFinalDate(String date) {
        SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd");
        Date dater;
        try {
            dater = form.parse(date);
            SimpleDateFormat postFormater = new SimpleDateFormat("dd MMM");
            String newDateStr = postFormater.format(dater);
            return newDateStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String compareDate(String date) { //"2016-07-29 03:59:00"
        //date = "2016-08-03 15:37:23"; //Wed Aug 03 15:35:39 GMT+05:30 2016
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d1 = sdf.parse(date);
            String theirDate = new SimpleDateFormat("yyyy-MM-dd").format(d1);
            String todayDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            if (todayDate.trim().equalsIgnoreCase(theirDate.trim())) {
                Date s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);
                String time = new SimpleDateFormat("HH:mm a").format(s);
                return time;
            } else {
                Date s = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(date);

                String dateF = new SimpleDateFormat("yyyy-MM-dd").format(s);
                String timeF = new SimpleDateFormat("HH:mm a").format(s);
//                Date s = new SimpleDateFormat("dd MMM, HH:mm a").parse(date);
                String st = convertFinalDate(dateF);
                return st + "\n" + timeF;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


}
