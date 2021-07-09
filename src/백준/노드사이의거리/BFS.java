package 백준.노드사이의거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
    public static void main(String[] args) throws IOException {
        int x = 0, y = 0, len = 0, N = 0, M = 0;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        int[][] map = new int[N + 1][N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            len = Integer.parseInt(st.nextToken());

            map[x][y] = map[y][x] = len;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            sb.append(BFS(map, x, y)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int BFS(int[][] map, int x, int y) {
        int result = 0;
        boolean flag = false;
        boolean[] visit = new boolean[map.length];
        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(x, 0));

        while (!queue.isEmpty()) {
            Info cur = queue.poll();

            for (int i = 1; i < map.length; i++) {
                if (map[cur.now][i] != 0 && !visit[i]) {
                    if (i == y) {
                        result = cur.len + map[cur.now][i];
                        flag = true;
                        break;
                    }
                    visit[i] = true;
                    queue.add(new Info(i, map[cur.now][i] + cur.len));
                }
            }
            if (flag)
                break;
        }
        return result;
    }
}

class Info {
    int now;
    int len;

    public Info(int now, int len) {
        this.now = now;
        this.len = len;
    }
}
