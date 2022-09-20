package 백준.톱니바퀴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static Gear[] gears = new Gear[5];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = 0, score = 0;
    for (int i = 1; i <= 4; i++) {
      String input = br.readLine();
      int[] values = new int[8];
      for (int j = 0; j < 8; j++) {
        values[j] = input.charAt(j) - '0';
      }
      gears[i] = new Gear(values);
    }

    k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int target = Integer.parseInt(st.nextToken());
      int direction = Integer.parseInt(st.nextToken());
      boolean[] visit = new boolean[5];
      boolean[][] candidate = getCandidate();

      rotate(target, direction, candidate, visit);
    }

    for (int i = 1; i <= 4; i++) {
      score += (gears[i].values[gears[i].topIndex] == 0 ? 0 : Math.pow(2, i-1));
    }
    System.out.println(score);
  }

  public static void rotate(int index, int direction, boolean[][] candidate, boolean[] visit) {
    if ((1 <= index && index <= 4) && !visit[index]) {
      visit[index] = true;
      if (direction == -1) {
        gears[index].rotateToCounterClockWise();
        if (candidate[index][0]) {
          rotate(index - 1, 1, candidate, visit);
        }
        if (candidate[index][1]) {
          rotate(index + 1, 1, candidate, visit);
        }
      } else {
        gears[index].rotateToClockWise();
        if (candidate[index][0]) {
          rotate(index - 1, -1, candidate, visit);
        }
        if (candidate[index][1]) {
          rotate(index + 1, -1, candidate, visit);
        }
      }
    }
  }

  public static boolean[][] getCandidate() {
    boolean[][] candidate = new boolean[5][2];

    for (int i = 1; i < 4; i++) {
      if (gears[i].values[gears[i].rightIndex] != gears[i + 1].values[gears[i + 1].leftIndex]) {
        candidate[i][1] = candidate[i + 1][0] = true;
      }
    }
    return candidate;
  }
}

class Gear {

  int topIndex;
  int leftIndex;
  int rightIndex;
  int[] values;

  public Gear(int[] values) {
    this.values = values;
    this.topIndex = 0;
    this.rightIndex = 2;
    this.leftIndex = 6;
  }

  public void rotateToClockWise() {
    topIndex = (topIndex + 7) % 8;
    leftIndex = (leftIndex + 7) % 8;
    rightIndex = (rightIndex + 7) % 8;
  }

  public void rotateToCounterClockWise() {
    topIndex = (topIndex + 1) % 8;
    leftIndex = (leftIndex + 1) % 8;
    rightIndex = (rightIndex + 1) % 8;
  }
}