package 백준.욕심쟁이판다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static int N = 0;
    public static int max = 0;
    public static int[][] map;
    public static int[][] dp;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0)
                    max = Math.max(max, dfs(i, j));
            }
        }
        System.out.println(max);
    }

    public static int dfs(int x, int y) {
        int nextX = 0;
        int nextY = 0;
        if (dp[x][y] != 0)
            return dp[x][y];
        else {
            dp[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                nextX = x + dx[i];
                nextY = y + dy[i];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && map[x][y] < map[nextX][nextY])
                    dp[x][y] = Math.max(dp[x][y], dfs(nextX, nextY) + 1);
            }
            return dp[x][y];
        }
    }
}
