package 백준.보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

  public static int L = 0, W = 0;
  public static int[][] map;

  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int max = 0;

    L = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());

    map = new int[L][W];

    for (int i = 0; i < L; i++) {
      String input = br.readLine();
      for (int j = 0; j < W; j++) {
        map[i][j] = input.charAt(j);
      }
    }

    for (int i = 0; i < L; i++) {
      for (int j = 0; j < W; j++) {
        if (map[i][j] == 'L') {
          max = Math.max(max, bfs(i, j));
        }
      }
    }
    System.out.println(max);
  }

  public static int bfs(int x, int y) {
    int max = -1;
    int nx = 0, ny = 0;
    boolean[][] visit = new boolean[L][W];

    Queue<Point> queue = new LinkedList<>();
    queue.add(new Point(x, y));
    visit[x][y] = true;

    while (!queue.isEmpty()) {
      int size = queue.size();
      max++;
      for (int i = 0; i < size; i++) {
        Point now = queue.poll();

        for (int j = 0; j < 4; j++) {
          nx = now.x + dx[j];
          ny = now.y + dy[j];

          if (nx >= 0 && nx < L && ny >= 0 && ny < W && map[nx][ny] == 'L' && !visit[nx][ny]) {
            queue.add(new Point(nx, ny));
            visit[nx][ny] = true;
          }
        }
      }
    }
    return max;
  }

  static class Point {

    int x = 0;
    int y = 0;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}