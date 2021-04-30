package 백준.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0, H = 0, count = 0, total = 0;
    public static int[] dh = {-1, 1, 0, 0, 0, 0};
    public static int[] dx = {0, 0, -1, 0, 1, 0};
    public static int[] dy = {0, 0, 0, 1, 0, -1};
    public static int[][][] Map, visit;
    public static Queue<Point> tomato = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0, k = 0, val = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        Map = new int[H][N][M];
        visit = new int[H][N][M];

        for (i = 0; i < H; i++) {
            for (j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (k = 0; k < M; k++) {
                    val = Integer.parseInt(st.nextToken());
                    Map[i][j][k] = val;
                    if (val == 1) {
                        tomato.add(new Point(i, j, k));
                        visit[i][j][k] = 1;
                    } else if (val == 0)
                        total++;
                }
            }
        }
        System.out.println(func());
    }

    public static int func() {
        int x = 0, y = 0, h = 0, val = 0, i = 0, j = 0, nh = 0, nx = 0, ny = 0, turn = 0, size = 0;
        if (total == 0)
            return 0;

        while (!tomato.isEmpty()) {
            size = tomato.size();
            for (i = 0; i < size; i++) {
                Point now = tomato.poll();
                h = now.height;
                x = now.x;
                y = now.y;

                for (j = 0; j < 6; j++) {
                    nh = h + dh[j];
                    nx = x + dx[j];
                    ny = y + dy[j];

                    if (isPromising(nh, nx, ny)) {
                        visit[nh][nx][ny] = visit[h][x][y] + 1;
                        tomato.add(new Point(nh, nx, ny));
                        count++;
                    }
                }
            }
            turn++;
        }
        return count == total ? turn - 1 : -1;
    }

    public static boolean isPromising(int height, int x, int y) {
        return 0 <= height && height < H && 0 <= x && x < N && 0 <= y && y < M && Map[height][x][y] == 0 && visit[height][x][y] == 0;
    }
}

class Point {
    int height = 0;
    int x = 0;
    int y = 0;

    public Point(int height, int x, int y) {
        this.height = height;
        this.x = x;
        this.y = y;
    }
}
