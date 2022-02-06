package 백준.최소회의실개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;

    static class Meeting implements Comparable<Meeting> {
        int start = 0;
        int end = 0;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end < o.end)
                return -1;
            else if (this.end == o.end) {
                if (this.start <= o.start)
                    return -1;
                else
                    return 1;
            } else
                return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ArrayList<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            meetings.add(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(meetings, (o1, o2) -> o1.start - o2.start);

        for (Meeting meeting : meetings) {
            if (pq.isEmpty())
                pq.add(meeting.end);
            else {
                if (pq.peek() <= meeting.start)
                    pq.poll();
                pq.add(meeting.end);
            }
        }
        System.out.println(pq.size());
    }
}
