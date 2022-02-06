package 백준.N번쨰큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;

    public static void main(String[] args) throws IOException {
        int count = 1;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                pq.add(Integer.parseInt(st.nextToken()));
        }
        while (count < N) {
            pq.poll();
            count++;
        }
        System.out.println(pq.poll());
    }
}
