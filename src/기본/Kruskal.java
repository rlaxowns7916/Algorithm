package 기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Greedy 알고리즘
 * 간선을 가중치를 기준으로 정렬 (오름차순)
 * MST (최소비용신장트리)를 만드는 방법 중 하나
 * Cycle 여부 확인을 Union-Find를 통해서 확인한다.
 * 간선이 적은 희소그래프에서 유리하다.
 */
public class Kruskal {
    /**
     * N 정점의 개수
     * M 간선의 개수
     */
    public static int N = 0, M = 0;
    public static int[] parent;

    static class Connect implements Comparable<Kruskal.Connect> {
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

    public static ArrayList<Connect> links = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++)
            parent[i] = i;
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        parent[y] = x;
    }

    public static boolean isCycle(int x, int y) {
        return find(x) == find(y);
    }

    public static int kruskal() {
        int answer = 0, count = 0;
        int from = 0, to = 0, cost = 0;
        PriorityQueue<Connect> pq = new PriorityQueue<>(links);

        while (!pq.isEmpty() && count < N - 1) {
            Connect link = pq.poll();
            from = link.from;
            to = link.to;
            cost = link.cost;

            if (isCycle(from, to))
                continue;
            union(from, to);
            count++;
            answer += cost;
        }
        return answer;
    }
}
