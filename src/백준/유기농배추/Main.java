package 백준.유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};
  public static int[][] map;
  public static int N = 0, M = 0, K = 0;

  public static void main(String[] args) throws IOException {
    int T = 0;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    T = Integer.parseInt(st.nextToken());

    for (int i = 0; i < T; i++) {
      int count = 0;
      st = new StringTokenizer(br.readLine());
      M = Integer.parseInt(st.nextToken());
      N = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());

      ArrayList<Point> vegetables = new ArrayList<>();

      map = new int[N][M];
      for (int j = 0; j < K; j++) {
        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        map[y][x] = 1;
        vegetables.add(new Point(y, x));
      }

      for (Point vegetable : vegetables) {
        if (map[vegetable.x][vegetable.y] == 1) {
          bfs(vegetable.x, vegetable.y);
          count++;
        }
      }
      sb.append(count).append("\n");
    }
    System.out.println(sb);
  }

  public static void bfs(int x, int y) {
    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(x, y));
    map[x][y] = 0;
    while (!queue.isEmpty()) {

      Point now = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nextX = now.x + dx[i];
        int nextY = now.y + dy[i];

        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M
            && map[nextX][nextY] == 1) {
          queue.add(new Point(nextX, nextY));
          map[nextX][nextY] = 0;
        }
      }
    }
  }
}

class Point {

  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
