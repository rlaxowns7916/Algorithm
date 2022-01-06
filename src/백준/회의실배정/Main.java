package 백준.회의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static ArrayList<Meeting> meetings = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int i = 0, start = 0, end = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            meetings.add(new Meeting(start, end));
        }
        Collections.sort(meetings);
        System.out.println(calc());
    }

    public static int calc() {
        int next = 0, count = 0;

        for (Meeting now : meetings) {
            if (next <= now.start) {
                count++;
                next = now.end;
            }
        }
        return count;
    }
}

class Meeting implements Comparable<Meeting> {
    int start = 0;
    int end = 0;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Meeting o) {
        int diff = this.end - o.end;
        if (diff == 0) {
            return this.start - o.start;
        } else
            return diff;
    }
}
