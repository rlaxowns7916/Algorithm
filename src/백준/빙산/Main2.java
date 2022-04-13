package 백준.빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static int N = 0, M = 0;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static ArrayList<Point> ices = new ArrayList<>();

    static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        int turn = 0, result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0)
                    ices.add(new Point(i, j));
            }
        }

        while (true) {
            turn++;
            map = melting(map);
            if (ices.isEmpty())
                break;
            else if (isSeperated(map)) {
                result = turn;
                break;
            }
        }
        System.out.println(result);
    }

    public static int[][] melting(int[][] map) {
        int nearIce = 0;
        int x = 0, y = 0, nextX = 0, nextY = 0;
        int[][] newMap = new int[N][M];

        ArrayList<Point> copyIces = new ArrayList<>(ices);
        ices.clear();

        for (Point ice : copyIces) {
            x = ice.x;
            y = ice.y;
            nearIce = 0;
            for (int i = 0; i < 4; i++) {
                nextX = x + dx[i];
                nextY = y + dy[i];
                if (map[nextX][nextY] == 0)
                    nearIce++;
            }
            newMap[x][y] = Math.max(0, map[x][y] - nearIce);
            if (newMap[x][y] > 0)
                ices.add(new Point(x, y));
        }
        return newMap;
    }

    public static boolean isSeperated(int[][] map) {
        int count = 1, x = 0, y = 0, nextX = 0, nextY = 0;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];

        Point start = ices.get(0);
        queue.add(start);
        visit[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            x = now.x;
            y = now.y;

            for (int i = 0; i < 4; i++) {
                nextX = now.x + dx[i];
                nextY = now.y + dy[i];

                if (map[nextX][nextY] > 0 && !visit[nextX][nextY]) {
                    count++;
                    visit[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }

        }

        return count != ices.size();
    }
}
