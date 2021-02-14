package 백준.합분해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, K = 0;
    public static int[][] dp = new int[201][201];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(func());
    }

    public static int func() {
        int i = 0, j = 0, k = 0, l = 0;

        Arrays.fill(dp[1], 1);
        for (i = 2; i <= K; i++) {
            for (j = 0; j <= N; j++) {
                if (j == 0)
                    dp[i][j] = 1;
                else{
                    for(k=0;k<=j;k++){
                        dp[i][j] += dp[i-1][j-k];
                        dp[i][j] %= 1000000000;
                    }
                }
            }
        }
        return dp[K][N];
    }
}