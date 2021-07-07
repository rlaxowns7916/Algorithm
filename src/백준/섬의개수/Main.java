package 백준.섬의개수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringTokenizer st;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        int w = 0, h = 0;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;
            sb.append(solve(w, h)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int solve(int w, int h) throws IOException {
        int cnt = 0;
        int[][] map = new int[h][w];
        input(map, w, h);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 1) {
                    cnt++;
                    bfs(map, i, j);
                }
            }
        }
        return cnt;
    }

    public static void input(int[][] map, int w, int h) throws IOException {
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++)
                map[i][j] = st.nextToken().charAt(0) - '0';
        }
    }

    public static void bfs(int[][] map, int x, int y) {
        int nx = 0, ny = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        map[x][y] = -1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            for (int i = 0; i < 8; i++) {
                nx = now.x + dx[i];
                ny = now.y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && map[nx][ny] == 1) {
                    queue.add(new Point(nx, ny));
                    map[nx][ny] = -1;
                }
            }
        }

    }

    public static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

