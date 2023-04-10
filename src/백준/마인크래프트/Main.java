package 백준.마인크래프트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static int N = 0, M = 0, B = 0;
  public static int[][] map;

  public static void main(String[] args) throws IOException {
    long minTime = Long.MAX_VALUE;
    int blocks = 0, max = 0, min = 0, height = 0;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    B = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        blocks += map[i][j];
      }
    }

    max = (blocks + B) / (N * M);
    min = blocks / (N * M);

    for (int i = min; i <= Math.min(max, 256); i++) {
      long time = solve(i, height);
      if (minTime >= time) {
        minTime = time;
        height = i;
      }
    }
    sb.append(minTime).append(" ").append(height);
    System.out.println(sb);
  }

  public static long solve(int target, int height) {
    long sum = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (target > map[i][j]) {
          sum += target - map[i][j];
        } else if (target < map[i][j]) {
          sum += 2L * (map[i][j] - target);
        }
      }
    }
    return sum;
  }
}
