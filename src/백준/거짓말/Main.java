package 백준.거짓말;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

  public static int N = 0, M = 0;
  public static int[] parent;
  public static int[] rank;
  public static ArrayList<Integer> knowTheTruthOrigin = new ArrayList<>();
  public static ArrayList<ArrayList<Integer>> parties = new ArrayList<>();
  public static StringTokenizer st;
  public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  public static void main(String[] args) throws IOException {

    init();

    int count = 0;
    boolean[] knowTheTruth = new boolean[N + 1];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int participant = Integer.parseInt(st.nextToken());
      parties.add(new ArrayList<>());

      for (int j = 0; j < participant; j++) {
        int people = Integer.parseInt(st.nextToken());
        ArrayList<Integer> party = parties.get(i);

        if (!party.isEmpty()) {
          union(people, party.get(party.size() - 1));
        }
        party.add(people);
      }
    }

    for (int origin : knowTheTruthOrigin) {
      knowTheTruth[find(origin)] = true;
    }

    for (ArrayList<Integer> party : parties) {
      boolean flag = true;
      for (int people : party) {
        if (knowTheTruth[find(people)]) {
          flag = false;
          break;
        }
      }
      if (flag) {
        count++;
      }
    }
    System.out.println(count);
  }

  private static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x == y) {
      return;
    }

    if (rank[x] == rank[y]) {
      if (parent[x] < parent[y]) {
        parent[y] = x;
        rank[x] += 1;
      } else {
        parent[x] = y;
        rank[y] += 1;
      }
    } else {
      if (rank[x] < rank[y]) {
        parent[x] = y;
      } else {
        parent[y] = x;
      }
    }

  }

  private static int find(int x) {
    if (x == parent[x]) {
      return x;
    } else {
      return parent[x] = find(parent[x]);
    }
  }

  public static void init() throws IOException {
    int knowTheTruthCount = 0;
    st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    knowTheTruthCount = Integer.parseInt(st.nextToken());

    for (int i = 0; i < knowTheTruthCount; i++) {
      knowTheTruthOrigin.add(Integer.parseInt(st.nextToken()));
    }
    initDisjointSet();
  }

  private static void initDisjointSet() {
    parent = new int[N + 1];
    rank = new int[N + 1];
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
      rank[i] = 1;
    }
  }
}


