package 백준.노드사이의거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {
    public static int N = 0, M = 0, INF = Integer.MAX_VALUE;
    public static long[][] map;
    public static boolean[] upToDate;
    public static long[][] path;

    public static void main(String[] args) throws IOException {
        int x = 0, y = 0;
        long len = 0;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new long[N + 1][N + 1];
        upToDate = new boolean[N + 1];
        path = new long[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(path[i], INF);
            Arrays.fill(map[i], INF);
            map[i][i] = path[i][i] = 0;
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            len = Long.parseLong(st.nextToken());

            map[x][y] = map[y][x] = len;
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());

            sb.append(solve(x, y)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static long solve(int x, int y) {
        if (!upToDate[x]) {
            dijkstra(x);
            upToDate[x] = true;
        }
        return path[x][y];
    }

    public static void dijkstra(int x) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(x, x, 0));

        while (!pq.isEmpty()) {
            Point now = pq.poll();
            for (int i = 1; i <= N; i++) {
                if (path[x][i] > path[x][now.y] + map[now.y][i]) {
                    path[x][i] = path[x][now.y] + map[now.y][i];
                    pq.add(new Point(x, i, path[x][i]));
                }
            }
        }

    }
}
class Point implements Comparable<Point> {
    int x = 0;
    int y = 0;
    long len = 0;

    public Point(int x, int y, long len) {
        this.x = x;
        this.y = y;
        this.len = len;
    }

    @Override
    public int compareTo(Point o) {
        return Long.compare(this.len, o.len);
    }
}