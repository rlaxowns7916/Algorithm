package 백준.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {

  public static int N = 0;
  public static int[] dx = {-1, 0, 1, 0};
  public static int[] dy = {0, 1, 0, -1};

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    Character[][] normal;
    Character[][] unNormal;
    int normalCount = 0, unNormalCount = 0;

    normal = new Character[N][N];
    unNormal = new Character[N][N];

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < N; j++) {
        normal[i][j] = input.charAt(j);
        unNormal[i][j] = input.charAt(j);
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (normal[i][j] != 'X') {
          bfs(normal, false, i, j);
          normalCount++;
        }
        if (unNormal[i][j] != 'X') {
          bfs(unNormal, true, i, j);
          unNormalCount++;
        }
      }
    }

    sb.append(normalCount).append(" ").append(unNormalCount);
    System.out.println(sb);
  }

  public static void bfs(Character[][] map, boolean isUnNormal, int x, int y) {
    Queue<Integer> qx = new LinkedList<>();
    Queue<Integer> qy = new LinkedList<>();
    int nx = 0, ny = 0;
    char target = map[x][y];

    map[x][y] = 'X';
    qx.add(x);
    qy.add(y);

    while (!qx.isEmpty() && !qy.isEmpty()) {
      int nowX = qx.poll();
      int nowY = qy.poll();

      for (int i = 0; i < 4; i++) {
        nx = nowX + dx[i];
        ny = nowY + dy[i];

        if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] != 'X') {
          if (target == 'B') {
            if (map[nx][ny] == target) {
              qx.add(nx);
              qy.add(ny);
              target = map[nx][ny];
              map[nx][ny] = 'X';
            }
          } else {
            if (isUnNormal) {
              if (map[nx][ny] != 'B') {
                target = map[nx][ny];
                map[nx][ny] = 'X';
                qx.add(nx);
                qy.add(ny);
              }
            } else {
              if (map[nx][ny] == target) {
                target = map[nx][ny];
                map[nx][ny] = 'X';
                qx.add(nx);
                qy.add(ny);
              }
            }
          }
        }
      }
    }
  }
}