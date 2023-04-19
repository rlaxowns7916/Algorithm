package 백준.일곱난쟁이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

  public static void main(String[] args) throws IOException {
    int i = 0, j = 0;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> list = new ArrayList<>();

    for (i = 0; i < 9; i++) {
      list.add(Integer.parseInt(br.readLine()));
    }

    Collections.sort(list);

    for (i = 0; i < 8; i++) {
      for (j = i + 1; j < 9; j++) {
        int sum = 0;
        for (int k = 0; k < 9; k++) {
          if (k == i || k == j) {
            continue;
          }
          sum += list.get(k);
        }

        if (sum == 100) {
          for (int k = 0; k < 9; k++) {
            if (k == i || k == j) {
              continue;
            }
            sb.append(list.get(k)).append("\n");
          }
          break;
        }
      }
      if (sb.length() > 0) {
        break;
      }
    }
    System.out.println(sb);
  }

}
