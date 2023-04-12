package 백준.가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {

  public static int N = 0, K = 0;
  public static int max = 0;
  public static Set<Integer> alphabets = new LinkedHashSet<>();
  public static List<String> words = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int alphabetCount = 0;
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    boolean[] visit = new boolean[26];

    if (K < 5) {
      System.out.println(0);
      return;
    }
    visit['a' - 'a'] = visit['n' - 'a'] = visit['t' - 'a'] = visit['i' - 'a'] = visit['c'
        - 'a'] = true;

    for (int i = 0; i < N; i++) {
      String input = br.readLine();
      for (int j = 0; j < input.length(); j++) {
        if (alphabets.add(input.charAt(j) - 'a')) {
          alphabetCount++;
        }
      }
      words.add(input);
    }

    if (K >= alphabetCount) {
      System.out.println(N);
    } else {
      solve(5, 0, visit);
      System.out.println(max);
    }
  }

  public static void solve(int now, int depth, boolean[] visit) {
    if (now == K) {
      int count = 0;
      for (String word : words) {
        boolean canRead = true;
        for (int j = 4; j < word.length() - 4; j++) {
          if (!visit[word.charAt(j) - 'a']) {
            canRead = false;
            break;
          }
        }
        if (canRead) {
          count++;
        }
      }
      max = Math.max(max, count);
    } else if (depth >= visit.length) {
      return;
    } else {
      if (alphabets.contains(depth) && !visit[depth]) {
        visit[depth] = true;
        solve(now + 1, depth + 1, visit);
        visit[depth] = false;
      }
      solve(now, depth + 1, visit);
    }
  }
}
