package 백준.배열합치기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = 0, M = 0;
    int p1 = 0, p2 = 0;
    int[] A, B, union;

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    A = new int[N];
    B = new int[M];
    union = new int[N + M];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      B[i] = Integer.parseInt(st.nextToken());
    }

    for (int i = 0; i < N + M; i++) {
      if (p1 < N && p2 < M) {
        union[i] = A[p1] < B[p2] ? A[p1++] : B[p2++];
      } else if (p1 < N) {
        union[i] = A[p1++];
      } else {
        union[i] = B[p2++];
      }
      sb.append(union[i]).append(" ");
    }
    System.out.println(sb);
  }
}