package 백준.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), i = 0;
        int[] stairs = new int[N];
        int[] dp = new int[N];
        for (i = 0; i < N; i++)
            stairs[N - 1 - i] = Integer.parseInt(br.readLine());

        if (N < 3) {
            if (N == 1)
                System.out.println(stairs[0]);
            else
                System.out.println(stairs[0] + stairs[1]);
        } else {
            dp[0] = stairs[0];
            dp[1] = dp[0] + stairs[1];
            dp[2] = dp[0] + stairs[2];
            for (i = 3; i < N; i++)
                dp[i] = Math.max(dp[i - 2] + stairs[i], dp[i - 3] + stairs[i - 1] + stairs[i]);

            System.out.println(Math.max(dp[N - 1], dp[N - 2]));
        }
    }
}
