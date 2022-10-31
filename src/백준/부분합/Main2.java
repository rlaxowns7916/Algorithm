package 백준.부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

  public static void main(String[] args) throws IOException {
    int N = 0, S = 0;
    int lPointer = 0, rPointer = 0;
    long sum = 0, min = Long.MAX_VALUE;
    int[] numbers;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());

    numbers = new int[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    sum = numbers[lPointer];

    while (true) {
      if (sum < S) {
        if (rPointer + 1 < N) {
          sum += numbers[++rPointer];
        } else {
          break;
        }
      } else {
        min = Math.min(min, rPointer - lPointer + 1);
        sum -= numbers[lPointer++];
      }
    }
    min = min == Long.MAX_VALUE ? 0 : min;
    System.out.println(min);
  }
}
