package 백준.유레카이론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static ArrayList<Integer> list = new ArrayList<>();
  public static boolean find = false;

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    init();
    for (int i = 0; i < T; i++) {
      solve(0, 0, Integer.parseInt(br.readLine()));
      sb.append(find ? 1 : 0).append("\n");
      find = false;
    }
    System.out.println(sb);
  }

  public static void solve(int depth, int now, int target) {
    if (find) {
      return;
    } else if (depth == 3) {
      if (now == target) {
        find = true;
        return;
      }
    } else if(depth < 3){
      for (Integer integer : list) {
        if (now + integer <= target) {
          solve(depth + 1, now + integer, target);
        } else {
          return;
        }
      }
    }
  }

  public static void init() {
    int sum = 0, count = 1;

    while (sum + count <= 1000) {
      sum += count;
      count++;
      list.add(sum);
    }
  }
}
