package 백준.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static int[] stairs;
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        stairs = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++)
            stairs[i] = Integer.parseInt(br.readLine());
        System.out.println(getMaxScore(N));
    }

    public static int getMaxScore(int score) {
        if (score <= 0)
            return 0;
        else if (dp[score] != 0)
            return dp[score];
        else {
            dp[score] = Math.max(getMaxScore(score - 2), getMaxScore(score - 3) + stairs[score - 1]) + stairs[score];
            return dp[score];
        }
    }
}
