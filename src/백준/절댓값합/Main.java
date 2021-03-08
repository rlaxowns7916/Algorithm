package 백준.절댓값합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            int val = Math.abs(o1) - Math.abs(o2);
            if (val == 0)
                return o1 - o2;
            else
                return val;
        }
    });

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), i = 0, input = 0;

        for (i = 0; i < n; i++) {
            input = Integer.parseInt(br.readLine());
            if (input == 0) {
                if (pq.isEmpty())
                    sb.append(0).append("\n");
                else
                    sb.append(pq.poll()).append("\n");
            } else
                pq.add(input);
        }
        System.out.println(sb.toString());
    }
}
