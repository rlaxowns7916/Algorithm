package 백준.미로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N = 0;
    public static int[][] map;
    public static int[][] dist;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        init();
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int x, int y) {
        int nowX = 0, nowY = 0, nextX = 0, nextY = 0;
        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(x, y));
        dist[x][y] = 0;

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            nowX = now.x;
            nowY = now.y;
            for (int i = 0; i < 4; i++) {
                nextX = nowX + dx[i];
                nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    if (map[nextX][nextY] == 1) {
                        if (dist[nowX][nowY] < dist[nextX][nextY]) {
                            dist[nextX][nextY] = dist[nowX][nowY];
                            queue.add(new Point(nextX, nextY));
                        }
                    } else {
                        if (dist[nowX][nowY] + 1 < dist[nextX][nextY]) {
                            dist[nextX][nextY] = dist[nowX][nowY] + 1;
                            queue.add(new Point(nextX, nextY));
                        }
                    }
                }
            }
        }
        return dist[N-1][N-1];
    }

    public static void init() {
        map = new int[N][N];
        dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], N * N);
        }
    }
}
