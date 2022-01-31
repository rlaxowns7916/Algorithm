package 백준.내려가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static int[][] map;
    public static int[][][] dp;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0, min = 0, one = 0, two = 0, three = 0;
        N = Integer.parseInt(br.readLine());
        dp = new int[2][N + 1][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            one = Integer.parseInt(st.nextToken());
            two = Integer.parseInt(st.nextToken());
            three = Integer.parseInt(st.nextToken());

            dp[0][i][0] = Math.max(dp[0][i - 1][0], dp[0][i - 1][1]) + one;
            dp[1][i][0] = Math.min(dp[1][i - 1][0], dp[1][i - 1][1]) + one;


            dp[0][i][1] = Math.max(Math.max(dp[0][i - 1][0], dp[0][i - 1][1]), dp[0][i - 1][2]) + two;
            dp[1][i][1] = Math.min(Math.min(dp[1][i - 1][0], dp[1][i - 1][1]), dp[1][i - 1][2]) + two;


            dp[0][i][2] = Math.max(dp[0][i - 1][1], dp[0][i - 1][2]) + three;
            dp[1][i][2] = Math.min(dp[1][i - 1][1], dp[1][i - 1][2]) + three;
        }
        max = Math.max(Math.max(dp[0][N][0], dp[0][N][1]), dp[0][N][2]);
        min = Math.min(Math.min(dp[1][N][0], dp[1][N][1]), dp[1][N][2]);
        System.out.println(max + " " + min);
    }
}
