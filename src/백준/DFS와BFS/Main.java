package 백준.DFS와BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), V = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][N + 1];
        boolean[] visit = new boolean[N + 1];
        visit[V] = true;

        for (int i = 1; i <= N; i++)
            map[i][i] = 1;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            map[v1][v2] = map[v2][v1] = 1;
        }

        dfs(N, V, map, visit);
        bfs(N, V, map);

        System.out.println(sb.toString());
    }

    public static void dfs(int N, int V, int[][] map, boolean[] visit) {
        sb.append(V).append(" ");
        for (int i = 1; i <= N; i++) {
            if (V != i && map[V][i] == 1 && !visit[i]) {
                visit[i] = true;
                dfs(N, i, map, visit);
            }
        }
    }

    public static void bfs(int N, int V, int[][] map) {
        sb.append("\n").append(V).append(" ");
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[N + 1];

        queue.add(V);
        visit[V] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 1; i <= N; i++) {
                if (i != now && !visit[i] && map[now][i] == 1) {
                    visit[i] = true;
                    queue.add(i);
                    sb.append(i).append(" ");
                }
            }
        }
    }
}
