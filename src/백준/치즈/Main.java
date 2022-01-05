package 백준.치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[][] cheese;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int N = 0, M = 0, cheeseCount, turn = 0, prevCount = 0;
    public static Queue<Point> airs = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        int i = 0, j = 0, air = 0;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheese = new int[N][M];

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < M; j++) {
                air = Integer.parseInt(st.nextToken());
                cheese[i][j] = air;
                if (air == 1)
                    cheeseCount++;
            }
        }

        while (cheeseCount > 0) {
            turn++;
            prevCount = cheeseCount;
            melting();
        }
        sb.append(turn).append("\n");
        sb.append(prevCount).append("\n");

        System.out.println(sb);

    }

    public static void melting() {
        int i = 0, j = 0, x = 0, y = 0, nx = 0, ny = 0;
        prevCount = cheeseCount;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];

        Point now;
        queue.add(new Point(0, 0));
        visit[0][0] = true;


        while (!queue.isEmpty()) {
            now = queue.poll();
            x = now.x;
            y = now.y;

            for (i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny]) {
                    if (cheese[nx][ny] == 1) {
                        cheese[nx][ny] = 0;
                        cheeseCount--;
                    } else
                        queue.add(new Point(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }
}

class Point {
    int x = 0;
    int y = 0;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
