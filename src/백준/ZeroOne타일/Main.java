package 백준.ZeroOne타일;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static long[] dp = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(getTiles(N));
    }

    public static long getTiles(int num) {
        if (num <= 2)
            return num;
        else if (dp[num] != 0)
            return dp[num];
        else
            return dp[num]  = (getTiles(num - 1) + getTiles(num - 2))%15746;
    }
}