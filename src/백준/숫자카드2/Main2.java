package 백준.숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {

  public static void main(String[] args) throws IOException {
    int N = 0, M = 0;
    int[] numbers;
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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
      sb.append(count(numbers, target, N - 1)).append(" ");
    }
    System.out.println(sb);
  }

  public static int count(int[] arr, int key, int length) {
    return getUpperBound(arr, key) - getLowerBound(arr, key);
  }

  public static int getLowerBound(int[] arr, int key) {
    int low = 0, high = arr.length, mid = (low + high) / 2;

    while (low < high) {
      mid = (low + high) / 2;
      if (arr[mid] >= key) {
        high = mid;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  public static int getUpperBound(int[] arr, int key) {
    int low = 0, high = arr.length, mid = 0;
    while (low < high) {
      mid = (low + high) / 2;
      if (arr[mid] <= key) {
        low = mid+1;
      } else {
        high = mid;
      }
    }
    return low;
  }
}
