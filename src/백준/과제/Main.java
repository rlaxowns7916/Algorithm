package 백준.과제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;

    static class Homework implements Comparable<Homework> {
        int remainDate = 0;
        int score = 0;

        public Homework(int remainDate, int score) {
            this.remainDate = remainDate;
            this.score = score;
        }

        @Override
        public int compareTo(Homework o) {
            if (this.score == o.score)
                return this.remainDate - o.remainDate;
            return o.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        int i = 0, sum = 0, count = 1000;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Homework> list = new ArrayList<>();
        PriorityQueue<Homework> pq = new PriorityQueue<>();

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Homework(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, (o1, o2) -> {
            if (o1.remainDate == o2.remainDate)
                return o2.score - o1.score;
            return o2.remainDate - o1.remainDate;
        });
        i = 0;
        while (count > 0) {
            while (i < N  && list.get(i).remainDate >= count) {
                pq.add(list.get(i));
                i++;
            }
            if (pq.isEmpty()) {
                if (i < N)
                    count = list.get(i).remainDate;
                else
                    break;
            } else {
                Homework now = pq.poll();
                if (now.remainDate >= count) {
                    sum += now.score;
                    count--;
                }
            }
        }
        System.out.println((sum));
    }
}
