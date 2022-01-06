package 백준.강의실배정;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static ArrayList<Plan> plans = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = null;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), start = 0, end = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            plans.add(new Plan(start, end));
        }
        Collections.sort(plans);
        System.out.println(calc());
    }

    public static int calc() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Plan plan : plans) {
            if (!pq.isEmpty() && pq.peek() <= plan.start)
                pq.poll();
            pq.add(plan.end);
        }
        return pq.size();
    }
}

class Plan implements Comparable<Plan> {
    int start;
    int end;

    public Plan(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Plan o) {
        int diff = this.start - o.start;
        if (diff == 0) {
            return this.end - o.end;
        } else
            return diff;
    }
}
