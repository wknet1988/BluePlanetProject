package com.sxgs.zhsb.util;

import java.util.Calendar;

public class DateAssist {


    public static String getToday(){
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH)+1;
        int day = ca.get(Calendar.DATE);
       return ""+year + "-" + (month<10?"0":"") +month + "-" + (day<10?"0":"") +day;
    }


    public static String getTodayDaytime(){
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH)+1;
        int day = ca.get(Calendar.DATE);
        int hour = ca.get(Calendar.HOUR);
        int minute = ca.get(Calendar.MINUTE);
        int second = ca.get(Calendar.SECOND);
        return ""+year + "-" + (month<10?"0":"") +month + "-" + (day<10?"0":"") +day+" "+hour+":"+minute+":"+second;
    }

    public static String getFirstDayOfCurrentMonth(){
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH)+1;
        return ""+year + "-" + (month<10?"0":"") +month + "-" +"01";
    }

    public static String getLastDayOfCurrentMonth(){
        Calendar ca = Calendar.getInstance();
        int year = ca.get(Calendar.YEAR);
        int month = ca.get(Calendar.MONTH)+1;
        int day = ca.get(Calendar.DATE);
        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
            day = 31;
        }else if (month!=2){
            day = 30;
        }else if (year%4==0 || (year%100==0 && year%400==0)){
            day = 29;
        }else {
            day = 28;
        }
        return ""+year + "-" + (month<10?"0":"") +month + "-"+ (day<10?"0":"") +day;
    }

    public static int getDateDuration(String startTime, String endTime) {
        SimpleDateFormat date2stringFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar startCal = Calendar.getInstance();
        Calendar endCal = Calendar.getInstance();
        try {
            Date startDate = date2stringFormat.parse(startTime);
            Date endDate = date2stringFormat.parse(endTime);
            startCal.setTime(startDate);
            endCal.setTime(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int intervalDays = ((int) (endCal.getTime().getTime() / 1000) - (int) (startCal.getTime().getTime() / 1000))
                / 3600 / 24;
        return intervalDays;
    }

}