package 백준.맥주마시면서걸어가기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static boolean isFind = false;
  public static int beer = 20;

  public static void main(String[] args) throws IOException {
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int t = Integer.parseInt(br.readLine());

    for (int i = 0; i < t; i++) {
      isFind = false;
      int convCount = Integer.parseInt(br.readLine());
      st = new StringTokenizer(br.readLine());
      Point home = new Point(Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()));
      boolean[] visit = new boolean[convCount];
      List<Point> conv = new ArrayList<>();

      for (int j = 0; j < convCount; j++) {
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        conv.add(new Point(x, y));
      }

      st = new StringTokenizer(br.readLine());
      Point rockFestival = new Point(Integer.parseInt(st.nextToken()),
          Integer.parseInt(st.nextToken()));

      solve(home, rockFestival, conv, visit);
      sb.append(isFind ? "happy" : "sad").append("\n");
    }
    System.out.println(sb);
  }

  public static void solve(Point now, Point rockFestival, List<Point> conv, boolean[] visit) {
    if (isFind) {
      return;
    } else {
      if (getDiff(now, rockFestival) <= beer * 50) {
        isFind = true;
        return;
      } else {
        for (int i = 0; i < conv.size(); i++) {
          if (!visit[i] && getDiff(now, conv.get(i)) <= beer * 50) {
            visit[i] = true;
            solve(conv.get(i), rockFestival, conv, visit);

          }
        }
      }
    }
  }

  public static int getDiff(Point src, Point dest) {
    return Math.abs(src.x - dest.x) + Math.abs(src.y - dest.y);
  }
}

class Point {

  int x = 0;
  int y = 0;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
