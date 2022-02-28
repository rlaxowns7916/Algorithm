package 백준.서강그라운드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int n = 0, m = 0, r = 0;
    public static int[] items;
    public static int[][] map;
    public static int INF = 999999;

    static class Node implements Comparable<Node> {
        int to = 0;
        int len = 0;

        public Node(int to, int len) {
            this.to = to;
            this.len = len;
        }

        @Override
        public int compareTo(Node o) {
            return this.len - o.len;
        }
    }


    public static void main(String[] args) throws IOException {
        int from = 0, to = 0, weight = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 지역의 개수
         */
        n = Integer.parseInt(st.nextToken());
        /**
         * 수색범위
         */
        m = Integer.parseInt(st.nextToken());
        /**
         * 길의 개수
         */
        r = Integer.parseInt(st.nextToken());

        items = new int[n + 1];
        map = new int[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            map[from][to] = map[to][from] = weight;
        }
        System.out.println(solve());
    }

    public static int solve() {
        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dijkstra(i));
        }
        return max;
    }

    public static int dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[n + 1];
        int current = 0, sum = 0;
        Arrays.fill(dist, INF);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            current = now.to;
            for (int i = 1; i <= n; i++) {
                if (i == current)
                    continue;
                if (dist[current] + map[current][i] < dist[i]) {
                    dist[i] = dist[current] + map[current][i];
                    pq.add(new Node(i, dist[i]));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[i] <= m)
                sum += items[i];
        }
        return sum;
    }
}
