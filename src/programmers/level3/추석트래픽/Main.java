package programmers.level3.추석트래픽;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {

    }

    public int solution(String[] lines) {
        int len = lines.length, answer = 0;
        int[] start = new int[len];
        int[] end = new int[len];
        StringTokenizer st;


        for (int i = 0; i < len; i++) {
            String line = lines[i];
            st = new StringTokenizer(line);
            st.nextToken(); // YYYY-MM-DD skip
            end[i] = parseDayToMileSecond(st.nextToken());
            start[i] = end[i] - (int) (Double.parseDouble(st.nextToken().replace("s", "")) * 1000) + 1;

        }
        for (int i = 0; i < len; i++) {
            answer = Math.max(answer, countMaxThroughput(start[i], start, end));
            answer = Math.max(answer, countMaxThroughput(end[i], start, end));
        }
        return answer;
    }

    public static int countMaxThroughput(int time, int[] starts, int[] ends) {
        int len = starts.length, count = 0;
        for (int i = 0; i < len; i++) {
            if (starts[i] < time + 1000 && ends[i] >= time)
                count++;
        }
        return count;
    }

    public static int parseDayToMileSecond(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");

        return (int) (1000 * (int) (Integer.parseInt(st.nextToken()) * 3600 + Integer.parseInt(st.nextToken()) * 60 + Double.parseDouble(st.nextToken())));

    }
}
