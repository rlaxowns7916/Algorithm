package 백준.숫자카드2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static int MAX = 20000001;
  public static int HALF = 10000000;

  public static void main(String[] args) throws IOException {
    int N = 0, M = 0;
    int[] numbers = new int[MAX];
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    N = Integer.parseInt(br.readLine());
    numbers = new int[MAX];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      int target = Integer.parseInt(st.nextToken());

      numbers[target + HALF]++;
    }

    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int target = Integer.parseInt(st.nextToken());
      sb.append(numbers[target + HALF]).append(" ");
    }
    System.out.println(sb);
  }
}