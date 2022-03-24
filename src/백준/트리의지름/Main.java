package 백준.트리의지름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        int to;
        int cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static ArrayList<ArrayList<Node>> tree = new ArrayList<>();
    public static int farIndex = 0;
    public static int N = 0, max = 0;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        int from = 0, to = 0, cost = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visit = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            tree.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            tree.get(from).add(new Node(to, cost));
            tree.get(to).add(new Node(from, cost));
        }
        dfs(1, 0);
        visit = new boolean[N + 1];
        dfs(farIndex, 0);
        System.out.println(max);
    }

    public static void dfs(int idx, int dist) {
        ArrayList<Node> list = tree.get(idx);
        visit[idx] = true;
        if (max < dist) {
            farIndex = idx;
            max = dist;
        }

        for (Node node : list){
            if(!visit[node.to])
                dfs(node.to, node.cost + dist);
        }
    }
}
