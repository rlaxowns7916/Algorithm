package 백준.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {
    /**
     * V : 정점의 개수
     * E : 간선의 개수
     */
    public static int V = 0, E = 0;
    public static int INF = 99999999;

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static ArrayList<Node>[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = 0, from = 0, to = 0, weight = 0;

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        nodes = new ArrayList[V+1];

        for (int i = 1; i <= V; i++)
            nodes[i] = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            nodes[from].add(new Node(to, weight));
        }
        System.out.println(solve(start));
    }

    public static String solve(int start) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dist = new int[V+1];

        Arrays.fill(dist, INF);
        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node road : nodes[now.to]) {
                if (dist[road.to] > dist[now.to] + road.weight) {
                    dist[road.to] = dist[now.to] + road.weight;
                    pq.add(new Node(road.to, dist[road.to]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF)
                sb.append("INF");
            else
                sb.append(dist[i]);
            sb.append("\n");
        }
        return sb.toString();
    }
}
