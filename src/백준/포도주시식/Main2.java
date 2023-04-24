package 백준.포도주시식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    int[] wine = new int[10001];
    int[] dp = new int[10001];

    for (int i = 1; i <= n; i++) {
      wine[i] = Integer.parseInt(br.readLine());
    }

    dp[1] = wine[1];
    dp[2] = wine[1] + wine[2];
    for (int i = 3; i <= n; i++) {
      dp[i] = Math.max(dp[i - 2], dp[i - 3] + wine[i - 1]) + wine[i];
      dp[i] = Math.max(dp[i],dp[i-1]);
    }
    System.out.println(dp[n]);
  }

}
