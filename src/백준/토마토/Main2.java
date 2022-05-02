package 백준.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    /**
     * M: 가로칸
     * N: 세로칸
     */
    public static int M = 0, N = 0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int youngTomatoes;

    static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Queue<Point> oldTomatoes = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    oldTomatoes.add(new Point(i, j));
                else if (map[i][j] == 0)
                    youngTomatoes++;
            }
        }
        System.out.println(solve());
    }

    public static int solve() {
        int x = 0, y = 0, nextX = 0, nextY = 0;
        int turn = 0, size = 0;

        while (!oldTomatoes.isEmpty()) {
            size = oldTomatoes.size();
            for (int i = 0; i < size; i++) {
                Point now = oldTomatoes.poll();

                x = now.x;
                y = now.y;

                for (int j = 0; j < 4; j++) {
                    nextX = x + dx[j];
                    nextY = y + dy[j];

                    if (nextX>=0 && nextY >=0 && nextX < N && nextY < M && map[nextX][nextY] == 0) {
                        map[nextX][nextY] = 1;
                        oldTomatoes.add(new Point(nextX, nextY));
                        youngTomatoes--;
                    }
                }
            }
            turn++;
        }
        if (youngTomatoes == 0)
            return turn-1;
        else
            return -1;
    }
}
