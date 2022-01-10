package 백준.동전1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n = 0, k = 0;
    public static int[] values;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        values = new int[n + 1];
        dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            values[i] = Integer.parseInt(br.readLine());
            dp[i][0] = 1;
        }
        Arrays.sort(values);
        System.out.println(solve(k));
    }

    public static int solve(int k) {
        int i = 0, j = 0;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= k; j++) {
                if (j < values[i])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] + dp[i][j - values[i]];
            }
        }
        return dp[n][k];
    }
}
