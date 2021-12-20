package com.leon.adopen.domain.util;

import cn.hutool.core.date.DateUtil;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    public static String toString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(date);
    }

    public static String formateDate(String time, String format) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(Timestamp.valueOf(time));
    }

    public static String formateShortDate(String time) {
        return formateDate(time, "yyyy-MM-dd");
    }

    public static String formateDateTime(String time) {
        return formateDate(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 比较两个时间差是否在范围内
     *
     * @param date1  较晚时间
     * @param date2  较早时间
     * @param minute 差值范围
     * @return 如在差值范围内返回true, 否则返回False. 如date1<date2返回false.
     */
    public static boolean compareDiff(Date date1, Date date2, int minute) {
        if (!date1.before(date2)) {
            long diff = date1.getTime() - date2.getTime();
            if (diff / 60000 < minute) {
                return true;
            }
        }
        return false;
    }

    /**
     * 两个日期做减法，返回相差天数
     *
     * @throws ParseException
     * @throws ParseException
     */
    public static long datesub(Date date1, Date date2) throws ParseException {
        @SuppressWarnings("unused")
        long l = date1.getTime() - date2.getTime() > 0 ? date1.getTime()
                - date2.getTime() : date2.getTime() - date1.getTime();
        // 日期相减得到相差的日期
        long day = (date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000) > 0 ? (date1
                .getTime() - date2.getTime()) / (24 * 60 * 60 * 1000)
                : (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000);
        return day + 1;
    }

    public static String getNewDate() {
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdt.format(new Date());

    }

    public static String getBefoDateShort()
            throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        c.setTime(f.parse(String.valueOf(DateUtil.yesterday())));
        return f.format(c.getTime());
    }

    public static String getBefoDateShortNoChar()
            throws ParseException {
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        c.setTime(f.parse(String.valueOf(DateUtil.yesterday())));
        return f.format(c.getTime());
    }


    public static String getShortNow() {
        return formateDate(getNewDate(), "yyyy-MM-dd");
    }

    public static String getShortNowNoChar() {
        return formateDate(getNewDate(), "yyyyMMdd");
    }

    public static String formatShortDate(Date time) {
        // TODO Auto-generated method stub
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formateDate(sdt.format(time), "yyyy-MM-dd");
    }

    public static String formatLongDate(Date time) {
        // TODO Auto-generated method stub
        SimpleDateFormat sdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdt.format(time).toString();
    }

    public static String getNow() {
        // TODO Auto-generated method stub
        String time = getNewDate();
        return formateDate(time, "yyyy-MM-dd HH:mm:ss");
    }

    public static Date getFirstDayOfWeek(int year, int week) {

        Calendar c = Calendar.getInstance();
        if (year == 0) {
            year = c.get(Calendar.YEAR);// 年
            // year=new Date().getYear();
        }
        if (week == 0) {
            week = c.get(Calendar.WEEK_OF_YEAR);
        }
        c.set(Calendar.YEAR, year);
        c.set(Calendar.WEEK_OF_YEAR, week);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        setBeginTime(c);
        return c.getTime();
    }

    public static Date getLastDayOfWeek(int year, int week) {
        Calendar c = Calendar.getInstance();
        if (year == 0) {

            year = c.get(Calendar.YEAR);// 年
        }
        if (week == 0) {
            week = c.get(Calendar.WEEK_OF_YEAR);
        }
        c.set(Calendar.YEAR, year);
        c.set(Calendar.WEEK_OF_YEAR, week);
        c.setFirstDayOfWeek(Calendar.MONDAY);
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6);
        setEndTime(c);
        return c.getTime();
    }

    public static void setBeginTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        setBeginTime(c);
        date.setTime(c.getTimeInMillis());
    }

    public static void setEndTime(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        setEndTime(c);
        date.setTime(c.getTimeInMillis());
    }

    private static void setBeginTime(Calendar c) {
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
    }

    private static void setEndTime(Calendar c) {
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
    }

    public static boolean isTimeBetween(Date startTime, Date endTime) {
        try {
            long time = System.currentTimeMillis();
            if (time >= startTime.getTime() && time <= endTime.getTime()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean isInHour(String hours[], int hour) {
        for (String hd : hours) {
            String[] hs = hd.split("-");
            if (hour >= Integer.parseInt(hs[0])
                    && hour <= Integer.parseInt(hs[1])) {
                return true;
            }
        }
        return false;

    }

    public static boolean compareDate(String date1, String date2) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(date1));
            c2.setTime(df.parse(date2));
        } catch (ParseException e) {
            System.err.println("格式不正确");
        }
        int result = c1.compareTo(c2);
        if (result == 0) {
            return true;
        } else {
            return result >= 0;
        }
    }

    public static String getShortBeforeStartDate() throws ParseException {
        return getBefoDateShort() + " 00:00:00";
    }

    public static String getShortBeforeEndDate() throws ParseException {
        return getBefoDateShort() + " 23:59:59";
    }

    //获取第二天时间
    public static String getSecondDay() {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1);
        return f.format(calendar.getTime());
    }
}
