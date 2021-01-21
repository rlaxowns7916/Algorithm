package 백준.파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N = 0, M = 0, X = 0, INF = 999999;

    public static class Node implements Comparable<Node> {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Node>> map = new ArrayList<>(), reverseMap = new ArrayList<>();
        int i = 0, j = 0, start = 0, end = 0, weight = 0;
        int[] ans, revAns;

        N = Integer.parseInt(st.nextToken());//마을의 수
        M = Integer.parseInt(st.nextToken());//도로의 수
        X = Integer.parseInt(st.nextToken());//목적지

        for (i = 0; i <= N; i++) {
            map.add(new ArrayList<>());
            reverseMap.add(new ArrayList<>());
        }

        for (i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            weight = Integer.parseInt(st.nextToken());

            map.get(start).add(new Node(end, weight));
            reverseMap.get(end).add(new Node(start, weight));
        }

        ans = dijkstra(X, map);
        revAns = dijkstra(X, reverseMap);
        System.out.println(print(ans, revAns));
    }

    public static int[] dijkstra(int start, List<List<Node>> map) {
        int i = 0, j = 0;
        int[] ans = new int[N + 1];
        boolean[] visit = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        Arrays.fill(ans, INF);
        pq.add(new Node(start, 0));
        ans[start] = 0;

        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            int index = temp.target;
            if (visit[index])
                continue;
            else {
                visit[index] = true;
                for(Node node : map.get(index)){
                    if(ans[node.target] > ans[index] + node.weight){
                        ans[node.target] = ans[index] + node.weight;
                        pq.add(new Node(node.target,ans[node.target]));
                    }
                }
            }
        }
        return ans;
    }

    public static int print(int[] ans, int[] revAns) {
        int max = 0, i = 0;
        for (i = 1; i <= N; i++)
            max = max < ans[i] + revAns[i] ? ans[i] + revAns[i] : max;

        return max;
    }
}