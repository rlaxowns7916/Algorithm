package 백준.배;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static int N = 0, M = 0;

  public static void main(String[] args) throws IOException {
    StringTokenizer st;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    List<Integer> limits = new ArrayList<>();
    List<Integer> boxes = new ArrayList<>();

    N = Integer.parseInt(br.readLine());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      limits.add(Integer.parseInt(st.nextToken()));
    }

    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < M; i++) {
      boxes.add(Integer.parseInt(st.nextToken()));
    }

    limits.sort((o1, o2) -> o2 - o1);
    boxes.sort((o1, o2) -> o2 - o1);

    if (limits.get(0) < boxes.get(0)) {
      System.out.println(-1);
    } else {
      System.out.println(calculate(limits, boxes));
    }
  }

  public static int calculate(List<Integer> limits, List<Integer> boxes) {
    int count = 0, index = 0;

    while (!boxes.isEmpty()) {
      index = 0;
      for (int i = 0; i < limits.size() && index < boxes.size();) {
        if(limits.get(i) >= boxes.get(index)){
          i++;
          boxes.remove(index);
        }else{
          index++;
        }
      }
      count++;
    }
    return count;
  }
}
