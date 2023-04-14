package 백준.감시피하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static int N = 0;
  public static String[][] map;
  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};
  public static List<Point> teachers = new ArrayList<>();
  public static boolean result = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    map = new String[N][N];

    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        map[i][j] = st.nextToken();

        if (map[i][j].equals("T")) {
          teachers.add(new Point(i, j));
        }
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (map[i][j].equals("X")) {
          map[i][j] = "O";
          solve(1, i, j);
          map[i][j] = "X";
        }
      }
    }
    if (result) {
      System.out.println("YES");
    } else {
      System.out.println("NO");
    }

  }

  public static void solve(int depth, int i, int j) {
    if (result) {
      return;
    } else if (depth == 3) {
      result = canHide();
    } else if (i >= 0 && i < N && j >= 0 && j <= N) {
      int x = i, y = j;

      for (; x < N; x++) {
        for (; y < N; y++) {
          if (map[x][y].equals("X")) {
            map[x][y] = "O";
            solve(depth + 1, i, j);
            map[x][y] = "X";
          }
        }
        y = 0;
      }
    }
  }

  public static boolean canHide() {
    int nx = 0, ny = 0;
    for (Point teacher : teachers) {
      for (int i = 0; i < 4; i++) {
        int nowX = teacher.x;
        int nowY = teacher.y;

        while (true) {
          nx = nowX + dx[i];
          ny = nowY + dy[i];
          if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny].equals("O")) {
            break;
          }

          if (map[nx][ny].equals("S")) {
            return false;
          }
          nowX = nx;
          nowY = ny;
        }
      }
    }
    return true;
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
