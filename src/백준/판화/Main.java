package 백준.판화;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<String, Point> dir = Map.of(
        "D", new Point(1, 0),
        "U", new Point(-1, 0),
        "L", new Point(0, -1),
        "R", new Point(0, 1)
    );
    int N = Integer.parseInt(br.readLine());
    int nowX = 0, nowY = 0, nx = 0, ny = 0;
    char[][] map = new char[N][N];

    for (int i = 0; i < N; i++) {
      Arrays.fill(map[i], '.');
    }

    String input = br.readLine();
    for (int i = 0; i < input.length(); i++) {
      String op = String.valueOf(input.charAt(i));
      Point nowMove = dir.get(op);

      nx = nowX + nowMove.x;
      ny = nowY + nowMove.y;

      if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
        print(map, op, nowX, nowY);
        print(map, op, nx, ny);
        nowX = nx;
        nowY = ny;
      }
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        sb.append(map[i][j]);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static void print(char[][] map, String op, int x, int y) {
    if (map[x][y] != '.') {
      if (map[x][y] == '-') {
        map[x][y] = op.equals("R") || op.equals("L") ? map[x][y] : '+';
      } else {
        map[x][y] = op.equals("U") || op.equals("D") ? map[x][y] : '+';
      }
    } else {
      if (op.equals("R") || op.equals("L")) {
        map[x][y] = '-';
      } else {
        map[x][y] = '|';
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
