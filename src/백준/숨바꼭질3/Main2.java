package 백준.숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2 {
    public static int N = 0, K = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(find());
    }

    public static int find() {
        int[] dist = new int[200001];
        Deque<Integer> deque = new LinkedList<>();

        Arrays.fill(dist, 200001);
        deque.addFirst(N);
        dist[N] = 0;

        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now == K)
                break;

            if (now * 2 < 200001 && dist[now] < dist[now * 2]) {
                deque.addFirst(now * 2);
                dist[now * 2] = dist[now];
            }
            if (now - 1 >= 0 && dist[now] + 1 < dist[now - 1]) {
                deque.addLast(now - 1);
                dist[now - 1] = dist[now] + 1;
            }
            if (now + 1 <= K && dist[now] + 1 < dist[now + 1]) {
                deque.addLast(now + 1);
                dist[now + 1] = dist[now] + 1;
            }
        }
        return dist[K];
    }
}
