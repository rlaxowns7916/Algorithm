package 백준.파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main2 {

  public static int INF = 9999999;
  public static int N = 0, M = 0, X = 0;
  public static Map<Integer, ArrayList<Node>> map = new LinkedHashMap<>();

  public static void main(String[] args) throws IOException {
    int result = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    X = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int from = Integer.parseInt(st.nextToken());
      int to = Integer.parseInt(st.nextToken());
      int length = Integer.parseInt(st.nextToken());

      map.get(from).add(new Node(to, length));
    }

    int[] reverse = dijkstra(X);
    for (int i = 1; i <= N; i++) {
      if (i == X) {
        continue;
      }
      result = Math.max(result, dijkstra(i)[X] + reverse[i]);
    }
    System.out.println(result);

  }

  public static int[] dijkstra(int start) {
    int[] dist = new int[N + 1];
    boolean[] visit = new boolean[N + 1];
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(start, 0));
    Arrays.fill(dist, INF);

    while (!pq.isEmpty()) {
      Node now = pq.poll();
      if (!visit[now.to]) {
        visit[now.to] = true;
        dist[now.to] = now.length;

        for (Node promising : map.get(now.to)) {
          if (dist[promising.to] > promising.length + dist[now.to]) {
            pq.add(new Node(promising.to, promising.length + dist[now.to]));
          }
        }
      }
    }
    return dist;
  }
}

class Node implements Comparable<Node> {

  int to;
  int length;

  public Node(int to, int length) {
    this.to = to;
    this.length = length;
  }

  @Override
  public int compareTo(Node o) {
    return this.length - o.length;
  }
}