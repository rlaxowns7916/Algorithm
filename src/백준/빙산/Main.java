package 백준.빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

  public static int[][] map;
  public static int N = 0, M = 0;
  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    System.out.println(melting());
  }

  public static int melting() {
    int turn = 0;
    int nextX = 0, nextY = 0;
    boolean iceExist = false;

    if (isSeparate(map)) {
      return 0;
    }

    while (true) {
      turn++;
      iceExist = false;
      int[][] nextMap = new int[N][M];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (map[i][j] > 0) {
            int nearSea = 0;
            iceExist = true;
            for (int k = 0; k < 4; k++) {
              nextX = i + dx[k];
              nextY = j + dy[k];

              if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && map[nextX][nextY] == 0) {
                nearSea++;
              }
            }
            nextMap[i][j] = Math.max(0, map[i][j] - nearSea);
          }
        }
      }
      if (!iceExist) {
        return 0;
      } else if (isSeparate(nextMap)) {
        break;
      } else {
        map = nextMap;
      }
    }
    return turn;
  }

  public static boolean isSeparate(int[][] nextMap) {
    boolean isFirst = true;
    boolean[][] visit = new boolean[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if ((nextMap[i][j] > 0) && !visit[i][j]) {
          if (isFirst) {
            bfs(nextMap, visit, i, j);
            isFirst = false;
          } else {
            return true;
          }
        }
      }
    }
    return false;
  }

  public static void bfs(int[][] nextMap, boolean[][] visit, int x, int y) {
    int nowX = 0, nowY = 0, nextX = 0, nextY = 0;
    Queue<Point> queue = new LinkedList<>();
    visit[x][y] = true;
    queue.add(new Point(x, y));

    while (!queue.isEmpty()) {
      Point now = queue.poll();

      nowX = now.x;
      nowY = now.y;

      for (int i = 0; i < 4; i++) {
        nextX = nowX + dx[i];
        nextY = nowY + dy[i];

        if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && nextMap[nextX][nextY] > 0
            && !visit[nextX][nextY]) {
          visit[nextX][nextY] = true;
          queue.add(new Point(nextX, nextY));
        }
      }
    }
  }
}

class Point {

  int x = 0;
  int y = 0;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
