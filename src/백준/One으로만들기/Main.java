package 백준.One으로만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];

        System.out.println(func(n));

    }

    public static int func(int idx) {
        if(idx == 1)
            return 0;
        else if (dp[idx] != 0)
            return dp[idx];
        else {
            if (idx % 3 == 0 && idx % 2 == 0)
                return dp[idx] = Math.min(func(idx/3), Math.min(func(idx-1), func(idx/2))) + 1;
            else if (idx % 3 == 0)
                return dp[idx] = Math.min(func(idx/3), func(idx-1)) + 1;
            else if (idx % 2 == 0)
                return dp[idx] = Math.min(func(idx/2), func(idx-1)) + 1;
            else
                return dp[idx] = func(idx-1) + 1;
        }
    }
}
