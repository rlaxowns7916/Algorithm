package 백준.수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

  public static void main(String[] args) throws IOException {
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = 0, M = 0;
    int[] numbers;

    N = Integer.parseInt(br.readLine());
    numbers = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(numbers);

    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < M; i++) {
      int target = Integer.parseInt(st.nextToken());
      sb.append(isExist(numbers, target) ? 1 : 0).append("\n");
    }
    System.out.println(sb);
  }

  public static boolean isExist(int[] numbers, int target) {
    int low = 0, high = numbers.length - 1, mid = 0;

    while (low <= high) {
      mid = (low + high) / 2;
      if (numbers[mid] == target) {
        return true;
      } else {
        if (numbers[mid] > target) {
          high = mid - 1;
        } else {
          low = mid + 1;
        }
      }
    }
    return false;
  }
}