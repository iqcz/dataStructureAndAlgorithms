package com.lee.datastructureandalgorithms.tuling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 贪心算法
 * @author osyuj
 */
public class MeetingSchedule {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        List<Meeting> meetings = new ArrayList<>();
        //n个会议
        int n = cin.nextInt();
        for (int i = 0; i < n; i++) {
            int start = cin.nextInt();
            int end = cin.nextInt();
            Meeting meeting = new Meeting(i + 1, start, end);
            meetings.add(meeting);
        }

        meetings.sort(null);
        //当前的时间,从一天的0点开始,如果领导要求从8点开始 那curTime=8
        int curTime = 0;
        for (int i = 0; i < n; i++) {
            Meeting meeting = meetings.get(i);
            //会议的开始时间比我们当前的要大 表示可以开
            if (meeting.startTime >= curTime) {
                System.out.println(meeting.toString());
                curTime = meeting.endTime;
            }
        }
    }
}

class Meeting implements Comparable<Meeting> {
    // 编号
    int meNum;
    // 开始时间
    int startTime;
    // 结束时间
    int endTime;

    public Meeting(int meNum, int startTime, int endTime) {
        this.meNum = meNum;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Meeting o) {
        if (this.endTime > o.endTime) {
            return 1;
        }
        return -1;
    }

    @Override
    public String toString() {
        return "Meeting [meNum=" + meNum + ", startTime=" + startTime
                + ", endTime=" + endTime + "]";
    }
}

