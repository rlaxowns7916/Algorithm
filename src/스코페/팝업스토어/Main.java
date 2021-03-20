package 스코페.팝업스토어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static int[][] Map;
    public static Queue<Point> queue = new LinkedList<>();
    public static int[] dx = {0, 1};
    public static int[] dy = {1, 0};

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++)
                Map[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(BFS());
    }

    public static int BFS() {
        int i = 0, x = 0, y = 0, nx = 0, ny = 0;
        int[][] weight = new int[N][M];
        weight[0][0] = Map[0][0];
        queue.add(new Point(0, 0));

        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            x = temp.x;
            y = temp.y;

            for (i = 0; i < 2; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (weight[nx][ny] < weight[x][y] + Map[nx][ny]) {
                        weight[nx][ny] = weight[x][y] + Map[nx][ny];
                        queue.add(new Point(nx, ny));
                    }
                }
            }
        }
        return weight[N - 1][M - 1];
    }
}
