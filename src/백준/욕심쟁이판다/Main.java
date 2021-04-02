package 백준.욕심쟁이판다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, max = 0;
    public static int[][] Map;
    public static int[][] Dp;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Map = new int[N][N];
        Dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                Map[i][j] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                find(i, j);
        }
        System.out.println(max);
    }

    public static int find(int x, int y) {
        int nx = 0, ny = 0;

        if (Dp[x][y] != 0)
            return Dp[x][y];

        Dp[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];

            if (promising(nx, ny) && Map[x][y] < Map[nx][ny])
                Dp[x][y] = Math.max(Dp[x][y], find(nx, ny) + 1);
        }
        max = Math.max(Dp[x][y], max);
        return Dp[x][y];
    }

    public static boolean promising(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}