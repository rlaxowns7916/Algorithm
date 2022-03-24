package 기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 그리디 알고리즘
 * 정점을 기준으로 정렬
 * MST (최소비용신장트리)를 만드는 방법 중 하나
 */
public class Prim {
    public static int N = 0, M = 0;
    public static ArrayList<Connect>[] links;

    static class Connect implements Comparable<Connect> {
        int to = 0;
        int cost = 0;

        public Connect(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Connect o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        int from = 0, to = 0, cost = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        links = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++)
            links[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            links[from].add(new Connect(to, cost));
            links[to].add(new Connect(from, cost));
        }

        System.out.println(prim());
    }

    public static int prim() {
        int now = 1, count = 1, answer = 0;
        int to = 0, cost = 0;
        boolean[] visit = new boolean[N + 1];
        PriorityQueue<Connect> pq = new PriorityQueue<>();

        visit[now] = true;
        pq.addAll(links[now]);

        while (!pq.isEmpty() && count < N) {
            Connect link = pq.poll();

            to = link.to;
            cost = link.cost;

            if (visit[to])
                continue;
            count++;
            visit[to] = true;
            pq.addAll(links[to]);
            answer += cost;
        }
        return answer;
    }
}
