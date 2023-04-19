package 백준.사탕게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int max = 0;
    char[][] map = new char[N][N];
    int[] dx = {1, 0};
    int[] dy = {0, 1};

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < N; j++) {
        map[i][j] = input.charAt(j);
      }
    }
    max = Math.max(max, getMaximum(map));
    for (int i = 0 ;i < N; i++) {
      for (int j = 0; j < N; j++) {
        for (int k = 0; k < 2; k++) {
          int nx = i + dx[k];
          int ny = j + dy[k];

          if (nx < N && ny < N) {
            swap(map, i, j, nx, ny);
            max = Math.max(max, getMaximum(map));
            swap(map, nx, ny, i, j);
          }
        }
      }
    }
    System.out.println(max);
  }

  public static int getMaximum(char[][] map) {
    int max = 0;
    int length = map.length;
    int[] dx = {-1, 0};
    int[] dy = {0, -1};
    int[][][] lenMap = new int[2][length][length];

    for (int i = 0; i < length; i++) {
      for (int j = 0; j < length; j++) {
          for (int k = 0; k < 2; k++) {
            int px = i + dx[k];
            int py = j + dy[k];

            if (px >= 0 && py >= 0 &&  map[px][py] == map[i][j]) {
              lenMap[k][i][j] = Math.max(lenMap[k][i][j], lenMap[k][px][py] + 1);
              max = Math.max(max, lenMap[k][i][j]);
            }
        }
      }
    }
    return max+1;
  }

  public static void swap(char[][] map, int x1, int y1, int x2, int y2) {
    char tmp = map[x1][y1];
    map[x1][y1] = map[x2][y2];
    map[x2][y2] = tmp;
  }
}
