package 백준.네트워크연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static int[] parent;
    public static ArrayList<Connect> links = new ArrayList<>();

    static class Connect implements Comparable<Connect> {
        int from = 0;
        int to = 0;
        int cost = 0;

        public Connect(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Connect o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        int a = 0, b = 0, c = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            links.add(new Connect(a, b, c));
        }
        System.out.println(kruskal());
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        parent[y] = x;
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    public static boolean isVisit(int x, int y) {
        return find(x) == find(y);
    }

    public static int kruskal() {
        int answer = 0, count = 0;
        int from = 0, to = 0, cost = 0;
        boolean[] visit = new boolean[N + 1];
        PriorityQueue<Connect> pq = new PriorityQueue<>(links);

        while (!pq.isEmpty() && count < N - 1) {
            Connect link = pq.poll();
            from = link.from;
            to = link.to;
            cost = link.cost;

            if (isVisit(from, to))
                continue;
            union(from, to);
            count++;
            answer += cost;
        }
        return answer;
    }
}
