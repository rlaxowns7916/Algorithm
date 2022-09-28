package 백준.거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  public static int N = 0, M = 0;
  public static int truth = 0;

  public static int[] parent;
  public static boolean[] knowTheTruth;

  public static ArrayList<Integer>[] parties;

  public static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x != y) {
      parent[y] = x;
    }
  }

  public static int find(int x) {
    return parent[x] = x == parent[x] ? x : find(parent[x]);
  }


  public static void main(String[] args) throws IOException {
    System.out.println(solve());
  }

  public static int solve() throws IOException {
    int count = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    parent = new int[N + 1];
    knowTheTruth = new boolean[N + 1];
    parties = new ArrayList[M];

    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    st = new StringTokenizer(br.readLine());
    truth = Integer.parseInt(st.nextToken());

    for (int i = 0; i < truth; i++) {
      knowTheTruth[Integer.parseInt(st.nextToken())] = true;
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int numOfParticipant = Integer.parseInt(st.nextToken());
      parties[i] = new ArrayList<>();

      for (int j = 0; j < numOfParticipant; j++) {
        parties[i].add(Integer.parseInt(st.nextToken()));
      }

      for (int j = 0; j < parties[i].size() - 1; j++) {
        int a = parties[i].get(j);
        int b = parties[i].get(j + 1);
        union(a, b);
      }
    }

    for (int i = 1; i <= N; i++) {
      if (knowTheTruth[i]) {
        knowTheTruth[find(i)] = true;
      }
    }

    for (int i = 0; i < M; i++) {
      boolean skip = false;
      for (int people : parties[i]) {
        if (knowTheTruth[find(people)]) {
          skip = true;
          break;
        }
      }
      if (!skip) {
        count++;
      }
    }

    return count;
  }
}
