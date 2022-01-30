package 백준.최소비용구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
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

    public static int N = 0, M = 0, INF = 1000000000;
    public static ArrayList<Node>[] map;

    public static void main(String[] args) throws IOException {
        int i = 0, from = 0, to = 0, weight = 0, start = 0, end = 0;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new ArrayList[N + 1];
        for (i = 1; i <= N; i++)
            map[i] = new ArrayList<>();
        for (i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            map[from].add(new Node(to, weight));
        }
        st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        System.out.println(djikstra(start, end));
    }

    public static int djikstra(int start, int end) {
        Node current = null, next = null;
        boolean[] visit = new boolean[N + 1];
        int[] distance = new int[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(distance, INF);
        distance[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            current = pq.poll();

            if (visit[current.target])
                continue;
            visit[current.target] = true;

            for (int i = 0; i < map[current.target].size(); i++) {
                next = map[current.target].get(i);
                if (distance[next.target] > current.weight + next.weight) {
                    distance[next.target] = current.weight + next.weight;
                    pq.add(new Node(next.target, distance[next.target]));
                }
            }
        }

        return distance[end];
    }
}
