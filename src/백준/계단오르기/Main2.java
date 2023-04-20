package 백준.계단오르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] stairs = new int[301];
    int[][] dp = new int[2][301];

    for (int i = 1; i <= N; i++) {
      stairs[i] = Integer.parseInt(br.readLine());
    }

    dp[0][1] = dp[1][1] = stairs[1];
    dp[0][2] = stairs[1] + stairs[2];
    dp[1][2] = stairs[2];

    for(int i=3;i<=N;i++){
      dp[0][i] = dp[1][i-1] +stairs[i];
      dp[1][i] =  Math.max(dp[0][i-2], dp[1][i-2])+stairs[i];
    }

    System.out.println(Math.max(dp[0][N], dp[1][N]));
  }
}
