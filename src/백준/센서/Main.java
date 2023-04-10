package 백준.센서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static int N = 0, K = 0;
  public static List<Integer> censors = new ArrayList<>();
  public static List<Integer> diff = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    K = Integer.parseInt(br.readLine());

    if (N <= K) {
      System.out.println(0);
    } else {
      int sum =0;
      st = new StringTokenizer(br.readLine());

      for (int i = 0; i < N; i++) {
        censors.add(Integer.parseInt(st.nextToken()));
      }

      censors.sort((o1, o2) -> o1 - o2);

      for (int i = 0; i < censors.size() - 1; i++) {
        diff.add(censors.get(i + 1) - censors.get(i));
      }

      diff.sort(((o1, o2) -> o2 - o1));

      for (int i = 0; i < K-1; i++) {
        diff.remove(0);
      }

      for (Integer integer : diff) {
        sum += integer;
      }
      System.out.println(sum);
    }
  }
}