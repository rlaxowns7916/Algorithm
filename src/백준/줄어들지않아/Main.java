package 백준.줄어들지않아;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static long[][] dp = new long[65][10];
    public static boolean[] visit = new boolean[65];

    public static void main(String[] args) throws IOException {
        int T = 0, n = 0;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        Arrays.fill(dp[1], 1);
        visit[1] = true;

        for (int i = 0; i < T; i++) {
            n = Integer.parseInt(br.readLine());

            sb.append(solve(n)).append("\n");
        }
        System.out.println(sb);
    }

    public static long solve(int n) {
        if (!visit[n]) {
            for (int i = 1; i <= n; i++) {
                if (visit[i])
                    continue;
                else {
                    for (int j = 0; j < 10; j++)
                        dp[i][j] = calculate(i, j);
                }
                visit[i] = true;
            }
        }
        return getAnswer(n);
    }

    public static long getAnswer(int n) {
        long sum = 0;
        for (int i = 0; i < 10; i++)
            sum += dp[n][i];
        return sum;
    }

    public static long calculate(int row, int column) {
        long sum = 0;
        for (int i = column; i < 10; i++)
            sum += dp[row - 1][i];
        return sum;
    }
}
