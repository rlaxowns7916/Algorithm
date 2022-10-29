package 백준.용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int[] buffer;
    int N = Integer.parseInt(br.readLine());
    int lTarget = 0, rTarget = 0, lPointer = 0, rPointer = N - 1, difference = Integer.MAX_VALUE;

    buffer = new int[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      buffer[i] = Integer.parseInt(st.nextToken());
    }

    while (lPointer < rPointer) {
      int nowDifference = buffer[rPointer] + buffer[lPointer];
      int left = Math.abs(buffer[lPointer]), right = Math.abs(buffer[rPointer]);

      if (Math.abs(nowDifference) < Math.abs(difference)) {
        lTarget = lPointer;
        rTarget = rPointer;
        difference = nowDifference;
      }

      if (left < right) {
        rPointer--;
      } else {
        lPointer++;
      }
    }
    sb.append(buffer[lTarget]).append(" ").append(buffer[rTarget]);
    System.out.println(sb);
  }

}
