package 백준.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            map[v1][v2] = map[v2][v1] = 1;
        }
        System.out.println(BFS(map));
    }

    public static int BFS(int[][] map) {
        int count = 0, now = 0, i = 0;
        boolean[] visit = new boolean[N + 1];
        visit[1] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            now = queue.poll();

            for (i = 1; i <= N; i++) {
                if (!visit[i] && map[now][i] == 1) {
                    visit[i] = true;
                    queue.add(i);
                    count++;
                }
            }
        }
        return count;
    }
}