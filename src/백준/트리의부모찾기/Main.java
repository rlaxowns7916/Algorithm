package 백준.트리의부모찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static ArrayList<Integer>[] tree;
    public static int[] parent;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, from = 0, to = 0, n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        visit = new boolean[n + 1];
        parent = new int[n + 1];
        for (i = 0; i <= n; i++)
            tree[i] = new ArrayList<>();

        for (i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            tree[from].add(to);
            tree[to].add(from);
        }
        visit[1] = true;
        dfs(1);
        for (i = 2; i <= n; i++)
            sb.append(parent[i]).append("\n");
        System.out.println(sb);

    }

    public static void dfs(int start) {
        for (Integer child : tree[start]) {
            if (!visit[child]) {
                parent[child] = start;
                visit[child] = true;
                dfs(child);

            }
        }
    }
}