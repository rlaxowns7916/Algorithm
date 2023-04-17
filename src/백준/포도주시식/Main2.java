package 백준.포도주시식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] origin = new int[N+1];
    int[] dp = new int[N+1];

    for (int i = 1; i <= N; i++) {
      origin[i] = Integer.parseInt(br.readLine());
    }

    if (N <= 2) {
      dp[1] = origin[1];
      if (N == 2) {
        dp[2] = origin[1] + origin[2];
      }
    }

    for (int i = 3; i <= N; i++) {
      dp[i] = Math.max(dp[i-3] + origin[i-1],dp[i-2]) + origin[i];
    }
    System.out.println(Math.max(dp[N], dp[N - 1]));
  }
}
