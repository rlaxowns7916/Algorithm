package 백준.최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int V = 0, E = 0, INF = 1000000000;
    public static boolean[] visit;
    public static int[] distance;
    public static ArrayList<Node>[] map;

    static class Node implements Comparable<Node> {
        int target;
        int weight;

        public Node(int target, int weight) {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        int i = 0;
        int start = 0, from = 0, to = 0, weight = 0;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        map = new ArrayList[V + 1];
        distance = new int[V + 1];
        visit = new boolean[V + 1];

        for (i = 1; i <= V; i++) {
            map[i] = new ArrayList<>();
            distance[i] = INF;
        }
        distance[start] = 0;
        for (i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            map[from].add(new Node(to, weight));
        }
        dijkkstra(start);
        for (i = 1; i <= V; i++) {
            if (distance[i] == INF)
                sb.append("INF");
            else
                sb.append(distance[i]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkkstra(int start) {
        int i = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        Node current = null, next = null;

        while (!pq.isEmpty()) {
            current = pq.poll();
            if (visit[current.target])
                continue;

            visit[current.target] = true;
            for (i = 0; i < map[current.target].size(); i++) {
                next = map[current.target].get(i);
                if (visit[next.target])
                    continue;

                if (distance[next.target] > current.weight + next.weight) {
                    distance[next.target] = current.weight + next.weight;
                    pq.add(new Node(next.target, distance[next.target]));
                }
            }
        }
    }
}
