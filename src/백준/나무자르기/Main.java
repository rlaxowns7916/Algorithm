package 백준.나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static int N = 0, M = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    long max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, mid = 0, answer = 0;

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    long[] arr = new long[N];
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      int value = Integer.parseInt(st.nextToken());
      max = Math.max(max, value);
      min = Math.min(min, value);
      arr[i] = value;
    }

    while (min <= max) {
      mid = (min + max) / 2;
      long sum = 0;

      for (int i = 0; i < N; i++) {
        if (arr[i] > mid) {
          sum += arr[i] - mid;
        }
      }


      if (sum < M) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    System.out.println(max);
  }
}
