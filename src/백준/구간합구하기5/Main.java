package 백준.구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static int N = 0, M = 0;

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int[][] cumulativeSum;

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    cumulativeSum = new int[N + 1][N + 1];

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
          cumulativeSum[i][j] =
              Integer.parseInt(st.nextToken()) + cumulativeSum[i][j - 1] + cumulativeSum[i - 1][j] - cumulativeSum[i-1][j-1];
      }
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int x1 = Integer.parseInt(st.nextToken());
      int y1 = Integer.parseInt(st.nextToken());

      int x2 = Integer.parseInt(st.nextToken());
      int y2 = Integer.parseInt(st.nextToken());

      sb.append(getSum(x1, y1, x2, y2, cumulativeSum)).append("\n");
    }
    System.out.println(sb);
  }

  public static int getSum(int x1, int y1, int x2, int y2, int[][] cumulativeSum) {
    return cumulativeSum[x2][y2] - cumulativeSum[x1-1][y2] - cumulativeSum[x2][y1-1] + cumulativeSum[x1-1][y1-1];
  }
}
