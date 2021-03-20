package 스코페.배송전략실험;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static String input;
    public static boolean[] check;
    public static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, len = Integer.parseInt(br.readLine());
        input = br.readLine();
        check = new boolean[len + 1];
        dp = new long[len + 1];

        Arrays.fill(dp, -1);
        dp[1] = 1;
        for (i = 1; i <= len; i++) {
            if (input.charAt(i - 1) - '0' == 1)
                check[i] = true;
        }
        System.out.println(func(len));
    }

    public static long func(int target) {
        if (target > 0) {
            if (dp[target] != -1)
                return dp[target];
            else if (!check[target])
                return dp[target] = 0;
            else
                return dp[target] = func(target - 1) + func(target - 2);
        } else
            return 0;
    }
}
