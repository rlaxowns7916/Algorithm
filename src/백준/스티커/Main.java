package 백준.스티커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int T = 0, n = 0;

    public static void main(String[] args) throws IOException {
        int[][] stickers;
        int[][] dp;
        int max = 0;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());
            stickers = new int[2][100001];
            dp = new int[2][100001];

            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++)
                    stickers[j][k] = Integer.parseInt(st.nextToken());
            }

            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];

            dp[0][1] = dp[1][0] + stickers[0][1];
            dp[1][1] = dp[0][0] + stickers[1][1];

            for (int j = 2; j <= n; j++) {
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + stickers[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + stickers[1][j];
            }
            max = Math.max(dp[0][n], dp[1][n]);
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
