package 백준.치킨배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static int N = 0, M = 0;
  public static int INF = 999999999;
  public static long min = INF;

  public static List<Point> homes = new ArrayList<>();
  public static List<Point> chickens = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        int value = Integer.parseInt(st.nextToken());
        if (value == 1) {
          homes.add(new Point(i, j));
        } else if (value == 2) {
          chickens.add(new Point(i, j));
        }
      }
    }
    int[] selectedChicken = new int[M];
    boolean[] visit = new boolean[chickens.size()];
    solve(0, 0, selectedChicken, visit);

    System.out.println(min);

  }

  public static void solve(int now, int depth, int[] selectedChicken, boolean[] visit) {
    if (depth == M) {
      int sum = 0;
      for (Point home : homes) {
        int diff = INF;
        for (int index : selectedChicken) {
          Point chicken = chickens.get(index);
          diff = Math.min(diff, Math.abs(home.x - chicken.x) + Math.abs(home.y - chicken.y));
        }
        sum += diff;
      }
      min = Math.min(sum, min);
    } else if (now >= chickens.size()) {
      return;
    } else {
      visit[now] = true;
      selectedChicken[depth] = now;
      solve(now + 1, depth + 1, selectedChicken, visit);
      visit[now] = false;
      solve(now + 1, depth, selectedChicken, visit);
    }
  }

}

class Point {

  int x;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
