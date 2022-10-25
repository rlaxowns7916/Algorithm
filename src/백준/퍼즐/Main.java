package 백준.퍼즐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 3; j++) {
        String input = st.nextToken();
        if (input.equals("0")) {
          sb.append("9");
        } else {
          sb.append(input);
        }
      }
    }
    System.out.println(new Main().solve(Integer.parseInt(sb.toString())));
  }

  public int solve(int number) {
    int turn = 0;
    Set<Integer> visit = new LinkedHashSet<>();
    Queue<Integer> queue = new LinkedList<>();

    visit.add(number);
    queue.add(number);
    if (number == 123456789) {
      return 0;
    }

    while (!queue.isEmpty()) {
      int size = queue.size();
      turn++;
      for (int i = 0; i < size; i++) {
        int now = queue.poll();

        for (int j = 0; j < 4; j++) {
          int next = swap(now, j);
          if (next != -1 && visit.add(next)) {
            if (next == 123456789) {
              return turn;
            }
            queue.add(next);
          }
        }
      }
    }
    return -1;
  }

  public int swap(int number, int dir) {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    int emptyX = 0, emptyY = 0, nextX = 0, nextY = 0;
    String str = String.valueOf(number);

    for (int i = 0; i < 9; i++) {
      if (str.charAt(i) == '9') {
        emptyX = i / 3;
        emptyY = i % 3;
        break;
      }
    }

    nextX = emptyX + dx[dir];
    nextY = emptyY + dy[dir];

    if (nextX >= 0 && nextX < 3 && nextY >= 0 && nextY < 3) {
      int[][] map = numberToMap(number);
      map[emptyX][emptyY] = map[nextX][nextY];
      map[nextX][nextY] = 9;
      return mapToNumber(map);
    } else {
      return -1;
    }

  }

  public int mapToNumber(int[][] map) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        sb.append(map[i][j]);
      }
    }
    return Integer.parseInt(sb.toString());
  }

  public int[][] numberToMap(int number) {
    int[][] map = new int[3][3];
    String string = String.valueOf(number);

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        map[i][j] = string.charAt(3 * i + j) - '0';
      }
    }
    return map;
  }
}