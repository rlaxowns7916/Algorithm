package 백준.바이러스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static int vertex = 0, network = 0;
    public static int map[][];

    public static void main(String[] args) throws IOException {
        int v1 = 0, v2 = 0;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        vertex = Integer.parseInt(br.readLine());
        network = Integer.parseInt(br.readLine());

        map = new int[vertex + 1][vertex + 1];
        for (int i = 0; i < network; i++) {
            st = new StringTokenizer(br.readLine());

            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());

            map[v1][v2] = map[v2][v1] = 1;
        }
        bfs();
    }

    public static void bfs() {
        int count = 0, now = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visit = new boolean[vertex + 1];

        queue.add(1);
        visit[1] = true;

        while (!queue.isEmpty()) {
            now = queue.poll();
            for (int i = 1; i <= vertex; i++) {
                if (map[now][i] == 1 && !visit[i]) {
                    visit[i] = true;
                    queue.add(i);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
