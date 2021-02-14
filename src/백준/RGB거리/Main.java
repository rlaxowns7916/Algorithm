package 백준.RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static int[][] Map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, j = 0;
        N = Integer.parseInt(br.readLine());
        Map = new int[N][3];

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < 3; j++)
                Map[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(func());
    }

    public static int func() {
        int i = 0, j = 0, k = 0, min = Integer.MAX_VALUE;
        int[][] dp = new int[N][3];

        for (i = 0; i < 3; i++)
            dp[0][i] = Map[0][i];

        for (i = 1; i < N; i++) {
            for (j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (k = 0; k < 3; k++) {
                    if (j != k)
                        dp[i][j] = Math.min(dp[i][j], Map[i][j] + dp[i - 1][k]);
                }
            }
        }
        return Math.min(dp[N-1][0],Math.min(dp[N-1][1],dp[N-1][2]));
    }
}