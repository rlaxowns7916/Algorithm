package 백준.부등호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static String min = String.valueOf(Long.MAX_VALUE), max = String.valueOf(Long.MIN_VALUE);

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());

    String[] operators = new String[n];
    int[] numbers = new int[n + 1];
    boolean[] visit = new boolean[10];

    for (int i = 0; i < n; i++) {
      operators[i] = st.nextToken();
    }

    calculate(0, n + 1, operators, numbers, visit);
    sb.append(max).append("\n").append(min);
    System.out.println(sb);
  }

  public static void calculate(int depth, int total, String[] operators, int[] numbers,
      boolean[] visit) {
    if (depth == total) {
      long sum = 0;
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < numbers.length; i++) {
        sb.append(numbers[i]);
      }
      sum = Long.parseLong(sb.toString());
      if(sum > Long.parseLong(max)){
        max = sb.toString();
      }
      if(sum < Long.parseLong(min)){
        min = sb.toString();
      }
    } else {
      for (int i = 0; i < 10; i++) {
        if (!visit[i]) {
          if (depth == 0 || isPromising(numbers[depth - 1], i, operators[depth - 1])) {
            visit[i] = true;
            numbers[depth] = i;
            calculate(depth + 1, total, operators, numbers, visit);
            visit[i] = false;
          }
        }
      }
    }
  }

  public static boolean isPromising(int src, int dest, String operator) {
    if (operator.equals("<")) {
      return src < dest;
    } else {
      return src > dest;
    }
  }

}
