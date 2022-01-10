package 백준.동물원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;
        System.out.println(solve(N));
    }

    public static int solve(int target) {
        for (int i = 2; i <= target; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }
        return (dp[target][0] + dp[target][1] + dp[target][2]) % 9901;
    }
}
