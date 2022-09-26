package com.lee.datastructureandalgorithms.problems;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Question2 {

    public static final ThreadLocal<DateFormatter> formatter = ThreadLocal.withInitial(() -> new DateFormatter(new SimpleDateFormat("dd-MMM-yyyy")));


    static class MyTime {
        private final Date startTime;
        private final Date endTime;

        @Override
        public String toString() {
            return "MyTime{" + "startTime=" + startTime + ", endTime=" + endTime + '}';
        }

        public MyTime(Date startTime, Date endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String str1 = "20150801";
        String str2 = "20150802";
        String str3 = "20150803";
        String str4 = "20150806";
        String str5 = "20150810";
        Date date1 = format.parse(str1);
        Date date2 = format.parse(str2);
        Date date3 = format.parse(str3);
        Date date4 = format.parse(str4);
        Date date5 = format.parse(str5);

        List<Date> dateList = new ArrayList<>();
        dateList.add(date1);
        dateList.add(date2);
        dateList.add(date3);
        dateList.add(date4);
        dateList.add(date5);

        System.out.println("dateList = " + dateList);

        List<MyTime> myTimes = new ArrayList<>();

        Date firstDate = dateList.get(0);
        int i = dateList.size();
        while (i >= 0) {
            Date furtherDay = dateList.get(i - 1);
            System.out.println("furtherDay = " + furtherDay);

            Date addDate = addDay(firstDate, i - 1);
            System.out.println("addDate = " + addDate);

            if (addDate.getTime() == furtherDay.getTime()) {
                MyTime myTime = new MyTime(firstDate, furtherDay);
                myTimes.add(myTime);
                break;
            }

            MyTime myTime = new MyTime(furtherDay, furtherDay);
            myTimes.add(myTime);
            i--;
        }

        System.out.println("myTimes = " + myTimes);
    }


    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        if (intervals.length == 0) return res.toArray(new int[0][]);
        // 对起点终点进行排序
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int i = 0;
        while (i < intervals.length) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 如果有重叠，循环判断哪个起点满足条件
            while (i < intervals.length - 1 && intervals[i + 1][0] <= right) {
                i++;
                right = Math.max(right, intervals[i][1]);
            }
            // 将现在的区间放进res里面
            res.add(new int[]{left, right});
            // 接着判断下一个区间
            i++;
        }
        return res.toArray(new int[0][]);
    }

    public static Date addDay(Date date, Integer number) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, number);
        return calendar.getTime();
    }

}
