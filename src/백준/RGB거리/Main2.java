package 백준.RGB거리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[][] home = new int[N][3];
    int[][] dp = new int[N][3];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        home[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    System.arraycopy(home[0], 0, dp[0], 0, 3);
    for (int i = 1; i < N; i++) {
      dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + home[i][0];
      dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + home[i][1];
      dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + home[i][2];
    }

    System.out.println(Math.min(Math.min(dp[N - 1][0], dp[N - 1][1]), dp[N - 1][2]));
  }
}