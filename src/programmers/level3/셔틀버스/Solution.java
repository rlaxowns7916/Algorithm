package programmers.level3.셔틀버스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution {
    public static ArrayList<Integer> waiting = new ArrayList<>();

    public static String solution(int n, int t, int m, String[] timetable) {
        int turn = 0, now = 9 * 60, pointer = 0, inBus = 0, canRide = -0;
        /**
         * n: 셔틀 운행 횟수
         * t: 셔틀 운행 간격
         * m: 한 셔틀에 탈 수 있는 최대 크루 수
         */
        split(timetable);
        while (turn++ < n) {
            inBus = 0;
            while (inBus < m && pointer < waiting.size() && waiting.get(pointer) <= now) {
                inBus++;
                pointer++;
            }
            if (inBus < m)
                canRide = now;
            else
                canRide = waiting.get(pointer - 1) - 1;
            now += t;
        }
        return parseToTime(canRide);
    }

    public static String parseToTime(int number) {
        StringBuilder sb = new StringBuilder();
        int hour = number / 60, minute = number % 60;

        if (hour < 10)
            sb.append("0").append(hour);
        else
            sb.append(hour);

        if (minute < 10)
            sb.append(":0").append(minute);
        else
            sb.append(":").append(minute);
        return sb.toString();

    }

    public static void split(String[] timetable) {
        int hour = 0, minute = 0;
        for (String krew : timetable) {
            StringTokenizer st = new StringTokenizer(krew, ":");

            hour = Integer.parseInt(st.nextToken()) * 60;
            minute = Integer.parseInt(st.nextToken());

            waiting.add(hour + minute);
        }
        Collections.sort(waiting);
    }
}
