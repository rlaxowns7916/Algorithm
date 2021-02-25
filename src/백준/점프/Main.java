package 백준.점프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), i = 0, j = 0;
        int[][] map = new int[n][n];
        long[][] dp = new long[n][n];

        for (i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < n; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = 1;
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                if (map[i][j]!=0 && dp[i][j] != 0) {
                    if (i + map[i][j] < n)
                        dp[i + map[i][j]][j] += dp[i][j];
                    if (j + map[i][j] < n)
                        dp[i][j + map[i][j]] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }
}
