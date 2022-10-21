package 백준.아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

  public static int N = 0;
  public static int[][] map;
  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};
  public static Shark babyShark = null;

  public static void main(String[] args) throws IOException {
    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
        if (map[i][j] == 9) {
          babyShark = new Shark(new Point(i, j));
          map[i][j] = 0;
        }
      }
    }

    System.out.println(solve());
  }

  public static int solve() {
    int count = 0;

    while (true) {
      int result = search();
      if (result == -1) {
        break;
      }
      count += result;
    }
    return count;
  }

  public static int search() {
    int turn = 0, nowX = 0, nowY = 0, nextX = 0, nextY = 0;
    Queue<Point> queue = new LinkedList<>();
    boolean[][] visit = new boolean[N][N];
    Point now = babyShark.point, target = null;

    queue.add(now);
    visit[now.x][now.y] = true;

    while (!queue.isEmpty() && target == null) {
      turn++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        now = queue.poll();
        nowX = now.x;
        nowY = now.y;

        for (int j = 0; j < 4; j++) {
          nextX = nowX + dx[j];
          nextY = nowY + dy[j];

          if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visit[nextX][nextY]
              && map[nextX][nextY] <= babyShark.level) {
            if (0 != map[nextX][nextY] && babyShark.level != map[nextX][nextY]) {
              if ((target == null) || (nextX < target.x) || (nextX == target.x
                  && nextY < target.y)) {
                target = new Point(nextX, nextY);
              }
            }
            queue.add(new Point(nextX, nextY));
            visit[nextX][nextY] = true;
          }
        }
      }
    }
    if (target == null) {
      return -1;
    } else {
      map[target.x][target.y] = 0;
      babyShark.eat(target);
      return turn;
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

class Shark {

  Point point = null;
  int level = 2;
  int eat = 0;

  public Shark(Point point) {
    this.point = point;
    this.level = 2;
    this.eat = 0;
  }

  public void eat(Point point) {
    this.point = point;
    eat++;
    if (eat == level) {
      level++;
      eat = 0;
    }
  }
}
