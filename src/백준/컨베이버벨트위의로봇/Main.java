package 백준.컨베이버벨트위의로봇;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static int N = 0, K = 0;
  public static int[] belt;
  public static boolean[] robot;

  public static void main(String[] args) throws IOException {
    int start = 0, turn = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    belt = new int[2 * N];
    robot = new boolean[2 * N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < 2 * N; i++) {
      belt[i] = Integer.parseInt(st.nextToken());
    }

    while (true) {
      start = (start + (2 * N - 1)) % (2 * N);
      if (findEmpty() >= K) {
        break;
      }

      turn++;
      simulate(start);
    }
    System.out.println(turn);
  }

  public static void simulate(int start) {
    int end = (start + N - 1) % (N * 2), now = end, pre = -1;
    for (int i = 0; i < N; i++) {
      if (now == start) {
        if (belt[now] > 0) {
          robot[now] = true;
          belt[now] -= 1;
        }
      } else if (now == end) {
        robot[now] = false;
      } else if (robot[now]) {
        if (!robot[pre] && belt[pre] > 0) {
          if (pre != end) {
            robot[pre] = true;
          }
          belt[pre] -= 1;
          robot[now] = false;
        }
      }
      pre = now;
      now = (now + (2 * N - 1)) % (2 * N);
    }
  }

  public static int findEmpty() {
    int count = 0;
    for (int i = 0; i < 2 * N; i++) {
      if (belt[i] == 0) {
        count++;
      }
    }
    return count;
  }
}
