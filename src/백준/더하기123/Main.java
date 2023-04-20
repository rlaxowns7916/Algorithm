package 백준.더하기123;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    int[] arr = new int[11];
    arr[1] = arr[2] = arr[3] = 1;

    for (int i = 0; i < 11; i++) {
      if (i - 1 > 0) {
        arr[i] += arr[i - 1];
      }

      if (i - 2 > 0) {
        arr[i] += arr[i - 2];
      }

      if (i - 3 > 0) {
        arr[i] += arr[i - 3];
      }
    }
      while (T-- > 0) {
        int target = Integer.parseInt(br.readLine());
        sb.append(arr[target]).append("\n");
      }
    System.out.println(sb);
  }
}
