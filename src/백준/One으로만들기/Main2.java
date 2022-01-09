package 백준.One으로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        dp = new int[x + 1];

        solve(x, 0);
        System.out.println(dp[1]);
    }

    public static void solve(int value, int count) {
        if (value < 1)
            return;
        if (dp[value] == 0 || dp[value] > count){
            dp[value] = count;
            if (value % 3 == 0)
                solve(value / 3, count + 1);
            if (value % 2 == 0)
                solve(value / 2, count + 1);
            solve(value - 1, count + 1);
        }
    }
}
