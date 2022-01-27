package 백준.파일합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int T = 0, K = 0;
    public static int[] files;
    public static int[][] dp;
    public static int[] sum;
    public static int INF = 99999999;

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0, k = 0, l = 0, diag = 0;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (i = 0; i < T; i++) {
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            files = new int[K + 1];
            dp = new int[K + 1][K + 1];
            sum = new int[K + 1];
            for (j = 1; j <= K; j++) {
                Arrays.fill(dp[j], INF);
                files[j] = Integer.parseInt(st.nextToken());
                dp[j][j] = 0;
                sum[j] = sum[j - 1] + files[j];
            }

            for (diag = 1; diag < K; diag++) {
                for (j = 1; j <= K - diag; j++) {
                    k = j + diag;
                    for (l = 1; l < k; l++)
                        dp[j][k] = Math.min(dp[j][k], dp[j][l] + dp[l + 1][k] + sum[k] - sum[j - 1]);
                }
            }
            sb.append(dp[1][K]).append("\n");
        }
        System.out.println(sb);

    }
}
