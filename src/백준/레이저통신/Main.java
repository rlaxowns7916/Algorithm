package 백준.레이저통신;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int W = 0, H = 0;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static char[][] map;
    public static Point target;
    public static int INF = 999999;

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
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];

        for (int i = 0; i < H; i++) {
            String input = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'C')
                    target = new Point(i, j);
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        int nowX = 0, nowY = 0, nextX = 0, nextY = 0;
        int ans = 0, size = 0, turn = 0;
        boolean flag = false;
        Queue<Point> queue = new LinkedList<>();
        int[][] dist = new int[H][W];

        for (int i = 0; i < H; i++)
            Arrays.fill(dist[i], INF);

        queue.add(target);
        dist[target.x][target.y] = 0;

        while (!queue.isEmpty() && !flag) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                Point now = queue.poll();
                nowX = now.x;
                nowY = now.y;
                if (map[nowX][nowY] == 'C' && (nowX != target.x || nowY != target.y)) {
                    ans = dist[nowX][nowY];
                    flag = true;
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    nextX = nowX;
                    nextY = nowY;
                    while (true) {
                        nextX += dx[j];
                        nextY += dy[j];
                        if (nextX >= 0 && nextX < H && nextY >= 0 && nextY < W && map[nextX][nextY] != '*') {
                            if (dist[nextX][nextY] > turn) {
                                dist[nextX][nextY] = turn;
                                queue.add(new Point(nextX, nextY));
                            }
                        } else
                            break;
                    }
                }
            }
            turn++;
        }
        return ans;
    }
}
