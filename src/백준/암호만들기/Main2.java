package 백준.암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main2 {

  public static int L = 0, C = 0;
  public static List<String> alphabets = new ArrayList<>();
  public static List<String> candidates = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    L = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    boolean[] visit = new boolean[C];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < C; i++) {
      alphabets.add(st.nextToken());
    }
    Collections.sort(alphabets);

    solve(0, 0, visit);

    for (String candidate : candidates) {
      sb.append(candidate).append("\n");
    }

    System.out.println(sb);
  }

  public static void solve(int now, int depth, boolean[] visit) {
    if (depth == L) {
      int consonant = 0;
      int vowel = 0;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < now; i++) {
        if (visit[i]) {
          String alphabet = alphabets.get(i);
          sb.append(alphabet);
          if (isVowel(alphabet)) {
            vowel++;
          } else {
            consonant++;
          }
        }
      }

      if (vowel >= 1 && consonant >= 2) {
        candidates.add(sb.toString());
      }
    } else if (now >= C) {
      return;
    } else {
      visit[now] = true;
      solve(now + 1, depth + 1, visit);
      visit[now] = false;
      solve(now + 1, depth, visit);
    }
  }

  public static boolean isVowel(String chr) {
    return chr.equals("a") || chr.equals("e") || chr.equals("i") || chr.equals("o") || chr.equals(
        "u");
  }
}
