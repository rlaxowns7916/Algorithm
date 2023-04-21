package 백준.스티커;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

  public static void main(String[] args) throws IOException {
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int max = 0;
      int n = Integer.parseInt(br.readLine());
      int[][] stickers = new int[2][100001];
      for (int i = 0; i < 2; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < n; j++) {
          stickers[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      int[][] dp = new int[2][100001];
      dp[0][0] = stickers[0][0];
      dp[1][0] = stickers[1][0];
      dp[0][1] = dp[1][0] + stickers[0][1];
      dp[1][1] = dp[0][0] + stickers[1][1];

      if (n <= 2) {
        max = Math.max(Math.max(dp[0][0], dp[1][0]), Math.max(dp[0][1], dp[1][1]));
      } else {

        for (int i = 2; i < n; i++) {
          dp[0][i] = Math.max(Math.max(dp[0][i - 2], dp[1][i - 2]), dp[1][i - 1]) + stickers[0][i];
          dp[1][i] = Math.max(Math.max(dp[0][i - 2], dp[1][i - 2]), dp[0][i - 1]) + stickers[1][i];

        }
        max = Math.max(Math.max(dp[0][n-2],dp[1][n-2]),Math.max(dp[0][n-1],dp[1][n-1]));
      }

      sb.append(max).append("\n");
    }
    System.out.println(sb);
  }
}