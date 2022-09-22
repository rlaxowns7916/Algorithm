package 백준.물통;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static int[] limit = new int[3];

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    limit[0] = Integer.parseInt(st.nextToken());
    limit[1] = Integer.parseInt(st.nextToken());
    limit[2] = Integer.parseInt(st.nextToken());

    Set<Integer> answer = new LinkedHashSet<>();

    Queue<Buckets> queue = new LinkedList<>();
    queue.add(new Buckets(0, 0, limit[2]));

    Set<Buckets> visit = new LinkedHashSet<>();
    visit.add(queue.peek());

    while (!queue.isEmpty()) {
      Buckets origin = queue.poll();
      int[] waters = origin.water;
      if (waters[0] == 0 && waters[2] >= 0) {
        answer.add(waters[2]);
      }

      if (waters[0] > 0) {
        Buckets mv1 = move(origin, 0, 1);
        Buckets mv2 = move(origin, 0, 2);

        if (visit.add(mv1)) {
          queue.add(mv1);
        }
        if (visit.add(mv2)) {
          queue.add(mv2);
        }
      }

      if (waters[1] > 0) {
        Buckets mv1 = move(origin, 1, 0);
        Buckets mv2 = move(origin, 1, 2);

        if (visit.add(mv1)) {
          queue.add(mv1);
        }
        if (visit.add(mv2)) {
          queue.add(mv2);
        }
      }

      if (waters[2] > 0) {
        Buckets mv1 = move(origin, 2, 0);
        Buckets mv2 = move(origin, 2, 1);

        if (visit.add(mv1)) {
          queue.add(mv1);
        }
        if (visit.add(mv2)) {
          queue.add(mv2);
        }
      }
    }
    answer.stream().sorted().forEach(it -> sb.append(it).append(" "));
    System.out.println(sb);
  }

  public static Buckets move(Buckets origin, int from, int to) {
    int[] originWaters = {origin.water[0], origin.water[1], origin.water[2]};

    if (originWaters[to] + originWaters[from] > limit[to]) {
      originWaters[from] -= (limit[to] - originWaters[to]);
      originWaters[to] = limit[to];
    } else {
      originWaters[to] += originWaters[from];
      originWaters[from] = 0;

    }
    return new Buckets(originWaters[0], originWaters[1], originWaters[2]);
  }
}

class Buckets {

  int[] water = new int[3];

  public Buckets(int a, int b, int c) {
    water[0] = a;
    water[1] = b;
    water[2] = c;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Buckets buckets = (Buckets) o;
    return water[0] == buckets.water[0] && water[1] == buckets.water[1]
        && water[2] == buckets.water[2];
  }

  @Override
  public int hashCode() {
    return Objects.hash(water[0], water[1], water[2]);
  }
}
