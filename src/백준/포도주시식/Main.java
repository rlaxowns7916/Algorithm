package 백준.포도주시식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] wine = new int[N + 1];
        for (int i = 1; i <= N; i++)
            wine[i] = Integer.parseInt(br.readLine());

        System.out.println(func(wine));
    }

    public static int func(int[] wine) {
        if (N < 3) {
            if (N == 2)
                return wine[1] + wine[2];
            else
                return wine[1];
        } else {
            int[] dp = new int[10001];
            dp[1] = wine[1];
            dp[2] = wine[1] + wine[2];

            for (int i = 3; i <= N; i++)
                dp[i] = Math.max(Math.max(dp[i - 3] + wine[i - 1], dp[i - 2]) + wine[i], dp[i - 1]);

            return dp[N];
        }
    }
}