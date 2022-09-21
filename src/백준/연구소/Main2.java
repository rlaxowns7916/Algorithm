package 백준.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {

  public static int virus = 0, safe = 0, wall = 0;
  public static int N = 0, M = 0, MAX = 0;
  public static int[][] Map;
  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};
  public static ArrayList<Point> safeArea = new ArrayList<>();
  public static ArrayList<Point> viruses = new ArrayList<>();
  public static LinkedList<Integer> newWalls = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    Map = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        int value = Integer.parseInt(st.nextToken());
        if (value == 1) {
          wall++;
        } else if (value == 2) {
          virus++;
          viruses.add(new Point(i, j));
        } else {
          safe++;
          safeArea.add(new Point(i, j));
        }
        Map[i][j] = value;
      }
    }
    solve(0, 0);

    System.out.println(MAX);

  }

  public static void solve(int depth, int index) {
    if (depth == 3) {
      for (int newWall : newWalls) {
        Point point = safeArea.get(newWall);
        Map[point.x][point.y] = 1;
      }
      MAX = Math.max(MAX, bfs());
      for (int newWall : newWalls) {
        Point point = safeArea.get(newWall);
        Map[point.x][point.y] = 0;
      }
    } else if (index < safe) {
      newWalls.addLast(index);
      solve(depth + 1, index + 1);
      newWalls.removeLast();
      solve(depth, index + 1);
    }
  }

  public static int bfs() {
    int infection = 0;
    int nowX = 0, nowY = 0, nextX = 0, nextY = 0;
    Queue<Point> queue = new LinkedList<>(viruses);
    boolean[][] visit = new boolean[N][M];

    while (!queue.isEmpty()) {
      Point point = queue.poll();
      nowX = point.x;
      nowY = point.y;
      if (!visit[nowX][nowY]) {
        infection++;
        visit[nowX][nowY] = true;

        for (int i = 0; i < 4; i++) {
          nextX = nowX + dx[i];
          nextY = nowY + dy[i];

          if (0 <= nextX && nextX < N && 0 <= nextY && nextY < M && !visit[nextX][nextY]
              && Map[nextX][nextY] == 0) {
            queue.add(new Point(nextX, nextY));
          }
        }
      }
    }
    return N * M - (wall + 3 + infection);
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
